package com.dwarfeng.familyhelper.life.node.handler;

import com.dwarfeng.subgrade.stack.handler.Handler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LauncherSettingHandler implements Handler {

    @Value("${launcher.reset_activity_template_driver_support}")
    private boolean resetActivityTemplateDriverSupport;

    @Value("${launcher.online_activity_template_drive_delay}")
    private long onlineActivityTemplateDriveDelay;
    @Value("${launcher.enable_activity_template_drive_delay}")
    private long enableActivityTemplateDriveDelay;

    public boolean isResetActivityTemplateDriverSupport() {
        return resetActivityTemplateDriverSupport;
    }

    public long getOnlineActivityTemplateDriveDelay() {
        return onlineActivityTemplateDriveDelay;
    }

    public long getEnableActivityTemplateDriveDelay() {
        return enableActivityTemplateDriveDelay;
    }

    @Override
    public String toString() {
        return "LauncherSettingHandler{" +
                "resetActivityTemplateDriverSupport=" + resetActivityTemplateDriverSupport +
                ", onlineActivityTemplateDriveDelay=" + onlineActivityTemplateDriveDelay +
                ", enableActivityTemplateDriveDelay=" + enableActivityTemplateDriveDelay +
                '}';
    }
}
