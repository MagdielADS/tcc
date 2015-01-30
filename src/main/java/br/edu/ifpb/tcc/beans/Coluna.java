/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.tcc.beans;

import java.util.List;

/**
 *
 * @author Magdiel Ildefonso
 */
public class Coluna {
    private String nome;
    private String descricao;
    private List<String> restricoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(List<String> restricoes) {
        this.restricoes = restricoes;
    }

    @Override
    public String toString() {
        return "Coluna{" + "nome=" + nome + ", descricao=" + descricao + ", restricoes=" + restricoes + '}';
    }

}
