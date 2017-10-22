package ad17.unit2.examples;

public class Telephone {
	private int code;
	private int number;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Telephone [code=" + code + ", number=" + number + "]";
	}
	
	
	
}


