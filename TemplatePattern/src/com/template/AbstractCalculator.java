package com.template;

/**
 * 计算器抽象方法
 *
 * @Author: li cong zhi
 * @CreateDate: 2020/1/20 13:16
 * @UpdateUser: li cong zhi
 * @UpdateDate: 2020/1/20 13:16
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public abstract class AbstractCalculator {
    /**
     * 实现对本类其它方法的调用
     *
     * @param
     * @return
     * @throws
     * @author li cong zhi
     * @date 2020/1/20 13:18
     */
    public final int calculate(String exp, String opt) {
        int[] array = split(exp, opt);
        return calculate(array[0], array[1]);
    }

    /**
     * 被子类重写的方法
     *
     * @param
     * @return
     * @throws
     * @author li cong zhi
     * @date 2020/1/20 13:20
     */
    protected abstract int calculate(int num1, int num2);

    protected int[] split(String exp, String opt) {
        String[] array = exp.split(opt);
        int[] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}
