package api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataEx1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		//현재 시스템 출력값을 담는 객체 생성
		Date now = new Date();
		System.out.println(now);
		
//		System.out.println("초 :"+now.getSeconds());
		//특정 포맷의 문자열로 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 2016-09-28 14:22:01
		String formattedNow = sdf.format(now);
		System.out.println("특정 포맷의 문자열로 변화:"+formattedNow);
		
		//문자열을 Date객체로 변환
		String inputDateStr = "2016-09-09"; //  14:22:01";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate = format.parse(inputDateStr);
		System.out.println(inputDateStr+"(문자열)을 Date객체로 변환:"+inputDate);
		
		//특정일로부터의 100일후의 날짜를 구함.
		Calendar c1 = new GregorianCalendar();
		c1.setTime(inputDate);
		c1.add(Calendar.DAY_OF_YEAR, 100); // 100일이 더해짐.
		Date dateAfter100 = c1.getTime();
		System.out.println(inputDateStr+"의 100일 후의 날짜는 "+format.format(dateAfter100));
		
		Date birthday = format.parse("1972-02-20");
		long diffMsec = now.getTime() - birthday.getTime(); // ms
		long diffDay = diffMsec / (1000*60*60*24);
		System.out.println(diffDay+" from My Birthday "+birthday);
		
		//자바8에서 제공하는 LocalDate를 이용
		LocalDate localDate  = LocalDate.now();
		LocalDate futureDate = localDate.plus(100, ChronoUnit.DAYS);
//		System.out.println(futureDate);
		System.out.println(localDate+"의 100일 후는 "+futureDate);
		
		long dayDiff = localDate.until(futureDate, ChronoUnit.DAYS);
		System.out.println(futureDate+"와 오늘의 날짜 간격(차이):" + dayDiff + "일");
		
	}
	
}
