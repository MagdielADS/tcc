/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.loaders;

import br.edu.ifpb.tcc.persistencia.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magdiel Ildefonso
 */
public class LoaderGazetteer {

    public static void main(String[] args) {
        Connection conn = Conexao.getInstance().createConnection();

        List<String> geometrias = new ArrayList<>();

        String sql = "select gid, nome, ST_AsText(the_geom) as geo from gazetteer_v3 where tipo ilike 'estado'";
        PreparedStatement pst;

        try {

            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int qtde = 0;
            while (rs.next()) {
                System.out.println(++qtde + " - " + "Local: " + rs.getString("nome") 
                        + " - ID: " + rs.getInt("gid") + " - Geometria: " + rs.getString("geo"));
            }

            pst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaderGazetteer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
