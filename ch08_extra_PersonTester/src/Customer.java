public class Customer extends Person
{
	private String customerNumber;
	
	public Customer()
	{
		super();
		customerNumber = "";
		count++;
	}
	
	public Customer(String firstName, String lastName, String EmailAddress, String customerNumber)
	{
		super(firstName, lastName, EmailAddress);
		this.customerNumber = customerNumber;
		count++;
	}
	
	public String getCustomerNumber()
	{
		return customerNumber;
	}
	
	public void setCustomerNumber(String customerNumber)
	{
		this.customerNumber = customerNumber;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "Customer number: " + customerNumber;
	}
	
	public String getMotto()
	{
		String motto = "The Customer is Always Right!";
		
		return motto;
	}
}