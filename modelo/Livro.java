package modelo;

import java.util.Objects;
public class Livro {
    private String titulo;
    private String autor;
    private int ano;


    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTítulo() {
        return titulo;
    }

    public void setTítulo(String título) {
        this.titulo = título;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return Objects.equals(titulo, livro.titulo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(titulo, autor, ano);
    }

    @Override
    public String toString() {
        return "Nome do livro: " + getTítulo() + " , autor : " + getAutor() + " ano: " + getAno();
    }



}
