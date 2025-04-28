/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

/*
 * Bibliotecas utilizadas para manipular listas
 */
import java.util.ArrayList;
import java.util.List;

import lab02.exceptions.CancelamentoNaoPermitidoException;
import lab02.exceptions.IngressoNaoEncontradoException;
import lab02.notifications.Notificavel;

public class Cliente implements Comparable<Cliente>{

    private String nome;
    private String email;
    private final List<Ingresso> ingressos;
    private final List<Notificavel> notificacoes;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     */
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.ingressos = new ArrayList<>();
        this.notificacoes = new ArrayList<>();
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
        // Se o ingresso não foi encontrado, lança uma exceção
        throw new IngressoNaoEncontradoException("Ingresso não encontrado.");

    }

    /**
     * Adiciona um canal de notificação ao cliente
     * @param notificacao o canal de notificação a ser adicionado
     */
    public void adicionarNotificacao(Notificavel notificacao) {
        this.notificacoes.add(notificacao);
    }
    /**
     * Envia uma notificação para todos os canais de notificação do cliente
     * @param mensagem a mensagem a ser enviada
     */
    public void enviarNotificacao(String mensagem) {
        for (Notificavel notificacao : notificacoes) {
            notificacao.exibirNotificacao(mensagem);
        }
    }

    /**
     * Compara este cliente com outro cliente
     * @param outroCliente o outro cliente a ser comparado
     * @return 0 se os clientes têm ingressos para o mesmo evento, -1 caso contrário
     */
    @Override
    public int compareTo(Cliente outroCliente) {        
        for (Ingresso ingresso : this.ingressos) {
            for (Ingresso outroIngresso : outroCliente.getIngressos()) {
                if (ingresso.getEvento().equals(outroIngresso.getEvento())) {
                    System.out.println("Os clientes têm ingressos para o mesmo evento: " + ingresso.getEvento().getNome());
                    return 0;  // Os clientes têm ingressos para o mesmo evento
                }
            }
        }
        System.out.println("Os clientes não têm ingressos para o mesmo evento.");
        return -1; // Os clientes não têm ingressos para o mesmo evento
    }
}