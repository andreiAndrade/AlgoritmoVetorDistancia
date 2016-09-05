/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

        Vertice vA = new Vertice("a");
        Vertice vB = new Vertice("b");
        Vertice vC = new Vertice("c");
        Vertice vD = new Vertice("d");
        Vertice vE = new Vertice("e");

        vA.addVizinho(new Rota(vB, 8));
        vA.addVizinho(new Rota(vC, 2));

        vB.addVizinho(new Rota(vA, 8));
        vB.addVizinho(new Rota(vD, 4));
        vB.addVizinho(new Rota(vC, 1));
        vB.addVizinho(new Rota(vE, 2));

        vC.addVizinho(new Rota(vA, 2));
        vC.addVizinho(new Rota(vD, 1));
        vC.addVizinho(new Rota(vB, 1));

        vD.addVizinho(new Rota(vB, 4));
        vD.addVizinho(new Rota(vC, 1));
        vD.addVizinho(new Rota(vE, 3));

        vE.addVizinho(new Rota(vB, 2));
        vE.addVizinho(new Rota(vD, 3));

        GRAFO.addAll(Arrays.asList(vA, vB, vC, vD, vE));

        for (Vertice v : GRAFO) {
            new Thread(v).start();
        }

        Thread.sleep(3000);
        soutRotas();
    }

    private static void soutRotas() {
        for (Vertice v : GRAFO) {
            System.out.println("________________Novas Rotas_______________");
            System.out.println("Rotas de: " + v.getNome());
            System.out.println("Numero de rotas: " + v.getRotas().size());
            for (Rota r : v.getRotas()) {
                System.out.println("Destino: " + r.getDestino().getNome() + " Custo: " + r.getCusto());
            }
        }
    }
}
