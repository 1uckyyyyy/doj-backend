package com.djay.doj.judge;

import com.djay.doj.judge.strategy.DefaultJudgeStrategy;
import com.djay.doj.judge.strategy.JavaLanguageJudgeStrategy;
import com.djay.doj.judge.strategy.JudgeContext;
import com.djay.doj.judge.strategy.JudgeStrategy;
import com.djay.doj.judge.codesandbox.model.JudgeInfo;
import com.djay.doj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
