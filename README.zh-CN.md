[English](README.md) | [简体中文](README.zh-CN.md) | [繁體中文](README.zh-TW.md)

# 多 Minio Spring Boot Starter

让 Spring Boot 应用快速集成多个 `minio`——一个高性能对象存储。

## 快速开始

- 导入依赖

```xml
    <dependency>
        <groupId>com.jiovan.spring.starter</groupId>
        <artifactId>multiple-minio-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> 默认情况下，此 starter 会自动生效，你可以通过 `jiovan.multiple-minio.enabled = false` 关闭它。

- 使用前缀 `jiovan.multiple-minio` 配置 Spring Boot 的 `application.yml`

```yml
jiovan:
    multiple-minio:
        primary:
            host: '192.168.0.1'
            port: 9000
            secure-http: true
            access-key: 'foo1'
            secret-key: 'bar1'
            bucket-name: 'app1'
        secondary:
            host: '192.168.0.2'
            port: 9000
            secure-http: true
            access-key: 'foo2'
            secret-key: 'bar2'
            bucket-name: 'app2'
        tertiary:
            host: '192.168.0.3'
            port: 9000
            secure-http: true
            access-key: 'foo3'
            secret-key: 'bar3'
            bucket-name: 'app3'
```

> 此 starter 最多支持 3 个 `MinioClient`。（三振出局）

- 通过 `@Autowired`/`@Resource` 注解并配合 `@Qualifier` 注解注入以下 Bean（以 `primary` 为例）

| Bean 类型 | 限定符 |
|-------------|--------------------------------------------|
| MinioClient | PrimaryMinioAutoConfiguration.MINIO_CLIENT |

## 文档

- GitHub：https://github.com/jiovan-labs/multiple-minio-spring-boot-starter
- Minio 主页：https://min.io
- Minio GitHub：https://github.com/minio/minio

## 环境要求

- jdk 17+

## 许可证

本项目采用 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 许可证。

请参阅 `NOTICE.txt` 文件了解所需的声明与归属信息。

## 捐赠

喜欢这个工具包吗？欢迎[向我们捐赠](https://jiovan.com/donation)以支持开发。

## 版权

北京玖漫科技有限公司

## 网站

- 玖漫：https://jiovan.com
