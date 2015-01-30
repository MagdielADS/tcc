/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.loaders;

import br.edu.ifpb.tcc.beans.Local;
import br.edu.ifpb.tcc.beans.Mapeamento;
import br.edu.ifpb.tcc.beans.Ponto;
import br.edu.ifpb.tcc.fachada.Fachada;
import br.edu.ifpb.tcc.persistencia.GazetteerDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magdiel Ildefonso
 */
public class LoaderRecuperandoPonto {

    public static void main(String[] args) {
        Fachada f = new Fachada();

        //Setando uma lista com possíveis resultados de um arquivo
        List<String> resultados = new ArrayList<>();

        resultados.add("2011");
        resultados.add("UNIVERSIDADE FEDERAL DE MATO GROSSO");
        resultados.add("UFMT");
        resultados.add("33004540000100");
        resultados.add("5");
        resultados.add("Centro_Oeste");
        resultados.add("MATO GROSSO");
        resultados.add("CUIABA");

        //Recuperando dos resultados apenas os que são locais
        List<Local> locais = new ArrayList<>();
        for (String result : resultados) {
            List<Local> loc = GazetteerDAO.recuperaLocais(result);
            locais.addAll(loc);
        }
        //Locais recuperados
        for (Local local : locais) {
            System.out.println("Local: " + local.getNome() + " Tipo: " + local.getTipo());
        }
        //Construindo mapeamento a partir da lista de locais
        Mapeamento map = f.construirMapeamento(locais);
        //Mapeamento criado
        System.out.println(map);
        //Recuperando local mais interno
        Local local = f.geometriaMaisInterna(map);
        //Local recuperado
        System.out.println(local);
        //Recuperando ponto do local
        Ponto ponto = GazetteerDAO.recuperaPonto(local);
        //Ponto recuperada
        System.out.println(ponto);
    }
}
