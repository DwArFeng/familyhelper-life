package com.dwarfeng.familyhelper.life.stack.dao;

import com.dwarfeng.familyhelper.life.stack.bean.entity.PbFileInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 个人最佳文件信息数据访问层。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface PbFileInfoDao extends BatchBaseDao<LongIdKey, PbFileInfo>, EntireLookupDao<PbFileInfo>,
        PresetLookupDao<PbFileInfo> {
}
