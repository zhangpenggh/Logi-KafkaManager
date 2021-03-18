package com.xiaojukeji.kafka.manager.dao;

import com.xiaojukeji.kafka.manager.common.entity.pojo.AlertStrategyDO;

import java.util.List;

public interface AlertStrategyDao {
    int insert(AlertStrategyDO alertStrategyDO);

    void update(AlertStrategyDO alertStrategyDO);

    int delete(Long id);

    AlertStrategyDO get(Long clusterId);

    List<AlertStrategyDO> listAll();

}