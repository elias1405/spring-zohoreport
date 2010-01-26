package net.jclagache.zohoreport.config;

import java.io.Serializable;

public class ZohoProxyConfig implements Serializable {
	
	private static final long serialVersionUID = -6697449283693849051L;

	private String proxyHost;
	
	private int proxyPort = 8080;
	
	private String proxyUserName = "";
	
	private String proxyPassword = "";	

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyUserName() {
		return proxyUserName;
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public String getProxyPassword() {
		return proxyPassword;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}
}
