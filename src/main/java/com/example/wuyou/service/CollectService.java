package com.example.wuyou.service;

import com.example.wuyou.model.enums.CollectTypeEnum;

public interface CollectService {
  Boolean addCollect(String userId, String jobId, CollectTypeEnum type);
}
