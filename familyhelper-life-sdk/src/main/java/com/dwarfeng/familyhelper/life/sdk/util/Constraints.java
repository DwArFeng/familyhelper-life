package com.dwarfeng.familyhelper.life.sdk.util;

/**
 * 约束类。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public final class Constraints {

    /**
     * 名称的长度约束。
     */
    public static final int LENGTH_NAME = 50;

    /**
     * 备注的长度约束。
     */
    public static final int LENGTH_REMARK = 100;

    /**
     * 用户主键的长度约束。
     */
    public static final int LENGTH_USER = 50;

    /**
     * 单位的长度约束。
     */
    public static final int LENGTH_UNIT = 10;

    private Constraints() {
        throw new IllegalStateException("禁止实例化");
    }
}
