//Kobe Converse pg 241
$(document).ready(function() {
	$("#calculate").click(function(evt) {
		var investment = $("#investment").val();
		var annualRate = $("#rate").val();
		var years = $("#years").val();
		
		if (isNaN(investment) || investment <= 0) {
			alert("Investment must be a valid number greater than zero.");
		} 
		else if(isNaN(annualRate) || annualRate <= 0) {
			alert("Annual rate must be a valid number greater than zero.");
		}
		else if(isNaN(years) || years <= 0) {
			alert("Years must be a valid number\nand greater than zero.");
		}
		// if all entries are valid, calulate future value
		else {
			futureValue = investment;
			for (i = 1; i <= years; i++) {
				futureValue += futureValue * annualRate / 100;
			}			
			$("#future_value").attr("value", futureValue);
		}
		evt.preventDefault();
	}); //end click
	investment.focus();
}); //end ready