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
public class Date {
    private int dia;
    private int mes;
    private int ano;
    private int diasdoano;
    private int semanasdoano;
    
    public Date()
    {
        DateTime datr = new DateTime();
        ano = datr.getYear();
        mes = datr.getMonthOfYear();
        dia = datr.getDayOfMonth();
        diasdoano = datr.getDayOfYear();
        semanasdoano = datr.getWeekyear();
    }
    
    public Date(int dia, int mes, int ano)
    {
        if ((mes <=12)&&(mes > 0)) 
        {
            if (validaDiasMes(dia,mes,ano)) 
            {
                this.mes = mes; 
                this.ano = ano; 
                this.dia = dia;
                this.diasdoano =this.daysOfTheYear();
                this.semanasdoano = this.weeksOfTheYear();
            }
            else 
            {
                this.mes = -1; 
                this.dia = -1; 
                this.ano = -1;
                this.diasdoano = -1;
                this.semanasdoano = -1;
            }
            
        } 
        else 
        {
            this.dia = -1;
            this.mes = -1;
            this.ano = -1;
            this.diasdoano = -1;
            this.semanasdoano = -1;
        }
    }
    
    
    private boolean validaDiasMes(int dia, int mes, int ano){
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return (dia <= 31)&&(dia > 0);
            case 4: case 6: case 9: case 11:
                return (dia <=30)&&(dia > 0);
            case 2:
                if (bisexto(ano)) return (dia <= 29)&&(dia > 0);
                else return (dia <=28)&&(dia > 0);
            default:
                return false;
        }
    }
    
    public boolean bisexto(int ano){
        return (ano % 4 == 0) && ( (ano % 100 != 0) || (ano % 400 == 0) ); 
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        if ((mes <=12)&&(mes > 0)) this.mes = mes;
    }

      /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }
    
    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        if (validaDiasMes(dia,mes,ano)) this.dia = dia;
        else this.dia = 0;
    }
    
    public String toString(){
        String sdia;
        if (dia < 10) sdia = "0"+this.dia;
        else sdia = ""+this.dia;
        String smes;
        if (mes < 10) smes = "0"+this.mes;
        else smes = ""+this.mes;
        String sano;
        if (ano < 10) sano = "000"+this.ano;
        else if (ano < 100) sano = "00"+this.ano;
        else if (ano < 1000) sano = "0"+this.ano;
        else sano = ""+this.ano;
        return sdia+"/"+smes+"/"+sano;
    }
    
    public String toString(String simbolo){
        String sdia;
        if (dia < 10) sdia = "0"+this.dia;
        else sdia = ""+this.dia;
        String smes;
        if (mes < 10) smes = "0"+this.mes;
        else smes = ""+this.mes;
        String sano;
        if (ano < 10) sano = "000"+this.ano;
        else if (ano < 100) sano = "00"+this.ano;
        else if (ano < 1000) sano = "0"+this.ano;
        else sano = ""+this.ano;
        return sdia+simbolo+smes+simbolo+sano;
    }
    
    
    public boolean betweenDates(Date date, Date date2)
    {
        if (date.getAno() > date2.getAno()) 
        {
            Date aux = date2;
            date2 = date;
            date = aux;
        } 
        else if (date.getAno() == date2.getAno())
        {
            if (date.daysOfTheYear() > date2.daysOfTheYear()) 
            {
                Date aux = date2;
                date2 = date;
                date = aux;
            }
        }
        if ((date.getAno() < this.ano)&&(this.ano < date2.getAno())) 
        {
            return true;
        } 
        else if ((date.getAno() <= this.ano)&&(this.ano < date2.getAno())) 
        {
            if (date.getMes() < this.mes) return true;
            else if (date.getMes() == this.mes) 
            {
                return date.getDia() <= this.dia;
            }
            else return false;
        }
        else if((date.getAno() < this.ano)&&(this.ano <= date2.getAno()))
        {
            if (date2.getMes() > this.mes) return true;
            else if (date2.getMes() == this.mes) 
            {
                return date2.getDia() >= this.dia;
            }
            else return false;
        }
        else if((date.getAno() == this.ano)&&(this.ano == date2.getAno()))
        {
            if ((date.getMes() < this.mes)&&( this.mes < date2.getMes())) return true;
            else if ((date.getMes() == this.mes)&&(this.mes < date2.getMes())) 
            {
                return date.getDia() <= this.dia;
            }
            else if ((date.getMes() < this.mes)&&(this.mes == date2.getMes())) 
            {
                return date2.getDia() >= this.dia;
            }
            else if ((date.getMes() == this.mes)&&(this.mes == date2.getMes())) 
            {
                return (date.getDia() <= this.dia)&&(this.dia <= date2.getDia());
            }
            else return false;
        }
        else 
        {
            return false;
        } 
    }
    
    public Date dateAfter(int dias)
    {
        int year = this.ano;
        int month = this.mes;
        int day = this.dia;
        if (dias > 0) 
        {
            if ((this.dia + dias)>(this.daysOfTheMonth(this.mes, this.ano)))
            {
                int [] meses = {0,31,28,31,30,31,30,31,31,30,31,30,31};
                int dauxiliar = this.daysOfTheYear() + dias;
                int anoauxiliar;
                if (this.bisexto(this.ano)) anoauxiliar = 366;
                else anoauxiliar = 365;
                int i = 1;
                while (dauxiliar > anoauxiliar)
                {
                    if (this.bisexto(year)) 
                    {
                        if (dauxiliar > 366) {
                            dauxiliar -= 366; 
                            year = this.ano + i;
                            i++;
                        } else {
                            
                        }
                    }
                    else 
                    {
                        if (dauxiliar > 365) {
                            dauxiliar -= 365; 
                            year = this.ano + i;
                            i++;
                        }
                    } 
                    if (this.bisexto(this.ano + i )) anoauxiliar = 366;
                    else anoauxiliar = 365;
                }
                if (this.bisexto(year)) {
                    meses[2] = 29;
                }
                for (int j=1; j<13 ; j++){
                    if (dauxiliar > meses[j]) {
                        dauxiliar -= meses[j];
                        System.out.println(j+" Meses"+ meses[j]);
                        System.out.println("dias: "+dauxiliar);
                        month = j+1;
                    } 
                    else {
                      day = dauxiliar;
                      break;
                    }
                }
                return new Date(day,month,year);
            }   
            else 
            {
            return new Date(this.dia+dias,this.mes,this.ano);
            } 
            
        }
        else 
        {
            return new Date(this.dia,this.mes,this.ano);
        }
        
    }
    
    private int daysOfTheYear()
    {
        int i = 1;
        int conta = 0;
        while (i < this.mes) 
        {
            conta += this.daysOfTheMonth(i, this.ano);
            i++;
        }
        conta += this.dia;
        return conta;
    }
    
    private int daysOfTheMonth(int mes, int ano)
    {
        if ((mes > 0)&&(mes < 13)) 
        {
            int [] meses = {0,31,28,31,30,31,30,31,31,30,31,30,31};
            if (!this.bisexto(ano)) return meses[mes];
            else 
            {
                meses[2] = 29;
                return meses[mes];
            }
        }
        else 
        {
            return 0;
        }
    } 
    
    private int weeksOfTheYear()
    {
        int dias = this.daysOfTheYear();
        int conta = 1;
        while (dias > 7) {
            dias -= 7;
            conta++;
        }
        return conta;
    }
    
    public int getSemanasDoAno()
    {
        return this.semanasdoano;
    }
    
    public int getDiasDoAno()
    {
        return this.diasdoano;
    }
}
