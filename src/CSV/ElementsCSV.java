package CSV;

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
    private String cdsala;
    
    
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
        cdsala = "";
    }
    
    public ElementsCSV(int diasemana, int horaIni, int horaFim, int minutoIni, int minutoFim, String nomedocente, String cddocente, String nomedisciplina, String cddisciplina, String sala, String cdsala){
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
        this.cdsala = cdsala;
    }
    
    public ElementsCSV(ElementsCSV csv)
    {
        this.diasemana = csv.getDayWeek();
        this.horaIni = csv.getHourIni();
        this.minutoIni = csv.getMinuteIni();
        this.horaFim = csv.getHourEnd();
        this.minutoFim = csv.getMinuteEnd();
        this.nomedocente = csv.getTeacherName();
        this.cddocente = csv.getCdTeacher();
        this.nomedisciplina = csv.getSubjectName();
        this.cddisciplina = csv.getCdSubject();
        this.sala = csv.getClassRoom();
        this.cdsala = csv.getCdClassRoom();
    }
   

    /**
     * @return the diasemana
     */
    public int getDayWeek() 
    {
        return diasemana;
    }

    /**
     * @param diasemana the diasemana to set
     */
    public void setDayWeek(int diasemana) {
        this.diasemana = diasemana;
    }

    /**
     * @return the horaIni
     */
    public int getHourIni() {
        return horaIni;
    }

    /**
     * @param horaIni the horaIni to set
     */
    public void setHourIni(int horaIni) {
        this.horaIni = horaIni;
    }

    /**
     * @return the minutoIni
     */
    public int getMinuteIni() {
        return minutoIni;
    }

    /**
     * @param minutoIni the minutoIni to set
     */
    public void setMinuteIni(int minutoIni) {
        this.minutoIni = minutoIni;
    }

    /**
     * @return the horaFim
     */
    public int getHourEnd() {
        return horaFim;
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHourEnd(int horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * @return the minutoFim
     */
    public int getMinuteEnd() {
        return minutoFim;
    }

    /**
     * @param minutoFim the minutoFim to set
     */
    public void setMinuteEnd(int minutoFim) {
        this.minutoFim = minutoFim;
    }

    /**
     * @return the nomedocente
     */
    public String getTeacherName() {
        return nomedocente;
    }

    /**
     * @param nomedocente the nomedocente to set
     */
    public void setTeacherName(String nomedocente) {
        this.nomedocente = nomedocente;
    }

    /**
     * @return the cddocente
     */
    public String getCdTeacher() {
        return cddocente;
    }

    /**
     * @param cddocente the cddocente to set
     */
    public void setCdTeacher(String cddocente) {
        this.cddocente = cddocente;
    }

    /**
     * @return the nomedisciplina
     */
    public String getSubjectName() {
        return nomedisciplina;
    }

    /**
     * @param nomedisciplina the nomedisciplina to set
     */
    public void setSubjectName(String nomedisciplina) {
        this.nomedisciplina = nomedisciplina;
    }

    /**
     * @return the cddisciplina
     */
    public String getCdSubject() {
        return cddisciplina;
    }

    /**
     * @param cddisciplina the cddisciplina to set
     */
    public void setCdSubject(String cddisciplina) {
        this.cddisciplina = cddisciplina;
    }

    /**
     * @return the sala
     */
    public String getClassRoom() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setClassRoom(String sala) {
        this.sala = sala;
    }

    /**
     * @return the cdsala
     */
    public String getCdClassRoom() {
        return cdsala;
    }

    /**
     * @param cdsala the cdsala to set
     */
    public void setCdClassRoom(String cdsala) {
        this.cdsala = cdsala;
    }
}
