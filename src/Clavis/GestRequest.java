/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clavis;

/**
 *
 * @author toze
 */
public class GestRequest {
    
    private java.util.Collection<Request> requisicoes;
    
    public GestRequest(){
        requisicoes = new java.util.HashSet();
    }
    
    public GestRequest(java.util.Collection col){
        requisicoes = col;
    }
    
    public void addRequest(Request req){
        requisicoes.add(req);
    }
    
    public void removeRequest(Request req){
        requisicoes.remove(req);
    }
    
    
    
    
    
}
