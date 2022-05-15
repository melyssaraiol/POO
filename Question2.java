package atvpoo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question2 {

    private static Scanner ler = new Scanner(System.in);
    private static int numPessoas;
   
    private static void inputNumPessoas() throws InputMismatchException, NullPointerException {

        for (int x = 0; x < 1; x++) {
            try {
                System.out.println("Número de pessoas: ");
                numPessoas = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Insira um dado do tipo inteiro.");
                x -= 1;
            }
            ler.nextLine();
        }
    }

    private static void inputNome(int i, Pessoa[] pessoas) throws InputMismatchException {
        System.out.println((i + 1)+ "º" + " Nome: ");
        pessoas[i].setNome(ler.nextLine());
    }

    private static void inputIdade(int i, Pessoa[] pessoas) throws InputMismatchException {
        System.out.println((i + 1) + "º" + " Idade: ");
        pessoas[i].setIdade(ler.nextInt());
    }

    private static void inputCpf(int i, Pessoa[] pessoas) throws InputMismatchException {
        System.out.println((i + 1) + "º" + " CPF: ");
        pessoas[i].setCpf(ler.nextInt());
    }

    private static void lerPessoas(int i, Pessoa[] pessoas) {
        inputNome(i, pessoas);
        inputIdade(i, pessoas);
        inputCpf(i, pessoas);
    }

    private static void mostrarPessoas(int i, Pessoa[] pessoas) {
    	System.out.println((i + 1) + "º" + " Nome:  " + pessoas[i].getNome());
        System.out.println((i + 1) + "º" + " Idade: " + pessoas[i].getIdade());
        System.out.println((i + 1) + "º" +" CPF: "+ pessoas[i].getCpf());

    }

    public static void main(String args[]) {
        inputNumPessoas();
        Pessoa[] pessoas = new Pessoa[numPessoas];

        for (int i = 0; i < numPessoas; i++) {
            pessoas[i] = new Pessoa();
            try {
                lerPessoas(i, pessoas);

            } catch (InputMismatchException e) {
                System.out.println("Insira um dado válido.");
                i -= 1;
            }
            ler.nextLine();
        }
        for (int i = 0; i < numPessoas; i++) {
            mostrarPessoas(i, pessoas);
        }
    }

}

