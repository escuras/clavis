/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author toze
 */
public class DataBase {

    private Connection con;
    private boolean tie;

    public DataBase(String url) {
        try {
            con = DriverManager.getConnection(url);
            tie = true;
        } catch (SQLException e) {
            tie = false;
        }
    }

    public DataBase(String url, String username, String password) {
        try {
            con = DriverManager.getConnection(url, username, password);
            tie = true;
        } catch (SQLException e) {
            tie = false;
        }
    }

    public boolean isTie() {
        return tie;
    }

    public java.util.List<Clavis.Person> getPersons() {
        java.util.List<Clavis.Person> pessoas = new java.util.ArrayList<>();
        if (this.isTie()) {
            Statement smt;
            try {
                smt = con.createStatement();
            } catch (SQLException ex) {
                smt = null;
            }
            if (smt != null) {
                String sql = "Select * from Persons;";
                Clavis.Person pessoa;
                ResultSet rs;
                ResultSet rs2;
                Statement aux;
                try {
                    rs = smt.executeQuery(sql);
                    while (rs.next()) {
                        pessoa = new Clavis.Person(rs.getInt("id_pessoa"), rs.getString("nome"), rs.getString("identificacao"), rs.getString("telefone"), rs.getString("email"), rs.getInt("privilegio"));
                        sql = "select * from Functions where id_funcao ='" + rs.getInt("id_funcao") + "'";
                        aux = con.createStatement();
                        rs2 = aux.executeQuery(sql);
                        if (rs2.next()) {
                            Clavis.Function funcao = new Clavis.Function(rs2.getInt(1), rs2.getString(2), rs2.getInt(3));
                            pessoa.setFunction(funcao);
                        }
                        pessoas.add(pessoa);
                    }
                    if (!smt.isClosed()) {
                        smt.close();
                    }
                } catch (SQLException ex) {
                }
            }
        }
        return pessoas;
    }

    public java.util.List<Clavis.Function> getFunctions() {
        java.util.List<Clavis.Function> funcoes = new java.util.ArrayList<>();
        if (this.isTie()) {
            Statement smt;
            try {
                smt = con.createStatement();
            } catch (SQLException ex) {
                smt = null;
            }
            if (smt != null) {
                String sql = "Select * from Functions;";
                Clavis.Function funcao;
                try {
                    ResultSet rs = smt.executeQuery(sql);
                    while (rs.next()){
                        funcao = new Clavis.Function(rs.getInt(1),rs.getString(2),rs.getInt(3));
                        funcoes.add(funcao);
                    }
                    if (!smt.isClosed())smt.close();
                } catch (SQLException ex) {}
            }
        }
        return funcoes;
    }
    
    public java.util.List<Clavis.TypeOfMaterial> getTypeOfMaterials(){
        java.util.List<Clavis.TypeOfMaterial> tipos = new java.util.ArrayList<>();
        if (this.isTie()) {
            Statement smt;
            try {
                smt = con.createStatement();
            } catch (SQLException ex) {
                smt = null;
            }
            if (smt != null) {
                String sql = "Select * from TypesOfMaterial;";
                Clavis.TypeOfMaterial tipo;
                try {
                    ResultSet rs = smt.executeQuery(sql);
                    while (rs.next()){
                        tipo = new Clavis.TypeOfMaterial(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getInt(4),rs.getString(5));
                        tipos.add(tipo);
                    }
                    if (!smt.isClosed())smt.close();
                } catch (SQLException ex) {}
            }
        }
        return tipos;
    }
    
    public java.util.List<Clavis.Material> getMaterials(){
        java.util.List<Clavis.Material> materiais = new java.util.ArrayList<>();
        if (this.isTie()) {
            Statement smt;
            ResultSet rs2;
            Statement aux;
            try {
                smt = con.createStatement();
            } catch (SQLException ex) {
                smt = null;
            }
            if (smt != null) {
                String sql = "Select * from Materials group by id_tipo order by descricao;";
                Clavis.Material material;
                try {
                    ResultSet rs = smt.executeQuery(sql);
                    while (rs.next()){
                        sql = "select * from TypesOfMaterial where id_tipo ='" + rs.getInt("id_tipo") + "'";
                        aux = con.createStatement();
                        rs2 = aux.executeQuery(sql);
                        if (rs2.next()) {
                            Clavis.TypeOfMaterial tipo;
                            if (rs2.getString("Imagem").equals("nada")) tipo = new Clavis.TypeOfMaterial(rs2.getInt("id_tipo"),rs2.getString("descricao"),rs2.getInt("total"), rs2.getInt("livres"),rs2.getString("imagem"));
                            else tipo = new Clavis.TypeOfMaterial(rs2.getInt("id_tipo"),rs2.getString("descricao"),rs2.getInt("total"), rs2.getInt("livres"));
                            if (rs.getString("imagem") != null) material = new Clavis.Material(tipo, rs.getString("codigo"),rs.getString("descricao"),rs.getString("caracteristicas"), rs.getString("imagem"),rs.getBoolean("estado"));
                            else material = new Clavis.Material(tipo, rs.getString("codigo"),rs.getString("descricao"),rs.getString("caracteristicas"), rs.getBoolean("estado"));
                            materiais.add(material);
                            
                        }
                    }
                    if (!smt.isClosed())smt.close();
                } catch (SQLException ex) { System.out.println("erro");}
            }
        }
        return materiais;
    }
    
    public java.util.List<Clavis.Material> getMaterials(int id){
        java.util.List<Clavis.Material> materiais = new java.util.ArrayList<>();
        if (this.isTie()) {
            Statement smt;
            ResultSet rs2;
            Statement aux;
            try {
                smt = con.createStatement();
            } catch (SQLException ex) {
                smt = null;
            }
            if (smt != null) {
                String sql = "Select * from Materials where id_tipo='"+id+"' order by descricao asc;";
                Clavis.Material material;
                try {
                    ResultSet rs = smt.executeQuery(sql);
                    while (rs.next()){
                        sql = "select * from TypesOfMaterial where id_tipo ='" + id + "'";
                        aux = con.createStatement();
                        rs2 = aux.executeQuery(sql);
                        if (rs2.next()) {
                            Clavis.TypeOfMaterial tipo;
                            if (rs2.getString("Imagem").equals("nada")) tipo = new Clavis.TypeOfMaterial(rs2.getInt("id_tipo"),rs2.getString("descricao"),rs2.getInt("total"), rs2.getInt("livres"),rs2.getString("imagem"));
                            else tipo = new Clavis.TypeOfMaterial(rs2.getInt("id_tipo"),rs2.getString("descricao"),rs2.getInt("total"), rs2.getInt("livres"));
                            if (rs.getString("imagem") != null) material = new Clavis.Material(tipo, rs.getString("codigo"),rs.getString("descricao"),rs.getString("caracteristicas"), rs.getString("imagem"),rs.getBoolean("estado"));
                            else material = new Clavis.Material(tipo, rs.getString("codigo"),rs.getString("descricao"),rs.getString("caracteristicas"), rs.getBoolean("estado"));
                            materiais.add(material);
                        }
                    }
                    if (!smt.isClosed())smt.close();
                } catch (SQLException ex) { System.out.println("erro");}
            }
        }
        return materiais;
    }
    
    

}
