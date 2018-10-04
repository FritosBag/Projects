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
		int x = 0;
		return x; //temp | calculate
							//difference between the two formatted dates
	}
	
	public String getPricePerNightFormatted()
	{
		int nightlyRate = Integer.valueOf(NIGHTLY_RATE);
		nightlyRate = Integer.parseInt(nightlyRate); 
		String nightlyRateFormat = NumberFormat.getCurrencyInstance().format(nightlyRate);
		return nightlyRateFormat;
	}
	
	public double getTotalPrice()
	{
		double totalPrice = getNumberOfNights() * NIGHTLY_RATE;
		return totalPrice;
	}
	
	public String getTotalPriceFormatted()
	{
		String totalPriceFormatted = String.valueOf(getTotalPrice());
		NumberFormat.getCurrencyInstance().format(totalPriceFormatted);
		
		return totalPriceFormatted;
	}
}