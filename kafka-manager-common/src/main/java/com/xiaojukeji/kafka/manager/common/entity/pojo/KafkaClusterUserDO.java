package com.xiaojukeji.kafka.manager.common.entity.pojo;

import java.util.Date;

/**
 * @author zhangpeng
 * @date 2021/03/16
 * */
public class KafkaClusterUserDO {
    private Long id;

    private String appId;

    private String clusterId;

    private String password;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "KafkaClusterUserDO{" +
                "id=" + id +
                ", appId='" + appId + '\'' +
                ", password='" + password + '\'' +
                ", clusterId='" + clusterId + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }
}