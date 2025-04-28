package lab02.exceptions;

/**
 * Exceção lançada quando um evento não é encontrado.
 */
public class EventoNaoEncontradoException extends Exception {
    public EventoNaoEncontradoException(String message) {
        super(message);
    }
}
