package com.dwarfeng.familyhelper.life.impl.handler.pusher;

import com.alibaba.fastjson.JSON;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityGeneratedByDriverPushInfo;
import com.dwarfeng.familyhelper.life.stack.bean.dto.ActivityRemindedByDriverPushInfo;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 将信息输出至日志的推送器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
@Component
public class LogPusher extends AbstractPusher {

    public static final String PUSHER_TYPE = "log";

    private static final Logger LOGGER = LoggerFactory.getLogger(LogPusher.class);

    private static final String LEVEL_TRACE = "TRACE";
    private static final String LEVEL_DEBUG = "DEBUG";
    private static final String LEVEL_INFO = "INFO";
    private static final String LEVEL_WARN = "WARN";
    private static final String LEVEL_ERROR = "ERROR";

    @Value("${pusher.log.log_level}")
    private String logLevel;

    public LogPusher() {
        super(PUSHER_TYPE);
    }

    @Override
    public void activityGeneratedByDriver(ActivityGeneratedByDriverPushInfo pushInfo) throws HandlerException {
        String title = "推送由驱动生成活动消息:";
        String message = JSON.toJSONString(pushInfo, true);
        logData(title, message);
    }

    @Override
    public void activityRemindedByDriver(ActivityRemindedByDriverPushInfo pushInfo) throws HandlerException {
        String title = "推送由驱动提醒活动消息:";
        String message = JSON.toJSONString(pushInfo, true);
        logData(title, message);
    }

    @Override
    public void activityTemplateDriveReset() throws HandlerException {
        String title = "推送活动模板驱动重置消息:";
        logData(title, null);
    }

    private void logData(String title, String message) throws HandlerException {
        String logLevel = this.logLevel.toUpperCase();
        logString(title, logLevel);
        if (StringUtils.isNotEmpty(message)) {
            logString(message, logLevel);
        }
    }

    private void logString(String title, String logLevel) throws HandlerException {
        switch (logLevel) {
            case LEVEL_TRACE:
                LOGGER.trace(title);
                return;
            case LEVEL_DEBUG:
                LOGGER.debug(title);
                return;
            case LEVEL_INFO:
                LOGGER.info(title);
                return;
            case LEVEL_WARN:
                LOGGER.warn(title);
                return;
            case LEVEL_ERROR:
                LOGGER.error(title);
                return;
            default:
                throw new HandlerException("未知的日志等级: " + logLevel);
        }
    }

    @Override
    public String toString() {
        return "LogPusher{" +
                "logLevel='" + logLevel + '\'' +
                ", pusherType='" + pusherType + '\'' +
                '}';
    }
}
