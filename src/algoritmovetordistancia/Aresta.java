/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmovetordistancia;

/**
 *
 * @author 10070128
 */
class Aresta {
    int custo;
    Vertice vizinho;
    
    public Aresta() {}
    
    public Aresta(int custo, Vertice vizinho) {
        this.custo = custo;
        this.vizinho = vizinho;
    }
}
