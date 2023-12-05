package com.example.recuperaDadosBD;

import java.sql.*;
import java.util.ArrayList;
import com.example.conexaoBD.conexaoBD;
import com.example.util.*;

public final class recuperaDadosBD {

    //construtor suprimido, pois, essa classe tem como objetivo, apenas agrupar métodos.
    private recuperaDadosBD(){
        throw new AssertionError();    
    }

    public final static ArrayList<Viewer> recuperaViewers(){

        String sql = "SELECT * FROM viewer v LEFT JOIN cartao c ON v.cpf_cnpj = c.cpf_cnpj_conta";
        ArrayList<Viewer> viewerList = new ArrayList<>();

        try(Connection conexao = conexaoBD.conectar(); PreparedStatement preparedStatement = conexao.prepareStatement(sql))
        {
            
            System.out.println("Banco conectado! ");
            //Statement stn = conexao.createStatement();

            try (ResultSet resultSet = preparedStatement.executeQuery()) 
            {

                while (resultSet.next()) {
                    
                    Viewer viewer = new Viewer( resultSet.getLong("cpf_cnpj"), resultSet.getString("nome"),  resultSet.getString("email"),  resultSet.getInt("num_seguidores"), resultSet.getString("nacionalidade"), resultSet.getString("status"), resultSet.getString("descricao"));
                    
            
                    viewer.addCartao(new Cartao(resultSet.getLong("numero"), resultSet.getInt("codSeguranca"), resultSet.getDate("dataVencimento") != null ? resultSet.getDate("dataVencimento").toLocalDate() : null, resultSet.getLong("cpf_cnpj_conta")));
                    
                    viewerList.add(viewer);

                }

                conexaoBD.fecharConexao(conexao);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } 
        return viewerList != null ? viewerList: null;
    } 

    public final static ArrayList<Streamer> recuperaStreamers(){

        String sql = "SELECT * FROM streamer s LEFT JOIN cartao c ON s.cpf_cnpj = c.cpf_cnpj_conta";

        ArrayList<Streamer> streamerList = new ArrayList<>();

        try(Connection conexao = conexaoBD.conectar(); PreparedStatement preparedStatement = conexao.prepareStatement(sql))
        {
            
            System.out.println("Banco conectado! ");
            //Statement stn = conexao.createStatement();

            try (ResultSet resultSet = preparedStatement.executeQuery()) 
            {

                while (resultSet.next()) {
                    
                    Streamer streamer = new Streamer( resultSet.getLong("cpf_cnpj"), resultSet.getString("nome"),  resultSet.getString("email"),resultSet.getInt("num_seguidores"), resultSet.getString("nacionalidade"), resultSet.getString("status"), resultSet.getString("descricao"), resultSet.getInt("num_vizualizacoes"));

                    //System.out.print(streamer.toString()); 
                     streamer.addCartao(new Cartao(resultSet.getLong("numero"), resultSet.getInt("codSeguranca"), resultSet.getDate("dataVencimento") != null ? resultSet.getDate("dataVencimento").toLocalDate() : null, resultSet.getLong("cpf_cnpj_conta")));

                    streamerList.add(streamer);
                }
                conexaoBD.fecharConexao(conexao);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } 
        return streamerList != null ? streamerList: null;
        
    }
}
