package com.djay.doj.model.dto.question;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 判题用例
 * @Date: 2024/02/26 17:28
 * @Created by DJay
 */
@Data
public class JudgeCase {

    @ApiModelProperty("输入用例")
    private String input;

    @ApiModelProperty("输出用例")
    private String output;
}
