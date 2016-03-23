/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JMenu;

/**
 *
 * @author toze
 */
public class ItemMenu extends JMenu {
    
    private Color bg;
    private Color fg;
    
    public ItemMenu (){
        this.bg = Color.BLACK;
        this.fg = Color.WHITE;
    }
    
    public ItemMenu(Color bg, Color fg){
        this.bg = bg;
        this.fg = fg;
    }
    
    public void setFontColor(Color fg) {
        this.setFontColor(fg);
    }
    
    public void setBackgroundColor(Color bg) {
        this.bg = bg;
    }
    
}
