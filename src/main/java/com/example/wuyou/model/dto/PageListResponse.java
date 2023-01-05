package com.example.wuyou.model.dto;

import java.io.Serializable;

import lombok.Data;
@Data

public class PageListResponse<T> implements Serializable {
    /**
     * List
     */
    private java.util.List<T> List;

    /**
     * total
     */
    private long total;
}
