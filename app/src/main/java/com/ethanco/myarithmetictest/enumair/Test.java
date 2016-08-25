package com.ethanco.myarithmetictest.enumair;

import java.io.IOException;

/**
 * 一句话功能描述
 * 功能详细描述
 *
 * @author [作者] 必须
 * @see [相关类/方法] (可选)
 * @since [产品/模块版本] (必须)
 * @deprecated 可选
 */
public class Test {
    /**
     * 字段注释
     */
    private String logType;

    /**
     * 函数注解
     */
    public void write() {

    }

    /**
     * 一句话功能描述
     * 功能详细描述
     * @param [参数1] 参数1说明
     * @param [参数2] 参数2说明
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     * @deprecated (可选)
     */

    /**
     * 登陆
     * 账号的登陆，登陆成功后保存token到本地。
     *
     * @param name 用户名
     * @param pwd  密码
     * @return 登陆是否成功
     * @since 1.0
     */
    public boolean login(String name, String pwd) {
        return true;
    }

    /**
     * 关闭当前数据流
     * @throws IOException 当关闭流失败时抛出该异常
     */
    public void close() throws IOException {

    }
}
