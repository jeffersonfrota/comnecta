package com.example.util;

public class Streamer extends Conta{
    
    private int num_vizualizacao;

    public Streamer(long cpf_cnpj, String nome, String email, int num_seguidores, String nacionalidade, String status, String descricao, int num_vizualizacao){
        super(cpf_cnpj, nome, email, num_seguidores, nacionalidade, status, descricao);
        this.num_vizualizacao = num_vizualizacao;
    }

    public int getNum_vizualizacao() {
        return num_vizualizacao;
    }

    public void setNum_vizualizacao(int num_vizualizacao) {
        this.num_vizualizacao = num_vizualizacao;
    }

    @Override
    public String toString() {
        return super.toString() + ", num_visuzalição: " + this.num_vizualizacao + "\n";
    }
}
