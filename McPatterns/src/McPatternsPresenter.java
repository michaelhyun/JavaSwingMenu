import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

class McPatternsPresenter{
	// This is the class that will handle the model <-> UI communication.
	MenuModel model;
	McPatternsGUI view;
	ArrayList<MenuModel> menu = new ArrayList<MenuModel>();


	void loadMenuItems() {
		// TODO: Add code to read a file and load the menu items.

		try {
			URL path = ClassLoader.getSystemResource("menu.txt");
			File f = new File(path.toURI());
			Scanner in = new Scanner(f);
			while (in.hasNextLine()) {
				String line = in.nextLine();
				String[] products = line.split("\\|"); //Item|Cost String
				String name = products[0]; 
				double cost = Double.parseDouble(products[1]); 
				MenuModel theItem = new MenuModel(name, cost); 
				menu.add(theItem);
				 
			}
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to load order from " + "menu.txt" + ".");
		}
		
	}

	void attachView(McPatternsGUI view) {
		this.view = view;
	}
	// Add functions to return the menu items.
	
	public String getMenuName(int i){
		return menu.get(i).getName();
	}
	public double getMenuPrice(int i){
		return menu.get(i).getPrice();
	}
	
	
	
}