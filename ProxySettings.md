# howto configure your http(s) proxy server in spring-zohoreport

# Introduction #

You can configure **spring-zohoreport** to enable http and(or) https to pass through your proxy server


# Details #

## Unique http and https proxy ##
```
<bean id="zohoConfig" class="net.jclagache.zohoreport.config.ZohoConfig">
...
<property name="proxy.proxyHost" value="your_http_and_https_proxy_host_name" />
<property name="proxy.proxyPort" value="your_http_and_https_proxy_port" /> <!-- optional, default is 8080 -->
<property name="proxy.proxyUserName" value="your_http_and_https_proxy_port" /> <!-- optional, default is an empty string -->
<property name="proxy.proxyPassword" value="your_http_and_https_proxy_port" />	<!-- optional, default is an empty string -->	
...
</bean>
```

## Http proxy ##
```
<bean id="zohoConfig" class="net.jclagache.zohoreport.config.ZohoConfig">
...
<property name="httpProxy.proxyHost" value="your_http_proxy_host_name" />
<property name="httpProxy.proxyPort" value="your_http_proxy_port" /> <!-- optional, default is 8080 -->
<property name="httpProxy.proxyUserName" value="your_http_proxy_port" /> <!-- optional, default is an empty string -->
<property name="httpProxy.proxyPassword" value="your_http_proxy_port" /> <!-- optional, default is an empty string -->	
...
</bean>
```

## Https proxy ##
```
<bean id="zohoConfig" class="net.jclagache.zohoreport.config.ZohoConfig">
...
<property name="httpsProxy.proxyHost" value="your_https_proxy_host_name" />
<property name="httpsProxy.proxyPort" value="your_https_proxy_port" /> <!-- optional, default is 8080 -->
<property name="httpsProxy.proxyUserName" value="your_https_proxy_port" /> <!-- optional, default is an empty string -->
<property name="httpsProxy.proxyPassword" value="your_https_proxy_port" /> <!-- optional, default is an empty string -->	
...
</bean>
```