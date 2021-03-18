package com.xiaojukeji.kafka.manager.web.api.versionone.rd;

import com.xiaojukeji.kafka.manager.common.constant.ApiPrefix;
import com.xiaojukeji.kafka.manager.common.constant.Constant;
import com.xiaojukeji.kafka.manager.common.entity.Result;
import com.xiaojukeji.kafka.manager.common.entity.ResultStatus;
import com.xiaojukeji.kafka.manager.common.entity.pojo.MonitorRuleDO;
import com.xiaojukeji.kafka.manager.common.entity.pojo.gateway.AppDO;
import com.xiaojukeji.kafka.manager.common.utils.CopyUtils;
import com.xiaojukeji.kafka.manager.common.utils.JsonUtils;
import com.xiaojukeji.kafka.manager.common.utils.SpringTool;
import com.xiaojukeji.kafka.manager.common.utils.ValidateUtils;
import com.xiaojukeji.kafka.manager.monitor.MonitorService;
import com.xiaojukeji.kafka.manager.monitor.common.entry.Alert;
import com.xiaojukeji.kafka.manager.monitor.common.entry.NotifyGroup;
import com.xiaojukeji.kafka.manager.monitor.common.entry.Silence;
import com.xiaojukeji.kafka.manager.monitor.common.entry.Strategy;
import com.xiaojukeji.kafka.manager.monitor.common.entry.bizenum.MonitorMetricNameEnum;
import com.xiaojukeji.kafka.manager.monitor.common.entry.dto.MonitorRuleDTO;
import com.xiaojukeji.kafka.manager.monitor.common.entry.dto.MonitorSilenceDTO;
import com.xiaojukeji.kafka.manager.monitor.common.entry.vo.*;
import com.xiaojukeji.kafka.manager.monitor.common.monitor.MonitorAlertDetail;
import com.xiaojukeji.kafka.manager.monitor.common.monitor.MonitorRuleSummary;
import com.xiaojukeji.kafka.manager.monitor.component.AbstractMonitorService;
import com.xiaojukeji.kafka.manager.service.service.gateway.AppService;
import com.xiaojukeji.kafka.manager.web.converters.MonitorRuleConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zengqiao
 * @date 20/5/4
 */
@Api(tags = "RD-Monitor相关接口(REST)")
@RestController
@RequestMapping(ApiPrefix.API_V1_RD_PREFIX)
public class RdMonitorController {

    @Autowired
    private AbstractMonitorService monitorService;


    @ApiOperation(value = "获取所有监控策略", notes = "")
    @RequestMapping(value = "get-strategies", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<Strategy>> getStrategies() {

        return new Result<>(monitorService.getStrategies());
    }


}