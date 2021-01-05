# Health Assessment OSGi Application
## Prerequisite
- Java JDK 8

## Build
1. run the build script at project folder
    ```$xslt
    ./gradlew clean build
    ```
2. copy the bundle jar files to karaf deploy folder
    ```$xslt
    ./gradlew copy
    ```

## Run
1. start the karaf runtime
   ```$xslt
    ./karaf-runtime/bin/karaf
    ```
2. the web app is deployed at\
    http://localhost:8181

## Dependencies
- Apache Karaf 4.2.10
- Ops4j Pax-Web 7.2.19
- Jetty 9.4.31
