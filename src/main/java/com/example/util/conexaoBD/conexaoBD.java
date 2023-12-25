package com.example.util.conexaoBD;
import java.sql.*;

public class conexaoBD {

    //construtor suprimido, pois, essa classe tem como objetivo, apenas agrupar métodos.
    private conexaoBD(){
        throw new AssertionError();
    }

    //url do banco de dados a ser processado(programa, banco de dados, ip e porta, nome do banco de dado em questao)

    private static String jdbcUrl = "jdbc:postgresql://localhost:5432/test"; 
    //usuario do banco
    private static String userName = "postgres";
    //senha do banco
    private static String password = "nk29wp38s9";
    // variavel de conexao

    private static Connection connection = null;

    public static Connection conectar() {
       
        try{
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
                System.out.println("Conexao encerrada!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
