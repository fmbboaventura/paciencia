package paciencia.model.baralho;

public interface Pilha {

	public boolean vazio();
	
	public Carta getCarta();
	
	public boolean addCarta(Carta novaCarta);
	
	public boolean put();
	
}
