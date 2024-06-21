package src.main.java.com.matheusarjc.domain;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;


    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    // Aqui eu poderia colocar o @Getters e @Setters do Lombok também mas não é um projeto SB

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    // Aqui eu senti duvida, me esqueci do Pattern correto então separei em duas classes
    private String formatDate(LocalDate dataNascimento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formatter);
    }

    // Aqui eu fui testando e realmente não sabia como fazer e fui fazendo a lógica com a formatação de numero e lendo os parametros das boxes
    private String formatCurrency(BigDecimal amount) {
        NumberFormat currencyFormatter = NumberFormat.getInstance(Locale.GERMANY);
        return currencyFormatter.format(amount);
    }

    @Override
    public String toString(){
    return getNome() + " - " + formatDate(getDataNascimento()) + " - " + formatCurrency(salario) + " - " + funcao;
    }
}
