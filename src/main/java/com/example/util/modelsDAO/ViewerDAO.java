package com.example.util.modelsDAO;

import java.sql.*;
import java.util.ArrayList;
import com.example.util.conexaoBD.conexaoBD;
import com.example.util.models.Cartao;
import com.example.util.models.Viewer;

public final class ViewerDAO {

    //construtor suprimido, pois, essa classe tem como objetivo, apenas agrupar métodos
    private ViewerDAO(){
        throw new AssertionError();    
    }

    public final static ArrayList<Viewer> getViewers()
    {

        String sql = "SELECT * FROM viewer v LEFT JOIN cartao c ON v.cpf_cnpj = c.cpf_cnpj_conta";
        ArrayList<Viewer> viewerList = new ArrayList<>();

        try(Connection conexao = conexaoBD.conectar(); PreparedStatement preparedStatementConta = conexao.prepareStatement(sql))
        {
            
            System.out.println("Banco conectado! ");
            //Statement stn = conexao.createStatement();

            try (ResultSet resultSet = preparedStatementConta.executeQuery()) 
            {

                while (resultSet.next()) {
                    
                    Viewer viewer = new Viewer( resultSet.getString("cpf_cnpj"), resultSet.getString("nome"),  resultSet.getString("email"),  resultSet.getInt("num_seguidores"), resultSet.getString("nacionalidade"), resultSet.getString("status"), resultSet.getString("descricao"));
                    
            
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

    public final static boolean insertViewer(Viewer viewer)
    {
        String sql = "INSERT INTO conta(cpf_cnpj, nome, email, nacionalidade, num_seguidores, status, descricao) VALUES(?,?,?,?,?,?,?)";
        String sqlAux  = "INSERT INTO viewer(cpf_cnpj, nome, email, nacionalidade, num_seguidores, status, descricao) VALUES(?,?,?,?,?,?,?)";

        try(Connection connection = conexaoBD.conectar(); PreparedStatement preparedStatementConta = connection.prepareStatement(sql); PreparedStatement preparedStatementViewer = connection.prepareStatement(sqlAux)) {
            System.out.println("Banco Conectado!");

            preparedStatementConta.setString(1, viewer.getCpf_cnpj());
            preparedStatementConta.setString(2, viewer.getNome());
            preparedStatementConta.setString(3, viewer.getEmail());
            preparedStatementConta.setString(4, viewer.getNacionalidade());
            preparedStatementConta.setInt(5, viewer.getNum_seguidores());
            preparedStatementConta.setString(6, viewer.getStatus());
            preparedStatementConta.setString(7, viewer.getDescricao());

            preparedStatementViewer.setString(1, viewer.getCpf_cnpj());
            preparedStatementViewer.setString(2, viewer.getNome());
            preparedStatementViewer.setString(3, viewer.getEmail());
            preparedStatementViewer.setString(4, viewer.getNacionalidade());
            preparedStatementViewer.setInt(5, viewer.getNum_seguidores());
            preparedStatementViewer.setString(6, viewer.getStatus());
            preparedStatementViewer.setString(7, viewer.getDescricao());

            int linhasAfetadasConta = preparedStatementConta.executeUpdate();
            int linhasAfetadasViewer = preparedStatementViewer.executeUpdate();
    
            return linhasAfetadasConta > 0 && linhasAfetadasViewer > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 

    public final static boolean removeViewer(Viewer viewer){
        
        String sql = "DELETE FROM viewer WHERE cpf_cnpj = ? ";

        try (Connection connection = conexaoBD.conectar(); PreparedStatement        preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, viewer.getCpf_cnpj()); 
        
            int linhasAfetadas = preparedStatement.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public final static boolean updateViewer(Viewer viewer){
        
        String sql = "UPDATE viewer SET nome = ?, email = ? WHERE cpf_cnpj = ?";

        try(Connection connection = conexaoBD.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
       
            preparedStatement.setString(1, viewer.getNome());
            preparedStatement.setString(2, viewer.getEmail());
            preparedStatement.setString(3, viewer.getCpf_cnpj());

            int linhasAfetadas = preparedStatement.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}