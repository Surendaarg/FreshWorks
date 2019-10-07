package version1;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class DAO {
	static String fileLocation="C:\\Users\\JSONfilePretty.json";
	static File file = new File(fileLocation);

	private static boolean checkFileSize(File file2) {
		// TODO Auto-generated method stub
		final long SIZE_1GB = 1073741824L;
		boolean check = true;
		if(getFileSize(file2)>SIZE_1GB && getFileSize(file2)>0) {
			System.out.println("File Size is more than 1GB, you cant write future. Kindly delete data or remove file to proceed..");
			check = false;
		}
		return check;
	}
	public static long getFileSize(File file2) {
	     
	      if (!file2.exists() || !file2.isFile()) {
	         System.out.println("File doesn\'t exist");
	         return -1;
	      }
	      return file2.length();
	   }

	public DAO(Map<String, Product> map) throws IOException{
		mapProduct mProd = new mapProduct();
		
		addSampleData sample = new addSampleData();
		
		if (file.createNewFile())
		{
		    System.out.println("File is created!");
		    mProd.map= sample.getSampleData(map);
		    writeToFile(mProd.map);
		} else {
		    System.out.println("File already exists.");
		}
		
		}
	
	public DAO() {
		// TODO Auto-generated constructor stub
	}

	public static void writeToFile(Map<String, Product> map) throws IOException {
		if(checkFileSize(file)) {
			ObjectMapper mapper = new ObjectMapper();
			mapProduct mapProduct = getMapProduct(map);
			try {
				mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileLocation), mapProduct);
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	private static mapProduct getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean readFromFile() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapProduct prod = null;
		try {
		prod=mapper.readValue(new File(fileLocation), mapProduct.class);
		System.out.println(prod);
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public static String getFileLocation() {
		return fileLocation;
	}

	public static void setFileLocation(String fileLocation, Map<String, Product> map) throws IOException {
		DAO dao = new DAO();
		dao.fileLocation = fileLocation+"//Surendaarresult.json";
		writeToFile(map);
	}
	
	public static mapProduct getMapProduct(Map<String, Product> map){
		//System.out.println("Display");
		mapProduct mProduct = new mapProduct();
		mProduct.map = map;
		//System.out.println(mProduct.toString());
		return mProduct;
		
	}
	
	public boolean createFile() {
		try {
			if(file.createNewFile())
			{
				return true;
			}
			else
				return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean unitTestAddData(Map<String, Product> map) {
		mapProduct mProd = new mapProduct();
		addSampleData sample = new addSampleData();
		mProd.map= sample.getSampleData(map);
	    try {
			writeToFile(mProd.map);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	}
