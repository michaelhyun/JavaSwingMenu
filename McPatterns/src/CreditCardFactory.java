public class CreditCardFactory {

	public CreditCard CreditCardFactory1(String creditCardNumber) throws Exception{
		

		String firstNumber = creditCardNumber.substring(0,1);
		String secondNumber = creditCardNumber.substring(1,2);
		
		if(firstNumber.equals("5") && "12345".contains(secondNumber) && creditCardNumber.length() == 16){
			return new MasterCC(creditCardNumber, "MasterCard");
		}
		else if(firstNumber.equals("4") && (creditCardNumber.length() == 13 || creditCardNumber.length() == 16)){
			return new VisaCC(creditCardNumber, "Visa");
		}
		else if(firstNumber.equals("3") && creditCardNumber.length() == 15 && (secondNumber.equals("4") || secondNumber.equals("7"))){
			return new AmExCC(creditCardNumber, "American Express");
		}
		else if(creditCardNumber.substring(0,4).equals("6011") && creditCardNumber.length() == 16){
			return new DiscoverCC(creditCardNumber, "Discover");
		}
		else{
			throw new Exception();
		}
	}

}
