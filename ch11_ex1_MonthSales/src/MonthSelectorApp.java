import java.text.NumberFormat;

public class MonthSelectorApp
{
    public static void main(String[] args)
    {
        System.out.println("Monthly Sales\n");
        
        MonthlySales[] monthlySales = { new MonthlySales("January", 9999.00), new MonthlySales("February", 1000000),
        								new MonthlySales("March", 534905.5), new MonthlySales("April", 3905.99),
        								new MonthlySales("May", 6), new MonthlySales("June", 36459), 
        								new MonthlySales("July", 789), new MonthlySales("August", 234890),
        								new MonthlySales("September", 892350), new MonthlySales("October", 235789),
        								new MonthlySales("November", 59), new MonthlySales("December", 3578)};
        }
        
        // declare monthNames and monthSales arrays
       // String[] monthName = {"January", "February", "March", "April", "May", "June", "July",
        //					  "August", "September", "October", "November", "December"};
       // double[] monthSales = {9999999, 1000000, 534905.5, 3905.99, 6, 36459, 789, 234890,
        //					   892350, 235789, 59, 3578};
        
        // get currency formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        // get one or more months
        String choice;
        do
        {
            // get the input from the user
            int monthNumber = Console.getInt("Enter month number: ");
            
            // validate input
            if (monthNumber < 1 || monthNumber > monthName.length)
            {
                Console.displayLine("Invalid month number. Try again.");           
            }
            else
            {
            	// get the index number for the month
            	// and display the month name and sales
            	
            	Console.displayLine("Sales for " + monthName[monthNumber - 1] + ": " 
            	+ currency.format(monthSales[monthNumber - 1]));
            }
            
            // check if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        } 
        while (choice.equalsIgnoreCase("y"));
        
        // display the total sales for the year
        double total = 0;
        
        for (int x = 0; x < monthName.length; x++)
        {
        	total += monthSales[x]; 
        }
        
        Console.displayLine("Total sales: " + currency.format(total) + ": ");
        
        Console.displayLine();
    }
}