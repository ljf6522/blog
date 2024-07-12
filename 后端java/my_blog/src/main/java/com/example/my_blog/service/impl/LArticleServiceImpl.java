package com.example.my_blog.service.impl;

import cn.hutool.core.lang.Dict;
import com.example.my_blog.common.Result;
import com.example.my_blog.dto.ArticleDeleteDto;
import com.example.my_blog.dto.ArticleIsRecommendDto;
import com.example.my_blog.dto.ArticleIsTopDto;
import com.example.my_blog.dto.LArticleDto;
import com.example.my_blog.mapper.*;
import com.example.my_blog.model.*;
import com.example.my_blog.service.LArticleService;
import com.example.my_blog.vo.ArticleHomeVo;
import com.example.my_blog.vo.ArticleRecommendVO;
import com.example.my_blog.vo.ArticleSearchVO;
import com.example.my_blog.vo.LArticleVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = "article")
public class LArticleServiceImpl implements LArticleService {
    @Autowired
    LArticleMapper lArticleMapper;
    @Autowired
    LCategoryMapper lCategoryMapper;
    @Autowired
    LTagMapper lTagMapper;
    @Autowired
    LArticleCategoryMapper lArticleCategoryMapper;
    @Autowired
    LArticleTagMapper lArticleTagMapper;
    @Resource
    RedisTemplate redisTemplate;

//    @Override
//    public List<LArticle> getLArticleList() {
//        return lArticleMapper.selectByExample(new LArticleExample());
//    }

//    阅读文章界面信息
    @Override
    @Cacheable(key = "'ArticleIndex'+#id", unless = "#result==null")
    public Result<HashMap> inLArticle(Integer id) {
        LArticleVo av=AtoAvo(lArticleMapper.selectByPrimaryKey(id));
//        int articleId=av.getId();
        av.setlCategory(lCategoryMapper.selectCategoryByArticleId(id));
        av.setlTags(lTagMapper.selectTagsByArticleId(id));
        Map m=new HashMap();
        m.put("article",av);
        m.put("previousArticle",lArticleMapper.selectLastArticle(id));
        m.put("nextArticle",lArticleMapper.selectNextArticle(id));
        return Result.success().code(200).data(m).message("成功");
    }

    private LArticleVo AtoAvo(LArticle article){
        LArticleVo av=new LArticleVo();
        BeanUtils.copyProperties(article,av);
        av.setlCategory(lCategoryMapper.selectCategoryByArticleId(article.getId()));
        av.setlTags(lTagMapper.selectTagsByArticleId(article.getId()));
        return av;
    }

//    文章管理 获取所有文章（包括分类标签,包括删除）
    @Override
    @Cacheable(key = "'getArticleAll'+#search", unless = "#result==null")
    public List<LArticleVo> getLArticleListBySearch(String search) {
//        List<LArticle> articleList= lArticleMapper.selectByExample(new LArticleExample());
//        List<LArticleVo> articleVos=new ArrayList<>();
        List<LArticleVo> articleVoList=lArticleMapper.selectBySearch(search);
        for (LArticleVo lArticleVo : articleVoList) {
            lArticleVo.setlCategory(lCategoryMapper.selectCategoryByArticleId(lArticleVo.getId()));
            lArticleVo.setlTags(lTagMapper.selectTagsByArticleId(lArticleVo.getId()));
        }
        return articleVoList;
    }

    @Override
    public boolean addLArticle(LArticle lArticle) {
        return lArticleMapper.insert(lArticle)>0;
    }

//    修改，新增，删除后更新缓存
    private List<LArticleVo> allLArticleList() {
        List<LArticleVo> articleVos=new ArrayList<>();
        List<LArticle> articleVoList=lArticleMapper.selectByExample(new LArticleExample());
        for (LArticle lArticle : articleVoList) {
            LArticleVo av=new LArticleVo();
            BeanUtils.copyProperties(lArticle,av);
            av.setlCategory(lCategoryMapper.selectCategoryByArticleId(lArticle.getId()));
            av.setlTags(lTagMapper.selectTagsByArticleId(lArticle.getId()));
            articleVos.add(av);
        }
        return articleVos;
    }
    //    管理：添加文章
    @Override
    public boolean addArticleDto(LArticleDto lArticleDto) {
//        System.out.println(lArticleDto);
        LArticle lArticle=new LArticle();
        BeanUtils.copyProperties(lArticleDto,lArticle);
        lArticle.setZan(0);
        lArticle.setIsDelete(0);
        lArticle.setReading(0);
        lArticle.setStatus(1);
        lArticle.setCreateTime(new Date());
//        插入数据库
//        判断是否有同标题文章
        if (lArticleMapper.ifRepeatArticle(lArticle.getArticleTitle(),lArticle.getArticleText())!=null){
            return false;
        }
        lArticleMapper.insert(lArticle);
        int articleId =lArticle.getId();
//        System.out.println("aid:"+lArticle.getId());
        if (articleId>0){
            List<LTag> lTags=lArticleDto.getlTags();
            for (LTag lTag : lTags) {
                lArticleTagMapper.insert(new LArticleTag().setArticleId(articleId).setTagId(lTag.getId()));
            }
            lArticleCategoryMapper.insert(new LArticleCategory().setArticleId(articleId).setCategoryId(lArticleDto.getlCategory()));

            redisTemplate.opsForValue().set("cache:article:getArticleAll", allLArticleList(), Duration.ofMinutes(20));

            return true;
        }else {
            return false;
        }
    }

