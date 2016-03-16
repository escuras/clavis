/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavicela;


import org.joda.time.DateTime;
/**
 *
 * @author toze
 */
public class Time {
     
    private int hora;
    private int minutos;
    private int segundos;

    public Time(int hora, int minutos, int segundos)
    {
        if ((hora >= 0 )&&(hora <= 23)) 
        {
            if ((minutos >= 0)&&(minutos <= 59)&&(segundos >= 0)&&(segundos <= 59)) 
            {
                this.hora = hora;
                this.minutos = minutos;
                this.segundos = segundos;
            } 
            else 
            {
                this.hora = -1;
                this.minutos = -1;
                this.segundos = -1;
            }
        } 
        else 
        {
            this.hora = -1;
            this.minutos = -1;
            this.segundos = -1;
        }
    }
    
    public Time(){
        DateTime tmr = new DateTime();
        this.hora = tmr.getHourOfDay();
        this.minutos = tmr.getMinuteOfHour();
        this.segundos = tmr.getSecondOfMinute();
    }
    
    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        if ((hora >= 0 )&&(hora <= 23)) this.hora = hora;
    }

    /**
     * @return the minutos
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * @param minutos the minutos to set
     */
    public void setMinutos(int minutos) {
        if ((minutos >= 0)&&(minutos <= 59)) this.minutos = minutos;
    }

    /**
     * @return the segundos
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * @param segundos the segundos to set
     */
    public void setSegundos(int segundos) {
        if ((segundos >= 0)&&(segundos <= 59)) this.segundos = segundos;
    }
    
    @Override
    public String toString(){
        String shora;
        String sminutos;
        String ssegundos;
        if (this.hora < 10) shora = "0"+this.hora;
        else shora = ""+this.hora;
        if (this.minutos < 10) sminutos = "0"+this.minutos;
        else sminutos = ""+this.minutos;
        if (this.segundos < 10) ssegundos = "0"+this.segundos; 
        else ssegundos = ""+this.segundos;
        return shora+":"+sminutos+":"+ssegundos;
    }
    
    public int compareTime(Time time)
    {
        // valor maximo 86399, pois o dia tem 86400. Com -100000 serve para indicar erro na validação. Com 0 as horas são iguais. 
        if (!time.isValid()) return -100000;
        if ((hora > 23)||(hora < 0)||(minutos > 59)||(minutos < 0)||(segundos < 0)||(segundos > 59)) return -100000;
        return ((time.getHora()-this.getHora())*3600) + ((time.getMinutos()-this.getMinutos())*60) + (time.getSegundos()-this.getSegundos());
    }
    
    public int compareTime(int hora, int minutos, int segundos)
    {
        if ((hora > 23)||(hora < 0)||(minutos > 59)||(minutos < 0)||(segundos < 0)||(segundos > 59)) return -100000;
        Time time = new Time(hora,minutos,segundos);
        return ((time.getHora()-this.getHora())*3600) + ((time.getMinutos()-this.getMinutos())*60) + (time.getSegundos()-this.getSegundos());
    }
    
    public boolean isValid()
    {
        return ((this.hora != -1)&&(this.minutos != -1)&&(this.segundos != -1));
    }
}
