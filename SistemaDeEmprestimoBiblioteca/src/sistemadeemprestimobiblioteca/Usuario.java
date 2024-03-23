package sistemadeemprestimobiblioteca;

import java.util.ArrayList;
import java.util.List;

class Usuario {
    private static int lastId = 0; // variável de classe para rastrear o último ID usado
    private int id;
    private String nome;
    private int cpf;
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario(int id, String nome, int cpf) {
        this.id = ++lastId; // incrementa automaticamente o ID
        setNome(nome);
        validacaoCpf(cpf);
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
    
    public int getCPF() {
        return this.cpf;
    }

    public boolean setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
            return true;
        } else {
            return false;
        }
    }

    public boolean validacaoCpf(int cpf) {
        if (cpf > 0) {
        String cpfStr = String.valueOf(cpf);
        if (cpfStr.length() == 11) {
            this.cpf = cpf;
            return true;
        } else {
            System.out.println("CPF invalido! Deve ter exatamente 11 digitos.");
            return false;
        }
        } else {
            System.out.println("CPF invalido! Deve ser um valor positivo.");
            return false;
        }
    }
    
    public void exibirUsuarios() {
    for (Usuario usuario : usuarios) {
        System.out.println("ID: " + usuario.getId()+ 
                           " | Nome: " + usuario.getNome()+
                           " | CPF: " + usuario.getCPF());
    }
}

    private boolean existeUsuario(Usuario novoUsuario) {
    int novoId = novoUsuario.getId();
    for (Usuario usuario : usuarios) {
        if (usuario.getId() == novoId) {
            return true;
        }
    }
    return false;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (existeUsuario(usuario) == true) {
            System.out.println("ID ja encontrada cadastrada, favor cadastrar usuario novamente com o ID certo.");
            return false;
        } else {
            usuarios.add(usuario);
            return true;
        }
    }
}
