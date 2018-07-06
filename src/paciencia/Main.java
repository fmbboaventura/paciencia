/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia;

import java.util.Scanner;
import java.util.Stack;
import paciencia.model.baralho.Baralho;
import paciencia.model.baralho.Carta;
import paciencia.model.pilha.Estoque;

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
        } while (opcao < 1 || opcao > 3);
        
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
    }

    private static void iniciarJogo() {
        int opcao = 0;
        do {
            System.out.println(p.toString());
            System.out.println("1 - Mover Carta");
            System.out.println(
                    (p.estoqueVazio())? 
                    "1 - Reempilhar Estoque" :
                    "2 - Virar Carta do Estoque"
            );
            System.out.println("3 - Sair");
            
            opcao = scan.nextInt();
            switch (opcao) {
                case 1: moverCarta(); break;
                case 2: 
                    if (p.estoqueVazio()) 
                        p.reempilharEstoque(); 
                    else p.virarCarta(); break;
                case 3: sair(); break;
                default: System.out.println("Opcao Invalida!!"); break;
            }
        } while (true);
    }

    private static void sair() {
        System.out.println("Ate Logo!!");
        System.exit(0);
    }

    private static void moverCarta() {
        
    }
    
}
