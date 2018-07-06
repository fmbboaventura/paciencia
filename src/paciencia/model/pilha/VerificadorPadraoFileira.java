package paciencia.model.pilha;

import paciencia.model.pilha.Pilha.Verificador;

public class VerificadorPadraoFileira extends Verificador {

    @Override
    /**
     * Avalia se carta2 pode ser colocada no topo de carta1. Fileiras
     * não vazias recebem cartas menores e com cores opostas.
     *
     * @param carta1
     * @param carta2
     * @return se a carta2 pode ser inserida sobre a carta 1
     */
    protected boolean verificar(Pilha.PilhaNo carta1, Pilha.PilhaNo carta2) {
        return super.verificar(carta1, carta2)
                && !carta2.getCarta().compararCor(carta1.getCarta())
                && // Tem cores opostas?
                carta2.getCarta().getValor() == carta1.getCarta().getValor() - 1; // Carta2 é menor?
    }

}
