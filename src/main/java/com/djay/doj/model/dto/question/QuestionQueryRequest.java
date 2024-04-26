package com.djay.doj.model.dto.question;

import com.djay.doj.common.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 查询请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("标签列表")
    private List<String> tags;

    @ApiModelProperty("题目答案")
    private String answer;

    @ApiModelProperty("创建用户 id")
    private Long userId;

    private static final long serialVersionUID = 1L;
}