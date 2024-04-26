package com.djay.doj.judge.codesandbox;

import com.djay.doj.judge.codesandbox.model.ExecuteCodeRequest;
import com.djay.doj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @Description: 代码沙箱接口定义
 * @Date: 2024/04/22 23:48
 * @Created by DJay
 */
public interface CodeSandbox {
    /**
     * 执行代码
     * @return ExecuteCodeResponse
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);

}
