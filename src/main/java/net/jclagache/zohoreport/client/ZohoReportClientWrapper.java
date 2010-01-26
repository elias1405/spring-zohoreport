package net.jclagache.zohoreport.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.h2.tools.Csv;

import net.jclagache.zohoreport.config.ZohoConfig;

import com.adventnet.zoho.client.report.ParseException;
import com.adventnet.zoho.client.report.ReportClient;
import com.adventnet.zoho.client.report.ServerException;

/** Zoho report client wrapper.
 * 
 * @author Jean-Christophe Lagache
 * @see <a href="http://css.zohostatic.com/db/api/v2_0/m2/javadocs/com/adventnet/zoho/client/report/ReportClient.html">Zoho ReportClient javadoc</a>
 */

public class ZohoReportClientWrapper {

	private ReportClient client;
	private ZohoConfig zohoConfig;

	public void init() throws ServerException {
		client = new ReportClient(zohoConfig.getApiKey());
		if(zohoConfig.hasProxy()) {
			client.setProxy(zohoConfig.getProxy().getProxyHost(), zohoConfig.getProxy().getProxyPort(), zohoConfig.getProxy().getProxyUserName(), zohoConfig.getProxy().getProxyPassword(), "BOTH");
		}
		else {
			if(zohoConfig.hasHttpProxy()) {
				client.setProxy(zohoConfig.getHttpProxy().getProxyHost(), zohoConfig.getHttpProxy().getProxyPort(), zohoConfig.getHttpProxy().getProxyUserName(), zohoConfig.getHttpProxy().getProxyPassword(), "HTTP");
			}
			if(zohoConfig.hasHttpsProxy()) {
				client.setProxy(zohoConfig.getHttpsProxy().getProxyHost(), zohoConfig.getHttpsProxy().getProxyPort(), zohoConfig.getHttpsProxy().getProxyUserName(), zohoConfig.getHttpsProxy().getProxyPassword(), "HTTPS");
			}
		}
	}

	public void login() throws ServerException, IOException {
		client.login(zohoConfig.getLoginName(), zohoConfig.getPassword());
	}

	public void logout() throws Exception {
		client.logout();
	}

	public ZohoConfig getConfig() {
		return zohoConfig;
	}

	public void setConfig(ZohoConfig config) {
		this.zohoConfig = config;
	}
	
	
	public ReportClient getClient() {
		return client;
	}

	/**
	 * SELECT
	 */
	public ResultSet selectData(String tableName, String criteria) throws ServerException, IOException, ParseException, SQLException {
		return selectData(tableName, criteria, null);
	}
	
	public ResultSet selectData(String tableName, String criteria, Map config) throws ServerException, IOException, ParseException, SQLException {
		String uri = client.getURI(zohoConfig.getLoginName(), zohoConfig
				.getDatabaseName(), tableName);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		client.exportData(uri, "CSV", baos, criteria, config);
		
		//these 2 lines ARE the solutions to transfert an outputstream to an inputstream
		byte[] data = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		
		byte[] b = new byte[bais.available()];
		bais.read(b);
		return Csv.getInstance().read(new StringReader(new String(b)), null);		
	}
	
	 

	/**
	 * INSERT
	 */

	public Map addData(String tableName, Map columnValues)
			throws ServerException, IOException, ParseException {
		return addData(tableName, columnValues, null);
	}

	public Map addData(String tableName, Map columnValues, Map config)
			throws ServerException, IOException, ParseException {
		String uri = client.getURI(zohoConfig.getLoginName(), zohoConfig
				.getDatabaseName(), tableName);
		return client.addRow(uri, columnValues, config);
	}

	/**
	 * DELETE
	 */
	public void deleteData(String tableName, String criteria)
			throws IOException, ServerException, ParseException {
		String uri = client.getURI(zohoConfig.getLoginName(), zohoConfig
				.getDatabaseName(), tableName);
		client.deleteData(uri, criteria, null);
	}

	public void deleteData(String tableName, String criteria, Map config)
			throws IOException, ServerException, ParseException {
		String uri = client.getURI(zohoConfig.getLoginName(), zohoConfig
				.getDatabaseName(), tableName);
		client.deleteData(uri, criteria, config);
	}

	/**
	 * UPDATE
	 */
	public void updateData(String tableName, Map columnValues, String criteria)
			throws IOException, ServerException, ParseException {
		String uri = client.getURI(zohoConfig.getLoginName(), zohoConfig
				.getDatabaseName(), tableName);
		client.updateData(uri, columnValues, criteria, null);
	}

	public void updateData(String tableName, Map columnValues, String criteria,
			Map config) throws IOException, ServerException, ParseException {
		String uri = client.getURI(zohoConfig.getLoginName(), zohoConfig
				.getDatabaseName(), tableName);
		client.updateData(uri, columnValues, criteria, config);
	}

}
