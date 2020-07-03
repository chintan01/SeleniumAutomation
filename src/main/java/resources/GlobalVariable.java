package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalVariable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Chintan\\eclipse-workspace\\EProject\\src\\main\\java\\resources\\data.properties");
	
		prop.load(fis);
		
		System.out.println(prop.getProperty("browser"));

		System.out.println(prop.getProperty("url"));
		
		prop.setProperty("browser", "firefox");
		
		System.out.println(prop.getProperty("browser"));
		
		FileOutputStream fout = new FileOutputStream("C:\\Users\\Chintan\\eclipse-workspace\\EProject\\src\\main\\java\\resources\\data.properties");
	
		prop.store(fout, null);
	}

}
