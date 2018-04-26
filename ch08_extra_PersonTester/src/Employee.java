public class Employee extends Person
{
	private String socialNumber;
	
	public Employee()
	{
		super();
		socialNumber = "";
		count++;
	}
	
	public Employee(String firstName, String lastName, String EmailAddress, String socialNumber)
	{
		super(firstName, lastName, EmailAddress);
		this.socialNumber = socialNumber;
		count++;
	}
	
	public String getSocialNumber()
	{
		return socialNumber;
	}
	
	public void setSocialNumber(String socialNumber)
	{
		this.socialNumber = socialNumber;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "Social security number: " + socialNumber;
	}
	
	public String getMotto()
	{
		String motto = "Customers Appreciate Hardworking Employees!";
		
		return motto;
	}
}