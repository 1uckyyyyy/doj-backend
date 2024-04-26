package com.djay.doj.judge.codesandbox.impl;

import com.djay.doj.judge.codesandbox.CodeSandbox;
import com.djay.doj.judge.codesandbox.model.ExecuteCodeRequest;
import com.djay.doj.judge.codesandbox.model.ExecuteCodeResponse;
import com.djay.doj.judge.codesandbox.model.JudgeInfo;
import com.djay.doj.model.enums.JudgeInfoMessageEnum;
import com.djay.doj.model.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Description: 示例代码沙箱（仅为了跑通业务流程）
 * @Date: 2024/04/22 23:51
 * @Created by DJay
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
