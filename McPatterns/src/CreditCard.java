public class CreditCard {
	String number;
	String name;
	
	
	public CreditCard(String number, String name){
		this.number = number;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public long getNumber(){
		return Long.parseLong(this.number);
	}
	


}
