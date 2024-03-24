
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sistemadeemprestimobiblioteca.Emprestimo;
import sistemadeemprestimobiblioteca.Estoque;
import sistemadeemprestimobiblioteca.Item;
import sistemadeemprestimobiblioteca.Usuario;

/**
 *
 * @author Ana Paula
 */
public class ControllerEmprestimo {
    
    private List<Emprestimo> emprestimos = new ArrayList<>();
    
    /**
     * Retorna a lista com todos os empréstimos ativos
     * @return List
     */
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    /**
     * Executa o empréstimo de um item para um usuário
     * @param Usuario usuario
     * @param Item item
     * @param Estoque estoque
     * @return boolean
     */
    public boolean emprestarItem(Usuario usuario, Item item, Estoque estoque) {
        Scanner s = new Scanner(System.in);
        if (existeEmprestimo(item) == true) {
            System.out.println("O item ja foi emprestado.");
            return false;
        } else if (estoque.existeItem(item) == false) {
            System.out.println("O item nao existe.");
            return false;
        } else {    
        System.out.println("Digite a data de início do emprestimo (formato dd/MM/yyyy):");
        String dataInicio = s.next();
        System.out.println("Digite a data de fim do emprestimo (formato dd/MM/yyyy):");
        String dataFim = s.next();
        Emprestimo emprestimo = new Emprestimo(dataInicio, dataFim);
            emprestimo.setUsuario(usuario);
            emprestimo.setItem(item);
            emprestimos.add(emprestimo);
            System.out.println("O item foi emprestado com sucesso.");
            return true;
        } 
    }

    /**
     * Executa a devolução de um item
     * @param Usuario usuario
     * @param Item item
     * @param Emprestimo emprestimo
     */
    public void devolverItem(Usuario usuario, Item item, Emprestimo emprestimo) {
        if (existeEmprestimo(item) == true) {
            emprestimos.remove(emprestimo);
            System.out.println("Item devolvido com sucesso."); 
        } else {
           System.out.println("ID nao se encontra entre os itens emprestados."); 
        }
    }
    
    /**
     * Verifica se o item selecionado está emprestado
     * @param Item novoItem
     * @return boolean
     */
    public boolean existeEmprestimo(Item novoItem) {
        int novoId = novoItem.getId();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getItem().getId() == novoId) {
                return true;
            }
        }
        return false;
    }
    
    public void itensEmprestados() {
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo.toString());
        }
}
}
