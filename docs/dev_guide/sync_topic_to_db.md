## 

对于接入km之前集群已有的topic，km默认不会同步到数据库中。 ，这些topic在列表中虽然都能查得到，但是在申请topic权限的时候审批就会报错。
所以需要将这些topic定期同步到db中。 步骤如下：

- 修改application.yml文件。