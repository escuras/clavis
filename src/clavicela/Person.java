/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavicela;

/**
 *
 * @author toze
 */
public class Person {
    private String nome;
    private String identificacao;
    private String telefone;
    private String email;
    private int id;
    
    public Person(){
        nome = "";
        identificacao = "";
        telefone = "";
        email = "";
        id = 0;
    }
    
    
    public Person(int id, String nome, String identificacao, String telefone, String email){
        this.nome = nome;
        this.identificacao = identificacao;
        this.telefone = telefone;
        this.email = email;
        this.id = id;
    }
    
    public Person(String nome, String identificacao, String telefone, String email){
        this.nome = nome;
        this.identificacao = identificacao;
        this.telefone = telefone;
        this.email = email;
        this.id = 0;
    }
    
    public Person(Person pess){
        this.nome = pess.getName();
        this.identificacao = pess.getIdentification();
        this.telefone = pess.getPhone();
        this.email = pess.getEmail();
        this.id = pess.getId();
    }
    
    public boolean ComparePhone(String telefone){
        return this.telefone.equals(telefone);
    }
    
    public boolean ComparePhone(int telefone){
        String val = String.valueOf(telefone);
        return this.telefone.equals(val);
    }
    
    public boolean CompareName(String nome){
        return this.nome.equals(nome);
    }
     
    public boolean CompareEmail(String email){
        return this.email.equals(email);
    }
    

    /**
     * @return the nome
     */
    public String getName() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setName(String nome) {
        this.nome = nome;
    }

    /**
     * @return the identificacao
     */
    public String getIdentification() {
        return identificacao;
    }

    /**
     * @param identificacao the identificacao to set
     */
    public void setIdentification(String identificacao) {
        this.identificacao = identificacao;
    }

    /**
     * @return the telefone
     */
    public String getPhone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setPhone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
