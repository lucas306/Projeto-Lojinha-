package loja.projeto_lojinha;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private String usuario = "root";
    private String senha = "Lucas@60";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "db_pessoas";

    public Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd,
                    usuario,
                    senha
            );
            System.out.println("Conexao bem sucedida");
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
