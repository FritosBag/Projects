package ch11_lab_StudentScores;

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
		Student i = (Student) o;
		if (this.getStudentLast().compareTo(i.getStudentLast()) < 0)
		{
			return -1;
		}
		else if (this.getStudentLast().compareTo(i.getStudentLast()) > 0)
		{
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString()
	{
		return studentLast + ", " + studentFirst + ": " + studentScore;
	}
}