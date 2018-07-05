package paciencia.model.baralho;

import java.util.Stack;

public class Fundacao implements Pilha {
	
	private Stack<Carta> pilha;
	private FileiraNo inicio, fim;
	private Verificador padrao, vazio;
	
	public Fundacao(){
		this.pilha = new Stack<Carta>();
	}

	@Override
	public boolean vazio() {
		if(this.pilha.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public Carta getCarta() {
		return this.pilha.pop();
	}

	@Override
	public boolean addCarta(Carta novaCarta) {
		if(vazio.verificar(novaCarta, this.pilha.peek())){
			this.pilha.push(novaCarta);
			return true;
		} else if (padrao.verificar(novaCarta, this.pilha.peek())){
			this.pilha.push(novaCarta);
			return true;
		}else
			return false;
	}

	@Override
	public boolean put() {
		// TODO Auto-generated method stub
		return false;
	}

}
