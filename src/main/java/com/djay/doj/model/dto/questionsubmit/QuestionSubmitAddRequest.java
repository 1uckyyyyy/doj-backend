package com.djay.doj.model.dto.questionsubmit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    @ApiModelProperty("编程语言")
    private String language;

    @ApiModelProperty("用户代码")
    private String code;

    @ApiModelProperty("题目 id")
    private Long questionId;

    private static final long serialVersionUID = 1L;
}