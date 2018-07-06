package paciencia.model.pilha;

import paciencia.model.baralho.Carta;

/**
 * Uma pilha de cartas capaz de representar as fileiras ou
 * fundações do jogo paciência. Pilhas podem receber Cartas
 * de outras Pilhas através do método 
 * {@linkplain #moverCarta(paciencia.model.pilha.Pilha, int) Paciencia.moverCarta(Pilha, int)}.
 * Pilhas precisam de {@linkplain Verificador Verificadores} para
 * avaliar se as cartas sendo inseridas com 
 * {@linkplain #moverCarta(paciencia.model.pilha.Pilha, int) Paciencia.moverCarta(Pilha, int)}
 * são válidas.
 * @author Filipe Boaventura
 */
public class Pilha {

    /**
     * {@linkplain Verificador} a ser usado quando esta Pilha não está vazia.
     */
    protected Verificador verificadorPadrao;

    /**
     * {@linkplain Verificador} a ser usado quando esta Pilha está vazia.
     */
    protected Verificador verificadorVazio;

    protected PilhaNo inicio;

    protected PilhaNo fim;
    
    public Pilha() {
        this.inicio = null;
        this.fim = null;
    }
    
    /**
     * Constrói uma {@linkplain Pilha} configurada
     * de acordo com o comportamento implemenado pelos seus
     * verificadores.
     *
     * @param vazio {@linkplain Verificador} de pilha vazia.
     * @param padrao {@linkplain Verificador} de pilha não vazia.
     */
    public Pilha(Verificador vazio, Verificador padrao) {
        this();
        this.verificadorPadrao = padrao;
        this.verificadorVazio = vazio;
    }

    public boolean vazio() {
        return this.inicio == null;
    }

    /**
     * Move uma sequencia de cartas da Pilha passada por argumento,
     * a partir do indice indicado, para esta pilha. As cartas 
     * sempre são inseridas no fim desta pilha.
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

    /**
     * Remove o nó especificado pelo indice.
     *
     * @param index
     * @return o {@linkplain PilhaNo no} removido
     */
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
    
    /**
     * Recupera o nó especificado pelo indice
     * @param index
     * @return o nó encontrado
     */
    protected PilhaNo getNo(int index) {
        PilhaNo no = this.inicio;
        
        if (index >= this.tamanho()) 
                throw new IllegalArgumentException("indice maior que o tamanho da pilha");

        for (int i = 0; i < index; i++) {
            no = no.getProximo();
        }

        return no;
    }
    
    /**
     * Retorna o ultimo nó em uma cadeia de nós.
     * @param no
     * @return
     */
    protected PilhaNo getFim(PilhaNo no) {
        PilhaNo atual = no;
        while(atual.proximo != null) atual = atual.proximo;
        return atual;
    }
    
    /**
     * Adiciona cartas à esta Pilha.
     * ATENÇÃO!! USE APENAS PARA INICIALIZAÇÃO!!!
     *
     * @param c carta a ser adcionada.
     */
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

    /**
     * Nó para a estrutura de dados duplamente encadeada
     * da {@linkplain Pilha}.
     */
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
    
    /**
     * Um Verificador é responsável por avaliar se 
     * uma carta pode ser inserida no topo de outra em uma {@linkplain Pilha}.
     */
    public static abstract class Verificador {

        /**
         * Avalia se carta2 pode ser colocada no topo de carta1.
         * A única condição avaliada por este verificador genérico é de
         * que a carta2 tem que estar virada para cima.
         *
         * @param carta1
         * @param carta2
         * @return se a carta2 pode ser inserida sobre a carta 1
         */
        protected boolean verificar(PilhaNo carta1, PilhaNo carta2) {
            return carta2.getCarta().isViradaParaCima();
        }

    }

}
