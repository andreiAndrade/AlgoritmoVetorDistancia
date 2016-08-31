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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Vertice> grafo = new ArrayList();
        
        Vertice a = new Vertice();
        Vertice b = new Vertice();
        Vertice c = new Vertice();
        
        a.vizinhos.add(new Aresta(1, b));
        a.vizinhos.add(new Aresta(3, c));
        
        b.vizinhos.add(new Aresta(1, a));
        b.vizinhos.add(new Aresta(5, c));
        
        c.vizinhos.add(new Aresta(3, a));
        c.vizinhos.add(new Aresta(5, b));
        
        grafo.addAll(Arrays.asList(a, b, c));
        
    }
    
    private static void calcularRota() {
        
    }
    
    private static void enviarRotas() {
        //enviar as listas
        //threads calcular rotas
    }
}
