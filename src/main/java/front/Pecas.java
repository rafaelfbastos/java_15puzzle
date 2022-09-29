package front;

import java.util.Objects;

public class Pecas {
    private int label;

    public Pecas(int label) {
        this.label = label;

    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public String labelSting(){
        if(label==0) return "";
        else if(label<10) return "0"+label;
        else return ""+label;
    }


    @Override
    public String toString() {

        return ""+label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pecas pecas = (Pecas) o;
        return label == pecas.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
