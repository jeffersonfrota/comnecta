package com.example.util.modelsDAO;

import java.sql.*;
import java.util.ArrayList;
import com.example.util.conexaoBD.*;
import com.example.util.models.Cartao;
import com.example.util.models.Streamer;

public final class StreamerDAO {

    //construtor suprimido, pois, essa classe tem como objetivo, apenas agrupar métodos
    private StreamerDAO(){
        throw new AssertionError();    
    }

     public final static ArrayList<Streamer> getStreamers(){

        String sql = "SELECT * FROM streamer s LEFT JOIN cartao c ON s.cpf_cnpj = c.cpf_cnpj_conta";

        ArrayList<Streamer> streamerList = new ArrayList<>();

        try(Connection conexao = conexaoBD.conectar(); PreparedStatement preparedStatement = conexao.prepareStatement(sql))
        {
            
            System.out.println("Banco conectado! ");
            //Statement stn = conexao.createStatement();

            try (ResultSet resultSet = preparedStatement.executeQuery()) 
            {

                while (resultSet.next()) {
                    
                    Streamer streamer = new Streamer( resultSet.getString("cpf_cnpj"), resultSet.getString("nome"),  resultSet.getString("email"),resultSet.getInt("num_seguidores"), resultSet.getString("nacionalidade"), resultSet.getString("status"), resultSet.getString("descricao"), resultSet.getInt("num_vizualizacoes"));

                    //System.out.print(streamer.toString()); 
                     streamer.addCartao(new Cartao(resultSet.getLong("numero"), resultSet.getInt("codSeguranca"), resultSet.getDate("dataVencimento") != null ? resultSet.getDate("dataVencimento").toLocalDate() : null, resultSet.getString("cpf_cnpj_conta")));

                    streamerList.add(streamer);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } 
        return streamerList != null ? streamerList: null;
        
    }
}
