package com.example.my_blog.mapper;

import com.example.my_blog.dto.LSettingNoticeDto;
import com.example.my_blog.dto.WebSettingDto;
import com.example.my_blog.model.LWebSetting;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/19
 */
public interface LWebSettingMapper {
    LWebSetting getWebSetting();

    int updateWebLybgi(String webLybgi);

    int updateWebHomeImage(String homeImage);

    int updateWebSbbgi(String sbbgi);

    int updateWebXcbgi(String xcbgi);

    int updateFriendBgi(String webFriendbgi);

    int updateToolBgi(String webToolbgi);

    int updateNoting(WebSettingDto settingDto);

    int updateWebNotice(LSettingNoticeDto lSettingNoticeDto);

}
