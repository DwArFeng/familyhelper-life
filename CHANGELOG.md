# ChangeLog

## Release_1.2.0_20251018_build_A

### 功能构建

- 部分 dubbo 消费者服务注册配置添加 `check="false"` 属性。
  - snowflakeGenerateService。

- 优化配置文件。
  - 优化 `application-context-database.xml`，使得更多属性可以在配置文件中配置。

- 为部分工具类中方法的入口参数增加 `@Nonnull` 注解。
  - com.dwarfeng.familyhelper.life.impl.service.telqos.CommandUtil。

- FTP 路径机制优化。
  - 新增 FtpPathResolver 代替 FtpConstants，使得 FTP 路径由静态定义变为动态解析。
  - 新增 `ftp/path.properties`，使得服务的 FTP 根路径支持动态配置。
  - 新的 FTP 路径机制使得不同组服务共享同一 FTP 服务器时，存储文件的路径隔离成为可能。

- 优化部分处理器的实现。
  - 优化 ActivityFileOperateHandlerImpl 中的部分常量字符串的内容。

- 优化 impl 模块下的 `logging` 目录结构。
  - 将 `logging/settings-windows.xml` 重命名为 `settings-ref-windows.xml`，以消除文件名的歧义。
  - 更新 `logging/README.md` 中的相关说明。

- 优化 node 模块下的 `logging` 目录结构。
  - 将 `logging/settings-linux.xml` 重命名为 `settings-ref-linux.xml`，以消除文件名的歧义。
  - 将 `logging/settings-windows.xml` 重命名为 `settings-ref-windows.xml`，以消除文件名的歧义。
  - 更新 `logging/README.md` 中的相关说明。

- 优化部分维护服务实现中的部分方法的性能。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityCoverInfoMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityDataItemMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityDataNodeMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityDataRecordMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityDataSetMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityFileInfoMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityParticipantMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityTemplateCoverInfoMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityTemplateDataInfoMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityTemplateDriverInfoMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityTemplateDriverSupportMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityTemplateFileInfoMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityTemplateMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityTemplateParticipantMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.ActivityTypeIndicatorMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PbFileInfoMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PbItemMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PbNodeMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PbRecordMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PbSetMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PoacMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PoadMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PoatacMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PoatMaintainServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PopbMaintainServiceImpl。

- 导入运维指令。
  - com.dwarfeng.datamark.service.telqos.*。

- 增加 Hibernate 实体数据标记字段，并应用相关实体侦听器。
  - com.dwarfeng.familyhelper.life.impl.bean.entity.HibernateActivityTypeIndicator。
  - com.dwarfeng.familyhelper.life.impl.bean.entity.HibernateUser。

- 增加依赖。
  - 增加依赖 `dwarfeng-datamark` 以应用其新功能，版本为 `1.0.1.a`。

- 优化开发环境支持。
  - 在 .gitignore 中添加 VSCode 相关文件的忽略规则。
  - 在 .gitignore 中添加 Cursor IDE 相关文件的忽略规则。

- SPI 目录结构优化。
  - 将活动模板驱动机制的 SPI 接口与抽象类提相关代码文件提升至 `sdk` 模块中。
  - 将推送机制的 SPI 接口与抽象类提相关代码文件提升至 `sdk` 模块中。
  - 将重置机制的 SPI 抽象类提相关代码文件提升至 `sdk` 模块中。

- 依赖升级。
  - 升级 `subgrade` 依赖版本为 `1.6.0.a` 并解决兼容性问题，以应用其新功能。
  - 升级 `spring` 依赖版本为 `5.3.39` 以规避漏洞。
  - 升级 `protobuf` 依赖版本为 `3.25.5` 以规避漏洞。
  - 升级 `jetty` 依赖版本为 `9.4.57.v20241219` 以规避漏洞。
  - 升级 `netty` 依赖版本为 `4.1.119.final` 以规避漏洞。
  - 升级 `zookeeper` 依赖版本为 `3.9.4` 以规避漏洞。
  - 升级 `snowflake` 依赖版本为 `1.7.2.a` 以规避漏洞。
  - 升级 `dwarfeng-ftp` 依赖版本为 `1.3.5.a` 以规避漏洞。
  - 升级 `spring-terminator` 依赖版本为 `1.0.14.a` 以规避漏洞。
  - 升级 `spring-telqos` 依赖版本为 `1.1.14.a` 以规避漏洞。

