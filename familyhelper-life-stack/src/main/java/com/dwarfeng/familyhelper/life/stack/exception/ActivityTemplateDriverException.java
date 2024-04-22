package com.dwarfeng.familyhelper.life.stack.exception;

import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 驱动异常。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ActivityTemplateDriverException extends HandlerException {

    private static final long serialVersionUID = 3168874083789771814L;

    public ActivityTemplateDriverException() {
    }

    public ActivityTemplateDriverException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActivityTemplateDriverException(String message) {
        super(message);
    }

    public ActivityTemplateDriverException(Throwable cause) {
        super(cause);
    }
}
