## metric信息发送kafka

#### 发送consumer metrics

- 【运维管理】-【平台管理】-【配置管理】中新增配置。 配置键：PRODUCE_CONSUMER_METRICS_CONFIG_KEY 值：
```json
{ "clusterId": 3 , "topicName": "km_consumer_metrics" }

```
- 启动发送任务
```
http://bigdata-service-203:18080/swagger-ui.html#/
RD-Schedule相关接口
找到【触发执行调度任务】接口，并且触发任务：collectAndPublishCommunityTopicMetrics
## 查看任务

```

#### 发送topic metrics
- 【运维管理】-【平台管理】-【配置管理】中新增配置。 配置键：PRODUCE_TOPIC_METRICS_CONFIG_KEY 值：
```json
{ "clusterId":3, "topicName": "km_topic_metrics" }

```
- 启动发送任务
```
http://bigdata-service-203:18080/swagger-ui.html#/
RD-Schedule相关接口
找到【触发执行调度任务】接口，并且触发任务：collectAndPublishCGData
## 查看任务

```
