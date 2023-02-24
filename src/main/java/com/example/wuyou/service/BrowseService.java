package com.example.wuyou.service;

import com.example.wuyou.model.enums.BrowseTypeEnum;

public interface BrowseService {

    Boolean addBrowse(String userId, String jobId, BrowseTypeEnum type);
}
