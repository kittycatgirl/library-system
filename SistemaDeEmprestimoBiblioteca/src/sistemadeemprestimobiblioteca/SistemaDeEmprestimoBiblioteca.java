package sistemadeemprestimobiblioteca;

/**
 *
 * @author Ana Paula
 */

import controller.ControllerEmprestimo;
import controller.ControllerUsuario;
import java.util.Scanner;

public class SistemaDeEmprestimoBiblioteca {
    
    private static ControllerUsuario controllerUsuario = new ControllerUsuario();
    private static ControllerEmprestimo controllerEmprestimo = new ControllerEmprestimo();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

        // Cadastro de usuários
        Usuario usuario1 = new Usuario(1, "Josias", "02464024236");
        Usuario usuario2 = new Usuario(2, "Maria", "12389745620");
        controllerUsuario.cadastrarUsuario(usuario1);
        controllerUsuario.cadastrarUsuario(usuario2);

        // Cadastro de itens
        Livro livro1 = new Livro("Dom Casmurro", "Editora A", "Machado de Assis", "Romance", 1900, "0008469800941");
        Livro livro2 = new Livro("A Revolução dos Bichos", "Editora B", "George Orwell", "Ficcao Cientifica", 1945, "0002697580063");
        Revista revista1 = new Revista("Veja", "Editora C", "01/01/2024", 12345678);
        estoque.cadastrarItem(livro1);
        estoque.cadastrarItem(livro2);
        estoque.cadastrarItem(revista1);

