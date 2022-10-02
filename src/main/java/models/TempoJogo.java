package models;

import java.util.concurrent.TimeUnit;

public class TempoJogo implements Comparable<TempoJogo>{
    private long tempoInial;
    private long tempofinal;
    private long tempo;

    public long getTempoInial() {
        return tempoInial;
    }

    public void setTempoInial(long tempoInial) {
        this.tempoInial = tempoInial;
    }

    public long getTempofinal() {
        return tempofinal;
    }

    public void setTempofinal(long tempofinal) {
        this.tempofinal = tempofinal;
    }
    public void setTempo(){
        tempo = tempofinal-tempoInial;
    }

    public long getTempo() {
        return tempo;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }
    public void calcularTempo(){
        tempo = tempofinal-tempoInial;
    }

    @Override
    public String toString() {
        return String.format("%02d m : %02d s", TimeUnit.MILLISECONDS.toMinutes(tempo), TimeUnit.MILLISECONDS.toSeconds(tempo)%60);
    }

    @Override
    public int compareTo(TempoJogo o) {
        if(tempo<o.getTempo()) return -1;
        if(tempo>o.getTempo()) return +1;
        return 0;
    }
}
