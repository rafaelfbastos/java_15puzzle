package front;

import models.Pontuacao;
import models.PontuacaoDAO;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Principal extends JFrame {

    private JPanel score;
    private JButton iniciar;
    private JButton reiniciar;
    private JButton mostrarResultados;
    private Game game;


    public Principal() {
        super();
        Game game = new Game();
        game.setPreferredSize(new Dimension(610, 610));
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.darkGray);
        this.add(game);
        this.setTitle("Quebra Cabeça");
        gerarScorePanel();
        this.add(score);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(100, 100);
        ImageIcon icon = new ImageIcon("src/main/resources/icon.png");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
        this.pack();

    }

    protected void gerarScorePanel() {
        if(score!=null) score.removeAll();
        else score = new JPanel();

        score.setLayout(new BoxLayout(score, BoxLayout.Y_AXIS));
        score.setPreferredSize(new Dimension(300, 610));

        JLabel titulo = new JLabel("Quebra Cabeça:");
        titulo.setForeground(Color.lightGray);
        titulo.setFont(Recursos.getInstance().getFontNome());
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        score.setBackground(Color.BLACK);
        score.add(Box.createRigidArea(new DimensionUIResource(0, 30)));
        score.add(titulo);


        if (Recursos.getInstance().getEstado().equals("P")) {
            JLabel nome = new JLabel(Recursos.getInstance().getNome());
            nome.setForeground(Color.green);
            nome.setFont(Recursos.getInstance().getFontNome());
            nome.setAlignmentX(CENTER_ALIGNMENT);
            score.add(Box.createRigidArea(new DimensionUIResource(0, 75)));
            score.add(nome);
            score.add(Box.createRigidArea(new DimensionUIResource(0, 50)));
            JLabel pontos = new JLabel(""+ Recursos.getInstance().getJogadas());
            pontos.setForeground(Color.lightGray);
            pontos.setFont(Recursos.getInstance().getFontjogadas());
            pontos.setAlignmentX(CENTER_ALIGNMENT);
            score.add(pontos);


        }
        if (Recursos.getInstance().getEstado().equals("S")) {
            iniciarButton();
            score.add(Box.createRigidArea(new DimensionUIResource(0, 40)));
            iniciar.setAlignmentX(CENTER_ALIGNMENT);
            score.add(iniciar);
            score.add(Box.createRigidArea(new DimensionUIResource(0, 75)));
            mostrarResultadosButton();
            mostrarResultados.setAlignmentX(CENTER_ALIGNMENT);
            score.add(mostrarResultados);

        }
        if(Recursos.getInstance().getEstado().equals("F")){

            JLabel nome = new JLabel(Recursos.getInstance().getNome());
            nome.setForeground(Color.green);
            nome.setFont(Recursos.getInstance().getFontNome());
            nome.setAlignmentX(CENTER_ALIGNMENT);
            score.add(Box.createRigidArea(new DimensionUIResource(0, 75)));
            score.add(nome);
            score.add(Box.createRigidArea(new DimensionUIResource(0, 50)));
            JLabel pontos = new JLabel(""+ Recursos.getInstance().getJogadas());
            pontos.setForeground(Color.lightGray);
            pontos.setFont(Recursos.getInstance().getFontjogadas());
            pontos.setAlignmentX(CENTER_ALIGNMENT);
            score.add(pontos);

            JLabel fim = new JLabel("Fim de Jogo");
            fim.setForeground(Color.red);
            fim.setFont(Recursos.getInstance().getFontNome());
            fim.setAlignmentX(CENTER_ALIGNMENT);
            score.add(Box.createRigidArea(new DimensionUIResource(0, 75)));
            score.add(fim);
            score.add(Box.createRigidArea(new DimensionUIResource(0, 40)));
            reiniciarButton();
            reiniciar.setAlignmentX(CENTER_ALIGNMENT);
            score.add(reiniciar);
            score.add(Box.createRigidArea(new DimensionUIResource(0, 40)));
            mostrarResultadosButton();
            mostrarResultados.setAlignmentX(CENTER_ALIGNMENT);
            score.add(mostrarResultados);



        }

    }
    public void render() {
        gerarScorePanel();
        SwingUtilities.updateComponentTreeUI(this);

    }
    public void iniciarButton(){
        iniciar = new JButton("Iniciar");
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recursos.getInstance().setNome(JOptionPane.showInputDialog("Digite seu Nome:"));
                Recursos.getInstance().setEstado("P");
                render();

            }
        });
    }
    public void reiniciarButton(){
        reiniciar = new JButton("Reiniciar");
        reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recursos.getInstance().setEstado("P");
                Recursos.getInstance().setJogadas(0);
                render();
            }
        });
    }
    public void mostrarResultadosButton(){
        mostrarResultados = new JButton("Mostrar Resultados");
        mostrarResultados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Pontuacao> pontuacoes = PontuacaoDAO.findAll();
                new JanelaPontuacao(pontuacoes);

            }
        });
    }

}
