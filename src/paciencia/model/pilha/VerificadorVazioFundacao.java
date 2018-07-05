package paciencia.model.pilha;

public class VerificadorVazioFundacao extends Pilha.Verificador{

    /**
     * Verifica a carta2 pode ser colocada no topo da carta1
     * Uma fundação vazia só aceita reis de qualquer naipe.
     * Qualquer outra carta retorna false.
     *
     * @param carta1
     * @param carta2
     * @return
     */
    @Override
    protected boolean verificar(Pilha.PilhaNo carta1, Pilha.PilhaNo carta2) {
        return super.verificar(carta1, carta2) 
                && carta2.proximo == null && // Fundações recebem apenas uma carta
                carta2.getCarta().getValor() == 1; // Fundações vazias recebem apenas Áses 
    }
    
}