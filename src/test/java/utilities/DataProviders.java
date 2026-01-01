package utilities;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider (name="Data")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\Userdata.xlsx";
		XLUtility ExUtil = new XLUtility(path);
		int rows = ExUtil.getRowCount("Sheet1");
		int columns = ExUtil.getCellCount("Sheet1", 1);
		String apidata[][] =new String[rows][columns];
		
		for(int r=1; r<=rows; r++)
		{
			for(int c=0; c<columns; c++)
			{
				apidata[r-1][c] = ExUtil.getCellData("Sheet1", r, c);
			}
		}
		return apidata;
	}
	
	@DataProvider (name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path = ".\\testData\\Userdata.xlsx";
		XLUtility ExUtil = new XLUtility(path);
		int rownum = ExUtil.getRowCount("Sheet1");
		String apidata[] = new String[rownum];
		
		for(int i=1; i<=rownum; i++)
		{
			apidata[i-1] = ExUtil.getCellData("Sheet1", i, 1);
		}
		return apidata;
	}
	
	
	@DataProvider (name="StoreData")
	public String[][] getDataStore() throws IOException
	{
		String path = ".\\testData\\Userdata.xlsx";
		XLUtility ExUtil = new XLUtility(path);
		int rows = ExUtil.getRowCount("Sheet2");
		int columns = ExUtil.getCellCount("Sheet2", 1);
		String apidata[][] =new String[rows][columns];
		
		for(int r=1; r<=rows; r++)
		{
			for(int c=0; c<columns; c++)
			{
				apidata[r-1][c] = ExUtil.getCellData("Sheet2", r, c);
			}
		}
		return apidata;
	}
	
	@DataProvider (name="StoreUserID")
	public String[] getStoreUserID() throws IOException
	{
		String path = ".\\testData\\Userdata.xlsx";
		XLUtility ExUtil = new XLUtility(path);
		int rownum = ExUtil.getRowCount("Sheet2");
		String apidata[] = new String[rownum];
		
		for(int i=1; i<=rownum; i++)
		{
			apidata[i-1] = ExUtil.getCellData("Sheet2", i, 1);
		}
		return apidata;
	}
}
