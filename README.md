<img align="right" alt="PhoenixMC logo" width="100" src="https://avatars0.githubusercontent.com/u/35197080?s=400&u=289914ca504d80656a3cdb9646342c76666e2c0b&v=4" style="border-radius: 100%">

# Phoenix Framework 

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ffc28ae8f9524b90a83a4039b8e378d4)](https://app.codacy.com/app/PhoenixMC/PhoenixAPI?utm_source=github.com&utm_medium=referral&utm_content=ThePhoenixMC/PhoenixAPI&utm_campaign=Badge_Grade_Dashboard)
[![Build Status](https://travis-ci.org/ThePhoenixMC/PhoenixAPI.svg?branch=master)](https://travis-ci.org/ThePhoenixMC/PhoenixAPI)
[![MIT](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/ThePhoenixMC/PhoenixAPI/blob/master/LICENSE)
[![Gitter](https://camo.githubusercontent.com/da2edb525cde1455a622c58c0effc3a90b9a181c/68747470733a2f2f6261646765732e6769747465722e696d2f4a6f696e253230436861742e737667)](https://gitter.im/ThePhoenixMC)
![GitHub forks](https://img.shields.io/github/forks/badges/shields.svg?style=flat-square&label=Fork)
![GitHub stars](https://img.shields.io/github/stars/badges/shields.svg?style=flat-square&label=Stars)

Cross server-side plugin framework.  



Languages: English,[简体中文](README.zhcn.md)

## Introduction

Phoenix is a open source [Minecraft](http://minecraft.net) server plugin 
framework that makes your plugin developing easier.

The main goals of the project are to make Phoenix can be loaded on Spigot,
 Sponge, Nukkit and some other Minecraft server software.
 

## Docs

The best place to receive support is on [GitHub issues](https://github.com/ThePhoenixMC/PhoenixAPI/issues).

Javadocs for PhoenixAPI can be found [here](https://thephoenixmc.github.io/javadoc).

The official developing guide is on [Wiki](https://github.com/ThePhoenixMC/PhoenixAPI/wiki)  

## Building


### 1. Setup

This project require Java 8 or above.  

After installing [Oracle JDK](http://oracle.com/technetwork/java/javase/downloads) (recommended) or [OpenJDK](http://openjdk.java.net/), and
[Maven](https://maven.apache.org), checkout the source:

```sh
git clone https://github.com/ThePhoenixMC/PhoenixAPI.git
cd PhoenixAPI
```

### 2. Build

```sh
mvn install
```

The final jar will be placed in `target/` named `Phoenix-API-X.X.X-SNAPSHOT.jar`.

## Using

### Maven

Add the flowing code to your `pom.xml`:

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

## Contributing

We will always have a need for developers to help improve Phoenix.

### Pull request

1. Fork it.
2. Create your feature branch (`git checkout -b my-new-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin my-new-feature`).
5. Create new Pull Request.

### Join us

You can find us on Telegram: [Click here](https://t.me/PhoenixMCDev).

## Licensing

PhoenixAPI is open-source software released under the MIT license. Please see
the [`LICENSE`](LICENSE) file for details.


[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)