package com.djay.doj.model.dto.question;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * 创建请求
 */
@Data
public class QuestionAddRequest implements Serializable {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("标签列表")
    private List<String> tags;

    @ApiModelProperty("题目答案")
    private String answer;

    @ApiModelProperty("判题用例")
    private List<JudgeCase> judgeCase;

    @ApiModelProperty("判题配置")
    private JudgeConfig judgeConfig;

    private static final long serialVersionUID = 1L;
}