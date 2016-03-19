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
public class Material extends TypeOfMaterial {
    private int codigo;
    private String descricao;
    private String caracteristicas;
    
    public Material(){
        super();
        this.codigo = -1;
        this.descricao = "";
        this.caracteristicas = "";
    }
    
    public Material(TypeOfMaterial m, int codigo, String descricao){
        super(m);
        this.codigo = codigo;
        this.descricao = descricao;
        this.caracteristicas = "";
    }
    
    public Material(TypeOfMaterial m, int codigo, String descricao, String caracteristicas){
        super(m);
        this.codigo = codigo;
        this.descricao = descricao;
        this.caracteristicas = caracteristicas;
    }
    
    public Material(Material m){
        super(m);
        this.codigo = m.getCodeOfMaterial();
        this.descricao = m.getDescription();
        this.caracteristicas = m.getFeatures();
    }

    /**
     * @return the id
     */
    public int getCodeOfMaterial() {
        return codigo;
    }

    /**
     * @param codigo
     */
    public void setCodeOfMaterial(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */

    public String getDescription() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescription(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the caracteristicas
     */
    public String getFeatures() {
        return caracteristicas;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setFeatures(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    @Override
    public String toString(){
        return this.descricao + "\n\n" + this.caracteristicas;
    }
    
    
    
}
