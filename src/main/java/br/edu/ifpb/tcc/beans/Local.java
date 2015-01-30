/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.beans;

/**
 *
 * @author Magdiel Ildefonso
 */
public class Local {

    private int id;
    private int gid;
    private String nome;
    private String tipo;
    private String geometria;

    public int getId() {
        return id;
    }

    public int getGid() {
        return gid;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getGeometria() {
        return geometria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setGeometria(String geometria) {
        this.geometria = geometria;
    }

    @Override
    public String toString() {
        return "Local{" + "id=" + id + ", gid=" + gid + ", nome=" + nome + ", tipo=" + tipo + '}';
    }
    

}
