package paciencia.model.baralho;

import java.util.Stack;

public class Pilha {
	
	private Verificador verificadorPadrao;
	private Verificador verificadorVazio;
	private Stack<Carta> pilha;
	
	public Pilha(){
		this.pilha = new Stack<Carta>();
	}

	public boolean vazio(){
		if(pilha.isEmpty())
			return true;
		else
			return false;
	}
	
	public Carta getCarta(){
		return this.pilha.pop();
	}
	
	public void addCarta(Carta novaCarta){
		if(this.put()){
			this.pilha.push(novaCarta);
		}
	}
	
	public boolean put(){
		return true;
	}
	
}
