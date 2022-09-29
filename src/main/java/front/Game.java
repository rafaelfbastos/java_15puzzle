package front;

import models.Pontuacao;
import models.PontuacaoDAO;

import javax.swing.*;
import javax.swing.event.MouseInputListener;



import java.awt.*;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class Game extends JPanel {

    private Tabuleiro tabuleiro;
    public int mouseClickX;
    public int mouseClickY;

    public Game() {

        tabuleiro = new Tabuleiro();

        addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickX = e.getX();
                mouseClickY = e.getY();
                gameLoop();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    public void gameLoop() {
        update();
        render();
    }

    public void update() {
        tabuleiro.update(mouseClickX, mouseClickY);

        if (tabuleiro.verificarVitoria()) {
            Recursos.getInstance().tocarWin();
            Recursos.getInstance().setEstado("F");
            LocalDate data = LocalDate.now();
            tabuleiro.shuflleTabuleiro();
            PontuacaoDAO.inserir(
                    new Pontuacao(Recursos.getInstance().getNome(), Recursos.getInstance().getJogadas(), data));
        }

    }

    private void render() {
        repaint();
        Main.janela.render();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        super.paintComponent(g2d);
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, 610, 610);

        if (Recursos.getInstance().getEstado().equals("S")) {
            g2d.drawImage(Recursos.getInstance().getInicio(), 0, 0, null);
        }

        if (Recursos.getInstance().getEstado().equals("F")) {
            g2d.drawImage(Recursos.getInstance().getFim(), 0, 0, null);
        }

        if (Recursos.getInstance().getEstado().equals("P")) {
            // desenhar linhas
            g2d.setColor(Color.lightGray);
            g2d.fillRect(0, 0, 2, 610);
            g2d.fillRect(0, 0, 610, 2);
            g2d.fillRect(152, 0, 2, 610);
            g2d.fillRect(304, 0, 2, 610);
            g2d.fillRect(456, 0, 2, 610);
            g2d.fillRect(608, 0, 2, 610);
            g2d.fillRect(0, 152, 610, 2);
            g2d.fillRect(0, 304, 610, 2);
            g2d.fillRect(0, 456, 610, 2);
            g2d.fillRect(0, 608, 610, 2);

            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(0).getLabel()), 2, 2, null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(1).getLabel()), 154, 2, null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(2).getLabel()), 306, 2, null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(3).getLabel()), 458, 2, null);
            // ----------------------------------------------------------------------------------------------------------------------
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(4).getLabel()), 2, 154, null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(5).getLabel()), 154, 154, null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(6).getLabel()), 306, 154, null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(7).getLabel()), 458, 154, null);
            // ----------------------------------------------------------------------------------------------------------------------
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(8).getLabel()), 2, 306, null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(9).getLabel()), 154, 306, null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(10).getLabel()), 306, 306,
                    null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(11).getLabel()), 458, 306,
                    null);
            // ----------------------------------------------------------------------------------------------------------------------
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(12).getLabel()), 2, 458, null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(13).getLabel()), 154, 458,
                    null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(14).getLabel()), 306, 458,
                    null);
            g2d.drawImage(Recursos.getInstance().getImagem(tabuleiro.getTabuleiro().get(15).getLabel()), 458, 458,
                    null);

            /*
             * Desenhar peças com texto
             * 
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(0).labelSting(),50,90);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(1).labelSting(),200,90);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(2).labelSting(),350,90);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(3).labelSting(),500,90);
             * //---------------------------------------------------------------------------
             * ---
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(4).labelSting(),50,240);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(5).labelSting(),200,240);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(6).labelSting(),350,240);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(7).labelSting(),500,240);
             * //---------------------------------------------------------------------------
             * ---
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(8).labelSting(),50,390);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(9).labelSting(),200,390);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(10).labelSting(),350,390);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(11).labelSting(),500,390);
             * //---------------------------------------------------------------------------
             * ---
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(12).labelSting(),50,540);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(13).labelSting(),200,540);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(14).labelSting(),350,540);
             * g2d.setFont(Recursos.getInstance().fontMenu);
             * g2d.setColor(Color.red);
             * g2d.drawString(""+tabuleiro.getTabuleiro().get(15).labelSting(),500,540);
             */

        }

    }
}
