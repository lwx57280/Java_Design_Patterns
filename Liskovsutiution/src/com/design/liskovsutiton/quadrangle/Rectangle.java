package com.design.liskovsutiton.quadrangle;

/**
 * 长方形
 * @Author:         cong zhi
 * @CreateDate:     2021/3/16 19:56
 * @UpdateUser:     cong zhi
 * @UpdateDate:     2021/3/16 19:56
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class Rectangle implements QuadRangle{

    private long height;

    private long width;

    public void setHeight(long height) {
        this.height = height;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    @Override
    public long getWidth() {
        return height;
    }

    @Override
    public long getHeight() {
        return width;
    }
}
