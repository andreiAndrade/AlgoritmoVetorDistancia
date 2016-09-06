/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmovetordistancia;

import java.util.*;

/**
 * @author 10070128
 */
public class Vertice extends Thread {
    //region Attributes
    private String nome;
    private List<Rota> vizinhos;
    private List<Rota> rotas;
    private Map<Vertice, List<Rota>> rotasRecebidas;
    private boolean alterouRotas;
    private boolean recebeuRotas;
    //endregion

    public Vertice(String nome) {
        this.nome = nome;
        this.rotas = new ArrayList();
        this.rotas.add(new Rota(this, 0));
        this.vizinhos = new ArrayList();
        this.rotasRecebidas = new HashMap();
    }

    //region Getters and Setters
    public String getNome() {
//        System.out.println("//Nome: " + nome);
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Rota> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(List<Rota> vizinhos) {
        this.vizinhos = vizinhos;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }

    public Map<Vertice, List<Rota>> getRotasRecebidas() {
        return rotasRecebidas;
    }

    public void setRotasRecebidas(Map<Vertice, List<Rota>> rotasRecebidas) {
        this.rotasRecebidas = rotasRecebidas;
    }

    public boolean isAlterouRotas() {
        return alterouRotas;
    }

    public void setAlterouRotas(boolean alterouRotas) {
        this.alterouRotas = alterouRotas;
    }

    public boolean isRecebeuRotas() {
        return recebeuRotas;
    }

    public void setRecebeuRotas(boolean recebeuRotas) {
        this.recebeuRotas = recebeuRotas;
    }
    //endregion

    public void addVizinho(Rota vizinho) {
        this.vizinhos.add(vizinho);
        this.rotas.add(vizinho);
        this.alterouRotas = true;
    }

    synchronized public void enviarRotas() {
        this.alterouRotas = false;
        for (Rota r : this.vizinhos) {
            System.out.println("Enviando rota de: " + this.nome+" para: "+ r.getDestino().getNome());
            r.getDestino().addRotasRecebidas(this, this.rotas);
        }
    }

    private void addRotasRecebidas(Vertice vertice, List<Rota> rotas) {
        if (this.rotasRecebidas.get(vertice) != null)
            this.rotasRecebidas.replace(vertice, rotas);
        else
            this.rotasRecebidas.put(vertice, rotas);
        calcularRotas();
    }

    public void calcularRotas() {
        this.alterouRotas = false;

        for (Map.Entry<Vertice, List<Rota>> entry : this.rotasRecebidas.entrySet()) {
            int custoInicial = getCustoPorVertice(entry.getKey());
            List<Rota> novasRotas = new ArrayList();

            for (Rota rotaRecebida : entry.getValue()) {
                boolean alterou = false;
                for (Rota minnhaRota : this.rotas) {
                    if (rotaRecebida.getDestino().equals(minnhaRota.getDestino())) {
                        if (minnhaRota.getCusto() != 0) {
                            if ((rotaRecebida.getCusto() + custoInicial) < minnhaRota.getCusto()) {
                                minnhaRota.setCusto(rotaRecebida.getCusto() + custoInicial);
                                this.alterouRotas = true;
                            }
                        }
                        alterou = true;
                        break;
                    }
                    alterou = false;
                }
                if (!alterou) {
                    Rota novaRota = new Rota(rotaRecebida.getDestino(), rotaRecebida.getCusto() + custoInicial);
                    novasRotas.add(novaRota);
                    this.alterouRotas = true;
                }
            }

            this.rotas.addAll(novasRotas);
        }

        if (this.alterouRotas) {
            enviarRotas();
        }
    }

    public int getCustoPorVertice(Vertice v) {
        for (Rota r : this.vizinhos) {
            if (r.getDestino().equals(v))
                return r.getCusto();
        }

        return 0;
    }


    public boolean equals(Vertice v) {
        return v.nome.equals(this.nome);
    }

    @Override
    public void run() {
        try {
            enviarRotas();
        } catch (ConcurrentModificationException cme) {
            System.out.println("Problema de concorrência, será resolvido em breve.");
        }
    }
}
