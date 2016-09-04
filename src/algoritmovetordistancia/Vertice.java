/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmovetordistancia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 10070128
 */
// implementa a interface runnable
public class Vertice implements Runnable {
    String nome;
    List<Aresta> vizinhos;
    boolean alterouRotas;
    
    // construtor com o nome do vértice
    public Vertice(String nome) { 
        this.nome=nome;
        this.vizinhos = new ArrayList();
        
    }
    
    public Vertice(String nome, List<Aresta> vizinhos) {
        this.nome = nome;
        this.vizinhos = vizinhos;
    }
    
    public void addArestas(Aresta... vizinho) {
        this.vizinhos.addAll(Arrays.asList(vizinho));
        this.alterouRotas = true;
    }
    
    public void calcularRota( List<Aresta> vizinhos) throws InterruptedException{
        // Aqui vai a lógica do calculo das rotas
        // Abaixo é só um teste para ver funcionando as chamadas das threads:
        for (int i=0; i<vizinhos.size();i++){
            if(vizinhos.get(i).vizinho.alterouRotas){
                Thread.sleep(10000);
                System.out.println("Calculando rota de: "+ this.nome+" até: "+vizinhos.get(i).vizinho.nome);
            }
        }
        
    }
    //método chamado quando inicializar as threads
    @Override
    public void run() {
        try {
            calcularRota(this.vizinhos);
        } catch (InterruptedException ex) {
            Logger.getLogger(Vertice.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
