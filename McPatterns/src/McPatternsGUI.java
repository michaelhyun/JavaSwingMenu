import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

class McPatternsGUI extends JFrame {
	McPatternsPresenter presenter;
	private double cost = 0;
	
	public McPatternsGUI(McPatternsPresenter presenter) {
		
		this.presenter = presenter;
		presenter.attachView(this);
		showGUI();

	}
	
	private void showGUI() {
		presenter.loadMenuItems();

		JFrame theFrame = new JFrame("Homework 4");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		
		//Title panel TOP
		JPanel title = new JPanel(new FlowLayout());
		title.add(new JLabel("Welcome to McPatterns"));

		//Order Panel Right
		JPanel orderPanel = new JPanel();
		JLabel orderDetails = new JLabel("Your current order:");
		orderPanel.add(orderDetails);
		orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
		JTextArea list = new JTextArea();
		orderPanel.add(list);
		final JLabel totalCost = new JLabel("Total Cost: " + "$" + new DecimalFormat("##.##").format(cost)); //uses private variable
		orderPanel.add(totalCost);
		
		
		
		//CC Panel Bottom
		JPanel ccPane = new JPanel();
		ccPane.setLayout(new BoxLayout(ccPane, BoxLayout.Y_AXIS));
		ccPane.setBorder(BorderFactory.createRaisedBevelBorder());
		JTextField ccEntry = new JTextField("Enter CC #");
	   
		
		//confirm button
		JButton confirm = new JButton("Place Order");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Add the function to handle confirmed order
				//Think about where you will store order and who should manipulate.
				//Handle the Payment validation before confirming order. Who should validate?
				try{
					String ccNumber = ccEntry.getText();				
					
					CreditCardFactory ccFactory = new CreditCardFactory();
					CreditCard creditCard = ccFactory.CreditCardFactory1(ccNumber);
					String creditCardName = creditCard.getName();
					
					System.out.println("Your order is confirmed: " + "\n" + creditCardName + list.getText() + "\nTotal: " + "$" + new DecimalFormat("##.##").format(cost));
					
					//reset
					cost = 0;
					totalCost.setText("Total Cost: "+ "$" + new DecimalFormat("##.##").format(cost));
					list.setText("");
	
					//change top
					orderDetails.setText("Order confirmed for: " + creditCardName);
					orderDetails.repaint();

				}
				catch(Exception ee){
					System.out.println("Credit Card is not Valid");
				}
			}
		});
		
		//cancel button
		JButton cancel = new JButton("Cancel Order");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Add the function to handle cancel order
				//Think about where you will store order and who should manipulate.				
				list.setText("");
				cost = 0;
				totalCost.setText("Total Cost: "+ "$" + new DecimalFormat("##.##").format(cost)); //uses private variable
			}

		});
		ccPane.add(ccEntry);
		ccPane.add(confirm);
		ccPane.add(cancel);

		
		//Item Panel Left
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		// TODO: Ask the presenter for the buttons to create. Iterate over the buttons and create them
		int menuSize = presenter.menu.size();
		for(int i = 0; i < menuSize; i++){
			String name = presenter.menu.get(i).getName();
			double price = presenter.menu.get(i).getPrice();
			JButton itemButton = new JButton(name + " " + price);
			buttonPanel.add(itemButton);
			itemButton.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  	cost += price;
					  	totalCost.setText("Total Cost: " + "$" + new DecimalFormat("##.##").format(cost));
					  	list.setText(list.getText() + "\n" + name + ":  $" + price);  
					  } 
					} );
		}
		
		theFrame.add(title,BorderLayout.NORTH);
		theFrame.add(buttonPanel, BorderLayout.WEST);
		theFrame.add(ccPane, BorderLayout.SOUTH);
		theFrame.add(orderPanel, BorderLayout.EAST);
		theFrame.setSize(2000,800);
		
		theFrame.pack();
		theFrame.setVisible(true);
		
	}
}
