package com.example;
import java.sql.*;

import com.example.conexaoBD.conexaoBD;
import com.example.util.Viewer;
import java.util.ArrayList;



public class App 
{
    public static void main( String[] args )
    {
        try {
            
            Connection conexao = conexaoBD.conectar();
            
            if(conexao != null){
                System.out.println("Banco conectado! ");
                Statement stn = conexao.createStatement();

                consultaDados(stn);
                
                stn.close();
                conexao.close();
            }
            else{
                System.out.println("Deu ruim, falhou !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    static void consultaDados(Statement stn){
        String sql = "SELECT * FROM viewer";
        
        try {
           ResultSet result = stn.executeQuery(sql);
           ArrayList<Viewer> arrayList = new ArrayList<>();

           while(result.next()) {
                
                Viewer viewer = null;

                viewer = new Viewer( result.getLong("cpf_cnpj"), result.getString("nome"),  result.getString("email"),  result.getInt("num_seguidores"), result.getString("nacionalidade"), result.getString("status"), result.getString("descricao"));


                //System.out.print(viewer.toString());

                arrayList.add(viewer);

                //System.out.println("cpf_cnpj: " + result.getLong("cpf_cnpj") + ", nome: " + result.getString("nome") + ", email: " + result.getString("email") + ", nacionalidade: " + result.getString("nacionalidade") + ", num_seguidores: " + result.getInt("num_seguidores") + ", status: " + result.getString("status")  + ", descricão: " + result.getString("descricao"));    
           } 

           for(Viewer v : arrayList){
                System.out.print(v.toString());
           }
           
           result.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        

    } 
}
