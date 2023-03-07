package Generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//the statments which are common for all the scripts are written in the utlity class
public class File_Utility {

	/**
	 * this method is used to read the data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author adhi1
	 */
	
	public String getKeyAndVAlue(String key) throws Throwable
	{
		// to read the data from property file first the FIS object should be craeted
				FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties.txt");

				// properties object should be created to read the data from the external
				// resources
				Properties pro = new Properties();

				// call the load method from property file and give the input of FIS object
				pro.load(fis);

				// fetch the url from property file and store it in a variable URL
				String value = pro.getProperty(key);
				
				return value;
	}
}
