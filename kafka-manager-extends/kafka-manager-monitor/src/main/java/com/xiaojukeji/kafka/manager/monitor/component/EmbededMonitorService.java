package com.xiaojukeji.kafka.manager.monitor.component;

import com.xiaojukeji.kafka.manager.common.entity.pojo.AlertStrategyDO;
import com.xiaojukeji.kafka.manager.common.entity.pojo.LogicalClusterDO;
import com.xiaojukeji.kafka.manager.dao.AlertStrategyDao;
import com.xiaojukeji.kafka.manager.dao.LogicalClusterDao;
import com.xiaojukeji.kafka.manager.monitor.common.entry.*;
import com.xiaojukeji.kafka.manager.monitor.common.utils.CommonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "custom.monitor.embedded", name = "enable", havingValue = "true")
public class EmbededMonitorService extends AbstractMonitorService {

    @Autowired
    private AlertStrategyDao alertStrategyDao;

    @Autowired
    private LogicalClusterDao logicalClusterDao;

    @Override
    public Integer createStrategy(Strategy strategy) {
        AlertStrategyDO alertStrategyDO = CommonConverter.convert2StrategyDO(strategy);
        return alertStrategyDao.insert(alertStrategyDO);
    }

    @Override
    public Boolean deleteStrategyById(Long strategyId) {
        alertStrategyDao.delete(strategyId);
        return true;
    }

    @Override
    public Boolean modifyStrategy(Strategy strategy) {
        AlertStrategyDO alertStrategyDO = CommonConverter.convert2StrategyDO(strategy);
        alertStrategyDao.update(alertStrategyDO);
        return true;
    }

    @Override
    public List<Strategy> getStrategies() {
        List<AlertStrategyDO> alertStrategyDOS = alertStrategyDao.listAll();
        List<LogicalClusterDO> logicalClusterDOS = logicalClusterDao.listAll();
        Map<String, LogicalClusterDO> logicalClusterDOMap = new HashMap<>();
        for (LogicalClusterDO logicalClusterDO : logicalClusterDOS) {
            logicalClusterDOMap.put(logicalClusterDO.getIdentification(), logicalClusterDO);
        }
        return alertStrategyDOS.stream().map(alertStrategyDO -> {
            Strategy strategy = CommonConverter.convert2Strategy(alertStrategyDO);
            String cluster = strategy.getStrategyFilterList().get(0).getClusterIdentification();
            if (logicalClusterDOMap.containsKey(cluster)) {
                StrategyFilter newFilter = new StrategyFilter();
                newFilter.setTkey("clusterId");
                newFilter.setTval(logicalClusterDOMap.get(cluster).getId().toString());
                strategy.getStrategyFilterList().add(newFilter);
            }
            return strategy;
        }).collect(Collectors.toList());
    }

    @Override
    public Strategy getStrategyById(Long strategyId) {
        return CommonConverter.convert2Strategy(alertStrategyDao.get(strategyId));
    }

    @Override
    public List<Alert> getAlerts(Long strategyId, Long startTime, Long endTime) {
        return null;
    }

    @Override
    public Alert getAlertById(Long alertId) {
        return null;
    }

    @Override
    public Boolean createSilence(Silence silence) {
        return null;
    }

    @Override
    public Boolean releaseSilence(Long silenceId) {
        return null;
    }

    @Override
    public Boolean modifySilence(Silence silence) {
        return null;
    }

    @Override
    public List<Silence> getSilences(Long strategyId) {
        return null;
    }

    @Override
    public Silence getSilenceById(Long silenceId) {
        return null;
    }

    @Override
    public List<NotifyGroup> getNotifyGroups() {
        return null;
    }

    @Override
    public Boolean sinkMetrics(List<MetricSinkPoint> pointList) {
        return null;
    }

    @Override
    public Metric getMetrics(String metric, Long startTime, Long endTime, Integer step, Properties tags) {
        return null;
    }
}
