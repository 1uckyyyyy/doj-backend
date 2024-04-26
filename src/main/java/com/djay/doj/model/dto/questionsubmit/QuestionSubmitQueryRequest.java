package com.djay.doj.model.dto.questionsubmit;

import com.djay.doj.common.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 创建请求
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    @ApiModelProperty("编程语言")
    private String language;

    @ApiModelProperty("提交状态")
    private Integer status;

    @ApiModelProperty("题目 id")
    private Long questionId;

    @ApiModelProperty("用户 id")
    private Long userId;

    private static final long serialVersionUID = 1L;
}