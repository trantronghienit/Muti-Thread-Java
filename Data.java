package Thread;

public class Data {
	private int a ;
	private int b;
	
	private int flag ;
	
	
	public Data() {
		super();
	}
	
	public int getFlag() {
		return flag;
	}



	public void setFlag(int flag) {
		this.flag = flag;
	}



	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public int getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public int tinhTong() {
		return a + b;
	}

}
