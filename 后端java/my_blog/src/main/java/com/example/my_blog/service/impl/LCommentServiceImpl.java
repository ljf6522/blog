package com.example.my_blog.service.impl;

import com.example.my_blog.mapper.LArticleMapper;
import com.example.my_blog.mapper.LCommentMapper;
import com.example.my_blog.model.LComment;
import com.example.my_blog.service.LCommentService;
import com.example.my_blog.vo.LCommentsVo;
import com.example.my_blog.vo.RecentCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/10
 */
@Service
@CacheConfig(cacheNames = "article")
public class LCommentServiceImpl implements LCommentService {
    @Autowired
    LCommentMapper lCommentMapper;
    @Autowired
    LArticleMapper lArticleMapper;
    @Resource
    RedisTemplate redisTemplate;

//    获取当前文章评论
    @Override
    @Cacheable(key = "'getCommentListByArticleId'+#articleId", unless = "#result==null")
    public List<LCommentsVo> lComments(Integer articleId) {
        List<LCommentsVo> comAll=lCommentMapper.commentList(articleId);
        List<LCommentsVo> commentsVoList=new ArrayList<>();
//      选出没有父类评论id的评论作为主评论
        for (LCommentsVo comVo : comAll) {
            if (comVo.getCmParents()==null){
                commentsVoList.add(comVo);
            }
        }

        for (LCommentsVo lCommentsVo : commentsVoList) {
//          新建二级评论集
            List<LCommentsVo> childCommentList=new ArrayList<>();
            lCommentsVo.setlCommentsVos(childCommentVOs(lCommentsVo,comAll,childCommentList));
        }
        return commentsVoList;
    }
    //    搜索添加子评论
    private List<LCommentsVo> childCommentVOs(LCommentsVo voFu,List<LCommentsVo> allCom,List<LCommentsVo> childCom){
        for (LCommentsVo lCommentsVo : allCom) {
            if (lCommentsVo.getCmParents() == voFu.getId()){
                childCom.add(lCommentsVo);
                childCommentVOs(lCommentsVo,allCom,childCom);
            }
        }
        return childCom;
    }


//    添加评论
    @Override
    @Cacheable(key = "'getNewCommentList'", unless = "#result==null")
    public boolean addComment(LComment lComment) {
        if (lCommentMapper.insert(lComment)>0){
            redisTemplate.opsForValue().set("cache:article:getCommentListByArticleId"+lComment.getArticleId(),lComments(lComment.getArticleId()), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

//    获取最新评论
    @Override
    public List<RecentCommentVO> recentCommentList() {
        List<RecentCommentVO> rentCommentList = lCommentMapper.getRentCommentList();
        for (RecentCommentVO recentCommentVO : rentCommentList) {
            recentCommentVO.setArticleTitle(lArticleMapper.getArticleTitleById(recentCommentVO.getArticleId()));
        }
        return rentCommentList;
    }
}
