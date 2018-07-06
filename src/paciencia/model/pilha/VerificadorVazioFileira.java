package paciencia.model.pilha;

/**
 * Implementa a política de verificação para Fileiras vazias.
 *
 * @author Filipe Boaventura
 */
public class VerificadorVazioFileira extends Pilha.Verificador {

    @Override
    /**
     * Avalia se carta2 pode ser colocada no topo de carta1. 
     * Fileiras vazias só aceitam Reis.
     * virada para cima.
     *
     * @param carta1
     * @param carta2
     * @return se a carta2 é um rei.
     */
    protected boolean verificar(Pilha.PilhaNo carta1, Pilha.PilhaNo carta2) {
        return super.verificar(carta1, carta2)
                && carta2.getCarta().getValor() == 13; // Fileiras vazias recebem apenas Rei 
    }
}
