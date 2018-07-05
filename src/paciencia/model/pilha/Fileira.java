package paciencia.model.pilha;

import java.util.Stack;
import paciencia.model.baralho.Baralho;
import paciencia.model.baralho.Carta;

public class Fileira extends Pilha {

    private final Stack<Carta> reserva;
    private FileiraNo inicio;
    private FileiraNo fim;

    public Fileira(Baralho b, int numCartas) {
        this.reserva = new Stack<>();
        
        this.inicio = new FileiraNo(b.proximaCarta());
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

    @Override
    public boolean addCarta(Carta novaCarta) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean put(Carta c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
