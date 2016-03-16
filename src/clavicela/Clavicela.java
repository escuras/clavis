/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavicela;

import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author toze
 */
public class Clavicela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, ParserConfigurationException, SAXException, IOException {
        Date dat = new Date(7,5,2018);
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
        WeekDay day = new WeekDay(dat);
        day.setLocale("fr.FR");
        System.out.println(day.toString());
        WeekDay diaa = new WeekDay(1);
        //diaa.setLocale("fr.FR");
        System.out.println(diaa.toString());
        /*
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();;
       
        File inputFile = new File("lang/portuguese.xml");
        Document doc = (Document) dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();*/
        
    }
    
}
