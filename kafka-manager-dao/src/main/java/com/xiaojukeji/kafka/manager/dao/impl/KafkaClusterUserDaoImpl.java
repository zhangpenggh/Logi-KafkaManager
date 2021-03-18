package com.xiaojukeji.kafka.manager.dao.impl;

import com.xiaojukeji.kafka.manager.common.entity.pojo.KafkaClusterUserDO;
import com.xiaojukeji.kafka.manager.dao.KafkaClusterUserDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("kafkaClusterUserDao")
public class KafkaClusterUserDaoImpl implements KafkaClusterUserDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(KafkaClusterUserDO kafkaClusterUserDO) {
        sqlSessionTemplate.insert("KafkaClusterUserDao.insert", kafkaClusterUserDO);
        return 0;
    }

    @Override
    public List<KafkaClusterUserDO> selectByAppCluster(Long clusterId, String appId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("clusterId", clusterId);
        parameters.put("appId", appId);
        return sqlSessionTemplate.selectList("KafkaClusterUserDao.selectByAppCluster", parameters);
    }
}
