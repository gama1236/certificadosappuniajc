package com.uniajc.smartcampus.certificados.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleResponse {

    private Integer code;
    private String message;
    private Object value;

}
