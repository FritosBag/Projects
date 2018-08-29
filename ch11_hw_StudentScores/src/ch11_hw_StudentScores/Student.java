package ch11_hw_StudentScores;

public class Student implements Comparable
{
	private String studentLast;
	private String studentFirst;
	private int studentScore;
	
	Student()
	{
		studentLast = "";
		studentFirst = "";
		studentScore = 0;
	}
	
	Student(String studentLast, String studentFirst, int studentScore)
	{
		this.studentLast = studentLast;
		this.studentFirst = studentFirst;
		this.studentScore = studentScore;
	}
	
	public String getStudentLast()
	{
		return studentLast;
	}
	
	public void setStudentLast(String studentLast)
	{
		this.studentLast = studentLast;
	}
	
	public String getStudentFirst()
	{
		return studentFirst;
	}
	
	public void setStudentFirst(String studentFirst)
	{
		this.studentFirst = studentFirst;
	}
	
	public int getStudentScore()
	{
		return studentScore;
	}
	
	public void setStudentScore(int studentScore)
	{
		this.studentScore = studentScore;
	}
	
	@Override
	public int compareTo(Object o)
	{
		getStudentLast i = (getStudentLast) o;
		if (this.getStudentLast(studentLast).compareTo(i.studentLast))
		{
			return 1;
		}
		else if (this.studentLast.compareTo(i.studentLast))
		{
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString()
	{
		return "Student first name: " + studentFirst + "\n" +
			   "Student last name: " + studentLast + "\n" + 
			   "Student score: " + studentScore + "\n";
	}
}