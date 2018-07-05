package paciencia.model.pilha;

import paciencia.model.baralho.Carta;

public abstract class Pilha {
    
    protected Verificador verificadorPadrao;
    
    protected Verificador verificadorVazio;

    public abstract boolean vazio();
	
    public abstract Carta getCarta();
	
    /**
     * Método público para adicionar cartas à esta pilha.
     * Entidades externas utilização este método para inserir
     * cartas na pilha. Faz a verificação e delega a inserção
     * de fato para o método put.
     *
     * @param novaCarta
     * @return
     */
    public boolean addCarta(Carta novaCarta){
        boolean ok = (this.vazio())? 
            this.verificadorVazio.verificar(this.getCarta(), novaCarta):
            this.verificadorPadrao.verificar(this.getCarta(), novaCarta);
        
        if (ok) return this.put(novaCarta);
        else return false;
    }
	
    protected abstract boolean put(Carta c);
	
}
