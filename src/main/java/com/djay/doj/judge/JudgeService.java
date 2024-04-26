package com.djay.doj.judge;

import com.djay.doj.model.entity.QuestionSubmit;

/**
 * @Description:
 * @Date: 2024/04/23 1:01
 * @Created by DJay
 */
public interface JudgeService {

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(Long questionSubmitId);
}
