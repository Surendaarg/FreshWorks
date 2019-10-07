package version1;

import java.util.Map;

public class addSampleData {

	addSampleData(){
		
	}

	public Map<String, Product> getSampleData(Map<String, Product> map) {
		Product prod1 = new Product(100,"Surf Excel");
		Product prod2 = new Product(101,"Rin");
		map.put("A1", prod1);
		map.put("A2", prod2);
		return map;
	}
}
