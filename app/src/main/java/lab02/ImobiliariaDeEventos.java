/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.List;

public class ImobiliariaDeEventos {
    
    private List<Local> locais;
    private String nome;


    /**
     * Construtor da classe ImobiliariaDeEventos
     * @param nome o nome da imobiliária de eventos
     */
    public ImobiliariaDeEventos(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona um local à lista de locais disponíveis
     * @param local o local a ser adicionado
     */
    public void adicionarLocal(Local local) {
        this.locais.add(local);
    }

    /**
     * Busca um local pelo nome
     * @param nome o nome do local
     * @return o local encontrado ou null se não encontrado
     */
    public Local buscarLocal(String nome) {
        for (Local local : locais) {
            if (local.getNome().equalsIgnoreCase(nome)) {
                return local;
            }
        }
        return null;
    }

    /**
     * Busca um local pela capacidade
     * @param capacidadeMaxima a capacidade do local
     * @return o local encontrado ou null se não encontrado
     */
    public Local buscarLocal(double capacidadeMaxima) {
        for (Local local : locais) {
            if (local.getCapacidade() == capacidadeMaxima) {
                return local;
            }
        }
        return null;
    }
}
