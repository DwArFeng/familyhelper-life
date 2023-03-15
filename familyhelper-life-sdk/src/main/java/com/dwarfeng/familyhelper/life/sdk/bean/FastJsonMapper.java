package com.dwarfeng.familyhelper.life.sdk.bean;

import com.dwarfeng.familyhelper.life.sdk.bean.entity.*;
import com.dwarfeng.familyhelper.life.sdk.bean.key.FastJsonPopbKey;
import com.dwarfeng.familyhelper.life.stack.bean.entity.*;
import com.dwarfeng.familyhelper.life.stack.bean.key.PopbKey;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * FastJson Bean 映射器。
 *
 * @author DwArFeng
 * @since 1.6.0
 */
@Mapper
public interface FastJsonMapper {

    FastJsonLongIdKey longIdKeyToFastJson(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromFastJson(FastJsonLongIdKey fastJsonLongIdKey);

    FastJsonStringIdKey stringIdKeyToFastJson(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromFastJson(FastJsonStringIdKey fastJsonStringIdKey);

    FastJsonPopbKey popbKeyToFastJson(PopbKey popbKey);

    @InheritInverseConfiguration
    PopbKey popbKeyFromFastJson(FastJsonPopbKey fastJsonPopbKey);

    FastJsonPbSet pbSetToFastJson(PbSet pbSet);

    @InheritInverseConfiguration
    PbSet pbSetFromFastJson(FastJsonPbSet fastJsonPbSet);

    FastJsonPbNode pbNodeToFastJson(PbNode pbNode);

    @InheritInverseConfiguration
    PbNode pbNodeFromFastJson(FastJsonPbNode fastJsonPbNode);

    FastJsonPbItem pbItemToFastJson(PbItem pbItem);

    @InheritInverseConfiguration
    PbItem pbItemFromFastJson(FastJsonPbItem fastJsonPbItem);

    FastJsonPbRecord pbRecordToFastJson(PbRecord pbRecord);

    @InheritInverseConfiguration
    PbRecord pbRecordFromFastJson(FastJsonPbRecord fastJsonPbRecord);

    FastJsonPbFileInfo pbFileInfoToFastJson(PbFileInfo pbFileInfo);

    @InheritInverseConfiguration
    PbFileInfo pbFileInfoFromFastJson(FastJsonPbFileInfo fastJsonPbFileInfo);

    FastJsonPopb popbToFastJson(Popb popb);

    @InheritInverseConfiguration
    Popb popbFromFastJson(FastJsonPopb fastJsonPopb);

    FastJsonUser userToFastJson(User user);

    @InheritInverseConfiguration
    User userFromFastJson(FastJsonUser fastJsonUser);
}
