/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavis;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author toze
 */
public class Function {
    private String funcao;
    private int id;
    private int privilegio;
    private String locale;

    
    public Function()
    {
        this.funcao = "";
        this.id = 0;
        this.privilegio = 0;
    }
    
    public Function(int id, String funcao){
        this.funcao = funcao;
        this.id = id;
        this.privilegio = 0;
    } 
    
    public Function(Function func)
    {
        this.funcao = func.getFuncao();
        this.id = func.getId();
        this.privilegio = func.getPrivilegio();
    }
    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
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

    /**
     * @return the privilegio
     */
    public int getPrivilegio() {
        return privilegio;
    }

    /**
     * @param privilegio the privilegio to set
     */
    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }
    
    public void setLocale(String local){
        String [] valores = local.split("[-./|;,:_]");
        if (this.locale == null) this.locale = "pt-PT";
        if (valores.length == 2) {
            Locale loca = new Locale(valores[0], valores[1]);
            ResourceBundle sms = ResourceBundle.getBundle("langs.MensagemBundle", loca);
            if ((sms.getLocale().equals(loca))&&(sms.containsKey(this.funcao))) 
            {
                this.locale = local;
                this.funcao = sms.getString(this.funcao);
            } 
        }  
    }
    
    
}



