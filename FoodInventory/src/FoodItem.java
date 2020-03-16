/**
 * food item object that the other items inheret from
 * could possibly be abstract
 */

/**
 * @author maxmg
 *
 */

import java.util.*;

public abstract class FoodItem {
	
	
    protected Calendar calendar;
    protected Daycode expdate;
    protected Daycode dateadded;
    protected String name;
    protected ItemType type;
    private long barcode;
    
    public FoodItem() {
        calendar = Calendar.getInstance();
        //this.name = name;
        //place in each constructor
        //expdate = new Daycode(month, day, year);
        dateadded = new Daycode(calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.YEAR));
        
        
    }
    
    public String getName() {return name;}
    
    public Daycode getDaycode() {return expdate;}
    
    public Daycode getDateAdded() {return dateadded;}
    
    public ItemType getItemType() {return type;}
    
    public String toString() {
    	return name;
    }
}

