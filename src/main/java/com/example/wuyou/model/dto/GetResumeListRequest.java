package com.example.wuyou.model.dto;

import com.example.wuyou.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetResumeListRequest extends PageRequest implements Serializable {
    /**
     * job_name
     */
    private String keyword;

}
