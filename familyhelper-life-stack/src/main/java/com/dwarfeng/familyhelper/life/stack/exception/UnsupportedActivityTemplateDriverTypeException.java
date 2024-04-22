package com.dwarfeng.familyhelper.life.stack.exception;

/**
 * 不支持的活动模板驱动器类型异常。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class UnsupportedActivityTemplateDriverTypeException extends ActivityTemplateDriverException {

    private static final long serialVersionUID = 2432536762439232850L;

    private final String type;

    public UnsupportedActivityTemplateDriverTypeException(String type) {
        this.type = type;
    }

    @Override
    public String getMessage() {
        return "不支持的活动模板驱动器类型: " + type;
    }
}
