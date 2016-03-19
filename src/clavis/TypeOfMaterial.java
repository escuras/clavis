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
public class TypeOfMaterial {
    private int id;
    private String descricao;
    
    
    public TypeOfMaterial(){
        this.id = -1;
        this.descricao = "";
    }
    
    public TypeOfMaterial(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }
    
    public TypeOfMaterial(TypeOfMaterial material){
        this.id = material.id;
        this.descricao = material.descricao;
    }
    
    @Override
    public String toString(){
        return this.descricao;
    }

    /**
     * @return the id
     */
    public int getMaterialTypeID() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setMaterialTypeID(int id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getTypeOfMaterialName() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setTypeOfMaterialName(String descricao) {
        this.descricao = descricao;
    }   
}
