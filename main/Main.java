package main;

import modelo.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca bibli = new Biblioteca();

        bibli.adicionarLivro("O barco", "Evelyn Costal", 2009);
        bibli.adicionarLivro("A Canoa", "Evelyn Costal", 2009);


        bibli.adicionarLivro("O barco", "Evelyn Costal", 2009);

        bibli.buscarLivroPorAutor("Evelyn Costal");

        bibli.buscarLivroPorTitulo("O navio");
    }
}