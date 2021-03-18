package com.xiaojukeji.kafka.manager.common.entity.pojo;

/**
 * @author zhangpeng
 * @date 2021/03/16
 * */
public class AppPropertiesDO {

    private String group;
    private String groupPrefix;
    private String alarmHook;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroupPrefix() {
        return groupPrefix;
    }

    public void setGroupPrefix(String groupPrefix) {
        this.groupPrefix = groupPrefix;
    }

    public String getAlarmHook() {
        return alarmHook;
    }

    public void setAlarmHook(String alarmHook) {
        this.alarmHook = alarmHook;
    }
}
