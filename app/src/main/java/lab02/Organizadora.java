package lab02;

import java.util.List;

public class Organizadora {

    private String nome;
    private int cnpj;
    private String endereco;

    /**
     * Construtor da classe Organizadora
     * @param nome o nome da organizadora
     * @param cnpj o CNPJ da organizadora
     * @param endereco o endereço da organizadora
     */
    public Organizadora(String nome, int cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    /**
     * Retorna o nome da organizadora
     * @return o nome da organizadora
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o CNPJ da organizadora
     * @return o CNPJ da organizadora
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * Retorna o endereço da organizadora
     * @return o endereço da organizadora
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Cria um evento do tipo EventoFestival
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param data a data do evento
     * @param lineup a lista de artistas que se apresentarão no evento
     * @param duracao a duração do evento em horas
     * @return um evento do tipo EventoFestival
     */
    public EventoFestival criarEvento(String nome, Local local, double precoIngresso, String data, List<String> lineup, int duracao, int capacidade) {
        return new EventoFestival(nome, local, precoIngresso, this, data, capacidade, lineup, duracao);
    }
    /**
     * Cria um evento do tipo EventoJogo
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param data a data do evento
     * @param times a lista de times que se enfrentarão no evento
     * @return um evento do tipo EventoJogo
     */
    public EventoJogo criarEvento(String nome, Local local, double precoIngresso, String data, List<String> times, int capacidade) {
        return new EventoJogo(nome, local, precoIngresso, this, data, capacidade, times);
    }
    /**
     * Cria um evento do tipo EventoShow
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param data a data do evento
     * @param artista o artista que se apresentará no evento
     * @return um evento do tipo EventoShow
     */
    public EventoShow criarEvento(String nome, Local local, double precoIngresso, String data, String artista, int capacidade) {
        return new EventoShow(nome, local, precoIngresso, this, data, capacidade, artista);
    }
}
