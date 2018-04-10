package murach.games;

import java.util.Random;

public class NumberGame
{
	private int upperLimit;
	private int number;
	private int incrementGuessCount;
	
	public NumberGame()
	{
		this(50);
	}
	
	public NumberGame(int upperLimit)
	{
		this.upperLimit = 50;
		Random random = new Random();
		number = random.nextInt(getUpperLimit() - 1) + 1;
		incrementGuessCount = 1;
	}
	
	public int getUpperLimit()
	{
		return upperLimit;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public int getIncrementGuessCount()
	{
		incrementGuessCount++;
		return incrementGuessCount;
	}
}