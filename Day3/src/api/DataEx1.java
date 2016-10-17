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
		//���� �ý��� ��°��� ��� ��ü ����
		Date now = new Date();
		System.out.println(now);
		
//		System.out.println("�� :"+now.getSeconds());
		//Ư�� ������ ���ڿ��� ��ȯ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 2016-09-28 14:22:01
		String formattedNow = sdf.format(now);
		System.out.println("Ư�� ������ ���ڿ��� ��ȭ:"+formattedNow);
		
		//���ڿ��� Date��ü�� ��ȯ
		String inputDateStr = "2016-09-09"; //  14:22:01";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate = format.parse(inputDateStr);
		System.out.println(inputDateStr+"(���ڿ�)�� Date��ü�� ��ȯ:"+inputDate);
		
		//Ư���Ϸκ����� 100������ ��¥�� ����.
		Calendar c1 = new GregorianCalendar();
		c1.setTime(inputDate);
		c1.add(Calendar.DAY_OF_YEAR, 100); // 100���� ������.
		Date dateAfter100 = c1.getTime();
		System.out.println(inputDateStr+"�� 100�� ���� ��¥�� "+format.format(dateAfter100));
		
		Date birthday = format.parse("1972-02-20");
		long diffMsec = now.getTime() - birthday.getTime(); // ms
		long diffDay = diffMsec / (1000*60*60*24);
		System.out.println(diffDay+" from My Birthday "+birthday);
		
		//�ڹ�8���� �����ϴ� LocalDate�� �̿�
		LocalDate localDate  = LocalDate.now();
		LocalDate futureDate = localDate.plus(100, ChronoUnit.DAYS);
//		System.out.println(futureDate);
		System.out.println(localDate+"�� 100�� �Ĵ� "+futureDate);
		
		long dayDiff = localDate.until(futureDate, ChronoUnit.DAYS);
		System.out.println(futureDate+"�� ������ ��¥ ����(����):" + dayDiff + "��");
		
	}
	
}
