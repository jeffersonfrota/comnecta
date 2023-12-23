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

    public final static ArrayList<Viewer> getViewers(){

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

}
