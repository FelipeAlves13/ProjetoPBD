package br.com.complemento;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public abstract  class Formatos {
	private static SimpleDateFormat dataFormat  =new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat dataOutroFormat = new SimpleDateFormat("dd-MM-yyyy");
	private static SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
	private static SimpleDateFormat outraHora = new SimpleDateFormat("hh:mm:ss");
	private static DecimalFormat df = new DecimalFormat(" .00");
	
	
	public static SimpleDateFormat getDataFormat() {
		return dataFormat;
	}
	
	public static SimpleDateFormat getHoraFormat() {
		return horaFormat;
	}

	public static SimpleDateFormat getDataOutroFormat() {
		return dataOutroFormat;
	}
	
	public  static LocalTime converterLocalTime(long lg) {
		Instant instant = Instant.ofEpochMilli(lg);
	    LocalTime localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
	    return localDate;
	}

	public static DecimalFormat getDf() {
		return df;
	}

	public static SimpleDateFormat getOutraHora() {
		return outraHora;
	}

	
	
	
	
}
