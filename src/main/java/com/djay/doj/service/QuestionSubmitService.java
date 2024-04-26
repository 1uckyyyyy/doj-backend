package com.djay.doj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.djay.doj.model.dto.question.QuestionQueryRequest;
import com.djay.doj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.djay.doj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.djay.doj.model.entity.Question;
import com.djay.doj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.djay.doj.model.entity.User;
import com.djay.doj.model.vo.QuestionSubmitVO;
import com.djay.doj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DJay
 * @description 针对表【question_submit(题目提交)】的数据库操作Service
 * @createDate 2024-02-26 16:32:07
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取问题封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取问题封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
