package sistemadeemprestimobiblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Emprestimo {
    private static int lastId = 0; // variável de classe para rastrear o último ID usado
    private int id;
    private String dataInicio;
    private String dataFim;
    private List<Item> itens = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Emprestimo(String dataInicio, String dataFim) {
        this.id = ++lastId; // incrementa automaticamente o ID
        setDataInicio(dataInicio);
        setDataFim(dataFim);
    }

    
    public int getId() {
        return id;
    }

    public String getDataInicio() {
        return dataInicio;
    }
    
     public String getDataFim() {
        return dataFim;
    }

    public boolean setDataInicio(String dataInicio) {
        String[] partes = dataInicio.split("/"); // Divide a string em partes usando "/" como delimitador
        
        if (partes.length != 3) {
           System.out.println("Data de Inicio invalida! Deve estar no formato dia/mes/ano."); // Verifica se a string foi dividida em três partes
        }
        
        try { // Tenta converter cada parte para um número inteiro
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]); 
            
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 0) {
                System.out.println("Data de Inicio invalida! Verifique os valores de dia, mes e ano."); // Verifica se os valores são válidos para dia, mês e ano
                return false;
            } else {
            this.dataInicio = dataInicio;
            return true;
            }
        } catch (NumberFormatException e) {
           System.out.println("Data de Inicio invalida! Certifique-se de que todos os componentes sao numeros.");
           return false;
        }
    }

    public boolean setDataFim(String dataFim) {
        String[] partes = dataFim.split("/"); // Divide a string em partes usando "/" como delimitador
        
        if (partes.length != 3) {
           System.out.println("Data Final invalida! Deve estar no formato dia/mes/ano."); // Verifica se a string foi dividida em três partes
        }
        
        try { // Tenta converter cada parte para um número inteiro
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]); 
            
        LocalDate novaDataFim = LocalDate.of(ano, mes, dia);

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicioLocalDate = LocalDate.parse(this.dataInicio, dataFormatada); //convertir a data para poder fazer a comparacao

        if (novaDataFim.isBefore(dataInicioLocalDate)) {
            System.out.println("Data Final invalida! A data final não pode ser antes da data de inicio.");
            return false;
        }
            
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 0) {
                System.out.println("Data Final invalida! Verifique os valores de dia, mes e ano."); // Verifica se os valores são válidos para dia, mês e ano
                return false;
            } else {
            this.dataFim = dataFim;
            return true;
            }
        } catch (NumberFormatException e) {
           System.out.println("Data Final invalida! Certifique-se de que todos os componentes sao numeros.");
           return false;
        }
    }

    

    public boolean emprestarItem(Usuario usuario, Item item, Estoque estoque) {
        Scanner s = new Scanner(System.in);
        int idItem = item.getId();
        
        System.out.println("Digite o ID do item que quer emprestar: ");
        idItem = s.nextInt();
        
        System.out.println("Digite a data de início do emprestimo (formato dd/MM/yyyy):");
        String dataInicio = s.next();

        System.out.println("Digite a data de fim do emprestimo (formato dd/MM/yyyy):");
        String dataFim = s.next();

        Emprestimo emprestimo = new Emprestimo(dataInicio, dataFim);
        
        if (estoque.existeItem(item) == false) {
        System.out.println("O item ja foi emprestado.");
        return false;
        } else {
        estoque.excluirItem(item);
        usuarios.add(usuario);
        itens.add(item);
        emprestimos.add(emprestimo);
        System.out.println("O item emprestado com sucesso.");
        return true;
    } 
    }

    public void devolverItem() {
    }

    public boolean renovarEmprestimo() {
        return true;
    }
}

