package com.djay.doj.model.dto.question;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 判题配置
 * @Date: 2024/02/26 17:29
 * @Created by DJay
 */
@Data
public class JudgeConfig {

    @ApiModelProperty("时间限制（ms）")
    private Long timeLimit;

    @ApiModelProperty("内容限制（KB）")
    private Long memoryLimit;

    @ApiModelProperty("堆栈限制（KB）")
    private Long stackLimit;
}
