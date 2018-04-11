public class Order
{
	private int burgerAmount;
	private int friesAmount;
	private int sodaAmount;
	private static double burgerPrice;
	private static double friesPrice;
	private static double sodaPrice;
	private double burgerTotal;
	private double friesTotal;
	private double sodaTotal;
	
	public Order()
	{
		burgerAmount = 0;
		friesAmount = 0;
		sodaAmount = 0;
		burgerPrice = 0;
		friesPrice = 0;
		sodaPrice = 0;
		burgerTotal = 0;
		friesTotal = 0;
		sodaTotal = 0;
	}
	
	public Order(int burgerAmount, int friesAmount, int sodaAmount, 
				double burgerTotal, double friesTotal, double sodaTotal)
	{
		this.burgerAmount = burgerAmount;
		this.friesAmount = friesAmount;
		this.sodaAmount = sodaAmount;
		burgerPrice = .99;
		friesPrice = .79;
		sodaPrice = 1.09;
		this.burgerTotal = burgerTotal;
		this.friesTotal = friesTotal;
		this.sodaTotal = sodaTotal;
	}
	
	public double burgerCalc(int burgerAmount, double burgerTotal)
	{
		burgerTotal = burgerAmount * burgerPrice;
		return burgerTotal;
	}
	
	public double friesCalc(int friesAmount, double friesTotal)
	{
		friesTotal = friesAmount * friesPrice;
		return friesTotal;
	}
	
	public double sodaCalc(int sodaAmount, double sodaTotal)
	{
		sodaTotal = sodaAmount * sodaPrice;
		return sodaTotal;
	}
	
	public int getBurgerAmount()
	{
		return burgerAmount;
	}
	
	public void setBurgerAmount(int burgerAmount)
	{
		this.burgerAmount = burgerAmount;
	}
	
	public int getFriesAmount()
	{
		return friesAmount;
	}
	
	public void setFriesAmount(int friesAmount)
	{
		this.friesAmount = friesAmount;
	}
	
	public int getSodaAmount()
	{
		return sodaAmount;
	}
	
	public void setSodaAmount(int sodaAmount)
	{
		this.sodaAmount = sodaAmount;
	}
	
	public double getBurgerTotal()
	{
		return burgerTotal;
	}
	
	public void setBurgerTotal(double burgerTotal)
	{
		this.burgerTotal = burgerTotal;
	}
	
	public double getFriesTotal()
	{
		return friesTotal;
	}
	
	public void setFriesTotal(double friesTotal)
	{
		this.friesTotal = friesTotal;
	}
	
	public double getSodaTotal()
	{
		return sodaTotal;
	}
	
	public void setSodaTotal(double sodaTotal)
	{
		this.sodaTotal = sodaTotal;
	}
}