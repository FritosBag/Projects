import java.text.NumberFormat;

public class Order
{
	private int burgerAmount;
	private int friesAmount;
	private int sodaAmount;
	private static final double BURGER_PRICE = .99;
	private static final double FRIES_PRICE = .79;
	private static final double SODA_PRICE = 1.09;
	
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
	
	public double burgerCalc(int burgerAmount)
	{
		double burgerCost;
		
		burgerCost = burgerAmount * BURGER_PRICE;
		return burgerCost;
	}
	
	public String burgerCalcFormatted()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(burgerCalc(burgerAmount));
		
	}
	public double friesCalc(int friesAmount)
	{
		double friesCost;
		
		friesCost = friesAmount * FRIES_PRICE;
		return friesCost;
	}
	
	public String friesCalcFormatted()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(friesCalc(friesAmount));
	}
	
	public double sodaCalc(int sodaAmount)
	{
		double sodaCost;
		
		sodaCost = sodaAmount * SODA_PRICE;
		return sodaCost;
	}
	
	public String sodaCalcFormatted()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(sodaCalc(sodaAmount));
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
}