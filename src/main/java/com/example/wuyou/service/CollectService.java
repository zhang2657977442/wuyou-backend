package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.enums.CollectTypeEnum;

public interface CollectService {
  Boolean addCollect(String userId, String dataId, CollectTypeEnum type);

  Boolean deleteCollect(String userId, String dataId, CollectTypeEnum type);

  Boolean isCollect(String userId, String dataId, CollectTypeEnum type);

  PageListResponse getCollectList(long current, long pageSize, String userId, CollectTypeEnum type);

  Boolean delete(String id);

}