- 新增 telqos 指令。
  - com.dwarfeng.familyhelper.life.impl.service.telqos.SupportCommand。

- 优化支持实体机制。
  - 新建支持 QoS 服务 com.dwarfeng.familyhelper.life.stack.service.SupportQosService。
  - 将支持实体维护服务的重置功能迁移至 QoS 服务。

### Bug 修复

- 修正 `familyhelper-life-impl` 模块中错误的 dubbo 应用名称。

- 修复 telqos 工具类中部分注解不正确的 bug。
  - com.dwarfeng.familyhelper.life.impl.service.telqos.CommandUtil。

- 修复部分功能性实体集合类型的字段在映射时有可能产生空指针异常的问题。
  - com.dwarfeng.familyhelper.life.sdk.bean.dto.FastJsonActivityRemindedByDriverPushInfo。
  - com.dwarfeng.familyhelper.life.sdk.bean.dto.WebInputActivityCoverOrderUpdateInfo。
  - com.dwarfeng.familyhelper.life.sdk.bean.dto.WebInputActivityTemplateCoverOrderUpdateInfo。

- 重置功能 bug 修复。
  - 在活动模板驱动未启动的状态下重置提醒驱动，会导致提醒驱动意外启动。

### 功能移除

- 修复部分功能启动延时为 0 时行为不正确的 bug。
  - 活动模板驱动服务启动。

- 去除支持实体维护服务的重置功能。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDriverSupportMaintainService。

---

## Release_1.1.1_20240425_build_A

### 功能构建

- 增加服务方法。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityFileOperateService。

- 实现运维指令。
  - com.dwarfeng.familyhelper.life.impl.service.telqos.ActivityTemplateDriveCommand。
  - com.dwarfeng.familyhelper.life.impl.service.telqos.ActivityTemplateDriveLocalCacheCommand。
  - com.dwarfeng.familyhelper.life.impl.service.telqos.ResetCommand。

- 实现预设重置器。
  - com.dwarfeng.familyhelper.life.impl.handler.resetter.CronResetter。
  - com.dwarfeng.familyhelper.life.impl.handler.resetter.DubboResetter。
  - com.dwarfeng.familyhelper.life.impl.handler.resetter.FixedDelayResetter。
  - com.dwarfeng.familyhelper.life.impl.handler.resetter.FixedRateResetter。
  - com.dwarfeng.familyhelper.life.impl.handler.resetter.NeverResetter。

- 实现预设驱动器。
  - com.dwarfeng.familyhelper.life.impl.handler.atdriver.CronActivityTemplateDriverProvider。
  - com.dwarfeng.familyhelper.life.impl.handler.atdriver.CronActivityTemplateDriverSupporter。
  - com.dwarfeng.familyhelper.life.impl.handler.atdriver.FixedDelayActivityTemplateDriverProvider。
  - com.dwarfeng.familyhelper.life.impl.handler.atdriver.FixedDelayActivityTemplateDriverSupporter。
  - com.dwarfeng.familyhelper.life.impl.handler.atdriver.FixedRateActivityTemplateDriverProvider。
  - com.dwarfeng.familyhelper.life.impl.handler.atdriver.FixedRateActivityTemplateDriverSupporter。

- 实现预设推送器。
  - com.dwarfeng.familyhelper.life.impl.handler.pusher.DrainPusher。
  - com.dwarfeng.familyhelper.life.impl.handler.pusher.LogPusher。
  - com.dwarfeng.familyhelper.life.impl.handler.pusher.MultiPusher。

- 实现核心机制。
  - 推送机制。
  - 驱动机制。
  - 重置机制。

- 添加实体属性。
  - ActivityTemplateDriverInfo.remindScopeType。

