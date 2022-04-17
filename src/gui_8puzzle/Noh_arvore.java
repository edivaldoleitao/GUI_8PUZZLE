/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_8puzzle;

/**
 *
 * @author Win10
 */
class Noh_arvore {

    private int profundidade;
    private Noh_arvore no_pai;
    private int[][] estado;
    private String acao_tomada;

    public Noh_arvore(int profundidade, Noh_arvore no_pai, int[][] estado, String acao_tomada) {
        super();
        this.profundidade = profundidade;
        this.no_pai = no_pai;
        this.estado = estado;
        this.acao_tomada = acao_tomada;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public Noh_arvore getNo_pai() {
        return no_pai;
    }

    public int[][] getEstado() {
        return estado;
    }

    public String getAcao_tomada() {
        return acao_tomada;
    }

}
