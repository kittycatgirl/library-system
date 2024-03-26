package sistemadeemprestimobiblioteca;

import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

class Livro extends Item {
    private String autor;
    private String genero;
    private int anoPublicacao;
    private String isbn; //International Standard Book Number/ Padrão Internacional de Numeração de Livro
    private static final List<String> GENEROS_PERMITIDOS = Arrays.asList("Romance", "Aventura", "Ficcao Cientifica", "Fantasia", "Policial", "Drama");


    public Livro(String titulo, String editora, String autor, String genero, int anoPublicacao, String isbn) {
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

    public String getIsbn() {
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
        } else if (anoPublicacao < 0) {
            System.out.println("Ano de publicacao invalido! Deve ser um valor positivo e nao superior ao ano atual.");
            return false;
        } else {
        System.out.println("Ano de publicacao invalido! Certifique-se de inserir um número inteiro.");
        return false;
        }
    }
    
    public boolean setIsbn(String isbn) {
        if (!isbn.isEmpty()) {
        if (isbn.length() == 13) {
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
        System.out.println("Digite o novo genero do livro:");
                setGenero(s.nextLine());
        System.out.println("Digite o novo ano de publicacao do livro:");
                setAnoPublicacao(s.nextInt());
        System.out.println("Digite o novo ISBN do livro:");
                setIsbn(s.next());
        System.out.println("Livro editado com sucesso!");
    }
    
    @Override
    public void alterarItem(int opcao) {
        Scanner s = new Scanner(System.in);

        switch(opcao) {
            case 1:
                System.out.println("Digite o novo titulo do livro:");
                setTitulo(s.nextLine());
                System.out.println("Título alterado com sucesso!");
                break;
            case 2:
                System.out.println("Digite a nova editora do livro:");
                setEditora(s.nextLine());
                System.out.println("Editora alterada com sucesso!");
                break;
            case 3:
                System.out.println("Digite o novo autor do livro:");
                setAutor(s.nextLine());
                System.out.println("Autor alterado com sucesso!");
                break;
            case 4:
                System.out.println("Digite o novo genero do livro:");
                setGenero(s.nextLine());
                System.out.println("Genero alterado com sucesso!");
                break;
            case 5:
                System.out.println("Digite o novo ano de publicacao do livro:");
                setAnoPublicacao(s.nextInt());
                System.out.println("Ano de publicacao alterado com sucesso!");
                break;
            case 6:
                System.out.println("Digite o novo ISBN do livro:");
                setIsbn(s.next());
                System.out.println("ISBN alterada com sucesso!");
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }
    
    @Override
    public String toString() {
      return "ID Livro: "+getId()+" | "+
             "Titulo: "+getTitulo()+" | "+
             "Editora: "+getEditora()+" | "+
             "Autor: "+getAutor()+" | "+
             "Genero: "+getAnoPublicacao()+" | "+
             "AnoPublicacao: "+getAnoPublicacao()+" | "+
             "ISBN: "+getIsbn();
    }

}

