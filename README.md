# halo-docs
适用于Spring Cloud体系的文档中心,不需要继承Swagger，支持选择IP调用，如果使用了Swagger优先Swagger调用

## 文档中心缓存设计


默认获取应用名: http://localhost:8081/admin/docsMeteData

通过Swagger获取应用名:http://localhost:8081/swagger-resources



默认的第二个接口获取接口参数信息:http://localhost:8081/halo-docs-sample-boot/docs

Swaggerer第二个接口获取接口参数信息http://localhost:8081/halo-docs-sample-boot/v2/api-docs


## 文档中心优先级显示设置
