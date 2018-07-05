package paciencia.model.baralho;

import java.util.Stack;

public class Fileira implements Pilha{
	
	private Stack<Carta> pilha;
	
	public Fileira(){
		this.pilha = new Stack<Carta>();
	}

	@Override
	public boolean vazio() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Carta getCarta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCarta(Carta novaCarta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean put() {
		// TODO Auto-generated method stub
		return false;
	}

}
