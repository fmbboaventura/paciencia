/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia.model.pilha;

import java.util.Iterator;
import java.util.Stack;
import paciencia.model.baralho.Baralho;
import paciencia.model.baralho.Carta;

/**
 * Classe responsável por implementar o comportamento da
 * pilha de estoque e descarte.
 * 
 * @author Filipe Boaventura
 */
public class Estoque {

    private final int cartasAVirar;
    private final int numCartas;
    
    private final Stack<Carta> estoque;
    private final Stack<Carta> descarte;
    
    public Estoque(Baralho b, int cartasAVirar, int numCartas) {
        this.cartasAVirar = cartasAVirar;
        this.numCartas = numCartas;
        
        this.estoque = new Stack<>();
        this.descarte = new Stack<>();
        
        for (int i = 0; i < this.numCartas; i++) {
            this.estoque.push(b.proximaCarta());
        }
    }
    
    /**
     * Remove uma carta do estoque e adciona no descarte.
     */
    public void virarCarta() {
        for (int i = 0; i < this.cartasAVirar; i++) {
            Carta pop = this.estoque.pop();
            pop.setViradaParaCima(true);
            this.descarte.push(pop);
        }
    }
    
    /**
     * Remove todas as cartas do descarte, inserindo-as
     * na pilha do estoque.
     */
    public void reempilhar() {
        while(!this.descarte.isEmpty()){
            Carta pop = this.descarte.pop();
            pop.setViradaParaCima(false);
            this.estoque.push(pop);
        }
    }
    
    /**
     * Remove uma carta da pilha de descarte.
     * @return - a carta removida.
     */
    public Carta getCarta() {
        return this.descarte.pop();
    }
    
    /**
     * Retorna, sem remover, a carta no topo da pilha de descarte
     * @return
     */
    public Carta peek() {
        return this.descarte.peek();
    }
    
    @Override
    public String toString() {
        String res = "";
        
        res = estoque.stream().map((_item) -> "[").reduce(res, String::concat);
        res += (res.equals("")) ? res : " <> ]";
        
        res = "ESTOQUE: " + res;
        
        String res2 = "";
        Iterator<Carta> it = descarte.iterator();
        for (int i = 0; i < descarte.size() - cartasAVirar; i++) {
            res2 += "[";
            it.next();
        }
        
        while (it.hasNext()) res2 += it.next().toString();
        
        res2 = "DESCARTE: " + res2;
        
        return res + "\n" + res2;
    }
    
    public boolean estoqueVazio() {
        return this.estoque.isEmpty();
    }
    
    public boolean descarteVazio() {
        return this.descarte.isEmpty();
    }
}
