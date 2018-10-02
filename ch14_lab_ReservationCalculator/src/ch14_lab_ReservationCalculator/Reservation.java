package ch14_lab_ReservationCalculator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Reservation
{	
	private LocalDate arrivalDate;
	private LocalDate departureDate;
	private static final int NIGHTLY_RATE = 145;
	
	Reservation()
	{
		arrivalDate = null;
		departureDate = null;
	}
	
	Reservation(LocalDate arrivalDate, LocalDate departureDate)
	{
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}
	
	public LocalDate getArrivalDate()
	{
		return arrivalDate;
	}
	
	public String getArrivalDateFormatted()
	{
		DateTimeFormatter arrivalDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String arrivalDateFormatted = String.valueOf(arrivalDate);
		return arrivalDateFormatted;
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
		DateTimeFormatter departureDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String departureDateFormatted = String.valueOf(departureDate);
		return departureDateFormatted;
	}

	public void setDepartureDate(LocalDate departureDate)
	{
		this.departureDate = departureDate;
	}
	
	public int getNumberOfNights()
	{
		int nightNumber = 0;
		return nightNumber; //temp | calculate
	}
	
	public String getPricePerNightFormatted()
	{
		//cast NIGHTLY_RATE to String then format?
		String x = ""; //temp variable
		return x;
	}
	
	public double getTotalPrice()
	{
		double totalPrice = 0;
		return totalPrice; //temp | calculate
	}
	
	public String getTotalPriceFormatted()
	{
		String totalPriceFormatted = String.valueOf(getTotalPrice());
		NumberFormat.getCurrencyInstance().format(totalPriceFormatted);
		
		return totalPriceFormatted;
	}
}