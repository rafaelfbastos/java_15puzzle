package front;

import models.Pontuacao;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TabelaPontuacao extends AbstractTableModel {

    private final String[] header = {"Posição","Nome", "Jogadas", "Data"};
    private final ArrayList<Pontuacao> TabelaList;

    public TabelaPontuacao(ArrayList<Pontuacao> pontuacoes) {
        TabelaList = pontuacoes;
    }


    @Override
    public int getRowCount() {
        if (TabelaList == null) {
            return 0;
        }
        return TabelaList.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.format("%dº ",rowIndex+1);
            case 1:
                return TabelaList.get(rowIndex).getNome();
            case 2:
                return TabelaList.get(rowIndex).getJogadas();
            case 3:
                return TabelaList.get(rowIndex).getData().toString();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int indice) {
        return header[indice];
    }
}
