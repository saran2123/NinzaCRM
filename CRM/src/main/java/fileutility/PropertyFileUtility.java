package fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("/Adv_Sel/configAppData/CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		
		return value;
				
		
		
	}

}
