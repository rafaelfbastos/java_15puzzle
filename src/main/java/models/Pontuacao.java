package models;

import java.time.LocalDate;
import java.util.Date;

public class Pontuacao implements Comparable<Pontuacao>{
    private int id;
    private String nome;
    private int jogadas;
    private LocalDate data;

    public Pontuacao(int id, String nome, int jogadas, LocalDate data) {
        this.nome = nome;
        this.jogadas = jogadas;
        this.data = data;
        this.id = id;
    }

    public Pontuacao( String nome, int jogadas, LocalDate data) {
        this.nome = nome;
        this.jogadas = jogadas;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public int compareTo(Pontuacao o) {
        if(o.getJogadas()>this.jogadas) return 1;

        else if (o.getJogadas()<this.jogadas) return -1;

        return 0;
    }
}
