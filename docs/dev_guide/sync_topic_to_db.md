## 

对于接入km之前集群已有的topic，km默认不会同步到数据库中。 ，这些topic在列表中虽然都能查得到，但是在申请topic权限的时候审批就会报错。
所以需要将这些topic定期同步到db中。 步骤如下：

- 修改application.yml文件,增加如下配置：
```yaml

task:
  op:
    sync-topic-enabled: true

```

- 启动同步任务: syncTopic2DB

```bash 
## 进入 http://bigdata-service-204:8080/swagger-ui.html#!/RD45Schedule3045620851255092147540REST41/triggerScheduledTaskUsingGET
## 找到GET /api/v1/rd/scheduled-tasks/{scheduledName}/run
## 启动任务: syncTopic2DB
```