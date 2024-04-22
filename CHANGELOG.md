# ChangeLog

### Release_1.1.1_20240420_build_A

#### 功能构建

- 实现预设推送器。
  - com.dwarfeng.familyhelper.life.impl.handler.pusher.DrainPusher。
  - com.dwarfeng.familyhelper.life.impl.handler.pusher.LogPusher。
  - com.dwarfeng.familyhelper.life.impl.handler.pusher.MultiPusher。

- 实现核心机制。
  - 推送机制。
  - 驱动机制。

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

#### Bug修复

- 修复项目中部分依赖的异常代码偏移未能正确设置的 bug。
  - 修复 `subgrade` 依赖的异常代码偏移未能正确设置的 bug。
  - 修复 `snowflake` 依赖的异常代码偏移未能正确设置的 bug。

#### 功能移除

- (无)

---

### Release_1.1.0_20240123_build_A

#### 功能构建

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

#### Bug修复

- 修复删除逻辑错误。
  - 修复 `PbNodeCrudOperation` 删除实体方法的逻辑错误。
  - 修复 `PbRecordCrudOperation` 删除实体方法的逻辑错误。

#### 功能移除

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

### Release_1.0.0_20220719_build_A

#### 功能构建

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

#### Bug修复

- (无)

#### 功能移除

- (无)
