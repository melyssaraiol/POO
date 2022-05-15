package atvpoo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question1 {
	static Scanner ler = new Scanner(System.in);
	static Pessoa[] pessoa = new Pessoa[3];
  	

  private static void inputNome(int i) throws InputMismatchException {
    System.out.println((i + 1)+ "º" + " Nome: ");
    pessoa[i].setNome(ler.next());
  }

  private static void inputIdade(int i) throws InputMismatchException {
    System.out.println((i + 1) + "º" + " Idade: ");
    pessoa[i].setIdade(ler.nextInt());
  }

  private static void inputCpf(int i) throws InputMismatchException {
    System.out.println((i + 1) + "º" + " CPF: ");
    pessoa[i].setCpf(ler.nextInt());
  }

  public static void main(String args[]) {
    for (int i = 0; i < 3; i++) {
      pessoa[i] = new Pessoa();

      try {
        inputNome(i);
        inputIdade(i);
        inputCpf(i);

      } catch (InputMismatchException e) {
        System.out.println("Insira um dado válido.");
        i -= 1;
      }
      ler.nextLine();
    }
    for (int i = 0; i < 3; i++) {
      System.out.println((i + 1) + "º" + " Nome:  " + pessoa[i].getNome());
      System.out.println((i + 1) + "º" + " Idade: " + pessoa[i].getIdade());
      System.out.println((i + 1) + "º" +" CPF: "+ pessoa[i].getCpf());

    }
  }

} 