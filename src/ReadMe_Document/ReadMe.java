package ReadMe_Document;

public class ReadMe {

}

/********************************************************************
******************* Documentacion de la Clase **********************

Explicaci�n del Prueba T�cnica:
1.- ShowAndCalculedRentails.java 
Esta clase es donde se ejecuta la l�gica de negocio, en determinar lso costos por el tipo de rango seleccionado.      La l�gica seg�n lo especificado y lo que entend�, es que para disfrutar la promoci�n familiar se debe:
1.	Indicar o solicitar la promoci�n espec�ficamente.
2.	Cuando el valor del tiempo solicitado,  es mayor o igual a tres (3), l�mite inferior, se calcula en costo total del tiempo y posteriormente se le resta el 30% del descuento  que exista entre   en el rango de tiempo [3 a 5].    
3.	Cuando el valor del tiempo solicitado,  es menor a tres (3)  l�mite inferior, no hay descuento. 

2.- CalcultedRateType.java      
Esta clase es un contenedor de los objectos, Day, Hora, Semana:
	private RentalByDay   rentalByDay;
	private RentalByHour  rentalByHour;
	private RentalByWeek  rentalByWeek;
Basicamente se usa para almacenar las caracter�sticas de cada tipo de objecto en una coleccion MAP y que luego a trav�s de la clave �H�, �D� o �W�, puedo recuperar informaci�n relevante a cada objeto, la cual varia para cada clase:
  	 static final int  COST_BY_HR  = 5;
	 static final int  TYPE        = 0;
	 static final char TYPE_CHAR   = 'H';	
       
3.- CalcultedRateTypeImpl.java 
 Esta clase implementa las interfaces RentalByDay, RentalByWeek, RentalByHour  y que estas interfaces a su vez  implementa la interface CostRentails. Esta �ltima interface obliga a implementar el m�todo �costTypeRange� donde se calcula  la tasa a pagar. El m�todo de esta clase escrito esta clase es inyectado en otra clase descripta posteriormente.

4.- CostRentails.java                 
M�todo  donde  crea o se implementa el c�lculo de la aplicaci�n.  Pero este m�todo es inyectado por constructor en la clase �costTypeRange�. Se inyecta en el m�todo: 
	public int costTypeRange(int numberHrs, int costXhrs ) {		
 		return CalcultedRateTypeImpl.costTypeRangeDynamic( numberHrs, costXhrs);
	}
	


5.- RentalByDay.java, RentalByHour.java , RentalByWeek.java                  
Estas tres (3) son utilizadas para definir el tipo: D�a, Hora y Semana. En ellas definen �nicamente los valores que son usados para el c�lculo del precio final. Finalmente cada una de estas interface a su vez implementa  la interface CostRentails. Esta interface se define el m�todo �costTypeRange�, el cual deber�  ser implementado en la clase que hereda a esta interface. 

6.- ValidationException.java      
Manejo de errores     de excepciones.

7.- ValidationExceptionCode.java     
Definici�n de c�digos errores que maneja la prueba.

  
  
NOTA: Se anexa test JUNIT   
  
********************************************************************/