package javaExp;

import java.text.ParseException;
import java.util.*;

public class Paciente extends Pessoa {

	private Date[] dataVac = new Date[4];
	
	Calendar calendar = new GregorianCalendar();

	public Date getDataVac(int i) {
		return dataVac[i];
	}
	
	public String getDataVacFormat(int dose) {
		return this.formatador.format(dataVac[dose]);
	}

	public void setDataVac(int dose, String dataVac) {
		try {
			this.dataVac[dose] = this.formatador.parse(dataVac);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public boolean valDataVac(int dose, String dataVac, String dataVacAnt) {
		try {
			Date dataAt = this.formatador.parse(dataVac);
			Date dataAnt = this.formatador.parse(dataVacAnt);
			Calendar valCal = new GregorianCalendar();
			calendar.setTime(dataAnt);
			calendar.add(Calendar.MONTH, 4);
			valCal.setTime(dataAt);
			int val = calendar.compareTo(valCal);
			if (val > 0) {
				Date data = calendar.getTime();
				System.out.printf("\n\tCidadão ainda não tem direito à nova dose\n\tretorne em : " + this.formatador.format(data) + "\n");
				return(false);
			}
		return(true);
		
		} catch (Exception e) {
			e.printStackTrace();
			return(true);
		}
	}
}