        // Interagindo com o sistema
        int opcao;
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Exibir Estoque");
            System.out.println("2. Exibir Emprestimos Ativos");
            System.out.println("3. Emprestar Item");
            System.out.println("4. Cadastrar Novo Item");
            System.out.println("5. Alterar Item");
            System.out.println("6. Devolver Item");
            System.out.println("7. Renovar Emprestimo");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    estoque.exibirEstoque();
                    break;
                case 2:
                    controllerEmprestimo.itensEmprestados();
                    break;
                case 3:
                    emprestarItem(scanner, estoque);
                    break;
                case 4:
                    devolverItem(scanner, estoque);
                    break;
                case 5:
                    alterarInformacoesItem(scanner, estoque);
                    break;
                case 6:
                    cadastrarNovoItem(scanner, estoque);
                    break;
                case 7:
                    renovarEmprestimo(scanner, estoque);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 8);

        scanner.close();
    }

    public static void cadastrarNovoItem(Scanner scanner, Estoque estoque) {
        System.out.println("\n===== Cadastro de Novo Item =====");
        System.out.print("Digite o tipo de item (Livro/Revista): ");
        String tipoItem = scanner.nextLine();
        System.out.print("Digite o título do item: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a editora do item: ");
        String editora = scanner.nextLine();

        if (tipoItem.equalsIgnoreCase("Livro")) {
            System.out.print("Digite o autor do livro: ");
            String autor = scanner.nextLine();
            System.out.print("Digite o gênero do livro: ");
            String genero = scanner.nextLine();
            System.out.print("Digite o ano de publicação do livro: ");
            int anoPublicacao = scanner.nextInt();
            System.out.print("Digite o ISBN do livro: ");
            String isbn = scanner.nextLine();
            scanner.nextLine();
            Livro novoLivro = new Livro(titulo, editora, autor, genero, anoPublicacao, isbn);
            estoque.cadastrarItem(novoLivro);
        } else if (tipoItem.equalsIgnoreCase("Revista")) {
            System.out.print("Digite a data de publicação da revista (formato dia/mes/ano): ");
            String dataPublicacao = scanner.nextLine();
            System.out.print("Digite o ISSN da revista: ");
            int issn = scanner.nextInt();
            scanner.nextLine();
            Revista novaRevista = new Revista(titulo, editora, dataPublicacao, issn);
            estoque.cadastrarItem(novaRevista);
        } else {
            System.out.println("Tipo de item inválido!");
        }
    }
    
    public static void alterarInformacoesItem(Scanner scanner, Estoque estoque) {
    System.out.println("\n===== Alterar Informações de Item =====");
    System.out.print("Digite o ID do item que deseja alterar: ");
    int itemId = scanner.nextInt();
    scanner.nextLine();

    Item item = null;
    for (Item i : estoque.getItens()) {
        if (i.getId() == itemId) {
            item = i;
            break;
        }
    }

    if (item != null) {
        System.out.println("Deseja alterar todos as informacoes do item ou apenas um?");
        System.out.println("1. Todas");
        System.out.println("2. Apenas uma");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == 1) {
            if (item instanceof Livro) {
                ((Livro) item).alterarItem();
            } else if (item instanceof Revista) {
                ((Revista) item).alterarItem();
            } else {
                item.alterarItem();
            }
        } else if (escolha == 2) {
            if (item instanceof Livro) {
                System.out.println("Qual informacao deseja alterar?");
                System.out.println("1. Título");
                System.out.println("2. Editora");
                System.out.println("3. Autor");
                System.out.println("4. Genero");
                System.out.println("5. Ano Publicacao");
                System.out.println("6. ISBN");
                System.out.print("Escolha uma opcao: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                ((Livro) item).alterarItem(opcao);
            } else if (item instanceof Revista) {
                System.out.println("Qual informacao deseja alterar?");
                System.out.println("1. Título");
                System.out.println("2. Editora");
                System.out.println("3. Data Publicacao");
                System.out.println("4. ISSN");
                System.out.print("Escolha uma opcao: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                ((Revista) item).alterarItem(opcao);
            } else {
                System.out.println("Qual informacao deseja alterar?");
                System.out.println("1. Título");
                System.out.println("2. Editora");
                System.out.print("Escolha uma opcao: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                item.alterarItem(opcao);
            }
        } else {
            System.out.println("Opcao invalida!");
        }
    } else {
        System.out.println("Item não encontrado!");
    }
}

    public static void emprestarItem(Scanner scanner, Estoque estoque) {
        System.out.println("\n===== Emprestimo de Item =====");
        System.out.print("Digite o ID do usuário: ");
        int userId = scanner.nextInt();
        System.out.print("Digite o ID do item a ser emprestado: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        // Buscar usuário e item pelo ID
        Usuario usuario = null;
        for (Usuario u : controllerUsuario.getUsuarios()) {
            if (u.getId() == userId) {
                usuario = u;
                break;
            }
        }

        Item item = null;
        for (Item i : estoque.getItens()) {
            if (i.getId() == itemId) {
                item = i;
                break;
            }
        }

        if (usuario != null && item != null) {
            if (estoque.existeItem(item)) {
                controllerEmprestimo.emprestarItem(usuario, item, estoque);
            } else {
                System.out.println("Item não encontrado no estoque!");
            }
        } else {
            System.out.println("Usuário ou item não encontrado!");
        }
    }

    public static void devolverItem(Scanner scanner, Estoque estoque) {
        System.out.println("\n===== Devolução de Item =====");
        System.out.print("Digite o ID do usuário: ");
        int userId = scanner.nextInt();
        System.out.print("Digite o ID do item a ser devolvido: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        // Buscar usuário e item pelo ID
        Usuario usuario = null;
        for (Usuario u : controllerUsuario.getUsuarios()) {
            if (u.getId() == userId) {
                usuario = u;
                break;
            }
        }

        Item item = null;
        for (Item i : estoque.getItens()) {
            if (i.getId() == itemId) {
                item = i;
                break;
            }
        }

        if (usuario != null && item != null) {
            for (Emprestimo emprestimo : controllerEmprestimo.getEmprestimos()) {
                if (controllerEmprestimo.existeEmprestimo(item)) {
                    controllerEmprestimo.devolverItem(usuario, item, emprestimo);
                    break;
                }
            }
        } else {
            System.out.println("Usuário ou item não encontrado!");
        }
    }
    
     public static void renovarEmprestimo(Scanner scanner, Estoque estoque) {
        System.out.println("\n===== Renovação de Empréstimo =====");
        System.out.print("Digite o ID do usuário: ");
        int userId = scanner.nextInt();
        System.out.print("Digite o ID do item a ser renovado: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        // Buscar usuário e item pelo ID
        Usuario usuario = null;
        for (Usuario u : controllerUsuario.getUsuarios()) {
            if (u.getId() == userId) {
                usuario = u;
                break;
            }
        }

        Item item = null;
        for (Item i : estoque.getItens()) {
            if (i.getId() == itemId) {
                item = i;
                break;
            }
        }

        if (usuario != null && item != null) {
            for (Emprestimo emprestimo : controllerEmprestimo.getEmprestimos()) {
                if (controllerEmprestimo.existeEmprestimo(item)) {
                    System.out.print("Digite a nova data de fim do emprestimo (formato dd/MM/yyyy): ");
                    String novaDataFim = scanner.nextLine();
                    emprestimo.renovarEmprestimo(novaDataFim);
                    break;
                } else {
                    System.out.println("O item não foi encontrado nos emprestimos do usuario.");
                    }
        } 
        } else {
            System.out.println("Usuário ou item não encontrado!");
        }
    
    }
}

