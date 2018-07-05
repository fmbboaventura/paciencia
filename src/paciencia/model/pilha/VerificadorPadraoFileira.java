package paciencia.model.pilha;

import paciencia.model.pilha.Pilha.Verificador;

public class VerificadorPadraoFileira extends Verificador{

    @Override
    protected boolean verificar(Pilha.PilhaNo carta1, Pilha.PilhaNo carta2) {
        return super.verificar(carta1, carta2) && 
                !carta2.getCarta().compararCor(carta1.getCarta()) && // Tem cores opostas?
                carta2.getCarta().getValor() < carta1.getCarta().getValor(); // Carta2 é menor?
    }
    
}
