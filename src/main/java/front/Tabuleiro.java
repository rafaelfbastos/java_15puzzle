package front;

import java.util.ArrayList;
import java.util.Collections;

public class Tabuleiro {

    private ArrayList<Pecas> tabuleiro;
    private ArrayList<Pecas> pecas;

    public Tabuleiro() {
        tabuleiro = new ArrayList<>();
        pecas = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            pecas.add(new Pecas(i));
        }

        pecas.remove(0);
        pecas.add(new Pecas(0));

        tabuleiro.addAll(pecas);

       shuflleTabuleiro();

    }

    public ArrayList<Pecas> getPecas() {
        return pecas;
    }

    public void setPecas(ArrayList<Pecas> pecas) {
        this.pecas = pecas;
    }

    public ArrayList<Pecas> getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(ArrayList<Pecas> tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int retornarPeca(int mouseInputX, int mouseInputY) {

        if (mouseInputX > 0 && mouseInputX < 152 && mouseInputY > 0 && mouseInputY < 152) return 0;
        else if (mouseInputX > 152 && mouseInputX < 304 && mouseInputY > 0 && mouseInputY < 152) return 1;
        else if (mouseInputX > 304 && mouseInputX < 456 && mouseInputY > 0 && mouseInputY < 152) return 2;
        else if (mouseInputX > 456 && mouseInputX < 608 && mouseInputY > 0 && mouseInputY < 152) return 3;

        else if (mouseInputX > 0 && mouseInputX < 152 && mouseInputY > 152 && mouseInputY < 304) return 4;
        else if (mouseInputX > 152 && mouseInputX < 304 && mouseInputY > 152 && mouseInputY < 304) return 5;
        else if (mouseInputX > 304 && mouseInputX < 456 && mouseInputY > 152 && mouseInputY < 304) return 6;
        else if (mouseInputX > 456 && mouseInputX < 608 && mouseInputY > 152 && mouseInputY < 304) return 7;

        else if (mouseInputX > 0 && mouseInputX < 152 && mouseInputY > 304 && mouseInputY < 456) return 8;
        else if (mouseInputX > 152 && mouseInputX < 304 && mouseInputY > 304 && mouseInputY < 456) return 9;
        else if (mouseInputX > 304 && mouseInputX < 456 && mouseInputY > 304 && mouseInputY < 456) return 10;
        else if (mouseInputX > 456 && mouseInputX < 608 && mouseInputY > 304 && mouseInputY < 456) return 11;

        else if (mouseInputX > 0 && mouseInputX < 152 && mouseInputY > 456 && mouseInputY < 608) return 12;
        else if (mouseInputX > 152 && mouseInputX < 304 && mouseInputY > 456 && mouseInputY < 608) return 13;
        else if (mouseInputX > 304 && mouseInputX < 456 && mouseInputY > 456 && mouseInputY < 608) return 14;
        else if (mouseInputX > 456 && mouseInputX < 608 && mouseInputY > 456 && mouseInputY < 608) return 15;

        else return -1;

    }

    public void update(int mouseInputX, int mouseInputY) {
        int pecaSecionada = retornarPeca(mouseInputX, mouseInputY);

        //verificar esquerda e direira
        if (pecaSecionada - 1 >= 0 && pecaSecionada != 4 && pecaSecionada != 8 && pecaSecionada != 12) {
            if (tabuleiro.get(pecaSecionada - 1).getLabel() == 0) {
                Collections.swap(tabuleiro, pecaSecionada, pecaSecionada - 1);
                Recursos.getInstance().incrementarJogadas();
            }

        }
        if (pecaSecionada + 1 <= 15 && pecaSecionada != 3 && pecaSecionada != 7 && pecaSecionada != 11) {
            if (tabuleiro.get(pecaSecionada + 1).getLabel() == 0) {
                Collections.swap(tabuleiro, pecaSecionada, pecaSecionada + 1);
                Recursos.getInstance().incrementarJogadas();
            }
        }
        //verificar cima e baixo
        if (pecaSecionada - 4 >= 0) {
            if (tabuleiro.get(pecaSecionada - 4).getLabel() == 0) {
                Collections.swap(tabuleiro, pecaSecionada, pecaSecionada - 4);
                Recursos.getInstance().incrementarJogadas();
            }
        }
        if (pecaSecionada + 4 <= 15) {
            if (tabuleiro.get(pecaSecionada + 4).getLabel() == 0) {
                Collections.swap(tabuleiro, pecaSecionada, pecaSecionada + 4);
                Recursos.getInstance().incrementarJogadas();
            }
        }
    }

    public boolean verificarVitoria() {
        if (tabuleiro.equals(pecas)) return true;
        else return false;
    }

    public void shuflleTabuleiro(){

        for (int i = 0; i <100000 ; i++) {

            int pecaSecionada = Recursos.getInstance().gerarRandom(16);

            if (pecaSecionada - 1 >= 0 && pecaSecionada != 4 && pecaSecionada != 8 && pecaSecionada != 12) {
                if (tabuleiro.get(pecaSecionada - 1).getLabel() == 0) {
                    Collections.swap(tabuleiro, pecaSecionada, pecaSecionada - 1);

                }

            }
            if (pecaSecionada + 1 <= 15 && pecaSecionada != 3 && pecaSecionada != 7 && pecaSecionada != 11) {
                if (tabuleiro.get(pecaSecionada + 1).getLabel() == 0) {
                    Collections.swap(tabuleiro, pecaSecionada, pecaSecionada + 1);
                }
            }
            //verificar cima e baixo
            if (pecaSecionada - 4 >= 0) {
                if (tabuleiro.get(pecaSecionada - 4).getLabel() == 0) {
                    Collections.swap(tabuleiro, pecaSecionada, pecaSecionada - 4);
                }
            }
            if (pecaSecionada + 4 <= 15) {
                if (tabuleiro.get(pecaSecionada + 4).getLabel() == 0) {
                    Collections.swap(tabuleiro, pecaSecionada, pecaSecionada + 4);
                }
            }
        }


    }

}
