/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmovetordistancia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10070128
 */
public class Vertice {
    String nome;
    List<Aresta> vizinhos;
    boolean alterouRotas;
    
    public Vertice() {
        this.vizinhos = new ArrayList();
    }
    
    public Vertice(String nome, List<Aresta> vizinhos) {
        this.nome = nome;
        this.vizinhos = vizinhos;
    }
    
    public void addVizinho(Aresta vizinho) {
        this.vizinhos.add(vizinho);
        this.alterouRotas = true;
    }
}