- 优化文件格式。
  - 优化 `telqos/connection.properties` 文件的格式。

- 增加预设的运维指令。
  - com.dwarfeng.springtelqos.api.integration.log4j2.Log4j2Command。

- dwarfeng-ftp 优化。
  - 优化 FtpHandler 的扫描方式，使其符合最新版本标准。

- dubbo 优化。
  - 优化 `dubbo/connection.properties` 中配置的键名。

- 日志功能优化。
  - 优化默认日志配置，默认配置仅向控制台输出 `INFO` 级别的日志。
  - 优化日志配置结构，提供 `conf/logging/settings.xml` 配置文件及其不同平台的参考配置文件，以供用户自定义日志配置。
  - 优化日志配置结构，提供 `confext/logging-settings.xml` 配置文件，以供外部功能自定义日志配置。
  - 优化启动脚本，使服务支持新的日志配置结构。
  - 优化 `assembly.xml`，使项目打包时输出新的日志配置结构。
  - 优化 `confext/README.md`，添加新的日志配置结构的相关说明。

- 优化项目结构，增加项目目录。
  - `./confext/`。
  - `./libext/`。
  - `./opt/`。
  - `./optext/`。

- 依赖升级。
  - 升级 `subgrade` 依赖版本为 `1.5.2.a` 并解决兼容性问题，以应用其新功能。
  - 升级 `spring-telqos` 依赖版本为 `1.1.9.a` 以应用其新功能。
  - 升级 `spring` 依赖版本为 `5.3.31` 以规避漏洞。
  - 升级 `mysql` 依赖版本为 `8.2.0` 以规避漏洞。
  - 升级 `snakeyaml` 依赖版本为 `2.0` 以规避漏洞。
  - 升级 `dubbo` 依赖版本为 `2.7.22` 以规避漏洞。
  - 升级 `jetty` 依赖版本为 `9.4.51.v20230217` 以规避漏洞。
  - 升级 `netty` 依赖版本为 `4.1.104.Final` 以规避漏洞。
  - 升级 `zookeeper` 依赖版本为 `3.7.2` 以规避漏洞。
  - 升级 `guava` 依赖版本为 `32.0.1-jre` 以规避漏洞。
  - 升级 `slf4j` 依赖版本为 `1.7.36` 以规避漏洞。
  - 升级 `snowflake` 依赖版本为 `1.5.1.a` 以规避漏洞。
  - 升级 `dwarfeng-ftp` 依赖版本为 `1.1.13.a` 以规避漏洞。
  - 升级 `spring-terminator` 依赖版本为 `1.0.12.a` 以规避漏洞。

### Bug 修复

- 修复项目中部分依赖的异常代码偏移未能正确设置的 bug。
  - 修复 `subgrade` 依赖的异常代码偏移未能正确设置的 bug。
  - 修复 `snowflake` 依赖的异常代码偏移未能正确设置的 bug。

### 功能移除

- (无)

---

## Release_1.1.0_20240123_build_A

### 功能构建

- 优化部分操作服务及操作处理器。
  - 优化 PbSetOperateService 中方法的参数名称。
  - 优化 PbSetOperateHandler 中方法的参数名称，实现类中的注释，实现类中的方法的部分代码顺序。

- 优化 Ftp 常量类以及 FtpHandler 调用方式。

- 增加预设查询。
  - PbItemMaintainService.CHILD_FOR_SET_NAME_LIKE。
  - PbNodeMaintainService.CHILD_FOR_SET_NAME_LIKE。

- 完成实体的操作服务。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityDataSetOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityDataNodeOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityDataItemOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateCoverOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateParticipantOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateFileOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityTemplateDataInfoOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityCoverOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityFileOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityParticipantOperateService。
  - com.dwarfeng.familyhelper.life.stack.service.ActivityDataRecordOperateService。

- 新增实体及其维护服务，单元测试通过。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.Activity。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityActivityDataRecordRelation。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityCoverInfo。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataItem。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataNode。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataRecord。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityDataSet。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityFileInfo。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityParticipant。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplate。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateActivityDataItemRelation。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateCoverInfo。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverInfo。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateDriverSupport。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateFileInfo。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTemplateParticipant。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.ActivityTypeIndicator。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.Poac。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.Poad。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.Poat。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.Poatac。

