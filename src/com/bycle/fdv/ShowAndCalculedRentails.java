package com.bycle.fdv;

import java.util.HashMap;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

 

public class ShowAndCalculedRentails {
	
	
    private static final Double DISCOUNT_FAMILY      = 0.30;
    private static final int    MIN_PROMOTION_DISCOUNT_FAMILY   = 3;
    private static final int    MAX_PROMOTION_DISCOUNT_FAMILY   = 5;
	private static final int    DIFF_PROMOTION_DISCOUNT_FAMILY  = MAX_PROMOTION_DISCOUNT_FAMILY - MIN_PROMOTION_DISCOUNT_FAMILY + 1;
	
	private static final String TYPE_RANGO_DETAILS   = "H|D|W";

    private   RentalByDay   rentalByDay;
	private   RentalByHour  rentalByHour;
	private   RentalByWeek  rentalByWeek;
	
	
	
 	
	public ShowAndCalculedRentails() {
 
	}



	public  Double showCalculedRentails(String grupoFamily,  int numberHours, String typeTime)  throws  ValidationException {
	     
		HashMap <String, CalcultedRateType> lista;

		if(numberHours < 0)
 		   throw new ValidationException(ValidationExceptionCode.INVALID_CANT_HRS_NEGATIVA_CERO, "Cantidad de Tiempo Negativas: " + numberHours);
		
		// Definir un HashMap
		lista   = new HashMap <String, CalcultedRateType>();
		CalcultedRateType  hour = new CalcultedRateType(rentalByHour, rentalByHour.COST_BY_HR); 
		CalcultedRateType  day  = new CalcultedRateType(rentalByDay,  rentalByDay.COST_BY_HR);
		CalcultedRateType  week = new CalcultedRateType(rentalByWeek, rentalByWeek.COST_BY_HR);
  
		// agrega objeto por cada typo a las lista MAP
		lista.put("H",  hour);
		lista.put("D",  day);
		lista.put("W",  week);
		 	 
  		CalcultedRateTypeImpl CalcultedRateTypeImpl = new CalcultedRateTypeImpl(); 		
 			
		CalcultedRateType calculedRents = new CalcultedRateType( CalcultedRateTypeImpl );
		Double resultRentals  = (double) calculedRents.costTypeRangeDynamic(numberHours, lista.get(typeTime).getCostType());

  		// Test si es grupo familiar
		if(grupoFamily.equalsIgnoreCase("Y") ||  grupoFamily.equalsIgnoreCase("S")) {
		    Double resultRentalsPromosion = caluledRentalFamily(numberHours, lista.get(typeTime).getCostType(), calculedRents);
 
		    resultRentals -= resultRentalsPromosion;
		    
		}
		 
        return resultRentals;

 	}

	
	
	// Metodo para calcluo promosiones por grupo familiar
  	public static Double caluledRentalFamily(int cantHrs, int costoType, CalcultedRateType calculedRents) throws ValidationException    {
 		 Double resultRentalsPromosion = 0.0; 
		 int    hrsWithInPromotion = 0;
	   	
 		
	     if(cantHrs >= MAX_PROMOTION_DISCOUNT_FAMILY) hrsWithInPromotion =  DIFF_PROMOTION_DISCOUNT_FAMILY;         
	       else  if(cantHrs >= MIN_PROMOTION_DISCOUNT_FAMILY)
	      		 // cantHrs >= MINIMO  SE APLICA TARIFA SOBRE LA CANT. HRS - DIFF  
	            	 hrsWithInPromotion   =    cantHrs - DIFF_PROMOTION_DISCOUNT_FAMILY + 1;
	     
	     // Hubo determina si hubo descuento hrsWithInPromotion 
	     if(hrsWithInPromotion != 0)
	     {
	       	//resultRentalsPromosion  =  calcultedTipo(typeOpcionBycle, hrsWithInPromotion)*DISCOUNT_FAMILY;
 	       	resultRentalsPromosion = calculedRents.costTypeRangeDynamic(hrsWithInPromotion, costoType)*DISCOUNT_FAMILY;
 	     }   
		       	     
 	     return resultRentalsPromosion;         	      	  
	 }	  


	public int inputParameter(String grupoFamily,  String numberHrs, String typeTime)  throws  ValidationException {
	     		
		int numberHours = 0;
 
		try {
 		   // TODO Auto-generated method stub
 		   JFrame frame = new JFrame("Imput Bycle Datos");

 		   // prompt grupo familiar
	       grupoFamily = JOptionPane.showInputDialog(frame, "Promosion Es Grupo Familiar [Y/N] ?");
	       grupoFamily = grupoFamily.toUpperCase().substring(0, 1);
 		   System.out.printf("Grupo Familiar [Y/N]: Opcion '%s'.\n", grupoFamily);

 	       // prompt numero de hrs
	       typeTime = JOptionPane.showInputDialog(frame, "Selecione tipo de Rango a Alquilar x [H]ours, [D]ays o  [W]eeks  ? ");
		   typeTime = typeTime.toUpperCase().substring(0, 1);
		   System.out.printf("Selecione el type x  '%s'.\n", typeTime);
				
 	       // prompt numero de hrs
	       numberHrs = JOptionPane.showInputDialog(frame, "Num de Periodo a  Alquilar en Hrs/Days/Weeks  [n] ?");
		   numberHours = Integer.parseInt(numberHrs);
 		   System.out.printf("Numero de Hrs Seleccionada '%s'.\n", numberHours);
		 }
		  catch (IllegalArgumentException |  NullPointerException  e)  {
			  throw new ValidationException(ValidationExceptionCode.INVALID_FORMAT_IMPUT, "Se introdujo Formato Invalido  " 
		       + "[" + grupoFamily + "]" + "[" + typeTime + "]" + "[" + numberHrs + "]"); 	 		
		  }
  		
		  if(numberHours < 0)
			 throw new ValidationException(ValidationExceptionCode.INVALID_CANT_HRS_NEGATIVA_CERO, "Cantidad de tiempo negativo: " + numberHours + " Tipo Opcion: " + typeTime );

 		  if(TYPE_RANGO_DETAILS.indexOf(typeTime) == -1)
			 throw new ValidationException(ValidationExceptionCode.NO_EXISTE_TIPO, "Tipo de Rango Renta Invalido no es [H, D, W] : "  + typeTime );

		   return numberHours;
   	}
    	
}
