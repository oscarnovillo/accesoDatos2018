package ad17.unit2.activities;

public class Coffee {
	private String name;
	private int providerId;
	private float price;
	private int sales;
	private int total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	 @Override
	    public String toString() {
	        return "Coffee{" + "name=" + name + "price=" + price+ "sales=" + sales + "total=" + total +'}';
	    }

}
