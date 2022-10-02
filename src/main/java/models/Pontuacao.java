package models;

import java.time.LocalDate;


public class Pontuacao implements Comparable<Pontuacao>{
    private int id;
    private String nome;
    private int jogadas;
    private LocalDate data;
    private String board;
    private TempoJogo tempo;

    public Pontuacao(int id, String nome, int jogadas, LocalDate data, String board, TempoJogo tempo) {
        this.nome = nome;
        this.jogadas = jogadas;
        this.data = data;
        this.id = id;
        this.board = board;
        this.tempo = tempo;
    }

    public Pontuacao( String nome, int jogadas, LocalDate data, String board, TempoJogo tempo) {
        this.nome = nome;
        this.jogadas = jogadas;
        this.data = data;
        this.board = board;
        this.tempo = tempo;
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

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public TempoJogo getTempo() {
        return tempo;
    }

    public void setTempo(TempoJogo tempo) {
        this.tempo = tempo;
    }

    @Override
    public int compareTo(Pontuacao o) {
        if(o.getJogadas()>this.jogadas) return 1;
        else if (o.getJogadas()<this.jogadas) return -1;
        else{
           return tempo.compareTo(o.getTempo());
        }
    }
}
