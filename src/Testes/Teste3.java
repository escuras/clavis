/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import TimeDate.Date;
import TimeDate.WeekDay;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toze
 */
public class Teste3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date dat = new Date(17,2,2016);
        Date dat2 = new Date(28,2,2016);
        try {
            WeekDay day = new WeekDay(dat);
            System.out.println(day.toString());
        } catch (ParseException ex) {
            Logger.getLogger(Teste3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(Date.numberOfDaysBetweenDates(dat, dat2));
        List<Date> datas = Date.DatesBetweenDates(dat, dat2, 3);
        for (Date date : datas){
            System.out.println(date.toString());
        }
    }
    
}
