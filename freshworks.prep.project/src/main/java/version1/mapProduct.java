package version1;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class mapProduct {
	@Override
	public String toString() {
		return "AllProducts ["+ map.toString() + "]";
	}

	static Map<String, Product> map = new HashMap<String, Product>();

	public Map<String, Product> getMap() {
		return map;
	}

	public static void setMap(Map<String, Product> map) {
		mapProduct.map = map;
	}
	
}
