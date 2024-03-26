package sistemadeemprestimobiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    
    private List<Item> itens = new ArrayList<>();
    
    public List<Item> getItens() {
        return itens;
    }

    public boolean existeItem(Item novoItem) {
    int novoId = novoItem.getId();
    for (Item item : itens) {
        if (item.getId() == novoId) {
            return true;
        }
    }
    return false;
    }

    public boolean cadastrarItem(Item item) {
        if (existeItem(item) == true) {
            System.out.println("ID ja encontrada no estoque, favor cadastrar item novamente com o ID certo.");
            return false;
        } else {
            itens.add(item);
            return true;
        }
    }

    public void excluirItem(Item item) {
        if (existeItem(item) == true) {
            itens.remove(item);
        } else {
           System.out.println("ID nao se encontra no Estoque."); 
        }
    }

    
    public void exibirEstoque() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Item item : itens) {
                System.out.println(item.toString());
            }
        }
    }

}
