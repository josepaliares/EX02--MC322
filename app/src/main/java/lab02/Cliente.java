/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

/*
 * Bibliotecas utilizadas para manipular listas
 */
import java.util.ArrayList;
import java.util.List;

import lab02.exceptions.IngressoNaoEncontradoException;
import lab02.exceptions.CancelamentoNaoPermitidoException;

public class Cliente {

    private String nome;
    private String email;
    private List<Ingresso> ingressos;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     */
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.ingressos = new ArrayList<>();
    }

    /**
     * Retorna o nome do cliente
     * @return o nome do cliente
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do cliente
     */
    public void setNome(String nome){
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    /**
     * Retorna o email do cliente
     * @return o email do cliente
     */
    public String getEmail(){
        return email;
    }

    /**
     * Altera o email do cliente para `email` 
     * @param email o novo email do cliente
     */
    public void setEmail(String email){
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio.");
        }
        this.email = email;
    }

    /**
     * Retorna a lista de ingressos do cliente
     * @return a lista de ingressos do cliente
     */
    public List<Ingresso> getIngressos(){
        return ingressos;
    }
    /**
     * Adiciona um ingresso a lista de ingressos do cliente
     * @param ingresso o ingresso a ser adicionado
     */
    public void adicionarIngresso(Ingresso ingresso){
        ingressos.add(ingresso);
    }
    /**
     * Adiciona uma lista de ingressos a lista de ingressos do cliente
     * @param novosIngressos a lista de ingressos a serem adicionados
     */
    public void adicionarIngresso(List<Ingresso> novosIngressos) {
        ingressos.addAll(novosIngressos);
    }
    /**
     * Remove um ingresso da lista de ingressos do cliente
     * @param ingresso o ingresso a ser removido
     */
    public void removerIngresso(Ingresso ingresso){
        ingressos.remove(ingresso);
    }
    /**
     * Cancela um ingresso da lista de ingressos do cliente
     * @param evento o evento do ingresso a ser removido
     */
    public void cancelarIngresso(Evento evento) throws IngressoNaoEncontradoException, CancelamentoNaoPermitidoException {
        if (evento.ingressosRestantes == 0){ // Não são permitidos cancelamentos após o sold out
            throw new CancelamentoNaoPermitidoException("Cancelamento não permitido.");
        }
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getEvento().equals(evento)) {
                this.removerIngresso(ingresso);
                break;
            }
        }

        throw new IngressoNaoEncontradoException("Ingresso não encontrado.");

    }
}