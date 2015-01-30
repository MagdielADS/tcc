/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.util;

import br.edu.ifpb.tcc.beans.Tabela;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magdiel Ildefonso
 */
public class GerenciadorArquivo {

    private String nomeDaTabela;
    private final String nomeArquivo;

    public GerenciadorArquivo(String nomeArq) {
        this.nomeArquivo = nomeArq;
        setNomeTabela();
    }

    public String getNomeDaTabela() {
        return nomeDaTabela;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    private void setNomeTabela() {
        String[] aux = nomeArquivo.split("/");
        String futuroNomeTabela = aux[aux.length - 1];
        futuroNomeTabela = futuroNomeTabela.replace(" ", "_");
        futuroNomeTabela = futuroNomeTabela.substring(0, futuroNomeTabela.indexOf("."));
        this.nomeDaTabela = futuroNomeTabela;
    }

    public List<String> convArqList() {
        List<String> linhas = new ArrayList<>();

        FileReader arq;
        try {
            arq = new FileReader(nomeArquivo);

            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null) {
                linhas.add(linha);
                linha = lerArq.readLine();
            }
            arq.close();
            lerArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;
    }

    public List<String> trataLinhasArq(List<String> linhas) {
        List<String> linhasTratadas = new ArrayList<>();
        List<String> lixo = new ArrayList<>();

        for (String linha : linhas) {
            if ((linha.charAt(linha.length() - 1) != ';')) {
                linhasTratadas.add(linha);
            } else if ((linha.charAt(0) == ';')) {
                if (linhasTratadas.size() > 0) {
                    linhasTratadas.remove(linhasTratadas.size() - 1);
                }
            } else {
                lixo.add(linha);
            }
        }
        return linhasTratadas;
    }

    public Tabela getMetadadosTabela(String primeiraLinhaArquivo) {
        Tabela tabela = new Tabela();
        String[] cols = primeiraLinhaArquivo.split(";");
        
        for (String col : cols) {
            tabela.addColunas(col);
        }
        tabela.setName(nomeDaTabela);
        return tabela;
    }
}
