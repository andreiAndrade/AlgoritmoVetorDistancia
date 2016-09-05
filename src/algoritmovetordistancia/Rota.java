/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmovetordistancia;

/**
 * @author 10070128
 */
class Rota {
    private int custo;
    private Vertice destino;

    public Rota(Vertice destino, int custo) {
        this.custo = custo;
        this.destino = destino;
    }

    public int getCusto() {
//        System.out.println("//Custo: " + custo);
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }
}
