package br.com.medaula.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

public class Util {
	

	public static Integer getIdade(Date data) {

		GregorianCalendar hj = new GregorianCalendar();
		GregorianCalendar nascimento = new GregorianCalendar();
		if (data != null) {
			nascimento.setTime(data);

			int anohj = hj.get(Calendar.YEAR);
			int anoNascimento = nascimento.get(Calendar.YEAR);
			return new Integer(anohj - anoNascimento);
		}

		return null;
	}
	
	
	public static String  StringToMD5(String texto) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(texto.getBytes(),0, texto.getBytes().length);
		return new BigInteger(1,md.digest()).toString(16);
	}
	
	
	
	public static String getUrlAplicacao(HttpServletRequest request){
		StringBuilder sb = new StringBuilder()
		.append(request.getScheme()).append("://")
		.append(request.getServerName())
		.append(request.getServerPort() == 80 ? "" : ":"+request.getServerPort())
		.append(request.getContextPath());
		
		return sb.toString();
	}
	
	public static Date parseDate(String date, String format) {
	     try {
	         return new SimpleDateFormat(format).parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
}
