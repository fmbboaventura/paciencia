package paciencia.model.pilha;

import paciencia.model.baralho.Carta;

public class Pilha {

    protected Verificador verificadorPadrao;

    protected Verificador verificadorVazio;

    protected PilhaNo inicio;

    protected PilhaNo fim;
    
    public Pilha() {
        this.inicio = null;
        this.fim = null;
    }
    
    public Pilha(Verificador vazio, Verificador padrao) {
        this();
        this.verificadorPadrao = padrao;
        this.verificadorVazio = vazio;
    }

    public boolean vazio() {
        return this.inicio == null;
    }

    public Carta getCarta() {
        if (this.fim == null) return null;
        return this.fim.getCarta();
    }

    /**
     *
     * @param seqDeCartas
     * @param indice
     * @return
     */
    public boolean moverCarta(Pilha seqDeCartas, int indice) {
        
        PilhaNo no = seqDeCartas.getNo(indice);
        return moverCarta(no, seqDeCartas);
    }
    
    public boolean moverCarta(Pilha pilha) {
        return moverCarta(pilha.fim, pilha);
    }
    
    private boolean moverCarta(PilhaNo no, Pilha seqDeCartas) {
        if (!no.getCarta().isViradaParaCima()) return false;
        
        boolean ok = (this.vazio())
                ? this.verificadorVazio.verificar(this.fim, no)
                : this.verificadorPadrao.verificar(this.fim, no);

        if (ok) {
            PilhaNo anterior = no.anterior;
            no.anterior = this.fim;
            this.fim = seqDeCartas.fim;
            seqDeCartas.fim = anterior.anterior;
            seqDeCartas.fim.getCarta().setViradaParaCima(true);
            return true;
        } else {
            return false;
        }
    }

    //protected abstract boolean put(Pilha c);

    protected PilhaNo getNo(int index) {
        PilhaNo no = this.inicio;

        for (int i = 0; i < index; i++) {
            if (no == null) 
                throw new IllegalArgumentException("indice maior que o tamanho da pilha");
            no = no.getProximo();
        }

        return no;
    }
    
    public void addCarta(Carta c) {
        PilhaNo no = new PilhaNo(c);
        
        if(vazio()) {
            this.inicio = no;
            this.fim = this.inicio;
        } else {
            this.fim.proximo = no;
            this.fim = this.fim.proximo;
        }
    }

    protected class PilhaNo {

        protected Carta c;
        protected PilhaNo proximo;
        protected PilhaNo anterior;

        public PilhaNo(Carta c) {
            this.c = c;
            this.proximo = null;
            this.anterior = null;
        }

        public Carta getCarta() {
            return c;
        }

        public void setCarta(Carta c) {
            this.c = c;
        }

        public PilhaNo getProximo() {
            return proximo;
        }

        public void setProximo(PilhaNo proximo) {
            this.proximo = proximo;
        }

        public PilhaNo getAnterior() {
            return this.anterior;
        }
        
        public void setAnterior(PilhaNo anterior) {
            this.anterior = anterior;
        }
    }
    
    public static abstract class Verificador {

        protected boolean verificar(PilhaNo carta1, PilhaNo carta2) {
            return carta2.getCarta().isViradaParaCima();
        }

    }

}
