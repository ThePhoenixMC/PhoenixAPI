# Phoenix Framework

Cross server-side plugin framework.

* TeamCity: <a href="https://ci.lss233.com/viewType.html?buildTypeId=PhoenixFramework_API&guest=1"><img src="https://ci.lss233.com/app/rest/builds/buildType:(id:PhoenixFramework_API)/statusIcon" alt="TC Build"/></a> 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ffc28ae8f9524b90a83a4039b8e378d4)](https://app.codacy.com/app/PhoenixMC/PhoenixAPI?utm_source=github.com&utm_medium=referral&utm_content=ThePhoenixMC/PhoenixAPI&utm_campaign=Badge_Grade_Dashboard)
* Travis CI: [![Build Status](https://travis-ci.org/ThePhoenixMC/PhoenixAPI.svg?branch=master)](https://travis-ci.org/ThePhoenixMC/PhoenixAPI)
* Circle CI: [![CircleCI](https://circleci.com/gh/ThePhoenixMC/PhoenixAPI.svg?style=svg)](https://circleci.com/gh/ThePhoenixMC/PhoenixAPI)


English,[简体中文](README.zhcn.md)

## What is Phoenix ?

Phoenix is a Minecraft server plugin framework that makes your plugin developing easier.

We are trying to make Phoenix can be loaded on Spigot, Sponge and some other Minecraft server software.
## Building Phoenix

### Requirements

- Java 8 JDK or Higher.
- Maven.

Run the following command to build it:

`mvn clean install`

## Using

We don't have any stable release yet.

### Developing

Add the flowing code to your `pom.xml`:

```xml
    <dependencies>
        <dependency>
            <groupId>com.lss233.phoenix</groupId>
            <artifactId>Phoenix-API</artifactId>
            <version>THE_LAST_VERSION_OF_PHOENIX_API</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
```

### Server

* Drop correct version of **Phoenix Framework** plugin to your server's plugin directory.
* Restart it.

#### Installing modules

* Drop **Phoenix Module** to `your server's plugin configuration directory/PhoenixFramework/modules`.
* * Spigot server: `plugin/PhoenixFramework/modules/`.
* Restart server.

## Contributing

We will always have a need for developers to help improve Phoenix.

### Pull request

1. Fork it.
2. Create your feature branch (`git checkout -b my-new-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin my-new-feature`).
5. Create new Pull Request.


### Join us

See [Contacting](#Contacting)

## Contacting

Click [here](https://t.me/PhoenixMCDev) to join our Telegram group.

## Licensing

* See [LICENSE](LICENSE)

