package tesouro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws ParseException {
		
		String date1, date2;
		
		Scanner leia = new Scanner(System.in);
		
		date1 = leia.nextLine();
		date2 = leia.nextLine();
		
		Date d1 = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
		Date d2 = new SimpleDateFormat("dd-MM-yyyy").parse(date2);
		
		long diff = Math.abs(d1.getTime() - d2.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		System.out.println(diffDays);

	}

}
