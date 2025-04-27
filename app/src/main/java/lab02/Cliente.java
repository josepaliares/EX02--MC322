/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

/*
 * Bibliotecas utilizadas para manipular listas
 */
import java.util.ArrayList;
import java.util.List;

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
}