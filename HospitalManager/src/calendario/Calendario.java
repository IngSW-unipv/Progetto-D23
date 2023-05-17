package calendario;
import java.util.Calendar;

public class Calendario {
	public static void main(String[] args) {  
	      // create a calendar object mycalobj  
	      Calendar mycalendar =  Calendar.getInstance();  
	      System.out.println("Today  :" + mycalendar.getTime());  
	      
	      mycalendar.set(Calendar.YEAR , 1996);  
	      System.out.println(" Altered Date(1) :" + mycalendar.getTime()); 
	      
	      mycalendar.set  (1996 , 9 , 23);  
	      System.out.println(" Altered Date (2) :" + mycalendar.getTime());  
	     }  
}
