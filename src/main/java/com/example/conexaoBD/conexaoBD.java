package com.example.conexaoBD;
import java.sql.*;

public class conexaoBD {
    //url do banco de dados a ser processado(programa, banco de dados, ip e porta, nome do banco de dado em questao)

    private static String jdbcUrl = "jdbc:postgresql://localhost:5432/teste"; 

    //usuario do banco
    private static String userName = "postgres";
    private static String password = "nk29wp38s9";

    public static Connection conectar() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

            //estabelecimento da conexaso
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void fecharConexao(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
