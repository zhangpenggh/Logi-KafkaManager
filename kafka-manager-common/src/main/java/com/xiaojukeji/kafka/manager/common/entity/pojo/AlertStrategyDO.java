package com.xiaojukeji.kafka.manager.common.entity.pojo;

public class AlertStrategyDO {

    private Long id;

    private String name;

    private Integer priority;

    private String periodHoursOfDay;

    private String periodDaysOfWeek;

    private String strategyExpressionList;

    private String strategyFilterList;

    private String strategyActionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPeriodHoursOfDay() {
        return periodHoursOfDay;
    }

    public void setPeriodHoursOfDay(String periodHoursOfDay) {
        this.periodHoursOfDay = periodHoursOfDay;
    }

    public String getPeriodDaysOfWeek() {
        return periodDaysOfWeek;
    }

    public void setPeriodDaysOfWeek(String periodDaysOfWeek) {
        this.periodDaysOfWeek = periodDaysOfWeek;
    }

    public String getStrategyExpressionList() {
        return strategyExpressionList;
    }

    public void setStrategyExpressionList(String strategyExpressionList) {
        this.strategyExpressionList = strategyExpressionList;
    }

    public String getStrategyFilterList() {
        return strategyFilterList;
    }

    public void setStrategyFilterList(String strategyFilterList) {
        this.strategyFilterList = strategyFilterList;
    }

    public String getStrategyActionList() {
        return strategyActionList;
    }

    public void setStrategyActionList(String strategyActionList) {
        this.strategyActionList = strategyActionList;
    }

    @Override
    public String toString() {
        return "StrategyDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", periodHoursOfDay='" + periodHoursOfDay + '\'' +
                ", periodDaysOfWeek='" + periodDaysOfWeek + '\'' +
                ", strategyExpressionList=" + strategyExpressionList +
                ", strategyFilterList=" + strategyFilterList +
                ", strategyActionList=" + strategyActionList +
                '}';
    }

}
