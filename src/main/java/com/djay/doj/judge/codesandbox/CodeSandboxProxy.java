package com.djay.doj.judge.codesandbox;

import com.djay.doj.judge.codesandbox.model.ExecuteCodeRequest;
import com.djay.doj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Date: 2024/04/23 0:42
 * @Created by DJay
 */
@Slf4j
public class CodeSandboxProxy implements CodeSandbox {
    private final CodeSandbox codeSandbox; // 使用final是因为它只会被修改一次

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override

    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱执行前");
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱执行后");
        return executeCodeResponse;
    }
}
