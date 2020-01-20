package com.delegate.manager;

import com.delegate.company.Staff;
import com.delegate.company.StaffA;
import com.delegate.company.StaffB;

import java.util.HashMap;
import java.util.Map;
/**
 * 项目经理manager
 * @Author:         li cong zhi
 * @CreateDate:     2020/1/20 12:06
 * @UpdateUser:    li cong zhi
 * @UpdateDate:     2020/1/20 12:06
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class Manager {

    private Map<String, Staff> targets = new HashMap<>();

    public Manager() {
        targets.put("加密", new StaffA());
        targets.put("登录", new StaffB());
    }

    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
