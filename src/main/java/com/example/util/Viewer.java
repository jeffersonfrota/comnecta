package com.example.util;

public class Viewer extends Conta{

    public Viewer(long cpf_cnpj, String nome, String email, int num_seguidores, String nacionalidade, String status, String descricao){
        super(cpf_cnpj, nome, email, num_seguidores, nacionalidade, status, descricao);
    }


    @Override
    public String toString() {
        return super.toString() + "\n";
    }
}
