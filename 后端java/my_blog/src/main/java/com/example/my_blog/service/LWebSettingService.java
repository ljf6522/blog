package com.example.my_blog.service;

import com.example.my_blog.dto.LSettingNoticeDto;
import com.example.my_blog.dto.WebSettingDto;
import com.example.my_blog.model.LWebSetting;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/19
 */
public interface LWebSettingService {
    LWebSetting selectLWebSetting();

    boolean updateLyBgi(String lybgi);

    boolean updateHomeBgi(String homeBgi);

    boolean updateXiangceBgi(String xinagceBgi);

    boolean updateSuiBiBgi(String suiBiBgi);

    boolean updateFriend(String webFriendbgi);

    boolean updateSetting(WebSettingDto webSettingDto);

    boolean updateNotice(LSettingNoticeDto lSettingNoticeDto);

    boolean updateTool(String webToolbgi);
}
