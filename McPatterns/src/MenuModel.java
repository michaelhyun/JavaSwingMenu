class MenuModel {
    // Add your implementation for Menu Items here.
    // Determine what data you want to store for each item.

	String name;
	double price;
	
	public MenuModel(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	
	public double getPrice(){
		return this.price;
	}
	
	public String getName(){
		return this.name;
	}

	
	
	
	
	
	
	
}