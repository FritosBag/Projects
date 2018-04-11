import java.text.NumberFormat;

public class Order
{
	private int burgerAmount;
	private int friesAmount;
	private int sodaAmount;
	private static final double BURGER_PRICE = .99;
	
	public Order()
	{
		burgerAmount = 0;
		friesAmount = 0;
		sodaAmount = 0;
	}
	
	public Order(int burgerAmount, int friesAmount, int sodaAmount)
	{
		this.burgerAmount = burgerAmount;
		this.friesAmount = friesAmount;
		this.sodaAmount = sodaAmount;
	}
	
	public double burgerCalc(int burgerAmount, double burgerTotal)
	{
		double burgerCost;
		
		burgerCost = burgerAmount * BURGER_PRICE;
		return burgerCost;
	}
	
	public String burgerCalcFormatted()
	{
		NumberFormat number = NumberFormat.getCurrencyInstance();
		return currency.format(burgerCalc());
		
	}
	public double friesCalc(int friesAmount, double friesTotal)
	{
		double friesCost;
		
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