- 处理器名称优化。
  - OperateHandlerValidator -> HandlerValidator。

- Dubbo 微服务增加分组配置。

- 启停脚本优化。
  - 优化 Windows 系统的启动脚本。
  - 优化 Linux 系统的启停脚本。

- 使用 `MapStruct` 重构 `BeanTransformer`。

- 增加依赖。
  - 增加依赖 `protobuf` 以规避漏洞，版本为 `3.19.6`。
  - 增加依赖 `guava` 以规避漏洞，版本为 `31.1-jre`。
  - 增加依赖 `gson` 以规避漏洞，版本为 `2.8.9`。
  - 增加依赖 `snakeyaml` 以规避漏洞，版本为 `1.33`。
  - 增加依赖 `jackson` 以规避漏洞，版本为 `2.14.0`。
  - 增加依赖 `javax.servlet-api` 以规避漏洞，版本为 `4.0.1`。
  - 增加依赖 `jboss-logging` 以规避漏洞，版本为 `3.4.3.Final`。

- 插件升级。
  - 升级 `maven-deploy-plugin` 插件版本为 `2.8.2`。

- 依赖升级。
  - 升级 `mysql` 依赖版本为 `8.0.31` 以规避漏洞。
  - 升级 `jedis` 依赖版本为 `3.8.0` 以规避漏洞。
  - 升级 `spring-data-redis` 依赖版本为 `2.7.5` 以规避漏洞。
  - 升级 `dubbo` 依赖版本为 `2.7.21` 以规避漏洞。
  - 升级 `zookeeper` 依赖版本为 `3.5.7` 以规避漏洞。
  - 升级 `curator` 依赖版本为 `4.3.0` 以规避漏洞。
  - 升级 `hibernate-validator` 依赖版本为 `6.2.5.Final` 以规避漏洞。
  - 升级 `dutil` 依赖版本为 `beta-0.3.2.a` 以规避漏洞。
  - 升级 `snowflake` 依赖版本为 `1.4.10.a` 以规避漏洞。
  - 升级 `subgrade` 依赖版本为 `1.3.1.a` 以规避漏洞。
  - 升级 `dwarfeng-ftp` 依赖版本为 `1.1.11.a` 以规避漏洞。
  - 升级 `spring-terminator` 依赖版本为 `1.0.10.a` 以规避漏洞。
  - 升级 `spring-telqos` 依赖版本为 `1.1.5.a` 以规避漏洞。

### Bug 修复

- 修复删除逻辑错误。
  - 修复 `PbNodeCrudOperation` 删除实体方法的逻辑错误。
  - 修复 `PbRecordCrudOperation` 删除实体方法的逻辑错误。

### 功能移除

- 删除不需要的依赖。
  - 删除 `commons-lang3` 依赖。
  - 删除 `commons-io` 依赖。
  - 删除 `joda-time` 依赖。
  - 删除 `httpcomponents` 依赖。
  - 删除 `el` 依赖。
  - 删除 `zkclient` 依赖。
  - 删除 `commons-net` 依赖。
  - 删除 `dozer` 依赖。

---

## Release_1.0.0_20220719_build_A

### 功能构建

- 项目结构建立，程序清理测试通过。

- 建立实体以及维护服务，并通过单元测试。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.PbFileInfo。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.PbItem。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.PbNode。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.PbRecord。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.PbSet。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.Popb。
  - com.dwarfeng.familyhelper.life.stack.bean.entity.User。

- 完成 node 模块，打包测试及启动测试通过。

- 完成实体的操作服务。
  - com.dwarfeng.familyhelper.life.impl.service.PbSetOperateServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PbNodeOperateServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PbItemOperateServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PbRecordOperateServiceImpl。
  - com.dwarfeng.familyhelper.life.impl.service.PbFileOperateServiceImpl。

### Bug 修复

- (无)

### 功能移除

- (无)
