/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmovetordistancia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 10070128
 */
public class AlgoritmoVetorDistancia {
    private static List<Vertice> GRAFO;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GRAFO = new ArrayList();
        
        Vertice vA = new Vertice();
        Vertice vB = new Vertice();
        Vertice vC = new Vertice();
        
        vA.addArestas(new Aresta(1, vB), new Aresta(3, vC));
        
        vB.addArestas(new Aresta(1, vA), new Aresta(5, vC));
        
        vC.addArestas(new Aresta(3, vA), new Aresta(5, vB));
        
        GRAFO.addAll(Arrays.asList(vA, vB, vC));
        
    }
    
    private static void calcularRota() {
        
    }
    
    private static void enviarRotas() {
        //enviar as listas
        //threads calcular rotas
    }
}
