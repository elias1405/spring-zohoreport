# How to build and test spring-zohoreport

# Introduction #

The Zoho Java Client library first must be downloaded and installed in your local repository.
  1. Download the dependant libraries from the [Zoho report client API for Java wiki page](http://zohoreportsapi.wiki.zoho.com/Java-Client-Library.html)
  1. Extract _Zoho\ZohoReportClient\lib\ZohoReportAPIClient.jar_ from the _ZohoReportAPIClient.zip_ archive.
  1. Add the Zoho Java Client library to your maven local repository :
`>mvn install:install-file -DgroupId=zoho -DartifactId="zoho-report" -Dpackaging=jar -Dversion=2.0 -Dfile=ZohoReportAPIClient.jar`


# Build #

  * Download **spring-zohoreport** sources as explained in [Source tab](http://code.google.com/p/spring-zohoreport/source/checkout).
  * run `mvn compile jar:jar`

# Test #
  * Download **spring-zohoreport** sources as explained in [Source tab](http://code.google.com/p/spring-zohoreport/source/checkout).
  * Create file _src\test\resources\zoho.properties_ containing at least :
```
zohoConfig.apiKey=your_zoho_api_key
zohoConfig.loginName=your_zoho_login
zohoConfig.password=your_zoho_password
```
> The default test database and tables are copied from the public **Super Store Sales Database** database. To copy this database in your environment :
    1. Sign in Zoho
    1. Goto the [Zoho Report featured samples page ](http://reports.zoho.com/ZDBSampleDatabases.cc) and choose the [Super Store Sales Database](http://reports.zoho.com/ZDBDataSheetView.cc?DBID=4000000037680)
    1. In the [Super Store Sales Database page ](http://reports.zoho.com/ZDBDataSheetView.cc?DBID=4000000037680), choose the _"Copy this DataBase"_ link

  * run `mvn test`

Optionally, the database name (_zohoConfig.databaseName_) and ProxySettings (_zohoConfig.proxy., zohoConfig.httpProxy., zohoConfig.httpsProxy._) can be overwritted in the _zoho.properties_ file.