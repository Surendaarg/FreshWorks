package freshworks.prep.project;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import version1.DAO;
import version1.Service;
import version1.mapProduct;

public class UnitTesting {
	mapProduct mProd = new mapProduct();
	DAO dao = new DAO();
@Test
public void createFile() throws IOException {
		
	assertEquals(true,dao.createFile());
}
@Test
public void addData() {
	assertEquals(true,dao.unitTestAddData(mProd.getMap()));
}
@Test
public void readFile()
{
	try {
		assertEquals(true,dao.readFromFile());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("File Not Found Exception");
	}
}
@Test
public void deleteData() {
	Service service = new Service();
	try {
		assertEquals(true, service.deleteDataBasedOnKey(mProd.getMap(), "A1"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("File Not Found Exception");
	}
}

}
