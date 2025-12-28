package modelo;
import dto.VolumeInfo;

import java.util.Objects;
public class Livro {
    private String title;
    private String authors;
    private String publishedDate;


    public Livro(String title, String authors, String publishedDate) {
        this.title = title;
        this.authors = authors;
        this.publishedDate = publishedDate;

    }


    public String getAutor() {
        return authors;
    }

    public String getTitulo() {
        return title;
    }

    public String getDataLancamento() {return publishedDate;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return Objects.equals(title, livro.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, authors, publishedDate);
    }

    @Override
    public String toString() {
        return "Nome do livro: " + getTitulo() + " , autor : " + getAutor() + " ano: " + getDataLancamento();
    }



}
