package com.example.util;
import java.util.ArrayList;

public class Conta{

    private long cpf_cnpj;
    private String nome, email, nacionalidade, status, descricao;
    private int num_seguidores;
    private ArrayList<Cartao> arrCartao;

    public Conta(long cpf_cnpj, String nome, String email, int num_seguidores, String nacionalidade, String status, String descricao ){
        
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.email = email;
        this.nacionalidade = nacionalidade;
        this.num_seguidores = num_seguidores;
        this.status = status;
        this.descricao = descricao;
        this.arrCartao = new ArrayList<>(); 
    }

    public void addCartao(Cartao cartao){
        this.arrCartao.add(cartao);
    }


    public long getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(long cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNum_seguidores() {
        return num_seguidores;
    }

    public void setNum_seguidores(int num_seguidores) {
        this.num_seguidores = num_seguidores;
    }

    @Override
    public String toString() {
        return "Conta = cpf_cnpj: " + cpf_cnpj + ", nome: " + nome + ", email: " + email + ", nacionalidade: "+ nacionalidade + ", status: " + status + ", descricao: " + descricao + ", num_seguidores: "+ num_seguidores + " , cartoes: " + arrCartao.toString();
    }
}
