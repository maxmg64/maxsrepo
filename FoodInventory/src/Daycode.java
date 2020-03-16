/**
 * this object stores the Daycode numerical value
 * has some other checks throws exception if
 * bad input
 */

/**
 * @author maxmg
 * 
 */

import java.util.Calendar;

public class Daycode {
   /**
    * fuilds
    * n
    */
   private int day;
   private int month;
   private int year;
   private int dayofyear;
   private Calendar calendar;
   //constructor
   public Daycode(int month, int day, int year) {
       //calendar = Calendar.getInstance();
       if(month > 12) {
         throw new IllegalArgumentException("I call a power battle on this bitch");
      }
       
      //Calendar calendar = Calendar.getInstance();
      /*
      int[] dayspermonth = {31,calendar.getActualMaximum(Calendar.DAY_OF_YEAR)-337,31,30,31,30,31,31,30,31,30,31};
      
      if(day > dayspermonth[month-1]) {
         throw new IllegalArgumentException("that's too big braaaaa");
      }
      */
      this.day = day;
      this.month = month;
      this.year = year;
      /*
      int a = 0;
      for(int i =0;i < month-1;i++) {
          a += dayspermonth[i];
          
      }
      dayofyear = a + day;
    */  
   }
   
   public int getDayOfYear() {
       return dayofyear;
   }
   //returns dos feilds
   public int getDay() {
      return day;
   }
   
   public int getMonth() {
      return month;
   }
   
   public int getYear() {
      return year;
   }
   //returns strings boi
   public String getStringeu() {
      return Integer.toString(day) + '/' + Integer.toString(month) + '/' + Integer.toString(year);
   }
   
   public String getString() {
      return Integer.toString(month) + '/' + Integer.toString(day) + '/' + Integer.toString(year);
   }
   
   public String toString() {
	   return getString();
   }
}
