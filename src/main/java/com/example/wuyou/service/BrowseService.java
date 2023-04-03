package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.enums.BrowseTypeEnum;

public interface BrowseService {

    Boolean addBrowse(String userId, String dataId, BrowseTypeEnum type);

    PageListResponse getBrowseList(long current, long pageSize, String userId, BrowseTypeEnum type);

    Boolean deleteBrowse(String id);

}
