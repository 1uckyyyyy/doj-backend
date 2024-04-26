package com.djay.doj.judge.codesandbox.impl;

import com.djay.doj.judge.codesandbox.CodeSandbox;
import com.djay.doj.judge.codesandbox.model.ExecuteCodeRequest;
import com.djay.doj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 远程代码沙箱
 * @Date: 2024/04/22 23:51
 * @Created by DJay
 */
@Slf4j
public class RemoteCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("远程代码沙箱");
        return null;
    }
}
