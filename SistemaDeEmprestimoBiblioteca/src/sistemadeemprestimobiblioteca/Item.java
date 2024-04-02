package sistemadeemprestimobiblioteca;

/**
 *
 * @author Ana Paula
 */

import java.util.Scanner;


public abstract class Item {
    private static int lastId = 0; // variável de classe para rastrear o último ID usado
    private int id;
    private String titulo;
    private String editora;

    public Item(String titulo, String editora) {
        this.id = ++lastId; // incrementa automaticamente o ID
        setTitulo(titulo);
        setEditora(editora);
    }
   
    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }
    
    public String getEditora() {
        return this.editora;
    }

    public boolean setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
            return true;
        } else {
            return false;
        }
    }

    public boolean setEditora(String editora) {
        if (editora != null && !editora.isEmpty()) {
            this.editora = editora;
            return true;
        } else {
            return false;
        }
    }
    
    public void alterarItem() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a novo titulo do item:");
                setTitulo(s.nextLine());
        System.out.println("Digite a nova editora do item:");
                setEditora(s.nextLine());
        System.out.println("Item editado com sucesso!");
    }
    
    public void alterarItem(int opcao) {
        Scanner s = new Scanner(System.in);

        switch(opcao) {
            case 1:
                System.out.println("Digite o novo titulo do item:");
                setTitulo(s.nextLine());
                System.out.println("Título alterado com sucesso!");
                break;
            case 2:
                System.out.println("Digite a nova editora do item:");
                setEditora(s.nextLine());
                System.out.println("Editora alterada com sucesso!");
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }
    
    public String toString() {
      return "ID Item: "+getId()+" | "+
             "Titulo: "+getTitulo()+" | "+
             "Editora: "+getEditora();
    }


}
