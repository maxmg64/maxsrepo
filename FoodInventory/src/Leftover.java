/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author max
 */
public class Leftover extends FoodItem {
    
    public Leftover(String name) {
        super.name = name;
        super.type = ItemType.LEFTOVER;
        
        calendar.add(Calendar.DATE, 7);
        expdate = new Daycode(calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.YEAR));
        calendar.add(Calendar.DATE, -7);
    }
}