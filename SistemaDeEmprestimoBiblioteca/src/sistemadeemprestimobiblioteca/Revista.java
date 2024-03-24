package sistemadeemprestimobiblioteca;

import java.util.Scanner;


class Revista extends Item {
    private String dataPublicacao;
    private int issn; //International Standard Serial Number / Número Internacional Normalizado das Publicações em Série

    public Revista(String titulo, String editora, String dataPublicacao, int issn) {
        super(titulo, editora);
        setDataPublicacao(dataPublicacao);
        setIssn(issn); 
    }

   
    public String getDataPublicacao() {
        return this.dataPublicacao;
    }

    public int getIssn() {
        return this.issn;
    }
    
    public boolean setDataPublicacao(String dataPublicacao) {
        String[] partes = dataPublicacao.split("/"); // Divide a string em partes usando "/" como delimitador
        
        if (partes.length != 3) {
           System.out.println("Data de publicacao invalida! Deve estar no formato dia/mes/ano."); // Verifica se a string foi dividida em três partes
        }
        
        try { // Tenta converter cada parte para um número inteiro
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]); 
            
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 0) {
                System.out.println("Data de publicacao invalida! Verifique os valores de dia, mes e ano."); // Verifica se os valores são válidos para dia, mês e ano
                return false;
            } else {
            this.dataPublicacao = dataPublicacao;
            return true;
            }
        } catch (NumberFormatException e) {
           System.out.println("Data de publicacao invalida! Certifique-se de que todos os componentes sao numeros.");
           return false;
        }
    }

    public boolean setIssn(int issn) {
        if (issn > 0) {
        String issnStr = String.valueOf(issn);
        if (issnStr.length() == 8) {
            this.issn = issn;
            return true;
        } else {
            System.out.println("ISSN invalido! Deve ter exatamente 8 digitos.");
            return false;
        }
        } else {
            System.out.println("ISSN invalido! Deve ser um valor positivo.");
            return false;
        }
    }
    
    @Override
    public void alterarItem() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a novo titulo da revista:");
                setTitulo(s.nextLine());
        System.out.println("Digite a nova editora da revista:");
                setEditora(s.nextLine());
        System.out.println("Digite a nova data de publicacao da revista:");
                setDataPublicacao(s.nextLine());
        System.out.println("Digite o novo ISSN da revista:");
                setIssn(s.nextInt());
        System.out.println("Revista editada com sucesso!");
    }
    
    @Override
    public String toString() {
      return "ID Revista: "+getId()+" | "+
             "Titulo: "+getTitulo()+" | "+
             "Editora: "+getEditora()+" | "+
             "Data de Publicacao: "+getDataPublicacao()+" | "+
             "ISSN: "+getIssn();
    }
}
