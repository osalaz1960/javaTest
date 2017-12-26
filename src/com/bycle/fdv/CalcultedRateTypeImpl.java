package com.bycle.fdv;

 

public class CalcultedRateTypeImpl  implements RentalByDay, RentalByWeek, RentalByHour   {
	
  RentalByDay   rentalByDay;
  RentalByHour  rentalByHour;
  RentalByWeek  rentalByWeek;


  
@Override
public int costTypeRange(int numberHrs, int costXhrs) {
	// TODO Auto-generated method stub
		
	return  numberHrs*costXhrs;
}
	
}

 
  

 
