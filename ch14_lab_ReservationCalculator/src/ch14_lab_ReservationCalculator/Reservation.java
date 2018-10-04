package ch14_lab_ReservationCalculator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Reservation
{	
	private LocalDate arrivalDate;
	private LocalDate departureDate;
	private String daysBetweenString;
	private static final int NIGHTLY_RATE = 145;
	
	Reservation()
	{
		arrivalDate = null;
		departureDate = null;
		daysBetweenString = null;
	}
	
	Reservation(LocalDate arrivalDate, LocalDate departureDate, String daysBetweenString)
	{
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.daysBetweenString = daysBetweenString;
	}
	
	public LocalDate getArrivalDate()
	{
		return arrivalDate;
	}
	
	public String getArrivalDateFormatted()
	{
		DateTimeFormatter atf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		return atf.format(arrivalDate);
	}
	
	public void setArrivalDate(LocalDate arrivalDate)
	{
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate()
	{
		return departureDate;
	}
	
	public String getDepartureDateFormatted()
	{
		DateTimeFormatter atf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		return atf.format(departureDate);
	}

	public void setDepartureDate(LocalDate departureDate)
	{
		this.departureDate = departureDate;
	}
	
	public String getDaysBetweenString()
	{
		return daysBetweenString;
	}

	public void setDaysBetweenString(String daysBetweenString)
	{
		this.daysBetweenString = daysBetweenString;
	}
	
	public int getNumberOfNights()
	{
		long daysBetween = ChronoUnit.DAYS.between(arrivalDate, departureDate);
		String daysBetweenString = String.valueOf(daysBetween);
		
		int nightNumber = Integer.parseInt(daysBetweenString);
		setDaysBetweenString(daysBetweenString);
		
		return nightNumber;		
	}
	
	public String getPricePerNightFormatted()
	{
		String nightlyRateFormat = NumberFormat.getCurrencyInstance().format(NIGHTLY_RATE);
		
		return nightlyRateFormat;
	}
	
	public double getTotalPrice()
	{
		double totalPrice = getNumberOfNights() * NIGHTLY_RATE;
		
		return totalPrice;
	}
	
	public String getTotalPriceFormatted()
	{
		NumberFormat.getCurrencyInstance().format(getTotalPrice());
		
		return NumberFormat.getCurrencyInstance().format(getTotalPrice());
	}
}