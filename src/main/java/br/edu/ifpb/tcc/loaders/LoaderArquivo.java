/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.loaders;

import br.edu.ifpb.tcc.beans.Tabela;
import br.edu.ifpb.tcc.persistencia.TabelaDAO;
import br.edu.ifpb.tcc.util.GerenciadorArquivo;
import java.util.List;

/**
 *
 * @author Magdiel Ildefonso
 */
public class LoaderArquivo {

    public static void main(String[] args) {
        //Instanciando gerenciador
        GerenciadorArquivo gerArq = new GerenciadorArquivo("C:/Users/Magdiel Ildefonso"
                + "/Downloads/CADASTRO DAS IES_2011.csv");

        //Convertendo Arquivo para lista de strings
        List<String> arq = gerArq.convArqList();
        //System.out.println("Arquivo sem tratamento");
        for (String string : arq) {
            //System.out.println(string);
        }

        //Retirando linhas desnecessárias
        List<String> listTratada = gerArq.trataLinhasArq(arq);
        //System.out.println("Arquivo sem linhas desnecessárias");
        for (String string : listTratada) {
            System.out.println(string);
        }

        //Criando Tabelas(Nome da tabela e lista de colunas)
        Tabela t = gerArq.getMetadadosTabela(listTratada.get(0));
        //System.out.println(t);

        //Removendo a primeira linhas pra ficar apenas com os dados
        listTratada.remove(0);
        //Criando tabela e inserindo dados
        //TabelaDAO.persisteArquivo(t, listTratada);
    }
}
