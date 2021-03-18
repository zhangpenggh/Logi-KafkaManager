package com.xiaojukeji.kafka.manager.common.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonUtilsTest {
    @Test
    public void testMapToJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "value");
        map.put("int", 1);
        String expectRes = "{\"key\":\"value\",\"int\":1}";
        Assert.assertEquals(expectRes, JsonUtils.toJSONString(map));
    }

    @Test
    public void testEnumToJson() {
        System.out.println(JsonUtils.toJson(MonitorMetricNameEnum.class));
        System.out.println(JsonUtils.toJson(MonitorMetricNameEnum.CONSUMER_MAX_DELAY_TIME));
    }

    public enum MonitorMetricNameEnum {
        TOPIC_MSG_IN("kafka-topic-msgIn", "条"),

        TOPIC_BYTES_IN( "kafka-topic-bytesIn", "字节/秒"),

        TOPIC_BYTES_REJECTED( "kafka-topic-bytesRejected", "字节/秒"),

        TOPIC_APP_PRODUCE_THROTTLE("kafka-topic-produce-throttled", "1:被限流"),

        TOPIC_APP_FETCH_THROTTLE("kafka-topic-fetch-throttled", "1:被限流"),

        CONSUMER_MAX_LAG("kafka-consumer-maxLag", "条"),

        CONSUMER_PARTITION_LAG("kafka-consumer-lag", "条"),

        CONSUMER_MAX_DELAY_TIME("kafka-consumer-maxDelayTime", "秒"),

        ;

        private String metricName;

        private String unit;

        MonitorMetricNameEnum(String metricName, String unit) {
            this.metricName = metricName;
            this.unit = unit;
        }

        public String getMetricName() {
            return metricName;
        }

        public void setMetricName(String metricName) {
            this.metricName = metricName;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return "MonitorMetricNameEnum{" +
                    "metricName='" + metricName + '\'' +
                    ", unit='" + unit + '\'' +
                    '}';
        }
    }
}
