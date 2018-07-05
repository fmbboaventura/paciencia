package paciencia.model.pilha;

public class VerificadorVazioFileira extends Pilha.Verificador{

    @Override
    protected boolean verificar(Pilha.PilhaNo carta1, Pilha.PilhaNo carta2) {
        return super.verificar(carta1, carta2) && 
                carta2.getCarta().getValor() == 13; // Fileiras vazias recebem apenas Rei 
    }
}