package com.dwarfeng.familyhelper.life.sdk.util;

import com.dwarfeng.subgrade.stack.exception.ServiceException;

/**
 * 服务异常代码。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public final class ServiceExceptionCodes {

    private static int EXCEPTION_CODE_OFFSET = 13000;

    public static final ServiceException.Code USER_NOT_EXISTS =
            new ServiceException.Code(offset(0), "user not exists");
    public static final ServiceException.Code USER_NOT_PERMITTED_FOR_PB_SET =
            new ServiceException.Code(offset(10), "user not permitted for pb set");
    public static final ServiceException.Code PB_SET_NOT_EXISTS =
            new ServiceException.Code(offset(20), "pb set not exists");
    public static final ServiceException.Code INVALID_PERMISSION_LEVEL =
            new ServiceException.Code(offset(30), "invalid permission level");
    public static final ServiceException.Code PB_NODE_NOT_EXISTS =
            new ServiceException.Code(offset(40), "pb node not exists");
    public static final ServiceException.Code ILLEGAL_PB_NODE_STATE =
            new ServiceException.Code(offset(50), "illegal pb node state");
    public static final ServiceException.Code PB_SET_NOT_IDENTICAL =
            new ServiceException.Code(offset(60), "pb set not identical");
    public static final ServiceException.Code PB_ITEM_NOT_EXISTS =
            new ServiceException.Code(offset(70), "pb item not exists");
    public static final ServiceException.Code ILLEGAL_PB_ITEM_STATE =
            new ServiceException.Code(offset(80), "illegal pb item state");
    public static final ServiceException.Code PB_RECORD_NOT_EXISTS =
            new ServiceException.Code(offset(90), "pb record not exists");
    public static final ServiceException.Code ILLEGAL_PB_RECORD_STATE =
            new ServiceException.Code(offset(100), "illegal pb record state");
    public static final ServiceException.Code PB_FILE_NOT_EXISTS =
            new ServiceException.Code(offset(110), "pb file not exists");
    public static final ServiceException.Code USER_NOT_PERMITTED_FOR_ACTIVITY_DATA_SET =
            new ServiceException.Code(offset(120), "user not permitted for activity data set");
    public static final ServiceException.Code ACTIVITY_DATA_SET_NOT_EXISTS =
            new ServiceException.Code(offset(130), "activity data set not exists");
    public static final ServiceException.Code ACTIVITY_DATA_NODE_NOT_EXISTS =
            new ServiceException.Code(offset(140), "activity data node not exists");
    public static final ServiceException.Code ILLEGAL_ACTIVITY_DATA_NODE_STATE =
            new ServiceException.Code(offset(150), "illegal activity data node state");
    public static final ServiceException.Code ACTIVITY_DATA_SET_NOT_IDENTICAL =
            new ServiceException.Code(offset(160), "activity data set not identical");
    public static final ServiceException.Code ACTIVITY_DATA_ITEM_NOT_EXISTS =
            new ServiceException.Code(offset(170), "activity data item not exists");
    public static final ServiceException.Code ILLEGAL_ACTIVITY_DATA_ITEM_STATE =
            new ServiceException.Code(offset(180), "illegal activity data item state");
    public static final ServiceException.Code ACTIVITY_TEMPLATE_NOT_EXISTS =
            new ServiceException.Code(offset(190), "activity template not exists");
    public static final ServiceException.Code USER_NOT_PERMITTED_FOR_ACTIVITY_TEMPLATE =
            new ServiceException.Code(offset(200), "user not permitted for activity template");
    public static final ServiceException.Code ACTIVITY_TEMPLATE_COVER_NOT_EXISTS =
            new ServiceException.Code(offset(210), "activity template cover not exists");
    public static final ServiceException.Code ILLEGAL_ACTIVITY_TEMPLATE_COVER_STATE =
            new ServiceException.Code(offset(220), "illegal activity template cover state");
    public static final ServiceException.Code ACTIVITY_TEMPLATE_PARTICIPANT_EXISTS =
            new ServiceException.Code(offset(230), "activity template participant exists");
    public static final ServiceException.Code ACTIVITY_TEMPLATE_PARTICIPANT_NOT_EXISTS =
            new ServiceException.Code(offset(240), "activity template participant not exists");
    public static final ServiceException.Code ACTIVITY_TEMPLATE_DATA_INFO_NOT_EXISTS =
            new ServiceException.Code(offset(250), "activity template data info not exists");
    public static final ServiceException.Code ACTIVITY_NOT_EXISTS =
            new ServiceException.Code(offset(260), "activity not exists");
    public static final ServiceException.Code USER_NOT_PERMITTED_FOR_ACTIVITY =
            new ServiceException.Code(offset(270), "user not permitted for activity");
    public static final ServiceException.Code ACTIVITY_LOCKED =
            new ServiceException.Code(offset(280), "activity locked");
    public static final ServiceException.Code ACTIVITY_COVER_NOT_EXISTS =
            new ServiceException.Code(offset(290), "activity cover not exists");
    public static final ServiceException.Code ILLEGAL_ACTIVITY_COVER_STATE =
            new ServiceException.Code(offset(300), "illegal activity cover state");
    public static final ServiceException.Code ACTIVITY_FILE_NOT_EXISTS =
            new ServiceException.Code(offset(310), "activity file not exists");
    public static final ServiceException.Code ILLEGAL_ACTIVITY_FILE_STATE =
            new ServiceException.Code(offset(320), "illegal activity file state");
    public static final ServiceException.Code ACTIVITY_PARTICIPANT_EXISTS =
            new ServiceException.Code(offset(330), "activity participant exists");
    public static final ServiceException.Code ACTIVITY_PARTICIPANT_NOT_EXISTS =
            new ServiceException.Code(offset(340), "activity participant not exists");
    public static final ServiceException.Code ACTIVITY_DATA_RECORD_NOT_EXISTS =
            new ServiceException.Code(offset(350), "activity data record not exists");
    public static final ServiceException.Code ACTIVITY_TEMPLATE_DRIVER_FAILED =
            new ServiceException.Code(offset(360), "activity template driver failed");
    public static final ServiceException.Code ACTIVITY_TEMPLATE_DRIVER_TYPE_UNSUPPORTED =
            new ServiceException.Code(offset(361), "activity template driver type unsupported");
    public static final ServiceException.Code ACTIVITY_TEMPLATE_DRIVER_INFO_NOT_EXISTS =
            new ServiceException.Code(offset(370), "activity template driver info not exists");

    private static int offset(int i) {
        return EXCEPTION_CODE_OFFSET + i;
    }

    /**
     * 获取异常代号的偏移量。
     *
     * @return 异常代号的偏移量。
     */
    public static int getExceptionCodeOffset() {
        return EXCEPTION_CODE_OFFSET;
    }

    /**
     * 设置异常代号的偏移量。
     *
     * @param exceptionCodeOffset 指定的异常代号的偏移量。
     */
    public static void setExceptionCodeOffset(int exceptionCodeOffset) {
        // 设置 EXCEPTION_CODE_OFFSET 的值。
        EXCEPTION_CODE_OFFSET = exceptionCodeOffset;

        // 以新的 EXCEPTION_CODE_OFFSET 为基准，更新异常代码的值。
        USER_NOT_EXISTS.setCode(offset(0));
        USER_NOT_PERMITTED_FOR_PB_SET.setCode(offset(10));
        PB_SET_NOT_EXISTS.setCode(offset(20));
        INVALID_PERMISSION_LEVEL.setCode(offset(30));
        PB_NODE_NOT_EXISTS.setCode(offset(40));
        ILLEGAL_PB_NODE_STATE.setCode(offset(50));
        PB_SET_NOT_IDENTICAL.setCode(offset(60));
        PB_ITEM_NOT_EXISTS.setCode(offset(70));
        ILLEGAL_PB_ITEM_STATE.setCode(offset(80));
        PB_RECORD_NOT_EXISTS.setCode(offset(90));
        ILLEGAL_PB_RECORD_STATE.setCode(offset(100));
        PB_FILE_NOT_EXISTS.setCode(offset(110));
        USER_NOT_PERMITTED_FOR_ACTIVITY_DATA_SET.setCode(offset(120));
        ACTIVITY_DATA_SET_NOT_EXISTS.setCode(offset(130));
        ACTIVITY_DATA_NODE_NOT_EXISTS.setCode(offset(140));
        ILLEGAL_ACTIVITY_DATA_NODE_STATE.setCode(offset(150));
        ACTIVITY_DATA_SET_NOT_IDENTICAL.setCode(offset(160));
        ACTIVITY_DATA_ITEM_NOT_EXISTS.setCode(offset(170));
        ILLEGAL_ACTIVITY_DATA_ITEM_STATE.setCode(offset(180));
        ACTIVITY_TEMPLATE_NOT_EXISTS.setCode(offset(190));
        USER_NOT_PERMITTED_FOR_ACTIVITY_TEMPLATE.setCode(offset(200));
        ACTIVITY_TEMPLATE_COVER_NOT_EXISTS.setCode(offset(210));
        ILLEGAL_ACTIVITY_TEMPLATE_COVER_STATE.setCode(offset(220));
        ACTIVITY_TEMPLATE_PARTICIPANT_EXISTS.setCode(offset(230));
        ACTIVITY_TEMPLATE_PARTICIPANT_NOT_EXISTS.setCode(offset(240));
        ACTIVITY_TEMPLATE_DATA_INFO_NOT_EXISTS.setCode(offset(250));
        ACTIVITY_NOT_EXISTS.setCode(offset(260));
        USER_NOT_PERMITTED_FOR_ACTIVITY.setCode(offset(270));
        ACTIVITY_LOCKED.setCode(offset(280));
        ACTIVITY_COVER_NOT_EXISTS.setCode(offset(290));
        ILLEGAL_ACTIVITY_COVER_STATE.setCode(offset(300));
        ACTIVITY_FILE_NOT_EXISTS.setCode(offset(310));
        ILLEGAL_ACTIVITY_FILE_STATE.setCode(offset(320));
        ACTIVITY_PARTICIPANT_EXISTS.setCode(offset(330));
        ACTIVITY_PARTICIPANT_NOT_EXISTS.setCode(offset(340));
        ACTIVITY_DATA_RECORD_NOT_EXISTS.setCode(offset(350));
        ACTIVITY_TEMPLATE_DRIVER_FAILED.setCode(offset(360));
        ACTIVITY_TEMPLATE_DRIVER_TYPE_UNSUPPORTED.setCode(offset(361));
        ACTIVITY_TEMPLATE_DRIVER_INFO_NOT_EXISTS.setCode(offset(370));
    }

    private ServiceExceptionCodes() {
        throw new IllegalStateException("禁止实例化");
    }
}
