package com.xiaojukeji.kafka.manager.monitor.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.xiaojukeji.kafka.manager.common.entity.pojo.AlertStrategyDO;
import com.xiaojukeji.kafka.manager.monitor.common.entry.dto.*;
import com.xiaojukeji.kafka.manager.common.utils.ListUtils;
import com.xiaojukeji.kafka.manager.monitor.common.entry.*;
import com.xiaojukeji.kafka.manager.common.entity.pojo.MonitorRuleDO;

import java.util.ArrayList;

/**
 * @author zengqiao
 * @date 20/5/21
 */
public class CommonConverter {
    public static Strategy convert2Strategy(Long strategyId, MonitorRuleDTO monitorDTO) {
        Strategy strategy = new Strategy();

        strategy.setId(strategyId);
        strategy.setName(monitorDTO.getName());
        strategy.setPriority(monitorDTO.getPriority());
        strategy.setPeriodHoursOfDay(monitorDTO.getPeriodHoursOfDay());
        strategy.setPeriodDaysOfWeek(monitorDTO.getPeriodDaysOfWeek());
        strategy.setStrategyExpressionList(new ArrayList<>());
        strategy.setStrategyFilterList(new ArrayList<>());
        strategy.setStrategyActionList(new ArrayList<>());

        for (MonitorStrategyExpressionDTO elem: monitorDTO.getStrategyExpressionList()) {
            StrategyExpression strategyExpression = new StrategyExpression();
            strategyExpression.setMetric(elem.getMetric());
            strategyExpression.setFunc(elem.getFunc());
            strategyExpression.setEopt(elem.getEopt());
            strategyExpression.setThreshold(elem.getThreshold());
            strategyExpression.setParams(elem.getParams());
            strategy.getStrategyExpressionList().add(strategyExpression);
        }

        for (MonitorStrategyFilterDTO elem: monitorDTO.getStrategyFilterList()) {
            StrategyFilter strategyFilter = new StrategyFilter();
            strategyFilter.setTkey(elem.getTkey());
            strategyFilter.setTopt(elem.getTopt());
            strategyFilter.setTval(ListUtils.strList2String(elem.getTval()));
            strategyFilter.setClusterIdentification(elem.getClusterIdentification());
            strategy.getStrategyFilterList().add(strategyFilter);
        }

        for (MonitorStrategyActionDTO elem: monitorDTO.getStrategyActionList()) {
            StrategyAction strategyAction = new StrategyAction();
            strategyAction.setNotifyGroup(ListUtils.strList2String(elem.getNotifyGroup()));
            strategyAction.setConverge(elem.getConverge());
            strategyAction.setCallback(elem.getCallback());
            strategy.getStrategyActionList().add(strategyAction);
        }
        return strategy;
    }

    public static MonitorRuleDTO convert2MonitorRuleDTO(MonitorRuleDO monitorRuleDO, Strategy strategy) {
        MonitorRuleDTO monitorRuleDTO = new MonitorRuleDTO();

        monitorRuleDTO.setId(monitorRuleDO.getId());
        monitorRuleDTO.setAppId(monitorRuleDO.getAppId());
        monitorRuleDTO.setName(strategy.getName());
        monitorRuleDTO.setPriority(strategy.getPriority());
        monitorRuleDTO.setPeriodHoursOfDay(strategy.getPeriodHoursOfDay());
        monitorRuleDTO.setPeriodDaysOfWeek(strategy.getPeriodDaysOfWeek());
        monitorRuleDTO.setStrategyExpressionList(new ArrayList<>());
        monitorRuleDTO.setStrategyFilterList(new ArrayList<>());
        monitorRuleDTO.setStrategyActionList(new ArrayList<>());

        for (StrategyExpression elem: strategy.getStrategyExpressionList()) {
            MonitorStrategyExpressionDTO strategyExpression = new MonitorStrategyExpressionDTO();
            strategyExpression.setMetric(elem.getMetric());
            strategyExpression.setFunc(elem.getFunc());
            strategyExpression.setEopt(elem.getEopt());
            strategyExpression.setThreshold(elem.getThreshold());
            strategyExpression.setParams(elem.getParams());
            monitorRuleDTO.getStrategyExpressionList().add(strategyExpression);
        }

        for (StrategyFilter elem: strategy.getStrategyFilterList()) {
            MonitorStrategyFilterDTO strategyFilter = new MonitorStrategyFilterDTO();
            strategyFilter.setTkey(elem.getTkey());
            strategyFilter.setTopt(elem.getTopt());
            strategyFilter.setTval(ListUtils.string2StrList(elem.getTval()));
            strategyFilter.setClusterIdentification(elem.getClusterIdentification());
            monitorRuleDTO.getStrategyFilterList().add(strategyFilter);
        }

        for (StrategyAction elem: strategy.getStrategyActionList()) {
            MonitorStrategyActionDTO strategyAction = new MonitorStrategyActionDTO();
            strategyAction.setNotifyGroup(ListUtils.string2StrList(elem.getNotifyGroup()));
            strategyAction.setConverge(elem.getConverge());
            strategyAction.setCallback(elem.getCallback());
            monitorRuleDTO.getStrategyActionList().add(strategyAction);
        }
        return monitorRuleDTO;
    }

    public static Silence convert2Silence(MonitorRuleDO monitorRuleDO, MonitorSilenceDTO monitorSilenceDTO) {
        Silence silence = new Silence();
        silence.setSilenceId(monitorSilenceDTO.getId());
        silence.setStrategyId(monitorRuleDO.getStrategyId());
        silence.setBeginTime(monitorSilenceDTO.getStartTime());
        silence.setEndTime(monitorSilenceDTO.getEndTime());
        silence.setDescription(monitorSilenceDTO.getDescription());
        return silence;
    }

    public static AlertStrategyDO convert2StrategyDO(Strategy strategy) {
        AlertStrategyDO alertStrategyDO = new AlertStrategyDO();
        alertStrategyDO.setId(strategy.getId());
        alertStrategyDO.setName(strategy.getName());
        alertStrategyDO.setPriority(strategy.getPriority());
        alertStrategyDO.setPeriodDaysOfWeek(strategy.getPeriodDaysOfWeek());
        alertStrategyDO.setPeriodHoursOfDay(strategy.getPeriodHoursOfDay());
        alertStrategyDO.setStrategyActionList(JSONObject.toJSONString(strategy.getStrategyActionList()));
        alertStrategyDO.setStrategyExpressionList(JSONObject.toJSONString(strategy.getStrategyExpressionList()));
        alertStrategyDO.setStrategyFilterList(JSONObject.toJSONString(strategy.getStrategyFilterList()));
        return alertStrategyDO;
    }

    public static Strategy convert2Strategy(AlertStrategyDO alertStrategyDO1) {
        Strategy strategy = new Strategy();
        strategy.setId(alertStrategyDO1.getId());
        strategy.setName(alertStrategyDO1.getName());
        strategy.setPriority(alertStrategyDO1.getPriority());
        strategy.setPeriodDaysOfWeek(alertStrategyDO1.getPeriodDaysOfWeek());
        strategy.setPeriodHoursOfDay(alertStrategyDO1.getPeriodHoursOfDay());
        strategy.setStrategyActionList(JSONObject.parseArray(alertStrategyDO1.getStrategyActionList(), StrategyAction.class));
        strategy.setStrategyExpressionList(JSONObject.parseArray(alertStrategyDO1.getStrategyExpressionList(),StrategyExpression.class));
        strategy.setStrategyFilterList(JSONObject.parseArray(alertStrategyDO1.getStrategyFilterList(), StrategyFilter.class));
        return strategy;
    }
}