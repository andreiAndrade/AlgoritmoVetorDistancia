/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// google chart
//gnu plotlib


package algoritmovetordistancia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 10070128
 */
public class AlgoritmoVetorDistancia {
    private static List<Vertice> GRAFO;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        GRAFO = new ArrayList();

        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        

        vA.addVizinho(new Rota(vB, 2));
        vA.addVizinho(new Rota(vC, 4));

        vB.addVizinho(new Rota(vA, 2));
        vB.addVizinho(new Rota(vD, 11));
        vB.addVizinho(new Rota(vC, 3));
        

        vC.addVizinho(new Rota(vA, 4));
        vC.addVizinho(new Rota(vD, 1));
        vC.addVizinho(new Rota(vB, 3));

        vD.addVizinho(new Rota(vB, 11));
        vD.addVizinho(new Rota(vC, 1));
      


        GRAFO.addAll(Arrays.asList(vA, vB, vC, vD));

        for (Vertice v : GRAFO) {
            new Thread(v).start();
            v.join();
        }

        Thread.sleep(3000);
        soutRotas();
        
        
    }

    private static void soutRotas() {
        for (Vertice v : GRAFO) {
            System.out.println("________________Novas Rotas_______________");
            System.out.println("Numero de rotas: " + v.getRotas().size());
            System.out.println("Rotas partindo de:" + v.getNome());
            for (Rota r : v.getRotas()) {
                System.out.println("Destino: " + r.getDestino().getNome() + " Custo: " + r.getCusto());
            }
        }
    }
}
