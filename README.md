# Phoenix Framework

Cross server-side plugin framework.

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

### Contributing A Patch

1. Fork it.
2. Create your feature branch (`git checkout -b my-new-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin my-new-feature`).
5. Create new Pull Request.

## Licensing

* See [LICENSE](LICENSE)

