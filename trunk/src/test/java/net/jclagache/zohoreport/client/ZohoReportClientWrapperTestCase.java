package net.jclagache.zohoreport.client;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import net.jclagache.zohoreport.BaseZohoReportTestCase;

public class ZohoReportClientWrapperTestCase extends BaseZohoReportTestCase {
	ZohoReportClientWrapper zohoClient;

	public void setZohoClient(ZohoReportClientWrapper zohoClient) {
		this.zohoClient = zohoClient;
	}

	public void testInsertData() throws Exception {
		zohoClient.login();
		zohoClient.addData("Sales", getValuesToInsert());
		zohoClient.logout();
	}
	
	public void testUpdateData() throws Exception {
		zohoClient.login();
		zohoClient.updateData("Sales", getValuesToUpdate(), getUpdateCriteria());
		zohoClient.logout();
	}
	
	public void testDeleteData() throws Exception {
		zohoClient.login();
		zohoClient.deleteData("Sales", getDeleteCriteria());
		zohoClient.logout();
	}
	
	public void testSelectData() throws Exception {
		zohoClient.login();
		ResultSet rs = zohoClient.selectData("Sales", getSelectCriteria());		
		zohoClient.logout();
		rs.close();
	}
	
	private HashMap getValuesToInsert() {
		SimpleDateFormat dtFmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		HashMap rowValsMap = new HashMap();
		rowValsMap.put("Date", dtFmt.format(new Date()));
		rowValsMap.put("Region", "EAST");
		rowValsMap.put("Product Category", "Sample_Grocery");
		rowValsMap.put("Product", "Sample_Meat");
		rowValsMap.put("Customer Name", "John");
		rowValsMap.put("Sales", "2303");
		rowValsMap.put("Cost", "1000");
		return rowValsMap;
	}
		
	private HashMap getValuesToUpdate()
    {        
        HashMap rowValsMap = new HashMap();
        rowValsMap.put("Product Category","Sample_Grain");
        rowValsMap.put("Product","Sample_Wheat");
        return rowValsMap;
    }
    
    private String getUpdateCriteria()
    {
        return "(\"Region\" = 'East') and (\"Product Category\" = 'Grocery')";
    }
    
    private String getDeleteCriteria()
    {
        return "(\"Region\" = 'West') and (\"Product Category\" = 'Stationery')";
    }
    
    private String getSelectCriteria()
    {
        return "(\"Region\" = 'Central') and (\"Product Category\" = 'Stationery')";
    }


}
