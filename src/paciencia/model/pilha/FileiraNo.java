package paciencia.model.pilha;

import paciencia.model.baralho.Carta;

class FileiraNo {
    private Carta c;
    private FileiraNo proximo;
    private FileiraNo anterior;

    public FileiraNo(Carta c) {
        this.c = c;
        this.proximo = null;
        this.anterior = null;
    }

    public Carta getCarta() {
        return c;
    }

    public void setCarta(Carta c) {
        this.c = c;
    }

    public FileiraNo getProximo() {
        return proximo;
    }

    public void setProximo(FileiraNo proximo) {
        this.proximo = proximo;
    }

    FileiraNo getAnterior() {
        return this.anterior;
    }
}
