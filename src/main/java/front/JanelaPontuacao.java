package front;

import models.Pontuacao;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class JanelaPontuacao extends JFrame {

    public JanelaPontuacao(ArrayList<Pontuacao> pontuacoes){
        super();
        Collections.sort(pontuacoes);
        Collections.reverse(pontuacoes);
        this.setTitle("Rank: ");
        this.setSize(new Dimension(600,500));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(300,200);
        TabelaPontuacao tabela = new TabelaPontuacao(pontuacoes);
        JTable jtable = new JTable(tabela);
        this.add(new JScrollPane(jtable));
        this.setVisible(true);

    }

}
