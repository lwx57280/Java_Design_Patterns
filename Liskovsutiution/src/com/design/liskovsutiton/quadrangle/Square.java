package com.design.liskovsutiton.quadrangle;
/**
 * 正方形
 * @Author:         cong zhi
 * @CreateDate:     2021/3/16 19:56
 * @UpdateUser:     cong zhi
 * @UpdateDate:     2021/3/16 19:56
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class Square implements QuadRangle{

    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public long getWidth() {
        return length;
    }

    @Override
    public long getHeight() {
        return length;
    }
}
