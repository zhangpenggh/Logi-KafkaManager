package com.xiaojukeji.kafka.manager.dao.impl;

import com.xiaojukeji.kafka.manager.common.entity.pojo.AlertStrategyDO;
import com.xiaojukeji.kafka.manager.dao.AlertStrategyDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlertStrategyDaoImpl implements AlertStrategyDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(AlertStrategyDO alertStrategyDO) {
        return sqlSessionTemplate.insert("AlertStrategyDao.insert", alertStrategyDO);
    }

    @Override
    public void update(AlertStrategyDO alertStrategyDO) {
        sqlSessionTemplate.update("AlertStrategyDao.update", alertStrategyDO);
    }

    @Override
    public int delete(Long id) {
        return sqlSessionTemplate.delete("AlertStrategyDao.delete", id);
    }

    @Override
    public AlertStrategyDO get(Long id) {
        return sqlSessionTemplate.selectOne("AlertStrategyDao.get", id);
    }

    @Override
    public List<AlertStrategyDO> listAll() {
        return sqlSessionTemplate.selectList("AlertStrategyDao.listAll");
    }
}
