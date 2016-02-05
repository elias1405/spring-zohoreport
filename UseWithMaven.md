# how to use spring-zohoreport in a maven project

# Introduction #

**spring-zohoreport** can be embedded in a Maven project.


# Details #

The Zoho Java Client library first must be downloaded and installed in your local repository.
  1. Download the dependant libraries from the [Zoho report client API for Java wiki page](http://zohoreportsapi.wiki.zoho.com/Java-Client-Library.html)
  1. Extract _Zoho\ZohoReportClient\lib\ZohoReportAPIClient.jar_ from the _ZohoReportAPIClient.zip_ archive.
  1. Add the Zoho Java Client library to your maven local repository :
`>mvn install:install-file -DgroupId=zoho -DartifactId="zoho-report" -Dpackaging=jar -Dversion=2.0 -Dfile=ZohoReportAPIClient.jar`

Simply add the **spring-zohoreport** repository in your maven _pom.xml_ _repositories_ section :

```
<!--
Spring-zohoreport google code repository 
-->
<repository>
   <id>spring-zohoreport-repository</id>
   <name>Spring-zohoreport Repository for Maven</name>
   <url>http://spring-zohoreport.googlecode.com/svn/repo/</url>
</repository>
```

Then add the **spring-zohoreport** and zoho client dependencies in your maven _pom.xml_ _dependencies_ section :
```
<dependency>
  <groupId>zoho</groupId>
  <artifactId>zoho-report</artifactId>
  <version>2.0</version>
</dependency>
<dependency>
   <groupId>net.jclagache</groupId>
   <artifactId>spring-zohoreport</artifactId>
   <version>0.1</version>
</dependency>
```