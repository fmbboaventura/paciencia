package paciencia.model.pilha;

public class VerificadorPadraoFundacao extends Pilha.Verificador {

    @Override
    /**
     * Avalia se carta2 pode ser colocada no topo de carta1. Fundações
     * recebem cartas em ordem crescente e do mesmo naipe.
     *
     * @param carta1
     * @param carta2
     * @return se a carta2 pode ser inserida sobre a carta 1
     */
    protected boolean verificar(Pilha.PilhaNo carta1, Pilha.PilhaNo carta2) {
        return super.verificar(carta1, carta2)
                && carta2.proximo == null
                && // Fundações recebem apenas uma carta
                carta2.getCarta().getNaipe().equals(carta1.getCarta().getNaipe())
                && // Tem o mesmo naipe?
                carta2.getCarta().getValor() == carta1.getCarta().getValor() + 1; // Carta2 é menor?
    }

}
