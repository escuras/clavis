/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Component;

/**
 *
 * @author toze
 */
public class Element {
    private double factorX;
    private double factorY;
    private Component com;
    private double largura;
    private double altura;
    private boolean sit;
    
    public Element(){
        this.com = null;
        this.factorX = 0.0;
        this.factorY = 0.0;
        this.largura= 0;
        this.altura = 0;
        this.sit =  true;
    }
    
    public Element(Component com, double factorX, double factorY, boolean sit){
        this.com = com;
        this.factorX = factorX;
        this.factorY = factorY;
        this.largura = com.getWidth();
        this.altura = com.getHeight();
        this.sit = sit;
    }
    
    public void putBounds(double largura_,double altura_){
        int x = com.getX();
        int y = com.getY();
        int lfinal = (int)((largura_/factorX)*this.largura);
        int afinal = (int)((altura_/this.factorY)*this.altura); 
        this.com.setBounds(new java.awt.Rectangle(x,y,lfinal,afinal));
    }
    
}
