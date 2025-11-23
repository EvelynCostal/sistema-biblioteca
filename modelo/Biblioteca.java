package modelo;

import exception.LivroJaExisteException;
import exception.LivroNaoEncontradoException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class    Biblioteca {
    Map< String, Set<Livro>> autorlivroMap = new HashMap<>();
    Set<Livro> listaLivro = new HashSet<>();

    public void adicionarLivro(String titulo, String autor, int ano){
        Livro livro = new Livro(titulo, autor, ano);
        try {
            if (listaLivro.contains(livro)) {
                throw new LivroJaExisteException("O livro " + titulo + " já existe na biblioteca.");
            }
            listaLivro.add(livro);
            autorlivroMap.putIfAbsent(autor, new HashSet<>());
            autorlivroMap.get(autor).add(livro);
            System.out.println("modelo.Livro adicionado com sucesso!");

        } catch (LivroJaExisteException e){
            System.out.println(e.getMessage());
        }

    }

    public void buscarLivroPorTitulo(String titulo) {
        try {
            for (Livro livro : listaLivro) {
                if (livro.getTítulo().equalsIgnoreCase(titulo)) {
                    System.out.println("modelo.Livro encontrado: " + livro);
                    return;
                }
            }

            throw new LivroNaoEncontradoException("Nenhum livro encontrado com o título: " + titulo);
        }catch (LivroNaoEncontradoException e){
            System.out.println(e.getMessage());
        }


    }

    public void buscarLivroPorAutor(String autor){
        if(!autorlivroMap.containsKey(autor)){
            System.out.println("Não existe esse autor na nossa lista");
            return;
        }

        Set<Livro> livros =  autorlivroMap.get(autor);
        for (Livro livro : livros){
            System.out.println(livro.getTítulo());
        }
    }

    @Override
    public String toString() {
        return " listaLivro: " + listaLivro ;
    }
}