package paciencia.model.pilha;

import java.util.Stack;
import paciencia.model.baralho.Baralho;
import paciencia.model.baralho.Carta;

/**
 *
 * @author Filipe Boaventura
 * @deprecated Não usar
 */
@Deprecated
public class Fileira extends Pilha {

    private final Stack<Carta> reserva;

    public Fileira(Baralho b, int numCartas) {
        this.reserva = new Stack<>();
        
        this.inicio = new PilhaNo(b.proximaCarta());
        this.fim = this.inicio;
        
        for (int i = 1; i < numCartas; i++)
            this.reserva.push(b.proximaCarta());
    }

    @Override
    public boolean vazio() {
        return this.reserva.isEmpty() && this.inicio == null;
    }

    @Override
    public Carta getCarta() {
        Carta c = this.fim.getCarta();
        this.fim = this.fim.getAnterior();
        return null;
    }
}
