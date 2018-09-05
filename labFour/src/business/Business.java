package business;

public class Business
{
	private int studentId;
	private String studentName;
	private String studentEmail;
	private double hoursAmount;
	
	public Business()
	{
		studentId = 0;
		studentName = "";
		studentEmail = "";
		hoursAmount = 0;
	}
	
	public Business(int studentId, String studentName, String studentEmail, double hoursAmount)
	{
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.hoursAmount = hoursAmount;
	}
	
	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}
	
	public int getStudentId()
	{
		return studentId;
	}
	
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	
	public String getStudentName()
	{
		return studentName;
	}
	
	public void setStudentEmail(String studentEmail)
	{
		this.studentEmail = studentEmail;
	}
	
	public String getStudentEmail()
	{
		return studentEmail;
	}
	
	public void setHoursAmount(Double hoursAmount)
	{
		this.hoursAmount = hoursAmount;
	}
	
	public double getHoursAmount()
	{
		return hoursAmount;
	}
	
	public static double calcHoursAmount(double hoursAmount)
	{
		hoursAmount = hoursAmount * 60.50;
		return hoursAmount;
	}
}