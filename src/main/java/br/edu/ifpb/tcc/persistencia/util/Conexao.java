package br.edu.ifpb.tcc.persistencia.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magdiel Ildefonso
 */
public class Conexao {
    private static Conexao instancia;
    private final File file;
    private final Properties prop;

    private Conexao() {
        file = new File("propriedades_conexao_bd.properties");
        prop = new Properties();
        try {
            prop.load(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conexao getInstance() {
        if (instancia == null) {
            return instancia = new Conexao();
        }
        return instancia;
    }

    public Connection createConnection() {
        try {
            Class.forName(prop.getProperty("driver"));
            return DriverManager.getConnection(prop.getProperty("path"), prop.getProperty("login"),
                    prop.getProperty("senha"));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
