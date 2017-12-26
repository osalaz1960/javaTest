package ReadMe_Document;

public class ReadMe {

}

/********************************************************************
******************* Documentacion de la Clase **********************

Explicación del Prueba Técnica:
1.- ShowAndCalculedRentails.java 
Esta clase es donde se ejecuta la lógica de negocio, en determinar lso costos por el tipo de rango seleccionado.      La lógica según lo especificado y lo que entendí, es que para disfrutar la promoción familiar se debe:
1.	Indicar o solicitar la promoción específicamente.
2.	Cuando el valor del tiempo solicitado,  es mayor o igual a tres (3), límite inferior, se calcula en costo total del tiempo y posteriormente se le resta el 30% del descuento  que exista entre   en el rango de tiempo [3 a 5].    
3.	Cuando el valor del tiempo solicitado,  es menor a tres (3)  límite inferior, no hay descuento. 

2.- CalcultedRateType.java      
Esta clase es un contenedor de los objectos, Day, Hora, Semana:
	private RentalByDay   rentalByDay;
	private RentalByHour  rentalByHour;
	private RentalByWeek  rentalByWeek;
Basicamente se usa para almacenar las características de cada tipo de objecto en una coleccion MAP y que luego a través de la clave “H”, “D” o “W”, puedo recuperar información relevante a cada objeto, la cual varia para cada clase:
  	 static final int  COST_BY_HR  = 5;
	 static final int  TYPE        = 0;
	 static final char TYPE_CHAR   = 'H';	
       
3.- CalcultedRateTypeImpl.java 
 Esta clase implementa las interfaces RentalByDay, RentalByWeek, RentalByHour  y que estas interfaces a su vez  implementa la interface CostRentails. Esta última interface obliga a implementar el método “costTypeRange” donde se calcula  la tasa a pagar. El método de esta clase escrito esta clase es inyectado en otra clase descripta posteriormente.

4.- CostRentails.java                 
Método  donde  crea o se implementa el cálculo de la aplicación.  Pero este método es inyectado por constructor en la clase “costTypeRange”. Se inyecta en el método: 
	public int costTypeRange(int numberHrs, int costXhrs ) {		
 		return CalcultedRateTypeImpl.costTypeRangeDynamic( numberHrs, costXhrs);
	}
	


5.- RentalByDay.java, RentalByHour.java , RentalByWeek.java                  
Estas tres (3) son utilizadas para definir el tipo: Día, Hora y Semana. En ellas definen únicamente los valores que son usados para el cálculo del precio final. Finalmente cada una de estas interface a su vez implementa  la interface CostRentails. Esta interface se define el método “costTypeRange”, el cual deberá  ser implementado en la clase que hereda a esta interface. 

6.- ValidationException.java      
Manejo de errores     de excepciones.

7.- ValidationExceptionCode.java     
Definición de códigos errores que maneja la prueba.

  
  
NOTA: Se anexa test JUNIT   
  
********************************************************************/