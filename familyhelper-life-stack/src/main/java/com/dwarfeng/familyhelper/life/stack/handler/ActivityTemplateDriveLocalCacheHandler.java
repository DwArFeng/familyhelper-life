package com.dwarfeng.familyhelper.life.stack.handler;

import com.dwarfeng.familyhelper.life.stack.struct.ActivityTemplateDriveInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.handler.LocalCacheHandler;

/**
 * 活动模板驱动用本地缓存处理器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ActivityTemplateDriveLocalCacheHandler extends
        LocalCacheHandler<LongIdKey, ActivityTemplateDriveInfo> {
}
