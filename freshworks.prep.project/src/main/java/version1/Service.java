package version1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Service {
	
	Scanner sc = new Scanner(System.in);
	
	public Map<String, Product> addJSONdataToFile(Map<String, Product> map) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter key as any String and Value as Product number in int followed by Product name\n Key :");
		String key = sc.next();
		Product prod = new Product();
		System.out.println("Product Number(s) :");
		prod.num= sc.nextInt();
		System.out.println("Product Name :");
		prod.name=sc.next();
		map.put(key, prod);
		DAO dao = new DAO();
		dao.writeToFile(map);
		System.out.println("Do you wish to set Time_To_Live property for the key?(Y/N)");
		String choice = sc.next();
		System.out.println(choice.charAt(0));
		if(choice.charAt(0)=='Y') {
			System.out.println("Time_To_Live in seconds:");
			int timeToLive = sc.nextInt();
			Scheduler schedule = new Scheduler();
			schedule.deleteKeyAfter(map, key, timeToLive);
		}
		System.out.println("Added successfully");
		return map;
	}

	public Map<String, Product> readDataFromFile(Map<String, Product> map) throws IOException {
		// TODO Auto-generated method stub
		//map.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));
		//DAO dao= new DAO();
		DAO dao = new DAO();
		dao.readFromFile();
		return map;
	}

	public boolean deleteDataBasedOnKey(Map<String, Product> map, String key) throws IOException {
		// TODO Auto-generated method stub
		
		Service service = new Service();
		map = service.readDataFromFile(map);
		Iterator<Map.Entry<String, Product>> itr = map.entrySet().iterator();
		boolean check=false;
		while(itr.hasNext()) {
			Map.Entry<String, Product> entry = itr.next();
		    if(entry.getKey().equals(key)) {
		    	 System.out.println("Removed Key:"+key);
		    	 check=true;
		        itr.remove();
		    }
		}
		
		if(check==false)
			System.out.println("key is not available");
		else
		{
			DAO dao = new DAO();
			dao.writeToFile(map);
		}
		return check;
	}

	public Map<String, Product> customFileLocation(Map<String, Product> map) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the new location :");
		String location = sc.next();
		DAO dao = new DAO(map);
		dao.setFileLocation(location, map);
		return map;
	}

	public String getFileLocation() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		return dao.getFileLocation();
	}

}
