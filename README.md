# Selenium Automation Tests

## Short Description
Selenium is a tool used to automate functional testing on web browsers. 
## Full Description
This image contains an environment in Debian to run selenium tests on Firefox and/or Google Chrome browsers. 

### How to use this image
```sh
$ docker run -t -v $(pwd)/seleniumTests:/seleniumTests huli/Selenium
```
You need to set the volume to where the testing code resides.
#### Image parameters
BROWSER
 - firefox
 - chrome

MAVEN_COMMAND  (you can select the suite, test class, or specific test to run). Examples:
```
//This runs all the tests in the suite testng.xml
MAVEN_COMMAND=-DsuiteXmlFile=src/test/java/newtest.xml
//This runs all methods on the class Testng
MAVEN_COMMAND=-Dtest=Testng
//This runs the method test1 from the Testng class
MAVEN_COMMAND=-Dtest=Testng#test1
//This runs the group called weekly
MAVEN_COMMAND=-Dgroups=weekly
```

Image run with parameters example

```
$ docker run -t -v $(pwd)/seleniumTests:/seleniumTests -e BROWSER=chrome -e MAVEN_COMMAND=-Dtest=Testng2 huli/Selenium

```
