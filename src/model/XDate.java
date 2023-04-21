/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MY-PC
 */
public class XDate {
    //dùng để chỉnh ngày
    public static  String pattern = "dd/MM/yyyy";
    public static SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    
    public static Object stringToDate(String text) {
        try {
            return sdf.parse(text);
        } catch (ParseException ex) {
            System.out.println("Parse Failed");
        }
        return null;
    }
    public static  String DateToString(Object o) {
        if(o != null){
            Date d =(Date) o;
            return sdf.format(d);
        }
        return "";
    }
}
