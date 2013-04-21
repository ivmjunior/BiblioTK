/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotk.models;

import java.util.Date;

/**
 *
 * @author rafael
 */
public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private long dataEmprestimo;
    private long dataDevolucao;
    
    public Emprestimo(Usuario usuario, Livro livro) {
        this.livro = livro;
        this.usuario = usuario;
        dataEmprestimo = new Date().getTime();
        dataDevolucao = dataEmprestimo + (60*60*24*7); // 7 dias
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public long getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(long dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public long getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(long dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}
