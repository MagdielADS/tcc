/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.tcc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magdiel Ildefonso
 */
public class Mapeamento {
    private Local pais;
    private Local regiao;
    private Local estado;
    private Local mesorregiao;
    private Local microrregiao;
    private Local municipio;

    public Local getPais() {
        return pais;
    }

    public void setPais(Local pais) {
        this.pais = pais;
    }
    
    public Local getRegiao() {
        return regiao;
    }

    public void setRegiao(Local regiao) {
        this.regiao = regiao;
    }

    public Local getEstado() {
        return estado;
    }

    public void setEstado(Local estado) {
        this.estado = estado;
    }

    public Local getMesorregiao() {
        return mesorregiao;
    }

    public void setMesorregiao(Local mesoregiao) {
        this.mesorregiao = mesoregiao;
    }

    public Local getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(Local microregiao) {
        this.microrregiao = microregiao;
    }

    public Local getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Local municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Mapeamento{" + "pais=" + pais + ", regiao=" + regiao + ", estado=" + estado + ", mesoregiao=" + mesorregiao + ", microregiao=" + microrregiao + ", municipio=" + municipio + '}';
    }
}
