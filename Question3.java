package atvpoo;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Question3 {
    private static Scanner ler = new Scanner(System.in);
    private static int numPessoas;
    private static LinkedHashSet<Pessoa> pessoas = new LinkedHashSet<Pessoa>();

    private static void inputNumPessoas() throws InputMismatchException, NullPointerException {

        for (int x = 0; x < 1; x++) {
            try {
                System.out.println("Número de pessoas: ");
                numPessoas = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Informe um dado do tipo inteiro.");
                x -= 1;
            }
            ler.nextLine();
        }
    }

    private static Pessoa inputNome(int i, Pessoa pessoa) throws InputMismatchException {
        System.out.println((i + 1) + "º" + "Nome: ");
        pessoa.setNome(ler.nextLine());
        return pessoa;
    }

    private static Pessoa inputIdade(int i, Pessoa pessoa) throws InputMismatchException {
        System.out.println((i + 1) + "º" + "Idade: ");
        pessoa.setIdade(ler.nextInt());
        return pessoa;
    }

    private static Pessoa inputCpf(int i, Pessoa pessoa) throws InputMismatchException {
        System.out.println((i + 1) + "º" + "CPF: ");
        pessoa.setCpf(ler.nextInt());
        return pessoa;
    }

    private static boolean checkCpf(Pessoa pessoa) {
        boolean cpfY = true;

        Iterator<Pessoa> pessoasIterator = pessoas.iterator();
        if (pessoas.size() == 0) {
            cpfY = false;
        } else {
            while (pessoasIterator.hasNext()) {
                Pessoa p = pessoasIterator.next();
                if (p.getCpf() == pessoa.getCpf()) {
                    cpfY = true;
                } else {
                    cpfY = false;
                }
            }
        }
        return cpfY;
    }

    public static void main(String args[]) {

        inputNumPessoas();

        for (int i = 0; i < numPessoas; i++) {
            Pessoa pessoa = new Pessoa();
            try {
                inputCpf(i, inputIdade(i, inputNome(i, pessoa)));

                if (checkCpf(pessoa)) {
                    System.out.println("O CPF informado já foi cadastrado.");
                    System.out.println("TENTE NOVAMENTE");
                    i -= 1;
                } else {
                    pessoas.add(pessoa);
                }

            } catch (InputMismatchException e) {
                System.out.println("Insira um dado válido.");
                i -= 1;
            }
            ler.nextLine();
        }

        Iterator<Pessoa> pessoasIterator = pessoas.iterator();
        while (pessoasIterator.hasNext()) {
            Pessoa p = pessoasIterator.next();
            System.out.println("Nome:  " + p.getNome());
            System.out.println("Idade: " +p.getIdade());
            if (p.getCpf() != 0) {
                System.out.println("CPF: "+ p.getCpf());
            } else {
                System.out.println("null");
            }

        }
    }

}