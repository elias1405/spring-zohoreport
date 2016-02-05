Project aims at simplifying the use of the Zoho Report Java client libraries and wrap the client configuration with the Spring framework bean configuration.

So far, only Zoho Report client libraries can SELECT, UPDATE, INSERT and DELETE datas whereas Zoho CloudSQL (so JDBC driver) is limited to SELECT.

This project uses Spring IOC container to manage Zoho Report client as a bean.

```
ZohoReportClientWrapper rc = (ZohoReportClientWrapper) ctx.getBean("zohoClient");
rc.login();
rc.addRow("sampleTable", data);
```


### Quickstart ###

  1. Download the current binaries library from the [Downloads page](http://code.google.com/p/spring-zohoreport/downloads/list).
  1. Download the dependant libraries from the [Zoho report client API for Java wiki page](http://zohoreportsapi.wiki.zoho.com/Java-Client-Library.html).
  1. In your project, simply edit the _applicationContext.xml_

```
<bean id="zohoConfig" class="net.jclagache.zohoreport.config.ZohoConfig">
   <property name="apiKey" value="your_zoho_api_key" />		
   <property name="loginName" value="your_zoho_login" />		
   <property name="password" value="your_zoho_password" />				
   <property name="databaseName" value="your_zoho_database" />		
</bean>
  

<bean id="zohoClient" class="net.jclagache.zohoreport.client.ZohoReportClientWrapper" init-method="init">
   <property name="config" ref="zohoConfig" />
</bean>
```

That's it. You can now use the _zohoClient_ methods.

Optionaly, you can configure your http(s) ProxySettings.

### Maven build, test and use ###
  * How to use **spring-zohoreport** in a maven project UseWithMaven
  * How to build and test **spring-zohoreport** BuildAndTestWithMaven

#### Authentication ####
```
public void login() throws ServerException, IOException;
public void logout() throws Exception;
```

#### SELECT data ####
```
public ResultSet selectData(String tableName, String criteria) throws ServerException, IOException, ParseException, SQLException;
public ResultSet selectData(String tableName, String criteria, Map config) throws ServerException, IOException, ParseException, SQLException;
```

#### INSERT data ####
```
public Map addData(String tableName, Map columnValues) throws ServerException, IOException, ParseException;
public Map addData(String tableName, Map columnValues, Map config) throws ServerException, IOException, ParseException;
```

#### DELETE data ####
```
public void deleteData(String tableName, String criteria) throws IOException, ServerException, ParseException;
public void deleteData(String tableName, String criteria, Map config) throws IOException, ServerException, ParseException;
```

#### UPDATE data ####
```
public void updateData(String tableName, Map columnValues, String criteria) throws IOException, ServerException, ParseException;
public void updateData(String tableName, Map columnValues, String criteria, Map config) throws IOException, ServerException, ParseException;
```

[Zoho ReportClient](http://css.zohostatic.com/db/api/v2_0/m2/javadocs/com/adventnet/zoho/client/report/ReportClient.html) methods can also be used : the _**ReportClient**_ is exposed via the _**getClient()**_ method.