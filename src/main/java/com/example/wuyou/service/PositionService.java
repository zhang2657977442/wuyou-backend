package com.example.wuyou.service;

import com.example.wuyou.model.dto.PageListResponse;
import com.example.wuyou.model.entity.Position;

public interface PositionService {

    PageListResponse getPositionList(long current, long pageSize);

    Boolean deletePosition(String id);

    Boolean addPosition(Position params);

    Boolean updatePosition(Position params);
}
