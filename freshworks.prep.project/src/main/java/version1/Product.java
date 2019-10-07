package version1;

public class Product {
int num;
String name;

@Override
public String toString() {
	return "Product [num=" + num + ", name=" + name + "]";
}

public int getNum() {
	return num;
}

public Product(int num, String name) {
	this.num = num;
	this.name = name;
}

public Product() {
	// TODO Auto-generated constructor stub
}

public void setNum(int num) {
	this.num = num;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
