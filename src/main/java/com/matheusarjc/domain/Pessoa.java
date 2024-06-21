package src.main.java.com.matheusarjc.domain;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

// Aqui eu poderia usar um Lombok para reduzir os Getters e Setters se fosse o caso mas vou colocar sem isso

    public Pessoa(String nome, LocalDate dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return nome;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    //Não sei se é necessário o toString() mas vou colocar porque no Lombok geralmente é só usar uma annotation @ToString
    @Override
    public String toString() {
        return nome + "-" + dataNascimento;
    }
}

