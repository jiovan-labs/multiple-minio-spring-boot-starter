[English](README.md) | [簡體中文](README.zh-CN.md) | [繁體中文](README.zh-TW.md)

# 多 Minio Spring Boot Starter

讓 Spring Boot 應用快速整合多個 `minio`——一個高效能物件儲存。

## 快速開始

- 匯入相依性

```xml
    <dependency>
        <groupId>com.jiovan.spring.starter</groupId>
        <artifactId>multiple-minio-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> 預設情況下，此 starter 會自動生效，你可以透過 `jiovan.multiple-minio.enabled = false` 關閉它。

- 使用字首 `jiovan.multiple-minio` 設定 Spring Boot 的 `application.yml`

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

> 此 starter 最多支援 3 個 `MinioClient`。（三振出局）

- 透過 `@Autowired`/`@Resource` 註解並配合 `@Qualifier` 註解注入以下 Bean（以 `primary` 為例）

| Bean 型別 | 限定符 |
|-------------|--------------------------------------------|
| MinioClient | PrimaryMinioAutoConfiguration.MINIO_CLIENT |

## 文件

- GitHub：https://github.com/jiovan-labs/multiple-minio-spring-boot-starter
- Minio 主頁：https://min.io
- Minio GitHub：https://github.com/minio/minio

## 環境要求

- jdk 17+

## 許可證

本專案採用 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 許可證。

請參閱 `NOTICE.txt` 檔案瞭解所需的宣告與歸屬資訊。

## 捐贈

喜歡這個工具包嗎？歡迎[向我們捐贈](https://jiovan.com/donation)以支援開發。

## 版權

北京玖漫科技有限公司

## 網站

- 玖漫：https://jiovan.com
