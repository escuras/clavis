/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavis;

import TimeDate.WeekDay;
import TimeDate.Time;
import TimeDate.Date;
import CSV.ElementsCSV;
import CSV.HandlingCSV;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
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
        System.out.println(time.toString(1));
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
        Function fun = new Function(1,"Professor");
        fun.setLocale("fr.FR");
        System.out.println(fun.getFuncao());
        HandlingCSV han = new HandlingCSV("http://localhost:8080/horario_disciplinas.csv");
        han.searchElements();
        List<ElementsCSV> elementos = han.getElements();
        elementos.stream().forEach((el) -> {
            System.out.println(el.getByElement(0));
        });
        TypeOfMaterial sala = new TypeOfMaterial(1, "sala");
        Material m = new Material(sala,2,"sala 1", "sala localizada em ...");
        Classroom sala1 = new Classroom(m,1,50,80,true);
        System.out.println(sala.toString());
        System.out.println(sala1.toString());
        langs.Locale cla = new langs.Locale();
        cla.setLocale("en.EN");
        System.out.println(cla.translate("Professor"));
        java.util.List<String> lista = cla.getlist(3);
        lista.stream().forEach((g) -> {
            System.out.println(g);
        });
   
        //System.out.println(sala1.hasSpace(79));
        /*
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();;
       
        File inputFile = new File("lang/portuguese.xml");
        Document doc = (Document) dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();*/
        //File input = new File("src.langs.dddd");
        //if (!input.exists()) input.createNewFile();
        
        DataBase.DataBase.connect();
    }
    
}
