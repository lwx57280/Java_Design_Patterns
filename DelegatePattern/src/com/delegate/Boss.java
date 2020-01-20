package com.delegate;

import com.delegate.manager.Manager;

/**
 * Boss 对项目经理manger下达命令
 * @Author:         li cong zhi
 * @CreateDate:     2020/1/20 12:08
 * @UpdateUser:    li cong zhi
 * @UpdateDate:     2020/1/20 12:08
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class Boss {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.doing("加密");
        manager.doing("登录");
    }
}
