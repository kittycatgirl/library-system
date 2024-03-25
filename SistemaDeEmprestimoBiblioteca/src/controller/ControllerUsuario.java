
package controller;

import java.util.ArrayList;
import java.util.List;
import sistemadeemprestimobiblioteca.Usuario;

/**
 *
 * @author Ana Paula
 */
public class ControllerUsuario {
    
    private List<Usuario> usuarios = new ArrayList<>();
    
    /**
     * Retorna todos os usuários cadastrados
     * @return List
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    /**
     * Exibe as informações de todos os usuários
     */
    public void exibirUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
    }

    /**
     * Verifica se o usuário informado está cadastrado
     * @param Usuario novoUsuario
     * @return boolean
     */
    public boolean existeUsuario(Usuario novoUsuario) {
        int novoId = novoUsuario.getId();
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == novoId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Executa o cadastro de um usuário
     * @param Usuario usuario
     * @return boolean
     */
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
