package paciencia.model.pilha;

public class Fundacao extends Pilha {

    @Deprecated
    public Fundacao(Verificador vazio, Verificador padrao) {
        this.verificadorPadrao = padrao;
        this.verificadorVazio = vazio;
        
        this.inicio = null;
        this.fim = null;
    }
}
