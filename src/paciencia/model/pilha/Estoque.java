/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia.model.pilha;

import java.util.Stack;
import paciencia.model.baralho.Baralho;
import paciencia.model.baralho.Carta;

/**
 *
 * @author Filipe Boaventura
 */
public class Estoque {

    private final int cartasAVirar;
    private final int numCartas;
    
    private Stack<Carta> estoque;
    private Stack<Carta> descarte;
    
    public Estoque(Baralho b, int cartasAVirar, int numCartas) {
        this.cartasAVirar = cartasAVirar;
        this.numCartas = numCartas;
        
        this.estoque = new Stack<>();
        this.descarte = new Stack<>();
        
        for (int i = 0; i < this.numCartas; i++) {
            this.estoque.push(b.proximaCarta());
        }
    }
    
    public void virarCarta() {
        for (int i = 0; i < this.cartasAVirar; i++) 
            this.descarte.push(this.estoque.pop());
    }
    
    public void reempilhar() {
        while(!this.descarte.isEmpty())
            this.estoque.push(this.descarte.pop());
    }
    
    public Carta getCarta() {
        return this.descarte.pop();
    }
    
    // TODO: MÉTODO PARA VISUALIZAR AS CARTAS NO TOPO
}
