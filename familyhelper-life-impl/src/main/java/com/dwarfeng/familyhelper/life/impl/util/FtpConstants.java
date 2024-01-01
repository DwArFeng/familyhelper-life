package com.dwarfeng.familyhelper.life.impl.util;

/**
 * FTP 常量。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public final class FtpConstants {

    public static final String[] FILE_PATHS_PB_FILE = new String[]{"familyhelper-life", "pb-file"};
    public static final String[] FILE_PATHS_ACTIVITY_TEMPLATE_COVER = new String[]{
            "familyhelper-life", "activity-template-cover"
    };
    public static final String[] FILE_PATHS_ACTIVITY_TEMPLATE_FILE = new String[]{
            "familyhelper-life", "activity-template-file"
    };
    public static final String[] FILE_PATHS_ACTIVITY_COVER = new String[]{"familyhelper-life", "activity-cover"};
    public static final String[] FILE_PATHS_ACTIVITY_FILE = new String[]{"familyhelper-life", "activity-file"};

    private FtpConstants() {
        throw new IllegalStateException("禁止实例化");
    }
}
