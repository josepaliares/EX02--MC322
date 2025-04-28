/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.List;

import lab02.exceptions.CancelamentoNaoPermitidoException;
import lab02.exceptions.CapacidadeInsuficienteException;
import lab02.exceptions.IngressoEsgotadoException;
import lab02.exceptions.IngressoNaoEncontradoException;
import lab02.exceptions.LocalIndisponivelException;
import lab02.filters.EventoPorLocalFilter;
import lab02.filters.EventoPorNomeFilter;
import lab02.filters.EventoPorPrecoFilter;
import lab02.filters.Filter;
import lab02.notifications.EMail;

/**
 * Contém a estrutura de implementação da aplicação.
 * 
 * @author NOME - RA
 */
public class App {

    /**
     * Aplicação principal
     * 
     * @param args
     */
    public static void main(String[] args) {

        Local localShow = new Local("Casa do Rock", 1000);
        Local localJogo = new Local("Estádio Municipal", 50000);
        Local localFestival = new Local("Parque da Cidade", 20000);

        Organizadora organizadora = new Organizadora("Organizadora XYZ", 1234567890, "Rua ABC, 123");

        // Criação de objetos utilizando sobrecarga
        EventoShow eventoShow = new EventoShow("Show de Rock", localShow, 50.0, organizadora, "2023-10-01",
                1000, "Artista A");
        EventoJogo eventoJogo = new EventoJogo("Jogo de Futebol", localJogo, 30.0, organizadora, "2023-10-02",
                2000, List.of("Time A", "Time B"));
        EventoFestival eventoFestival = new EventoFestival("Festival de Música", localFestival, 20.0, organizadora,
                "2023-10-03",
                15000, List.of("Artista A", "Artista B"), 3);

        organizadora.adicionarEvento(eventoShow);
        organizadora.adicionarEvento(eventoJogo);
        organizadora.adicionarEvento(eventoFestival);

        Local localNovo = new Local("Teatro Municipal", 500);

        // Alocação de locais tratando exceções
        try {
            localNovo.alocarParaEvento(eventoShow);
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            localJogo.alocarParaEvento(eventoShow);
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        
        
        // Venda de ingressos tratando exceções
        eventoShow.setIngressosRestantes(0);
        Cliente cliente = new Cliente("João", "joao@example.com");
        try {
            eventoShow.venderIngresso(cliente);
        } catch (IllegalArgumentException | IngressoEsgotadoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        
        // Cancelamento de ingressos tratando exceções
        try {
            eventoFestival.venderIngresso(cliente);
        } catch (IllegalArgumentException | IngressoEsgotadoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        eventoFestival.setIngressosRestantes(0);
        try {
            cliente.cancelarIngresso(eventoFestival);
        } catch (IngressoNaoEncontradoException | CancelamentoNaoPermitidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            cliente.cancelarIngresso(eventoJogo);
        } catch (IngressoNaoEncontradoException | CancelamentoNaoPermitidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Utilização das sobrecargas dos métodos de busca
        String nomeDoEvento = "Show de Rock";
        String localDoEvento = "Parque da Cidade";
        double precoMaximo = 35.0;
        Filter<Evento> filtroPorNome = new EventoPorNomeFilter(nomeDoEvento);
        Filter<Evento> filtroPorLocal = new EventoPorLocalFilter(localDoEvento);
        Filter<Evento> filtroPorPreco = new EventoPorPrecoFilter(precoMaximo);

        List<Evento> eventosEncontradosPorNome = organizadora.buscarEventos(filtroPorNome);

        System.out.println("Eventos encontrados com o nome '" + nomeDoEvento + "':");
        for (Evento evento : eventosEncontradosPorNome) {
            System.out.println(evento.getNome());
        }

        List<Evento> eventosEncontradosPorLocal = organizadora.buscarEventos(filtroPorLocal);

        System.out.println("Eventos encontrados no local '" + localDoEvento + "':");
        for (Evento evento : eventosEncontradosPorLocal) {
            System.out.println(evento.getNome());
        }

        List<Evento> eventosEncontradosPorPreco = organizadora.buscarEventos(filtroPorPreco);

        System.out.println("Eventos encontrados com o ingresso por menos de R$" + precoMaximo + ":");
        for (Evento evento : eventosEncontradosPorPreco) {
            System.out.println(evento.getNome());
        }

        // Demonstração da classe de notificação email
        EMail email = new EMail("joao@example.com");
        cliente.adicionarNotificacao(email);
        cliente.enviarNotificacao("Seu ingresso para o Festival de Música foi confirmado!");

        // Comparação entre clientes com os dois cenários de possuirem ingressos para o mesmo evento
        Cliente cliente2 = new Cliente("Maria", "maria@example.com");
        Cliente cliente3 = new Cliente("Carlos", "carlos@example.com");
        eventoFestival.setIngressosRestantes(5);
        try {
            eventoFestival.venderIngresso(cliente2);
            eventoJogo.venderIngresso(cliente3);
        } catch (IllegalArgumentException | IngressoEsgotadoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        cliente.compareTo(cliente2);
        cliente.compareTo(cliente3);
    }
}
