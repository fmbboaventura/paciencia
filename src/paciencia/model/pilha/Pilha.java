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
        if (!no.getCarta().isViradaParaCima()) return false;
        
        boolean ok = (this.vazio())
                ? this.verificadorVazio.verificar(this.fim, no)
                : this.verificadorPadrao.verificar(this.fim, no);

        if (ok) {
            no = seqDeCartas.removerNo(indice);
            if (this.vazio()) {
                this.inicio = no;
                this.fim = getFim(no);
                this.inicio.anterior = null;
                return true;
            } else {
                this.fim.proximo = no;
                no.anterior = this.fim;
                this.fim = getFim(no);
                return true;
            }
        } else {
            return false;
        }
    }
    
//    public boolean moverCarta(Pilha pilha) {
//        return moverCarta(pilha.fim, pilha);
//    }
    
//    private boolean moverCarta(PilhaNo no) {
//        if (!no.getCarta().isViradaParaCima()) return false;
//        
//        boolean ok = (this.vazio())
//                ? this.verificadorVazio.verificar(this.fim, no)
//                : this.verificadorPadrao.verificar(this.fim, no);
//
//        if (ok) {
//            if (this.vazio()) {
//                this.inicio = no;
//                this.fim = getFim(no);
//                this.inicio.anterior = null;
//                return true;
//            } else {
//                this.fim.proximo = no;
//                no.anterior = this.fim;
//                this.fim = getFim(no);
//                return true;
//            }
////            PilhaNo anterior = no.anterior;
////            no.anterior = this.fim;
////            this.fim = seqDeCartas.fim;
////            if (this.fim == null) this.inicio = this.fim;
////            seqDeCartas.fim = anterior;
////            if (seqDeCartas.fim == null) seqDeCartas.inicio = null;
////            else seqDeCartas.fim.getCarta().setViradaParaCima(true);
////            return true;
//        } else {
//            return false;
//        }
//    }

//    protected boolean put(Pilha p) {
//        if (this.vazio())
//    }

    protected PilhaNo removerNo(int index) {
        PilhaNo no = this.inicio;
        
        if (index >= this.tamanho()) 
                throw new IllegalArgumentException("indice maior que o tamanho da pilha");

        for (int i = 0; i < index; i++) {
            no = no.getProximo();
        }
        
        this.fim = no.getAnterior();
        no.setAnterior(null);
        if (this.fim == null) this.inicio = this.fim;
        else {
            this.fim.setProximo(null);
            this.fim.carta.setViradaParaCima(true);
        }
        return no;
    }
    
    protected PilhaNo getNo(int index) {
        PilhaNo no = this.inicio;
        
        if (index >= this.tamanho()) 
                throw new IllegalArgumentException("indice maior que o tamanho da pilha");

        for (int i = 0; i < index; i++) {
            no = no.getProximo();
        }

        return no;
    }
    
    protected PilhaNo getFim(PilhaNo no) {
        PilhaNo atual = no;
        while(atual.proximo != null) atual = atual.proximo;
        return atual;
    }
    
    public void addCarta(Carta c) {
        PilhaNo no = new PilhaNo(c);
        
        if(vazio()) {
            this.inicio = no;
            this.fim = this.inicio;
        } else {
            this.fim.proximo = no;
            no.anterior = this.fim;
            this.fim = this.fim.proximo;
        }
    }
    
    @Override
    public String toString() {
        if (vazio()) return "";
        String res = "";
        PilhaNo atual = this.inicio;
        
        while (atual != null) {
            res += (atual.carta.isViradaParaCima())?
                    atual.carta.toString(): "[";
            atual = atual.proximo;
        }
        
        return res;
    }

    public int tamanho() {
        if (vazio()) return 0;
        int tamanho = 0;
        PilhaNo no = inicio;
        while (no != null) {
            tamanho++;
            no = no.proximo;
        }
        return tamanho;
    }

    protected class PilhaNo {

        protected Carta carta;
        protected PilhaNo proximo;
        protected PilhaNo anterior;

        public PilhaNo(Carta c) {
            this.carta = c;
            this.proximo = null;
            this.anterior = null;
        }

        public Carta getCarta() {
            return carta;
        }

        public void setCarta(Carta c) {
            this.carta = c;
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
