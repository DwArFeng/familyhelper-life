# ChangeLog

### Release_1.1.0_20230314_build_A

#### 功能构建

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

- Dubbo 微服务增加分组配置。

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

- (无)

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
