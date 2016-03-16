/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavicela;

/**
 *
 * @author toze
 */
public class Clavicela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date dat = new Date();
        System.out.println(dat.toString(":"));
        System.out.println(dat.getDiasDoAno());
        System.out.println(dat.getSemanasDoAno());
        System.out.println(dat.dateAfter(0));
        System.out.println(dat.bisexto(2016));
        Time time =new Time();
        System.out.println(time.toString());
        Time time1 = new Time(23,59,59);
        Time time2 = new Time(0,0,0);
        System.out.println(time1.compareTime(0,0,0));
        System.out.println(dat.betweenDates(new Date(5,2,2016), new Date(1,1,2017)));
    }
    
}
