package com.example;
import java.sql.*;

import com.example.conexaoBD.conexaoBD;
import com.example.util.Viewer;
import java.util.ArrayList;



public class App 
{
    public static void main( String[] args )
    {

        String sql = "SELECT * FROM viewer";

        try(Connection conexao = conexaoBD.conectar(); PreparedStatement preparedStatement = conexao.prepareStatement(sql))
        {
            
            System.out.println("Banco conectado! ");
            //Statement stn = conexao.createStatement();

            try (ResultSet resultSet = preparedStatement.executeQuery()) 
            {
                
                ArrayList<Viewer> arrayList = new ArrayList<>();

                while (resultSet.next()) {
                    
                    Viewer viewer = null;

                    viewer = new Viewer( resultSet.getLong("cpf_cnpj"), resultSet.getString("nome"),  resultSet.getString("email"),  resultSet.getInt("num_seguidores"), resultSet.getString("nacionalidade"), resultSet.getString("status"), resultSet.getString("descricao"));

                    arrayList.add(viewer);

                    //System.out.print(viewer.toString());

                    //System.out.println("cpf_cnpj: " + resultSet.getLong("cpf_cnpj") + ", nome: " + resultSet.getString("nome") + ", email: " + resultSet.getString("email") + ", nacionalidade: " + resultSet.getString("nacionalidade") + ", num_seguidores: " + resultSet.getInt("num_seguidores") + ", status: " + resultSet.getString("status")  + ", descricão: " + resultSet.getString("descricao"));    

                }

                for(Viewer v : arrayList){
                    System.out.print(v.toString());
                }
                conexaoBD.fecharConexao(conexao);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}
