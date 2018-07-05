/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia;

import java.util.Stack;
import paciencia.model.baralho.Baralho;
import paciencia.model.baralho.Carta;
import paciencia.model.pilha.Estoque;

/**
 *
 * @author aluno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Baralho b = new Baralho(1);
//        
//        b.embaralhar();
//        for (Carta carta : b.cartas) {
//            System.out.println(carta.toString());
//        }
//        
//        Estoque e = new Estoque(b, 3, 24);
//        
//        System.out.println(e.toString());
//        e.virarCarta();
//        e.virarCarta();
//        System.out.println(e.toString());
        
        System.out.println(new Paciencia(1).toString());
    }
    
}
