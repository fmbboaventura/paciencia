package paciencia.model.pilha;

import java.util.Stack;
import paciencia.model.baralho.Carta;

public class Fundacao extends Pilha {

    private final Stack<Carta> pilha;

    public Fundacao(Verificador vazio, Verificador padrao) {
        this.pilha = new Stack<>();
        this.verificadorPadrao = padrao;
        this.verificadorVazio = vazio;
    }

    @Override
    public boolean vazio() {
        return this.pilha.isEmpty();
    }

    @Override
    public Carta getCarta() {
        return this.pilha.pop();
    }

    @Override
    protected boolean put(Carta c) {
        Carta push = this.pilha.push(c);
        return c.equals(push);
    }

}
