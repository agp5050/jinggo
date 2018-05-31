package ml.jinggo.domain;

/**
 * 1.属性前面2个字母是大写是可以，但是要2个都大写，或者都小写
 */
public class Car {
	public String brand;
	private String corp;	
	private double price;
	private int maxSpeed;

	//属性注入必须有默认的构造函数
	public Car() {}	
	public Car(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}	

	public Car(String brand, String corp, double price) {
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	public Car(String brand, String corp, int maxSpeed) {
		this.brand = brand;
		this.corp = corp;
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return "brand:"+brand+"/maxSpeed:"+maxSpeed+"/price:"+price;
	}

}

