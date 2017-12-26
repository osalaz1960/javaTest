package com.bycle.fdv;

 

// implements RentalByDay, RentalByWeek, RentalByHour 
public class CalcultedRateType{


	private RentalByDay   rentalByDay;
	private RentalByHour  rentalByHour;
	private RentalByWeek  rentalByWeek;
	
 	private  int          costType;	 
	//private CostRentails  costReatails;

	private CalcultedRateTypeImpl CalcultedRateTypeImpl;
	

	public CalcultedRateType( CalcultedRateTypeImpl CalcultedRateTypeImpl) {
		this.CalcultedRateTypeImpl = CalcultedRateTypeImpl;
 	}

	
	public CalcultedRateType(RentalByHour rentalByHour, int costType) {
		this.rentalByHour = rentalByHour;
        this.costType     = costType;
	}

	public CalcultedRateType(RentalByDay rentalByDay, int costType) {
		this.rentalByDay = rentalByDay;
        this.costType     = costType;
	}
		
	public CalcultedRateType(RentalByWeek rentalByWeek, int costType) {
		this.rentalByWeek = rentalByWeek;
        this.costType     = costType;
	}

	
	public int costTypeRangeDynamic(int numberHrs, int costXhrs ) {		
 		return CalcultedRateTypeImpl.costTypeRange( numberHrs, costXhrs);
	}
	
 
	public int getCostType() {
		return costType;
	}

 
	@Override
	public String toString() {
		return "CalcultedRateType [costType=" + costType + "]";
	}
  	
	
}
 
