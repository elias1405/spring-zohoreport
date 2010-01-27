package net.jclagache.zohoreport.config;

import java.io.Serializable;

public class ZohoConfig implements Serializable {

	private static final long serialVersionUID = 4001288858017393489L;

	private String apiKey;

	private String databaseName;

	private String loginName;

	private String password;
	
	private ZohoProxyConfig proxy;
	
	private ZohoProxyConfig httpProxy;
	
	private ZohoProxyConfig httpsProxy;
	
	public ZohoConfig() {
		proxy = new ZohoProxyConfig();
		httpProxy = new ZohoProxyConfig();
		httpsProxy = new ZohoProxyConfig();
	}
	
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ZohoProxyConfig getProxy() {
		return proxy;
	}

	public void setProxy(ZohoProxyConfig proxy) {
		this.proxy = proxy;
	}

	public ZohoProxyConfig getHttpProxy() {
		return httpProxy;
	}

	public void setHttpProxy(ZohoProxyConfig httpProxy) {
		this.httpProxy = httpProxy;
	}

	public ZohoProxyConfig getHttpsProxy() {
		return httpsProxy;
	}

	public void setHttpsProxy(ZohoProxyConfig httpsProxy) {
		this.httpsProxy = httpsProxy;
	}
	
	public boolean hasProxy() {
		if(getProxy().getProxyHost() != null) {
			return true;
		}
		else return false;
	}
	
	public boolean hasHttpProxy() {
		if(getHttpProxy().getProxyHost() != null) {
			return true;
		}
		else return false;
	}
	
	public boolean hasHttpsProxy() {
		if(getHttpsProxy().getProxyHost() != null) {
			return true;
		}
		else return false;
	}
	
}
