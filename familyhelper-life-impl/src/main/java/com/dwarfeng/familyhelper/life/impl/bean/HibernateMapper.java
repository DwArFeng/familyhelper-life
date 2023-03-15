package com.dwarfeng.familyhelper.life.impl.bean;

import com.dwarfeng.familyhelper.life.impl.bean.entity.*;
import com.dwarfeng.familyhelper.life.impl.bean.key.HibernatePopbKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Hibernate Bean 映射器。
 *
 * @author DwArFeng
 * @since 1.6.0
 */
@Mapper
public interface HibernateMapper {

    HibernateLongIdKey longIdKeyToHibernate(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromHibernate(HibernateLongIdKey hibernateLongIdKey);

    HibernateStringIdKey stringIdKeyToHibernate(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromHibernate(HibernateStringIdKey hibernateStringIdKey);

    HibernatePopbKey popbKeyToHibernate(PopbKey popbKey);

    @InheritInverseConfiguration
    PopbKey popbKeyFromHibernate(HibernatePopbKey hibernatePopbKey);

    @Mapping(target = "popbs", ignore = true)
    @Mapping(target = "nodes", ignore = true)
    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "items", ignore = true)
    HibernatePbSet pbSetToHibernate(PbSet pbSet);

    @InheritInverseConfiguration
    PbSet pbSetFromHibernate(HibernatePbSet hibernatePbSet);

    @Mapping(target = "setLongId", ignore = true)
    @Mapping(target = "set", ignore = true)
    @Mapping(target = "pbItems", ignore = true)
    @Mapping(target = "parentLongId", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "longId", ignore = true)
    HibernatePbNode pbNodeToHibernate(PbNode pbNode);

    @InheritInverseConfiguration
    PbNode pbNodeFromHibernate(HibernatePbNode hibernatePbNode);

    @Mapping(target = "setLongId", ignore = true)
    @Mapping(target = "set", ignore = true)
    @Mapping(target = "records", ignore = true)
    @Mapping(target = "nodeLongId", ignore = true)
    @Mapping(target = "node", ignore = true)
    @Mapping(target = "longId", ignore = true)
    HibernatePbItem pbItemToHibernate(PbItem pbItem);

    @InheritInverseConfiguration
    PbItem pbItemFromHibernate(HibernatePbItem hibernatePbItem);

    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "itemLongId", ignore = true)
    @Mapping(target = "item", ignore = true)
    @Mapping(target = "fileInfos", ignore = true)
    HibernatePbRecord pbRecordToHibernate(PbRecord pbRecord);

    @InheritInverseConfiguration
    PbRecord pbRecordFromHibernate(HibernatePbRecord hibernatePbRecord);

    @Mapping(target = "recordLongId", ignore = true)
    @Mapping(target = "record", ignore = true)
    @Mapping(target = "longId", ignore = true)
    HibernatePbFileInfo pbFileInfoToHibernate(PbFileInfo pbFileInfo);

    @InheritInverseConfiguration
    PbFileInfo pbFileInfoFromHibernate(HibernatePbFileInfo hibernatePbFileInfo);

    @Mapping(target = "userStringId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "pbSet", ignore = true)
    @Mapping(target = "pbLongId", ignore = true)
    HibernatePopb popbToHibernate(Popb popb);

    @InheritInverseConfiguration
    Popb popbFromHibernate(HibernatePopb hibernatePopb);

    @Mapping(target = "stringId", ignore = true)
    @Mapping(target = "popbs", ignore = true)
    HibernateUser userToHibernate(User user);

    @InheritInverseConfiguration
    User userFromHibernate(HibernateUser hibernateUser);
}
