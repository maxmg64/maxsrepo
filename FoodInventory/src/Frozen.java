/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author max
 */
public class Frozen extends FoodItem {
    
    public Frozen(int month, int day, int year, String name) {
        super.name = name;
        super.type = ItemType.FROZEN;
        expdate = new Daycode(month, day, year);
    }
}