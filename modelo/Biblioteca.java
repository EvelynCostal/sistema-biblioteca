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

    public void adicionarLivro(Livro livro){
        try {
            if (listaLivro.contains(livro)) {
                throw new LivroJaExisteException("O livro " + livro.getTitulo() + " já existe na biblioteca.");
            }
            listaLivro.add(livro);
            autorlivroMap.putIfAbsent(livro.getAutor(), new HashSet<>());
            autorlivroMap.get(livro.getAutor()).add(livro);
            System.out.println("Livro adicionado com sucesso!");
            System.out.println(livro);

        } catch (LivroJaExisteException e){
            System.out.println(e.getMessage());
        }

    }

    public void buscarLivroPorTitulo(String titulo) {
        try {
            for (Livro livro : listaLivro) {
                System.out.println(livro);
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("Livro encontrado: " + livro);
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
            System.out.println(livro.getTitulo());
        }
    }

    @Override
    public String toString() {
        return " listaLivro: " + listaLivro ;
    }
}