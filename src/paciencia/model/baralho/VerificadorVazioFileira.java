package paciencia.model.baralho;

public class VerificadorVazioFileira implements Verificador{

	@Override
	//recebe um A se estiver vazio
		public boolean verificar(Carta carta1, Carta carta2) {
			/**
			 * if(carta2 == null && carta1.getValor() == 1)
			 * 		return true
			 * else
			 */
			return false;
		}

}
