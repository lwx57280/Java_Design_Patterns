package com.delegate.company;
/**
 * 员工类StaffA
 * @Author:         li cong zhi
 * @CreateDate:     2020/1/20 12:07
 * @UpdateUser:    li cong zhi
 * @UpdateDate:     2020/1/20 12:07
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class StaffB implements Staff {
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我现在开始干" + command + "工作");
    }
}
