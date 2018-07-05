package paciencia.model.pilha;

import paciencia.model.baralho.Carta;

public class VerificadorPadraoFileira implements Verificador{

	@Override
	public boolean verificar(Carta carta1, Carta carta2) {
		/**
		 * Recebe cartas na ordem crescente e do mesmo naipe.
		 * if(carta1.compararCor(carta2) && carta1.getValor() - carta2.getValor() == 1)
			return true
		 */
		
		return false;
	}

}
