package com.djay.doj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.djay.doj.annotation.AuthCheck;
import com.djay.doj.common.BaseResponse;
import com.djay.doj.common.ErrorCode;
import com.djay.doj.common.ResultUtils;
import com.djay.doj.constant.UserConstant;
import com.djay.doj.exception.BusinessException;
import com.djay.doj.model.dto.question.QuestionQueryRequest;
import com.djay.doj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.djay.doj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.djay.doj.model.entity.Question;
import com.djay.doj.model.entity.QuestionSubmit;
import com.djay.doj.model.entity.User;
import com.djay.doj.model.vo.QuestionSubmitVO;
import com.djay.doj.service.QuestionSubmitService;
import com.djay.doj.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 */
@Api(tags = "02 题目提交管理")
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return questionId  提交纪律的id
     */
    @ApiOperation(value = "提交题目")
    @PostMapping("/")
    public BaseResponse<Long> doQueationSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                         HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(result);
    }

    /**
     * 分页获取题目提交列表（除管理员外，普通用户只能看到非答案、代码等公开信息）
     *  能够根据用户id、题目状态、编程语言去查询提交记录
     * @param questionSubmitQueryRequest
     * @return
     */
    @ApiOperation(value = "分页获取题目提交列表")
    @PostMapping("/submitList/page")
//    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                         HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        final User loginUser = userService.getLoginUser(request);
        // 从数据库中返回原始的题目提交分页信息（未脱敏）
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        // 返回脱敏信息
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }

}
