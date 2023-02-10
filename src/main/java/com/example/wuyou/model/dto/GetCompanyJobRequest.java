package com.example.wuyou.model.dto;

import com.example.wuyou.common.PageRequest;
import lombok.Data;
import java.io.Serializable;

@Data
public class GetCompanyJobRequest extends PageRequest implements Serializable {
    /**
     * company_id
     */
    private String id;

}
