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

/**
 *
 * @author toze
 */
public final class HandlingCSV {
    private List<ElementsCSV> elementos;
    private String url;
    private int data;
    
    public HandlingCSV(){
        this.url = null;
        elementos = new ArrayList();
    }
    
    public HandlingCSV(String url){
        this.url = url;
        elementos = new ArrayList();
    }
    
    public HandlingCSV(HandlingCSV trata){
        this.url = trata.getUrl();
        elementos = trata.getElements();
    }
    
    private void searchElements()
    {
        CSVReader reader;
        List<String[]> entradas = new ArrayList();
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
                        reader = new CSVReader(new InputStreamReader(input,"ISO-8859-1"),';');
                        if (reader.verifyReader()) 
                        {
                            entradas = reader.readAll();
                            File file = new File("download"+System.getProperty("file.separator")+"horario_disciplinas.csv");
                            if (!file.exists()) 
                            { 
                                File diretoria = new File("download");
                                diretoria.mkdir();
                                file.createNewFile();
                            }
                            try (CSVWriter scv = new CSVWriter(new FileWriter(new File("download/horario_disciplinas.csv")),';')) {
                                scv.writeAll(entradas);
                                scv.flush();
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
                if (entradas.size() >= 14) {
                    elemento = new ElementsCSV(Integer.valueOf(entradas.get(i)[3]),Integer.valueOf(entradas.get(i)[4]),Integer.valueOf(entradas.get(i)[6]),Integer.valueOf(entradas.get(i)[5]),Integer.valueOf(entradas.get(i)[7]),entradas.get(i)[10], entradas.get(i)[12],entradas.get(i)[14],entradas.get(i)[13],entradas.get(i)[11],entradas.get(i)[15]);
                    elementos.add(elemento);
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
            System.out.println("" + code);
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
        this.searchElements();
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
    
    
    
}
