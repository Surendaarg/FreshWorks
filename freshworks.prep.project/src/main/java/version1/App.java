package version1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
	
	static mapProduct mProd = new mapProduct();
	App() {
	try {
		
		DAO dao = new DAO();
		new DAO(mProd.map);
		
	} catch (IOException e) {
		System.out.println("File not able to create");
		e.printStackTrace();
	}
	}
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int choice;
		System.out.println("Welcome to the App !!!!\nSelect one among the choices provided"
				+ "\n1.Add JSON data into file"
				+ "\n2.Read existing data available in file"
				+ "\n3.Delete data based on key value"
				+ "\n4.Give custom file location\n5.exit");
		choice = sc.nextInt();
		new App();
		callService(choice, mProd.getMap());
		
	}

	private static void callService(int choice, Map<String, Product> map) throws IOException {
		// TODO Auto-generated method stub
		Service service = new Service();
		switch(choice) {
		case 1:{
			map=service.addJSONdataToFile(map);
			main(null);
			break;
		}
		case 2:{
			map=service.readDataFromFile(map);
			main(null);
			break;
		}
		case 3:{
			System.out.println("Key :");
			String key = sc.next();
			service.deleteDataBasedOnKey(map, key);
			main(null);
			break;
		}
		case 4:{
			map=service.customFileLocation(map);
			main(null);
		}
		default :{
			System.out.println("Thanks for using the App!! \n The file location is :"+service.getFileLocation());
		}
		}
	}

}
