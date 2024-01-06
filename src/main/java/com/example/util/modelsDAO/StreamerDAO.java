package com.example.util.modelsDAO;

import java.sql.*;
import java.util.ArrayList;
import com.example.util.conexaoBD.*;
import com.example.util.models.Streamer;

public final class StreamerDAO {

    //construtor suprimido, pois, essa classe tem como objetivo, apenas agrupar métodos
    private StreamerDAO(){
        throw new AssertionError();    
    }

     public final static ArrayList<Streamer> getStreamers(){

        String sql = "SELECT * FROM streamer v JOIN conta c ON v.cpf_cnpj_streamer = c.cpf_cnpj";

        ArrayList<Streamer> streamerList = new ArrayList<>();

        try(Connection conexao = conexaoBD.conectar(); PreparedStatement preparedStatement = conexao.prepareStatement(sql))
        {
            
            System.out.println("Banco conectado! ");
            //Statement stn = conexao.createStatement();

            try (ResultSet resultSet = preparedStatement.executeQuery()) 
            {

                while (resultSet.next()) {
                    
                    Streamer streamer = new Streamer( resultSet.getString("cpf_cnpj"), resultSet.getString("nome"),  resultSet.getString("email"),resultSet.getInt("num_seguidores"), resultSet.getString("nacionalidade"), resultSet.getString("status"), resultSet.getString("descricao"), resultSet.getInt("num_visualizacoes"));

                    streamerList.add(streamer);
                }
           
            }
            conexaoBD.fecharConexao(conexao);
        }catch (SQLException e) {
            e.printStackTrace();
        } 
        return streamerList;
        
    }

    public final static boolean insertStreamer(Streamer streamer){

        String insertConta = "INSERT INTO conta(cpf_cnpj, nome, email, nacionalidade, num_seguidores, status, descricao) VALUES(?,?,?,?,?,?,?)";
        String insertStreamer  = "INSERT INTO streamer(cpf_cnpj_streamer, cpf_cnpj_conta, num_visualizacoes) VALUES(?,?,?)";

        try(Connection connection = conexaoBD.conectar(); PreparedStatement preparedStatementConta = connection.prepareStatement(insertConta); PreparedStatement preparedStatementStreamer = connection.prepareStatement(insertStreamer)) {
            System.out.println("Banco Conectado!");

            preparedStatementConta.setString(1, streamer.getCpf_cnpj());
            preparedStatementConta.setString(2, streamer.getNome());
            preparedStatementConta.setString(3, streamer.getEmail());
            preparedStatementConta.setString(4, streamer.getNacionalidade());
            preparedStatementConta.setInt(5, streamer.getNum_seguidores());
            preparedStatementConta.setString(6, streamer.getStatus());
            preparedStatementConta.setString(7, streamer.getDescricao());
            

            preparedStatementStreamer.setString(1, streamer.getCpf_cnpj());
            preparedStatementStreamer.setString(2, streamer.getCpf_cnpj());
            preparedStatementStreamer.setInt(3, streamer.getNum_vizualizacao());

            int linhasAfetadasConta = preparedStatementConta.executeUpdate();
            int linhasAfetadasStreamer = preparedStatementStreamer.executeUpdate();
    
            return linhasAfetadasConta > 0 && linhasAfetadasStreamer > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    } 

    public final static boolean updateStreamer(Streamer streamer){
        
        String sqlConta = "UPDATE conta SET nome = ?, email = ?, nacionalidade = ?, num_seguidores = ?, status = ?, descricao = ? WHERE cpf_cnpj = ?";
        String sqlStreamer = "UPDATE streamer SET num_visualizacoes = ? WHERE cpf_cnpj_streamer = ?";

        try(Connection connection = conexaoBD.conectar(); PreparedStatement preparedStatementConta = connection.prepareStatement(sqlConta); PreparedStatement preparedStatementStreamer = connection.prepareStatement(sqlStreamer)) {
       
            preparedStatementConta.setString(1, streamer.getNome());
            preparedStatementConta.setString(2, streamer.getEmail());
            preparedStatementConta.setString(3, streamer.getNacionalidade());
            preparedStatementConta.setInt(4, streamer.getNum_seguidores());
            preparedStatementConta.setString(5, streamer.getStatus());
            preparedStatementConta.setString(6, streamer.getDescricao());
            preparedStatementConta.setString(7, streamer.getCpf_cnpj());

            preparedStatementStreamer.setInt(1, streamer.getNum_vizualizacao());
            preparedStatementStreamer.setString(2, streamer.getCpf_cnpj());

            int linhasAfetadasConta = preparedStatementConta.executeUpdate();
            int linhasAfetadasStreamer = preparedStatementStreamer.executeUpdate();

            return linhasAfetadasConta > 0 && linhasAfetadasStreamer > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     public final static boolean removeStreamer(Streamer streamer){
        
        String removeStreamer = "DELETE FROM streamer WHERE cpf_cnpj_streamer = ? ";
        String removeConta = "DELETE FROM conta WHERE cpf_cnpj = ?";

        try (Connection connection = conexaoBD.conectar(); PreparedStatement preparedStatementStreamer = connection.prepareStatement(removeStreamer); PreparedStatement preparedStatementConta = connection.prepareStatement(removeConta)) {

            preparedStatementStreamer.setString(1, streamer.getCpf_cnpj()); 
            preparedStatementConta.setString(1, streamer.getCpf_cnpj());
            
            int linhasAfetadasstreamer = preparedStatementStreamer.executeUpdate();
            int linhasAfetadasConta = preparedStatementConta.executeUpdate();
          
            return linhasAfetadasConta > 0 && linhasAfetadasstreamer > 0;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
