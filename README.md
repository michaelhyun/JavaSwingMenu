# JavaSwingMenu
A simple menu with Credit Card validation


Design Patterns

Exception
I wrote an exception handler for this program to make sure that all edge cases regarding the credit cards were accounted for.
This is a pro because I handle all edge cases. The bad thing is that it might rule out other credit cards for now.

Subclasses/Inheritance
Subclasses are implemented in my code to make it easy to implement other classes of credit cards. They all share the same attributes
and it makes it easy to make another credit card. The cons is that it is somewhat harder to read than if I did not use Subclasses, 
but the immense utility that is provided by using these shared characteristics and constructors makes up for it.

Encapsulation
The data is hidden from the client, and for example, the credit card chosen is hidden from the client. This is good for data hiding, 
but the cons are that it can be a little messy to read as well. (not in this case though) 


Factory
Factories were a really good way of choosing which subclass of the credit card class to implement. Based on the parameters given, the
factory easily chose which instance to create, and it is good because it allows for data hiding and is structurally nice. It can become
a little complex but in this case it is okay since it is a small assignment. 
