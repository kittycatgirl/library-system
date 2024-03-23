package sistemadeemprestimobiblioteca;

import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

class Livro extends Item {
    private String autor;
    private String genero;
    private int anoPublicacao;
    private int isbn; //International Standard Book Number/ Padrão Internacional de Numeração de Livro
    private static final List<String> GENEROS_PERMITIDOS = Arrays.asList("Romance", "Aventura", "Ficcaoo Cientifica", "Fantasia", "Policial", "Drama");


    public Livro(String titulo, String editora, String autor, String genero, int anoPublicacao, int isbn) {
        super(titulo, editora);
        setAutor(autor);
        setGenero(genero);
        setAnoPublicacao(anoPublicacao);
        setIsbn(isbn);
    }
     
   
    public String getAutor() {
        return this.autor;
    }
    
    public String getGenero() {
        return this.genero;
    }
    
    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public int getIsbn() {
        return this.isbn;
    }


    public boolean setAutor(String autor) {
        if (autor != null && !autor.isEmpty()) {
            this.autor = autor;
            return true;
        } else {
            return false;
        }
    }

    public boolean setGenero(String genero) {
        if (GENEROS_PERMITIDOS.contains(genero)) {
            this.genero = genero;
            return true;   
        } else {
            System.out.println("Genero inválido! Escolha um dos generos permitidos: " + GENEROS_PERMITIDOS);
            return false;   
        } 
    }

    public boolean setAnoPublicacao(int anoPublicacao) {
        if (anoPublicacao > 0 && anoPublicacao <= LocalDate.now().getYear()) {
            this.anoPublicacao = anoPublicacao;
            return true;
        } else {
            System.out.println("Ano de publicacao invalido! Deve ser um valor positivo e nao superior ao ano atual.");
            return false;
        }
    }
    
    public boolean setIsbn(int isbn) {
        if (isbn > 0) {
        String isbnStr = String.valueOf(isbn);
        if (isbnStr.length() == 13) {
            this.isbn = isbn;
            return true;
        } else {
            System.out.println("ISBN invalido! Deve ter exatamente 13 digitos.");
            return false;
        }
        } else {
            System.out.println("ISBN invalido! Deve ser um valor positivo.");
            return false;
        }
        
    }
    
    @Override
    public void alterarItem() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a novo titulo do livro:");
                setTitulo(s.nextLine());
        System.out.println("Digite a nova editora do livro:");
                setEditora(s.nextLine());
        System.out.println("Digite o novo autor do livro:");
                setAutor(s.nextLine());
        System.out.println("Digite o novo ano de publicacao do livro:");
                setAnoPublicacao(s.nextInt());
        System.out.println("Digite o novo ISBN do livro:");
                setIsbn(s.nextInt());
        System.out.println("Livro editado com sucesso!");
    }
    
    @Override
    public String toString() {
      return "ID: "+getId()+" | "+
             "Titulo: "+getTitulo()+" | "+
             "Editora: "+getEditora()+
             "Autor: "+getAutor()+" | "+
             "AnoPublicacao: "+getAnoPublicacao()+" | "+
             "ISBN: "+getIsbn();
    }

}

