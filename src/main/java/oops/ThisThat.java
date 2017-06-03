package oops;

class That{
	public void print(){
		System.out.println("That");
	}
}

public class ThisThat extends That{
	@Override
	public void print(){
		System.out.println("This");
	}

	public static void main(String[] args){
		That that = new That();
		That thisThat = new ThisThat();
		that.print();
		thisThat.print();
	}
}
