package src.main.java.com.matheusarjc.main;

import src.main.java.com.matheusarjc.domain.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Principal {
    //aqui os argumentos que vão ser passados para essa função, vão como um array de objetos String
    public static void main(String[] args){
        // a ideia é que retorne uma lista de tamanho fixo e serializado
        List<Funcionario> funcionarios = new ArrayList<>(List.of(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));
        // esse metodo vai remover o ou os nomes que eu colocar no parametro dentro dessa collection
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        // aqui vai mostrar as informações dos funcionarios
        funcionarios.forEach(funcionario -> System.out.println(funcionario));

        // aqui o aumento de 10%
        funcionarios.forEach(funcionario -> funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal("1.10"))));

        // não soube agrupar por função, sei que nesse caso teria um Map de começo, pulei de etapa.
        // essa é consequencia da de cima que não soube fazer por conta do tempo.

        // aniversario nos meses 10 e 12
        funcionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12)
                .forEach(funcionario -> System.out.println(funcionario));

        // aqui ele vai buscar o mais velho da collection e comparar as datas de nascimento, se não houver, vai retornar uma exception de que não há um mais velho. Foi utilizada a exception por conta da lista.
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Funcionário mais velho é: " + maisVelho.getNome() + " e tem " + maisVelho.getDataNascimento().until(LocalDate.now()).getYears() + " anos");

        // nome dos funcionarios em ordem alfabética
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(funcionario -> System.out.println(funcionario));

        // o total dos salarios dos funcionarios
        BigDecimal totalSalarios = (BigDecimal) funcionarios.stream()
                .map(funcionario -> funcionario.getSalario())
                .reduce(BigDecimal.ZERO, (salario1, salario2) -> salario1.add(salario2));
        System.out.println("O total de salarios é: " + totalSalarios);

        // quantidade de salarios minimos de cada funcionario pela base de R$1212
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários minimos");
        });
    }
}
