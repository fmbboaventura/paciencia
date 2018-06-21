/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia.model;

/**
 *
 * @author aluno
 */
public class Carta implements Comparable {
    
    private int valor;
    private Naipe naipe;
    
    public boolean compararCor(Carta c) {
        return this.naipe.ehVermelho() == c.naipe.ehVermelho();
    }
    
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Carta)) 
            throw new IllegalArgumentException("O objeto nao eh uma carta!!");
        
        Carta c = (Carta) o;
        
        return (this.valor < c.valor) ? -1:
                (this.valor > c.valor) ? 1: 0;
    }
    
    public enum Naipe {
        COPAS, OURO, PAUS, ESPADA;
        
        private boolean ehVermelho;
        
        static {
            COPAS.ehVermelho = true;
            OURO.ehVermelho = true;
            PAUS.ehVermelho = false;
            ESPADA.ehVermelho = false;
        }
        
        public boolean ehVermelho() {
            return ehVermelho;
        }
        
        public Naipe proximo() {
            return this.ordinal() < Naipe.values().length - 1
                ? Naipe.values()[this.ordinal() + 1]
                : Naipe.values()[0];
        }
    }
}
