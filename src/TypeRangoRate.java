import com.bycle.fdv.CalcultedRateTypeDayImpl;
import com.bycle.fdv.CalcultedRateTypeHrImpl;
import com.bycle.fdv.CalcultedRateTypeWeekImpl;

public class TypeRangoRate {
	
	private CalcultedRateTypeHrImpl calcultedRateTypeHrImpl;
	private CalcultedRateTypeDayImpl calcultedRateTypeDayImpl;
	private CalcultedRateTypeWeekImpl calcultedRateTypeWeekImpl;
	
	private int costos;

	public TypeRangoRate(CalcultedRateTypeHrImpl calcultedRateTypeHrImpl, int costos) {
		this.calcultedRateTypeHrImpl = calcultedRateTypeHrImpl;
		this.costos = costos;
	}
	
	public TypeRangoRate(CalcultedRateTypeDayImpl calcultedRateTypeDayImpl, int costos) {
		this.calcultedRateTypeDayImpl = calcultedRateTypeDayImpl;
		this.costos = costos;
	}	
	
	
	public TypeRangoRate(CalcultedRateTypeWeekImpl calcultedRateTypeWeekImpl, int costos) {
			this.calcultedRateTypeWeekImpl = calcultedRateTypeWeekImpl;
			this.costos = costos;
	}

	public CalcultedRateTypeHrImpl getCalcultedRateTypeHrImpl() {
		return calcultedRateTypeHrImpl;
	}

	public CalcultedRateTypeDayImpl getCalcultedRateTypeDayImpl() {
		return calcultedRateTypeDayImpl;
	}

	public CalcultedRateTypeWeekImpl getCalcultedRateTypeWeekImpl() {
		return calcultedRateTypeWeekImpl;
	}

	public int getCostos() {
		return costos;
	}		
	
 
}
