package lab02.filters;

import lab02.Evento;

public class EventoPorPrecoFilter implements Filter<Evento> {
    private final double precoMaximo;

    public EventoPorPrecoFilter(double precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    @Override
    public boolean matches(Evento evento) {
        return evento.getPrecoIngresso() <= precoMaximo;
    }
}

