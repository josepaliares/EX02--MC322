import org.junit.jupiter.api.Test;

import lab02.Cliente;
import lab02.EventoEmBar;
import lab02.EventoMusicaAoVivo;
import lab02.EventoShow;
import lab02.Local;
import lab02.Organizadora;
import lab02.exceptions.CancelamentoNaoPermitidoException;
import lab02.exceptions.IngressoEsgotadoException;
import lab02.exceptions.IngressoNaoEncontradoException;
import lab02.notifications.EMail;



public class Lab02Test {

    
    @Test
    public void enviarNotificacao() {
        Cliente cliente = new Cliente("João", "joao@example.com");
        EMail email = new EMail("joao@example.com");
        cliente.adicionarNotificacao(email);
        cliente.enviarNotificacao("Seu ingresso para o Festival de Música foi confirmado!");
    }

    @Test
    public void comparaClientes() {
        Cliente cliente1 = new Cliente("João", "joao@example.com");
        Cliente cliente2 = new Cliente("Maria", "maria@example.com");
        Cliente cliente3 = new Cliente("Carlos", "carlos@example.com");
;       Local localShow = new Local("Casa do Rock", 1000);
        Organizadora organizadora = new Organizadora("Organizadora XYZ", 1234567890, "Rua ABC, 123");
        EventoShow eventoShow = new EventoShow("Show de Rock", localShow, 50.0, organizadora, "2023-10-01",
                                    1000, "Artista A");
        try {
            eventoShow.venderIngresso(cliente1);
            eventoShow.venderIngresso(cliente2);
        } catch (IngressoEsgotadoException | IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        cliente1.compareTo(cliente2);
        cliente1.compareTo(cliente3);
    }

    @Test
    public void eventosCaracteristicas() {
        EventoEmBar eventoEmBar = new EventoEmBar("Bar 01", "18h", "2h");
        EventoMusicaAoVivo eventoMusicaAoVivo = new EventoMusicaAoVivo("Artista A", "Rock");
        eventoEmBar.descricao();
        eventoMusicaAoVivo.descricao();
    }

    @Test
    public void trataErros(){
        Local local = new Local("Casa do Rock", 1000);
        Organizadora organizadora = new Organizadora("Organizadora XYZ", 1234567890, "Rua ABC, 123");
        EventoShow eventoShow = new EventoShow("Show de Rock", local, 50.0, organizadora, "2023-10-01",
                                    1000, "Artista A");
        Cliente cliente = new Cliente("João", "joao@example.com");
        eventoShow.setIngressosRestantes(0);
        try {
            eventoShow.venderIngresso(cliente);
        } catch (IngressoEsgotadoException | IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            cliente.cancelarIngresso(eventoShow);
        } catch (IngressoNaoEncontradoException | CancelamentoNaoPermitidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}