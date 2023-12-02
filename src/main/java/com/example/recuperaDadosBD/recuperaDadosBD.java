package com.example.recuperaDadosBD;
import java.sql.*;
import java.util.ArrayList;

import com.example.conexaoBD.conexaoBD;
import com.example.util.Cartao;
import com.example.util.Viewer;

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

                    //System.out.print(viewer.toString());

                    //System.out.println("cpf_cnpj: " + resultSet.getLong("cpf_cnpj") + ", nome: " + resultSet.getString("nome") + ", email: " + resultSet.getString("email") + ", nacionalidade: " + resultSet.getString("nacionalidade") + ", num_seguidores: " + resultSet.getInt("num_seguidores") + ", status: " + resultSet.getString("status")  + ", descricão: " + resultSet.getString("descricao"));    

                }

                conexaoBD.fecharConexao(conexao);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } 
        return viewerList != null ? viewerList: null;
    } 
}
