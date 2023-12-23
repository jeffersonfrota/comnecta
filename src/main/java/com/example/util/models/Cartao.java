package com.example.util.models;

import java.time.LocalDate;

public class Cartao {
    
    private long numCartao;
    private int codSeguranca;
    private LocalDate dataVencimento;
    private long cpf_cnpj_conta;

    public Cartao(long numCartao, int codSeguranca, LocalDate dataVencimento, long cpf_cnpj_conta){
        
        this.numCartao = numCartao;
        this.codSeguranca = codSeguranca;
        this.dataVencimento = dataVencimento;
        this.cpf_cnpj_conta = cpf_cnpj_conta;

    }

    public long getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(long numCartao) {
        this.numCartao = numCartao;
    }

    public int getCodSeguranca() {
        return codSeguranca;
    }

    public void setCodSeguranca(int codSeguranca) {
        this.codSeguranca = codSeguranca;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public long getCpf_cnpj_conta() {
        return cpf_cnpj_conta;
    }

    public void setCpf_cnpj_conta(long cpf_cnpj_conta) {
        this.cpf_cnpj_conta = cpf_cnpj_conta;
    }

    @Override
    public String toString() {
        return "Cartao = numCartao: " + numCartao + ", codSeguranca: " + codSeguranca + ", dataVencimento: " + dataVencimento + ", cpf_cnpj_conta: " + cpf_cnpj_conta ;
    }

}
