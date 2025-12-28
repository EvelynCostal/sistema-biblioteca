package main;

import modelo.Biblioteca;
import webService.ConsultaLivros;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Biblioteca bibli = new Biblioteca();
        ConsultaLivros consultaLivros = new ConsultaLivros();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Busque um livro: ");
        String livro = scanner.nextLine();

        bibli.adicionarLivro( consultaLivros.consultaLivros(livro));

    }
}