/**
 *
 *sup this is the object that keeps track of all the items
 *
 */

import java.util.*;
/**
 *
 * @author max
 * @version 0.1
 */
public class FoodLogger {
    
    private Map<String, FoodItem> listofItems;
    private Calendar calendar;
    private static int NUMBER_OF_ITEMS;
    private int[] DAYS_IN_MONTH;
    //private static final String path = "list_of_fooditems.txt";
    
    FoodLogger() {
        listofItems = new HashMap<>();
        calendar = Calendar.getInstance();
        
        //maybe combine these
        
        DAYS_IN_MONTH = new int[12];
        DAYS_IN_MONTH[0] = 31;
        DAYS_IN_MONTH[1] = calendar.getActualMaximum(Calendar.DAY_OF_YEAR)-337;
        DAYS_IN_MONTH[2] = 31;
        DAYS_IN_MONTH[3] = 30;
        DAYS_IN_MONTH[4] = 31;
        DAYS_IN_MONTH[5] = 30;
        DAYS_IN_MONTH[6] = 31;
        DAYS_IN_MONTH[7] = 31;
        DAYS_IN_MONTH[8] = 30;
        DAYS_IN_MONTH[9] = 31;
        DAYS_IN_MONTH[10] = 30;
        DAYS_IN_MONTH[11] = 31;
        
        
        
        //{31,calendar.getActualMaximum(Calendar.DAY_OF_YEAR)-337,31,30,31,30,31,31,30,31,30,31};
    }
    //should add true false thing if item already exists
    /**
     * this method creates a new food item 
     * 
     * @param month expiration month
     * @param day   expiration day
     * @param year	expiration year
     * @param name	the name of the item of sustanents
     * @return true if created or false if already exists
     */
    public boolean createItem(int month, int day, int year, String name) {
    	if(listofItems.containsKey(name)) {return false;}
        listofItems.put(name, new Bought(month, day, year, name));
        NUMBER_OF_ITEMS++;
        return true;
    }
    /**
     * creates leftover item with exp of 7 days
     * 
     * @param name name of the item(at this point no duplicates)
     * @return true if created false if already exists
     */
    public boolean createleftoverItem(String name) {
    	if(listofItems.containsKey(name)) {return false;}
        listofItems.put(name, new Leftover(name));
        NUMBER_OF_ITEMS++;
        return true;
    }
    /**
     * creates a new frozen item
     * 
     * @param month expiration month
     * @param day   expiration day
     * @param year	epiration year
     * @param name	the name of the item of sustanents
     * @return true if created false if already exists
     */
    public boolean createFrozenItem(int month, int day, int year, String name) {
    	if(listofItems.containsKey(name)) {return false;}
    	listofItems.put(name, new Frozen(month, day, year, name));
    	NUMBER_OF_ITEMS++;
    	return true;
    }
    /**
     * 
     * @param  name the name of the item to remove
     * @return true if removed succesfully false if item not found
     */
    public boolean removeItem(String name) {
    	if(listofItems.containsKey(name)) {
    		listofItems.remove(name);
    		NUMBER_OF_ITEMS--;
    		return true;
    	}
    	return false;
    }
    //hey max instead of doing it like this have a fuild in Fooditem that has # of days expired. also have some static variable to keep track of the last time it was updated so it will
    //update when cirtain commands are issued or if you find a way have it update at midnight
    /**
     * 
     * @param name item you what get get days expired from
     * @return days expired -means days till expiration
     */
    public int daysExpired(String name) {
    	
    	int yearoffset = 0;
    	//also find way to get # of years till leap. have it loop through that to add
    	//while loop unitill i == 0 or something like that
    	
        if(listofItems.containsKey(name)) {
            FoodItem temp = listofItems.get(name);
            //if(calendar.get(Calendar.YEAR) != temp.getDaycode().getYear()) {calendar.get(Calendar.YEAR) - temp.getDaycode().getYear()};
            
            return calendar.get(Calendar.DAY_OF_YEAR) - 
            		dayofYear(temp.getDaycode().getMonth(), temp.getDaycode().getDay());
        }
        return 0;
    }
    /**
     * private function for calculating the day of year
     * 
     * @param month
     * @param day
     * @return returns the day of year
     */
    private int dayofYear(int month, int day) {
    	int dayofyear = 0;
    	for(int i = 0;i < month-1; i++) {
    		dayofyear += DAYS_IN_MONTH[i];
    	}
    	return dayofyear+day;
    }
    //check if .get returns null if key not found if so remove this if statement
    /**
     *return the item as a food item. returns null if not found 
     * 
     * @param name
     * @return 
     */
    public FoodItem getItem(String name) {
        if(listofItems.containsKey(name)) {
            return listofItems.get(name);
        }
        return null;
    }
    /**
     * 
     * @param name
     * @return true if item exists in the list false if not
     */
    public boolean containsItem(String name) {
    	return listofItems.containsKey(name);
    }
    //add some error checks
    /**
     * 
     * @return an array containing all of the food items
     */
    public FoodItem[] getAllItems() {
    	FoodItem[] list = new FoodItem[NUMBER_OF_ITEMS];
    	int index = 0;
    	for(Map.Entry<String, FoodItem> item : listofItems.entrySet()) {
    		list[index] = item.getValue();
    		index++;
    	}
    	return list;
    }
    /**
     *   
     * @return NUMBER_OF_ITEMS number of items currently in the list
     */
    public static int size() {return NUMBER_OF_ITEMS;}
    /**
     * clears the list
     */
    public void clear() {
        listofItems.clear();
        NUMBER_OF_ITEMS = 0;
    }
}
