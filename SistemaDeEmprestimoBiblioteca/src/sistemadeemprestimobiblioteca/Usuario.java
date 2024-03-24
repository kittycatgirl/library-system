package sistemadeemprestimobiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private static int lastId = 0; // variável de classe para rastrear o último ID usado
    private int id;
    private String nome;
    private String cpf;

    public Usuario(int id, String nome, String cpf) {
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
    
    public String getCPF() {
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

    public boolean validacaoCpf(String cpf) {
        if (cpf.length() == 11) {
            this.cpf = cpf;
            return true;
        } else {
            System.out.println("CPF invalido! Deve ter exatamente 11 digitos.");
            return false;
        }
        
    }
    
    public String toString() {
      return "ID Usuario: " + getId()+ 
             " | Nome: " + getNome()+
             " | CPF: " + getCPF();
 }
}
