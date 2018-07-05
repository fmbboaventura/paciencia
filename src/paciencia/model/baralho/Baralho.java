/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia.model.baralho;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import paciencia.model.baralho.Carta.Naipe;

/**
 *
 * @author aluno
 */
public class Baralho {
    
    public List<Carta> cartas;
    private Iterator<Carta> iterator;
    
    /**
     *
     * @param count - Numero de baralhos (52 cartas/baralho})
     */
    public Baralho(int count) {
        if (count < 1) 
            throw new IllegalArgumentException("count deve ser maior que 0!!");
        this.cartas = new LinkedList<>();
        Naipe n = Naipe.COPAS;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                this.cartas.add(new Carta(j, n));
            }
            n = n.proximo();
        }
        
        for (int i = 0; i < count-1; i++) {
            this.cartas.addAll(this.cartas);
        }
        this.iterator = this.cartas.iterator();
    }
    
    public Baralho() {
        this(1);
    }
    
    public Carta proximaCarta() {
        return this.iterator.next();
    }
    
    public boolean temProximaCarta() {
        return this.iterator.hasNext();
    }
    
    public void embaralhar() {
        Collections.shuffle(this.cartas);
    }
}
