/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Main {
    
    static Scanner scan = new Scanner(System.in);
    static Paciencia p = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(new Paciencia(1).toString());
        menuPrincipal();
    }
    
    public static void menuPrincipal() {
        System.out.println("♥♦♣♠ BEM VINDO AO PACIENCIA ♥♦♣♠");
        int opcao;
        do {
            System.out.println("Escolha uma Opcao...");
            System.out.println("1 - Iniciar jogo (vira 1 carta)");
            System.out.println("2 - Iniciar jogo (vira 3 cartas)");
            System.out.println("3 - Sair");
            
            opcao = scan.nextInt();
            
            switch (opcao) {
                case 1: 
                    p = new Paciencia(1);
                    iniciarJogo();
                    break;
                case 2: 
                    p = new Paciencia(3); 
                    iniciarJogo();
                    break;
                case 3: 
                    sair();
                    break;
            }
        } while (true);
    }

    private static void iniciarJogo() {
        int opcao;
        boolean fimDeJogo = false;
        do {
            System.out.println(p.toString());
            System.out.println("1 - Mover Carta");
            System.out.println(
                    (p.estoqueVazio())? 
                    "2 - Reempilhar Estoque" :
                    "2 - Virar Carta do Estoque"
            );
            System.out.println("3 - Sair");
            System.out.println("4 - Reiniciar");
            
            opcao = scan.nextInt();
            switch (opcao) {
                case 1: fimDeJogo = moverCarta(); break;
                case 2: 
                    if (p.estoqueVazio()) 
                        p.reempilharEstoque(); 
                    else p.virarCarta(); break;
                case 3: sair(); break;
                case 4: if (reiniciar()) return; break;
                default: System.out.println("Opcao Invalida!!"); break;
            }
        } while (!fimDeJogo);
        System.out.println("Parabéns! Vc ganhou!!");
    }

    private static void sair() {
        System.out.println("Ate Logo!!");
        System.exit(0);
    }

    private static boolean moverCarta() {
        System.out.println("Selecione a pilha de origem "
                + "(0 para selecionar a pilha de descarte)");
        int origem = scan.nextInt();
        
        System.out.println("Selecione a pilha de destino");
        int destino = scan.nextInt();
        
        if (origem > 4) {
            System.out.println("Selecione a carta a mover");
            int carta = scan.nextInt();

            try {
                if (!p.moverCarta(origem, destino, carta))
                    System.out.println("NAO PODE MOVER A CARTA!!!");
                return p.fimDeJogo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            try {
                if (!p.moverCarta(origem, destino))
                    System.out.println("NAO PODE MOVER A CARTA!!!");
                return p.fimDeJogo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
    
    private static boolean reiniciar() {
        int opcao;
        
        System.out.println("Reiniciar? (1 - sim, 0 - não)");
        opcao = scan.nextInt();
        return opcao == 1;
    }
    
}
