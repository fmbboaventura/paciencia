package paciencia.model.baralho;

/**
 * Representação de uma carata.
 *
 * @author Filipe Boaventura
 */
public class Carta implements Comparable {
    
    private final int valor;
    private final Naipe naipe;
    
    private boolean viradaParaCima;

    protected Carta(int valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
        this.viradaParaCima = false;
    }
    
    public int getValor() {
        return valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public boolean isViradaParaCima() {
        return viradaParaCima;
    }

    public void setViradaParaCima(boolean viradaParaCima) {
        this.viradaParaCima = viradaParaCima;
    }
    
    /**
     * Retora true se esta carta tiver a mesma cor que
     * a carta passador por argumento
     * @param c - A outra carta
     * @return - se as cartas tem a mesma cor
     */
    public boolean compararCor(Carta c) {
        return this.naipe.ehVermelho() == c.naipe.ehVermelho();
    }
    
    @Override
    /**
     * Compara cartas pelo valor
     * @param c
     * @return
     */
    public int compareTo(Object o) {
        if (!(o instanceof Carta)) 
            throw new IllegalArgumentException("O objeto nao eh uma carta!!");
        
        Carta c = (Carta) o;
        
        return (this.valor < c.valor) ? -1:
                (this.valor > c.valor) ? 1: 0;
    }

    @Override
    public String toString() {
        String nome = (valor == 11) ? " J":
                      (valor == 12) ? " Q":
                      (valor == 13) ? " K":
                      (valor == 10) ? "10":
                      (valor ==  1) ? " A":
                      " " + valor;
        return "[" + nome + " " + naipe.naipeString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        return this.naipe.equals(other.naipe) && this.valor == other.valor;
    }
    
    public enum Naipe {
        COPAS, OURO, PAUS, ESPADA;
        
        private boolean ehVermelho;
        
        static {
            COPAS.ehVermelho = true;
            OURO.ehVermelho = true;
            PAUS.ehVermelho = false;
            ESPADA.ehVermelho = false;
        }
        
        public boolean ehVermelho() {
            return ehVermelho;
        }
        
        public String naipeString() {
            String res = "";
            switch (this) {
                case COPAS: res = "♥"; break;
                case ESPADA: res = "♠"; break;
                case OURO: res = "♦"; break;
                case PAUS: res = "♣"; break;
            }
            return res;
        }
        
        /**
         * Retorna o próximo naipe em sequencia deste naipe.
         * @return
         */
        public Naipe proximo() {
            return this.ordinal() < Naipe.values().length - 1
                ? Naipe.values()[this.ordinal() + 1]
                : Naipe.values()[0];
        }
    }
}
