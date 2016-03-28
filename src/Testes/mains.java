/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

/**
 *
 * @author toze
 */
public class mains {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TimeDate.Date tempo = new TimeDate.Date();
        System.out.println(tempo.toString());
        TimeDate.Date tempo2 = tempo.dateAfter(30745);
        System.out.println(tempo2.toString());
    }
    
}
