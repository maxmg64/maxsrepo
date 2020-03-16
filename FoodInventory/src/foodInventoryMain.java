/**
 * 
 * @author maxmg
 *some bs law stuff goes here
 */

import java.util.*;

public class foodInventoryMain {
	/**
	 * 
	 * @param args String[] this remains unused for now
	 * @return				no return this is main trying out java docs
	 */
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		//Daycode day = new Daycode(calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.YEAR));
		
		//System.out.println(day.getString());
		long start = calendar.getTimeInMillis();
		
		FoodLogger log = new FoodLogger();
		
		log.createItem(3, 5, 2020, "ham");
		System.out.println("name: " + log.getItem("ham").getName());
		System.out.println("type: " + log.getItem("ham").getItemType());
		System.out.println("date added: " + log.getItem("ham").getDateAdded());
		System.out.println("daycode: " + log.getItem("ham").getDaycode());
		System.out.println("days expired: " + log.daysExpired("ham"));
		
		System.out.println();
		
		log.createFrozenItem(5, 6, 2020, "pizza");
		System.out.println("name: " + log.getItem("pizza").getName());
		System.out.println("type: " + log.getItem("pizza").getItemType());
		System.out.println("date added: " + log.getItem("pizza").getDateAdded());
		System.out.println("daycode: " + log.getItem("pizza").getDaycode());
		System.out.println("days expired: " + log.daysExpired("pizza"));
		
		System.out.println();
		
		System.out.println("contains pie:" + log.containsItem("pie"));
		System.out.println("contains pizza: " + log.containsItem("pizza"));
		
		System.out.println();
		
		System.out.println("pizza removed: " + log.removeItem("pizza"));
		
		System.out.println();
		
		
		log.createleftoverItem("posta");
		log.createItem(4, 1, 2020, "canned beans");
		log.createFrozenItem(1, 1, 2020, "muffins");
		
		System.out.println("Size is " + FoodLogger.size());
		System.out.println("list of all items and days expired");
		
		FoodItem[] listofItems = log.getAllItems();
		for(FoodItem i : listofItems) {
			System.out.println(i.getName() + "\t" + log.daysExpired(i.getName()));
		}
		calendar = Calendar.getInstance();
		long end = calendar.getTimeInMillis();
		
		System.out.println();
		System.out.println("Execution Time: " + (end - start));

	}
	
}
