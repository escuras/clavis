package clavicela;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author toze
 */
public class ElementsCSV {
    private int diasemana;
    private int horaIni;
    private int minutoIni;
    private int horaFim;
    private int minutoFim;
    private String nomedocente;
    private String cddocente;
    private String nomedisciplina;
    private String cddisciplina;
    private String sala;
    
    
    public ElementsCSV(){
        diasemana = 0;
        horaIni = 0;
        minutoIni = 0;
        horaFim = 0;
        minutoFim = 0;
        nomedocente = "";
        cddocente = "";
        nomedisciplina = "";
        cddisciplina = "";
        sala = "";
    }
    
    public ElementsCSV(int diasemana, int horaIni, int horaFim, int minutoIni, int minutoFim, String nomedocente, String cddocente, String nomedisciplina, String cddisciplina, String sala){
        this.diasemana = diasemana;
        this.horaIni = horaIni;
        this.minutoIni = minutoIni;
        this.horaFim = horaFim;
        this.minutoFim = minutoFim;
        this.nomedocente = nomedocente;
        this.cddocente = cddocente;
        this.nomedisciplina = nomedisciplina;
        this.cddisciplina = cddisciplina;
        this.sala = sala;
    }
    
    public ElementsCSV(ElementsCSV csv)
    {
        this.diasemana = csv.diasemana;
        this.horaIni = csv.horaIni;
        this.minutoIni = csv.minutoIni;
        this.horaFim = csv.horaFim;
        this.minutoFim = csv.minutoFim;
        this.nomedocente = csv.nomedocente;
        this.cddocente = csv.cddocente;
        this.nomedisciplina = csv.nomedisciplina;
        this.cddisciplina = csv.cddisciplina;
        this.sala = csv.sala;
    }
    
    public String getByElement(int val) 
    {
        if (exists()) {
            String[] valor = {String.valueOf(this.diasemana),String.valueOf(this.horaIni), String.valueOf(this.horaFim), String.valueOf(this.minutoIni), String.valueOf(this.minutoFim),this.nomedocente,this.cddocente, this.nomedisciplina, this.cddisciplina,this.sala};
            return valor[val];
        } else 
            return "none";
        
    }

    /**
     * @return the diasemana
     */
    public int getDiasemana() 
    {
        return diasemana;
    }
    
    private boolean exists()
    {
        return (diasemana != 0); 
    }

    /**
     * @param diasemana the diasemana to set
     */
    public void setDiasemana(int diasemana) {
        this.diasemana = diasemana;
    }

    /**
     * @return the horaIni
     */
    public int getHoraIni() {
        return horaIni;
    }

    /**
     * @param horaIni the horaIni to set
     */
    public void setHoraIni(int horaIni) {
        this.horaIni = horaIni;
    }

    /**
     * @return the minutoIni
     */
    public int getMinutoIni() {
        return minutoIni;
    }

    /**
     * @param minutoIni the minutoIni to set
     */
    public void setMinutoIni(int minutoIni) {
        this.minutoIni = minutoIni;
    }

    /**
     * @return the horaFim
     */
    public int getHoraFim() {
        return horaFim;
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHoraFim(int horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * @return the minutoFim
     */
    public int getMinutoFim() {
        return minutoFim;
    }

    /**
     * @param minutoFim the minutoFim to set
     */
    public void setMinutoFim(int minutoFim) {
        this.minutoFim = minutoFim;
    }

    /**
     * @return the nomedocente
     */
    public String getNomedocente() {
        return nomedocente;
    }

    /**
     * @param nomedocente the nomedocente to set
     */
    public void setNomedocente(String nomedocente) {
        this.nomedocente = nomedocente;
    }

    /**
     * @return the cddocente
     */
    public String getCddocente() {
        return cddocente;
    }

    /**
     * @param cddocente the cddocente to set
     */
    public void setCddocente(String cddocente) {
        this.cddocente = cddocente;
    }

    /**
     * @return the nomedisciplina
     */
    public String getNomedisciplina() {
        return nomedisciplina;
    }

    /**
     * @param nomedisciplina the nomedisciplina to set
     */
    public void setNomedisciplina(String nomedisciplina) {
        this.nomedisciplina = nomedisciplina;
    }

    /**
     * @return the cddisciplina
     */
    public String getCddisciplina() {
        return cddisciplina;
    }

    /**
     * @param cddisciplina the cddisciplina to set
     */
    public void setCddisciplina(String cddisciplina) {
        this.cddisciplina = cddisciplina;
    }

    /**
     * @return the sala
     */
    public String getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(String sala) {
        this.sala = sala;
    }
}
