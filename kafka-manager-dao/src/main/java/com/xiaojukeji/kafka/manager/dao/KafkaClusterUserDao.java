package com.xiaojukeji.kafka.manager.dao;

import com.xiaojukeji.kafka.manager.common.entity.pojo.KafkaClusterUserDO;
import com.xiaojukeji.kafka.manager.common.entity.pojo.gateway.KafkaUserDO;
import scala.util.parsing.combinator.testing.Str;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhangpeng
 * @date 2021/03/16
 */
public interface KafkaClusterUserDao {

    /**
     * 插入数据
     * @param kafkaClusterUserDO kafkaClusterUserDO
     * @return int
     */
    int insert(KafkaClusterUserDO kafkaClusterUserDO);

    /**
     * 按照集群、app查找用户
     * @return List<KafkaClusterUserDO>
     */
    List<KafkaClusterUserDO> selectByAppCluster(Long clusterId, String appId);
}
