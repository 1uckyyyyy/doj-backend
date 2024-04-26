package com.djay.doj.judge.codesandbox;

import com.djay.doj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.djay.doj.judge.codesandbox.model.ExecuteCodeRequest;
import com.djay.doj.judge.codesandbox.model.ExecuteCodeResponse;
import com.djay.doj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Date: 2024/04/22 23:55
 * @Created by DJay
 */
@SpringBootTest
class CodeSandboxTest {
    @Value("${codeSandbox.type}")
    private String type;
    @Test
    void execute() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.next();
            CodeSandbox codeSandBox = CodeSandboxFactory.newInstance(type);
            String code = "int main{}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputeList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputeList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
            Assertions.assertNotNull(executeCodeResponse);
        }

    }

    @Test
    void executeByValue() {
            CodeSandbox codeSandBox = CodeSandboxFactory.newInstance(type);
            String code = "int main{}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputeList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputeList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
            Assertions.assertNotNull(executeCodeResponse);

        }

    @Test
    void executeByProxy() {
        CodeSandbox codeSandBox = new CodeSandboxProxy(CodeSandboxFactory.newInstance(type));
        String code = "int main{}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputeList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputeList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.next();
            CodeSandbox codeSandBox = CodeSandboxFactory.newInstance(type);
            String code = "int main{}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputeList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputeList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        }
    }

}