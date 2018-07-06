/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia;

import java.util.LinkedList;
import java.util.List;
import paciencia.model.baralho.Baralho;
import paciencia.model.baralho.Carta;
import paciencia.model.pilha.Estoque;
import paciencia.model.pilha.Pilha;
import paciencia.model.pilha.Pilha.Verificador;
import paciencia.model.pilha.VerificadorPadraoFileira;
import paciencia.model.pilha.VerificadorPadraoFundacao;
import paciencia.model.pilha.VerificadorVazioFileira;
import paciencia.model.pilha.VerificadorVazioFundacao;

/**
 *
 * @author Filipe Boaventura
 */
public class Paciencia {
    private final Baralho baralho;
    private final Estoque estoque;
    private final List<Pilha> pilhas;
    
    private final int numBaralhos;
    
    public Paciencia(int cartasAvirar) {
        this.numBaralhos = 1;
        this.baralho = new Baralho(numBaralhos);
        this.baralho.embaralhar();
        this.estoque = new Estoque(baralho, cartasAvirar, 24);
        this.pilhas = new LinkedList<>();
        
        Verificador fundacaoPadrao = new VerificadorPadraoFundacao();
        Verificador fundacaoVazio = new VerificadorVazioFundacao();
        
        Verificador fileiraPadrao = new VerificadorPadraoFileira();
        Verificador fileiraVazio = new VerificadorVazioFileira();
        
        for (int i = 0; i < 4; i++) {
            Pilha p = new Pilha(fundacaoVazio, fundacaoPadrao);
            pilhas.add(p);
        }
        
        for (int i = 0; i < 7; i++) {
            Pilha p = new Pilha(fileiraVazio, fileiraPadrao);
            
            Carta proximaCarta = null;
            for (int j = 0; j < i+1; j++) {
                proximaCarta = this.baralho.proximaCarta();
                p.addCarta(proximaCarta);
            }
            proximaCarta.setViradaParaCima(true);
            this.pilhas.add(p);
        }
    }
    
    public boolean moverCarta(int orig, int dest, int carta) {
        if (dest == 0) 
            throw new IllegalArgumentException("Não pode mover pro descarte!");
        
        if (orig == dest)
            throw new IllegalArgumentException("origem e destino não podem ser iguais!!");
        
        if (orig ==  0) {
            if (this.estoque.descarteVazio())
                throw new IllegalArgumentException("Pilha de Origem Vazia!!!");
            dest--;
            Carta c = this.estoque.peek();
            Pilha temp = new Pilha();
            temp.addCarta(c);
            
            boolean moveu = pilhas.get(dest).moverCarta(temp, 0);
            if (moveu) this.estoque.getCarta();
            return moveu;
        } else {
            orig--;
            dest--;
            Pilha origem = this.pilhas.get(orig);
            Pilha destino = this.pilhas.get(dest);
            
            if (origem.vazio())
                throw new IllegalArgumentException("Pilha de Origem Vazia!!!");
            
            return destino.moverCarta(origem, (orig > 4) ?  carta: origem.tamanho()-1);
        }
    }
    
    @Override
    public String toString() {
        String res = estoque.toString() + "\n";
        
        for (int i = 0; i < 4; i++) {
            res += (i+1) + " - FUNDACAO: " + this.pilhas.get(i).toString() + "\n";
        }
        
        for (int i = 4; i < this.pilhas.size(); i++) {
            res += (i+1) + " - FILEIRA: " + this.pilhas.get(i).toString() + "\n";
        }
        
        return res;
    }

    void virarCarta() {
        estoque.virarCarta();
    }
    
    boolean estoqueVazio() {
        return estoque.estoqueVazio();
    }

    void reempilharEstoque() {
        estoque.reempilhar();
    }

    boolean moverCarta(int origem, int destino) {
        return this.moverCarta(origem, destino, 0);
    }
}
