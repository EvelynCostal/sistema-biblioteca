import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Biblioteca {
    Map< String, String> autorlivroMap = new HashMap<>();
    Set<Livro> listaLivro = new HashSet<>();

    public void adicionarLivro(String titulo, String autor){
        Livro livro = new Livro(titulo, autor);
        listaLivro.add(livro);
        System.out.println(listaLivro);
        autorlivroMap.put(livro.getAutor(), livro.getTítulo());
        System.out.println(autorlivroMap);

    }

    public void buscarLivroPorTitulo(String titulo){
        if(listaLivro.contains(titulo)){
            System.out.println("Este livro esta na lista");
        };

    }

    public void buscarLivroPorAutor(String autor){
        System.out.println(autorlivroMap.get(autor));

        // teste
        System.out.println(autorlivroMap.get(autor).equals(autor));
    }
}
