package com.example.my_blog.service;


import cn.hutool.core.lang.Dict;
import com.example.my_blog.common.Result;
import com.example.my_blog.dto.ArticleDeleteDto;
import com.example.my_blog.dto.ArticleIsRecommendDto;
import com.example.my_blog.dto.ArticleIsTopDto;
import com.example.my_blog.dto.LArticleDto;
import com.example.my_blog.model.LArticle;
import com.example.my_blog.vo.ArticleHomeVo;
import com.example.my_blog.vo.ArticleRecommendVO;
import com.example.my_blog.vo.ArticleSearchVO;
import com.example.my_blog.vo.LArticleVo;

import java.util.List;
import java.util.Map;

public interface LArticleService {

//    List<LArticle> getLArticleList();

    Result inLArticle(Integer id);

//    List<LArticleVo> getLArticleVoList();

    List<LArticleVo> getLArticleListBySearch(String search);

    boolean addLArticle(LArticle lArticle);

    boolean addArticleDto(LArticleDto lArticleDto);

    boolean upDataLArticle(LArticleDto lArticleDto);

    boolean updateDelete(ArticleDeleteDto articleDeleteDto);

    Map<String,Object> selectArticleHomeList(int pageNum, int pageSize);

    List<ArticleRecommendVO> getRecommendArticleList();

    List<ArticleSearchVO> getSearchArticle(String search);

    boolean foreverDeleteArticle(Integer id);

    boolean updateTop(ArticleIsTopDto articleIsTopDto);

    boolean updateRecommend(ArticleIsRecommendDto articleIsRecommendDto);

    LArticleVo LArticleVoById(Integer id);

    boolean addReading(Integer id);

    boolean addZan(Integer id);

    Dict updateArticleToMon();
}