    //    编辑修改文章
    @Override
    public boolean upDataLArticle(LArticleDto lArticleDto) {
        LArticle lArticle = new LArticle();
        BeanUtils.copyProperties(lArticleDto,lArticle);
        lArticle.setUpdateTime(new Date());
//        System.out.println("更改的"+lArticle);
        //        插入数据库
        lArticleMapper.updateByPrimaryKey(lArticle);
        int articleId=lArticleDto.getId();
        if (articleId>0){
//        修改分类
            LArticleCategory ac = new LArticleCategory().setArticleId(articleId).setCategoryId(lArticleDto.getlCategory());
            if (lArticleCategoryMapper.selectByPrimaryKey(articleId)!=null){
                lArticleCategoryMapper.updateByPrimaryKey(ac);
            }else {
                lArticleCategoryMapper.insert(ac);
            }

//            删除标签
            lArticleTagMapper.deleteByPrimaryKey(articleId);

//            插入标签
            for (LTag tag : lArticleDto.getlTags()) {
                lArticleTagMapper.insert(new LArticleTag().setArticleId(articleId).setTagId(tag.getId()));
            }
            redisTemplate.opsForValue().set("cache:article:getArticleAll", allLArticleList(), Duration.ofMinutes(20));
            return true;
        }

        return false;
//        return lArticleMapper.updateByExample(lArticle,new LArticleExample())>0;
    }

//    获取首页文章
    @Override
    @Cacheable(key = "'getHomeArticle'+#pageNum+'-'+#pageSize", unless = "#result==null")
    public Map<String,Object> selectArticleHomeList(int pageNum, int pageSize){
        Map m=new HashMap();
        int sum=lArticleMapper.selectArticleHome().size();
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleHomeVo> articleHomeVoList=lArticleMapper.selectArticleHome();
        for (ArticleHomeVo articleHomeVo : articleHomeVoList) {
            articleHomeVo.setlCategory(lCategoryMapper.selectCategoryByArticleId(articleHomeVo.getId()));
            articleHomeVo.setlTags(lTagMapper.selectTagsByArticleId(articleHomeVo.getId()));
        }
        m.put("total",sum);
        m.put("list",articleHomeVoList);
        return m;
    }

//    获取推荐文章
    @Override
    public List<ArticleRecommendVO> getRecommendArticleList() {
        return lArticleMapper.selectArticleRecommend();
    }

//    获取搜索文章
    @Override
    @Cacheable(key = "'searchArticle'+#search", unless = "#result==null")
    public List<ArticleSearchVO> getSearchArticle(String search) {
        return lArticleMapper.selectArticleSearchList(search);
    }

//    彻底删除文章
    @Override
    public boolean foreverDeleteArticle(Integer id) {
//        return lArticleMapper.deleteByPrimaryKey(id)>0;
        if (lArticleMapper.deleteByPrimaryKey(id)>0) {
            lArticleTagMapper.deleteByArticleId(id);
            lArticleCategoryMapper.deleteByArticleId(id);
            redisTemplate.opsForValue().set("cache:article:getArticleAll", allLArticleList(), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

//    是否置顶
    @Override
    public boolean updateTop(ArticleIsTopDto articleIsTopDto) {
//        return lArticleMapper.updateIsTop(articleIsTopDto)>0;
        if (lArticleMapper.updateIsTop(articleIsTopDto)>0){
            redisTemplate.opsForValue().set("cache:article:getArticleAll", allLArticleList(), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

//    是否推荐
    @Override
    public boolean updateRecommend(ArticleIsRecommendDto articleIsRecommendDto) {
//        return lArticleMapper.updateIsRecommend(articleIsRecommendDto)>0;
        if (lArticleMapper.updateIsRecommend(articleIsRecommendDto)>0){
            redisTemplate.opsForValue().set("cache:article:getArticleAll", allLArticleList(), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

//    暂时删除或者回收文章
    @Override
    public boolean updateDelete(ArticleDeleteDto articleDeleteDto) {
//        return lArticleMapper.updateIsDelete(articleDeleteDto)>0;
        if (lArticleMapper.updateIsDelete(articleDeleteDto)>0){
            redisTemplate.opsForValue().set("cache:article:getArticleAll", allLArticleList(), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
//    根据id获取编辑页面的文章
    public LArticleVo LArticleVoById(Integer id) {
        LArticleVo lArticleVo = lArticleMapper.getLArticleVoById(id);
        lArticleVo.setlCategory(lCategoryMapper.selectCategoryByArticleId(id));
        lArticleVo.setlTags(lTagMapper.selectTagsByArticleId(id));
        return lArticleVo;
    }

//   阅读+1
    @Override
    public boolean addReading(Integer id) {
        return lArticleMapper.updateRead(id)>0;
    }
//  点赞+1
    @Override
    public boolean addZan(Integer id) {
        return lArticleMapper.updateZan(id)>0;
    }

    @Override
    // 获取全部用户
    @Cacheable(key = "'aList'", unless = "#result==null")
    public Dict updateArticleToMon() {
//        统计日期
        List<LArticle> lArticles = lArticleMapper.selectByExample(new LArticleExample());
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM");
        for (LArticle lArticle : lArticles) {
            lArticle.setDateToString(dateformat.format(lArticle.getCreateTime()));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -6);
        Set<String> dates=new LinkedHashSet<>();
        // 获取最近五个月的日期
        for (int i = 1; i <= 6; i++) {
            calendar.add(Calendar.MONTH, 1); // 减去一个月
            Date recentMonth = calendar.getTime();
            dates.add(dateformat.format(recentMonth));
        }
//        System.out.println(dates);

        List<Dict> lineList = new ArrayList<>();
        for (String date : dates) {
            Integer sum=lArticles.stream().filter(a->a.getDateToString().equals(date)).reduce(0, (x, y) -> x + 1,Integer::sum);
            Dict dict = Dict.create();
            Dict line = dict.set("date", date).set("value", sum);
            lineList.add(line);
        }
        return  Dict.create().set("bar",lineList);
    }


}
