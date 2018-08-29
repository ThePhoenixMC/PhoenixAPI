<img align="right" alt="PhoenixMC logo" width="100" src="https://avatars0.githubusercontent.com/u/35197080?s=400&u=289914ca504d80656a3cdb9646342c76666e2c0b&v=4" style="border-radius: 100%">

# Phoenix Framework 

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ffc28ae8f9524b90a83a4039b8e378d4)](https://app.codacy.com/app/PhoenixMC/PhoenixAPI?utm_source=github.com&utm_medium=referral&utm_content=ThePhoenixMC/PhoenixAPI&utm_campaign=Badge_Grade_Dashboard)
[![Build Status](https://travis-ci.org/ThePhoenixMC/PhoenixAPI.svg?branch=master)](https://travis-ci.org/ThePhoenixMC/PhoenixAPI)
[![MIT](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/ThePhoenixMC/PhoenixAPI/blob/master/LICENSE)
[![Gitter](https://camo.githubusercontent.com/da2edb525cde1455a622c58c0effc3a90b9a181c/68747470733a2f2f6261646765732e6769747465722e696d2f4a6f696e253230436861742e737667)](https://gitter.im/ThePhoenixMC)
![GitHub forks](https://img.shields.io/github/forks/badges/shields.svg?style=flat-square&label=Fork)
![GitHub stars](https://img.shields.io/github/stars/badges/shields.svg?style=flat-square&label=Stars)

跨服务端插件框架.  



语言: [English](README.md),简体中文

## 介绍

Phoenix 是一个开源的 [Minecraft](http://minecraft.net) 服务端插件框架，
让你的开发更简单。

这个项目主要目的是让您今后的插件可以同时在 Spigot、 Sponge、 Nukkit等其他服务端上加载，
而不用操心移植的问题。
 

## 文档

您可以在 [GitHub issues](https://github.com/ThePhoenixMC/PhoenixAPI/issues) 寻求帮助.

PhoenixAPI 的 Javadoc 可以在 [这里](https://thephoenixmc.github.io/javadoc) 查看.

[@Lss233](https://github.com/lss233) 正在 Phoenix Framework 编写一个中文版的教程，
您可以在 [这里](https://blog.lss233.com/phoenixframework-ru-men-jiao-cheng/) 查看。   

## 构建


### 1. 初始化

这个项目需要Java 8 或以上版本。  

在安装 [Oracle JDK](http://oracle.com/technetwork/java/javase/downloads) (推荐) 或 [OpenJDK](http://openjdk.java.net/), 和
[Maven](https://maven.apache.org)之后, 下载源码:

```sh
git clone https://github.com/ThePhoenixMC/PhoenixAPI.git
cd PhoenixAPI
```

### 2. 编译

```sh
mvn install
```

最终的jar文件将会在 `target/` 文件夹， 名为 `Phoenix-API-X.X.X-SNAPSHOT.jar`.

## 使用

### Maven

在您的 `pom.xml` 适当位置添加以下内容:

```xml
    <repositories>
        <repository>
            <id>lss233-repo</id>
            <name>Lss233's Minecraft Repository</name>
            <url>https://lss233.com/artifactory/minecraft</url>
        </repository>    
    </repositories>
    <dependencies>
        <dependency>
            <groupId>com.lss233.phoenix</groupId>
            <artifactId>Phoenix-API</artifactId>
            <version>THE_LAST_VERSION_OF_PHOENIX_API</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
```

## 贡献

我们需要开发者协助我们开发Phoenix, 您可以通过以下两种方式协助我们:

### Pull request

1. Fork这个项目.
2. 创建您的特性分支 (`git checkout -b my-new-feature`).
3. 提交您的改动 (`git commit -am '修复Bug'`).
4. 提交您的分支 (`git push origin my-new-feature`).
5. 创建Pull Request.

### 加入小组

我们的QQ群号为: **498385830**  
当然，您也可以在Telegram上找到我们的群组: [点击这里](https://t.me/PhoenixMCDev)

## 许可

PhoenixAPI 是一个使用 MIT 协议的开源项目. 您可以在
[`LICENSE`](LICENSE) 文件中查看详情.


[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)