# Phoenix Framework

跨服务端插件框架.

[English](README.md),简体中文

## 什么是 Phoenix ?

Phoenix 是一个Minecraft服务端插件框架，它可以让你的插件开发更加便捷。

我们正在尝试让Phoenix兼容于Spigot和Sponge等服务端软件。

## 构建 Phoenix

### 要求

- Java 8 JDK 或者更高版本.
- Maven.

使用下面这段命令构建项目:

`mvn clean install`

## 使用

咱还没有正式版本.

### 开发

添加以下代码到你的 `pom.xml` (Maven):

```xml
    <dependencies>
        <dependency>
            <groupId>com.lss233.phoenix</groupId>
            <artifactId>Phoenix-API</artifactId>
            <version>PHOENIX_API的最后一个版本</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
```

### 服务器

- 将正确的 **Phoenix 框架** 版本插件丢到您服务器的插件文件夹.
- 重启服务器.

#### 安装Phoenix模组

- 将 **Phoenix 模组** `放至您服务器插件的配置文件夹/PhoenixFramework/modules`.
- - Spigot服务端: `plugin/PhoenixFramework/modules/`.
- 重启服务器.

## 贡献

我们需要开发者协助我们开发**Phoenix**.

### 贡献补丁

1. Fork这个项目.
2. 创建您的特性分支 (`git checkout -b my-new-feature`).
3. 提交您的改动 (`git commit -am '修复Bug'`).
4. 提交您的分支 (`git push origin my-new-feature`).
5. 创建Pull Request.

## 许可

- 请参阅 [LICENSE](LICENSE)