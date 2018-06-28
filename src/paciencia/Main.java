/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia;

import paciencia.model.baralho.Baralho;
import paciencia.model.baralho.Carta;

/**
 *
 * @author aluno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Baralho b = new Baralho(1);
        System.out.println(b.cartas.size());
        for (Carta carta : b.cartas) {
            System.out.println(carta.toString());
        }
        
        b.embaralhar();
        for (Carta carta : b.cartas) {
            System.out.println(carta.toString());
        }
    }
    
}
