# SpringBoot学习项目初始化

## 1.SpringBoot 起步练习
spring-boot-quickstart

> 包含知识点

### RESTful接口的实现与测试：

- RESTful API是一种基于HTTP方法的接口设计风格，用URI表示要操作的资源，用HTTP动词（GET、POST、PUT、DELETE）表示具体操作，依靠HTTP状态码表达操作结果。
- 设计RESTful API时应避免在URI中使用动词，采用复数等标准来提高可理解性。
- RESTful 接口可以降低前后端开发人员沟通成本，提高开发效率，但并不适用于所有场景。
- HTTP状态码200、400、500可以覆盖绝大部分的响应场景。

### Spring框架的注解及其使用

- `@RequestBody` 和 `@ResponseBody` 分别用于接收和响应JSON格式的HTTP请求体。
- `@RequestMapping` 和派生的注解（如`@GetMapping`、`@PostMapping`等）用于映射HTTP请求与处理程序。
- `@RestController` 和 `@Controller` 用于定义控制器，前者默认类中所有方法返回数据而非视图。
- `@PathVariable` 和 `@RequestParam` 用于获取URL中的变量和查询参数。

### Swagger3 (OpenAPI) 自动生成API文档和测试API

- Swagger是一个API文档维护工具，可以根据代码自动生成API文档，实现代码与文档同步更新。
- OpenAPI是Swagger的最新规范，助力构建RESTful接口文档。
- SpringDoc是一个将Swagger3集成到Spring应用的库，使用起来简单，不需要额外配置。
- 集成后可以通过`http://localhost:8080/swagger-ui.html`访问和测试API文档。

## 2.SpringBoot 配置管理
spring-boot-config



## 3. SpringBoot 静态资源和模板引擎
sprint-boot-template

## 4. 数据库开发框架
springboot-database

## 5. SpringBoot整合mybatis
spring-boot-mybatis

```
见notebook下的springBoot整合mybatis.md
```

## 6.SpringBoot 整合mybatis-plus
spring-boot-mybatis-plus

