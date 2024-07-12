package com.example.my_blog.service;

import com.example.my_blog.model.LComment;
import com.example.my_blog.vo.LCommentsVo;
import com.example.my_blog.vo.RecentCommentVO;

import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/10
 */
public interface LCommentService {
    List<LCommentsVo> lComments(Integer articleId);

    boolean addComment(LComment lComment);

    List<RecentCommentVO> recentCommentList();
}
