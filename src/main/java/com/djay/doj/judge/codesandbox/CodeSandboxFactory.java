package com.djay.doj.judge.codesandbox;

import com.djay.doj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.djay.doj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.djay.doj.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * @Description: 代码沙箱工厂（根据字符串创建指定的代码沙箱实例）
 * @Date: 2024/04/23 0:14
 * @Created by DJay
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱实例
     * @param type
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdPart":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }

    }

}
