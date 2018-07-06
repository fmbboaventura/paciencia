package paciencia.model.pilha;

public class VerificadorPadraoFundacao extends Pilha.Verificador{

    @Override
    protected boolean verificar(Pilha.PilhaNo carta1, Pilha.PilhaNo carta2) {
        return super.verificar(carta1, carta2) && 
                carta2.proximo == null && // Fundações recebem apenas uma carta
                carta2.getCarta().getNaipe().equals(carta1.getCarta().getNaipe()) && // Tem o mesmo naipe?
                carta2.getCarta().getValor() == carta1.getCarta().getValor()+1; // Carta2 é menor?
    }
    
}
