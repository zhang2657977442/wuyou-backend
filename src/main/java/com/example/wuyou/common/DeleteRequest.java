package com.example.wuyou.common;

import java.io.Serializable;
import lombok.Data;

@Data
public class DeleteRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}
