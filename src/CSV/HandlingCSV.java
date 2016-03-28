/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author toze
 */
public class HandlingCSV {
    private final List<ElementsCSV> elementos;
    private String url;
    private boolean novo;
    int i = 0;
    
    public HandlingCSV(){
        this.url = null;
        elementos = new ArrayList<>();
        novo = false; 
    }
    
    public HandlingCSV(String url){
        this.url = url;
        elementos = new ArrayList<>();
        novo = false;
    }
    
   
    
    public void searchElements()
    {
        CSVReader reader;
        List<String[]> entradas = new ArrayList<>();
        try {           
            try { 
                if ((this.url == null)||(!this.verifyConnectUrl())) {
                    File file = new File("download"+System.getProperty("file.separator")+"horario_disciplinas.csv");
                    if (!file.exists()) 
                    { 
                        File diretoria = new File("download");
                        diretoria.mkdir();
                        file.createNewFile();
                    } 
                    InputStream input = new FileInputStream(file);
                    InputStreamReader r = new InputStreamReader(new FileInputStream(file));
                    reader = new CSVReader(new InputStreamReader(input,r.getEncoding()),';');
                    if (reader.verifyReader()) 
                    {
                        entradas = reader.readAll();
                    }
                } else {
                    InputStream input;
                    try { 
                        input = new URL(url).openStream();
                        reader = new CSVReader(new InputStreamReader(input),';');
                        if (reader.verifyReader()) 
                        {
                            entradas = reader.readAll();
                            File file = new File("download"+System.getProperty("file.separator")+"horario_disciplinas.csv");
                            if (!file.exists()) 
                            { 
                                File diretoria = new File("download");
                                diretoria.mkdir();
                                file.createNewFile();
                                novo = true;
                                try (CSVWriter scv = new CSVWriter(new FileWriter(file),';')) {
                                    scv.writeAll(entradas);
                                    scv.flush();
                                }
                            } else {
                                File file2 = new File("horario_disciplinas.csv");
                                try (CSVWriter scv = new CSVWriter(new FileWriter(file2),';')) {
                                    
                                    scv.writeAll(entradas);
                                    scv.flush();
                                }
                                if (FileUtils.contentEquals(file, file2)) {
                                    file2.delete();
                                } else {
                                    try (CSVWriter scv = new CSVWriter(new FileWriter(file),';')) {
                                        file2.delete();
                                        scv.writeAll(entradas);
                                        scv.flush();
                                    novo = true;
                                    }
                                }
                            }
                        }
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(HandlingCSV.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(HandlingCSV.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }        
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(HandlingCSV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HandlingCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
        }
        if (!entradas.isEmpty()) {
            ElementsCSV elemento;
            for (int i=1; entradas.size() > i; i++) {
                if (entradas.get(i).length >= 16) {
                    elemento = new ElementsCSV(Integer.valueOf(entradas.get(i)[3]),Integer.valueOf(entradas.get(i)[4]),Integer.valueOf(entradas.get(i)[6]),Integer.valueOf(entradas.get(i)[5]),Integer.valueOf(entradas.get(i)[7]),entradas.get(i)[10], entradas.get(i)[12],entradas.get(i)[14],entradas.get(i)[13],entradas.get(i)[11],entradas.get(i)[15]);
                    elementos.add(elemento);
                }
            }
        }
        
        // tratamento para elementos contíguos,no entanto, apurados como separados
        
        if (!elementos.isEmpty()) {
            for (int i=0; i<elementos.size(); i++) {
                for (int j=0;j<elementos.size();j++){
                    if (elementos.get(i).getCdClassRoom().equals(elementos.get(j).getCdClassRoom())) {
                        if (elementos.get(i).getCdSubject().equals(elementos.get(j).getCdSubject())) {
                            if (elementos.get(i).getCdTeacher().equals(elementos.get(i).getCdTeacher())) {
                                if (elementos.get(i).getDayWeek() == elementos.get(j).getDayWeek()){
                                    if (elementos.get(i).getHourEnd() == elementos.get(j).getHourIni()) {
                                        if (elementos.get(i).getMinuteEnd() == elementos.get(j).getMinuteIni()){
                                            elementos.get(i).setHourEnd(elementos.get(j).getHourEnd());
                                            elementos.get(i).setMinuteEnd(elementos.get(j).getMinuteEnd());
                                            elementos.remove(j);
                                            i=0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    
    public boolean verifyConnectUrl()
    {
        HttpURLConnection connection = null;
        try 
        {
            URL u = new URL(this.url);
            connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("HEAD");
            int code = connection.getResponseCode();
            return true;
        } 
        catch (MalformedURLException e) 
        {
            return false;
        } 
        catch (IOException e) 
        {
            return false;
        } 
        finally 
        {
            if (connection != null) 
            {
                connection.disconnect();
            }
        }
    }
    
    
    public List<ElementsCSV> getElements() 
    {
        return elementos;
    }
    
    public boolean isEmpty()
    {
        if (elementos == null) return true;
        else return elementos.isEmpty();
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    public boolean isNew(){
        return novo;
    }
    
    
    
}
