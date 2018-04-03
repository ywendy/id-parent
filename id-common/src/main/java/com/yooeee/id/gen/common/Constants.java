package com.yooeee.id.gen.common;

/**
 * 生成id中间的常量.
 *
 * @author Administrator
 * @date 2018/4/2.
 */
public class Constants {
    /**
     * 时间值.
     */
    public static final long EPOCH = 1288834974657L;

    public static final long SEQ_MASK = -1L ^ (-1L << 0xa);

    public static final long GENE_MASK = -1L ^ (-1L << 0x6);
    public static final long APP_MASK = -1L ^ (-1L << 0x3);
    public static final long TYPE_MASK = -1L ^ (-1L << 0x1);

    public static final int APP_MAX = -1 ^ (-1 << 0x3);
    public static final int MIN = 0;

    public static final int ENV_MAX = 0X3;
    public static final int ENV_MIN = 0X0;



















}
