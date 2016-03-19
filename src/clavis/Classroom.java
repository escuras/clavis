/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavis;

/**
 *
 * @author toze
 */
public class Classroom extends Material{
    private int numero;
    private int ncomputadores; 
    private int lugares;
    private boolean projetor;
    
    
    public Classroom(){
        super();
        this.numero = -1;
        this.ncomputadores = -1;
        this.lugares = -1;
        this.projetor = false;
    }
    
    public Classroom(Material m, int numero){
        super(m);
        this.numero = numero;
        this.ncomputadores = -1;
        this.lugares = -1;
        this.projetor = false;
    }
    
    public Classroom(Material m, int numero, int ncomputadores, int lugares, boolean projetor){
        super(m);
        this.numero = numero;
        this.ncomputadores = ncomputadores;
        this.lugares = lugares;
        this.projetor = projetor;
    }

    public Classroom(Classroom classroom){
        super(classroom);
        this.numero = classroom.getNumber();
        this.ncomputadores = classroom.getComputers();
        this.lugares = classroom.getPlaces();
        this.projetor = classroom.hasProjector();
    }
    

    /**
     * @return the numero
     */
    public int getNumber() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumber(int numero) {
        this.numero = numero;
    }

    /**
     * @return the ncomputadores
     */
    public int getComputers() {
        return ncomputadores;
    }

    /**
     * @param ncomputadores the ncomputadores to set
     */
    public void setComputers(int ncomputadores) {
        this.ncomputadores = ncomputadores;
    }

    /**
     * @return the lugares
     */
    public int getPlaces() {
        return lugares;
    }

    /**
     * @param lugares the lugares to set
     */
    public void setPlaces(int lugares) {
        this.lugares = lugares;
    }

    /**
     * @return the projetor
     */
    public boolean hasProjector() {
        return projetor;
    }

    /**
     * @param projetor the projetor to set
     */
    public void addProjector(boolean projetor) {
        this.projetor = projetor;
    }
    
    public boolean hasSpace(int val) {
        return (val >= this.getPlaces());
    }
    
}
