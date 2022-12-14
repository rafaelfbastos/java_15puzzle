package front;

import models.TempoJogo;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class Recursos {

    private static Recursos singleton;
    private Font fontMenu;
    private Font fontNome;
    private Font fontjogadas;
    private int jogadas;
    private String nome;
    private String estado;
    private BufferedImage sprite;
    private AudioInputStream silence;
    private AudioInputStream win;
    private AudioInputStream transition;
    private Clip clipWin;
    private Clip clipTransition;
    private Clip clipSilence;
    private Random rdm;
    private BufferedImage inicio;
    private BufferedImage fim;
    private BufferedImage sprite2;
    public String modo;
    public int boardIndice;
    private TempoJogo tempo;
    private Map<Integer,String> boardName;


    Recursos() {
        setFontMenu(new Font("Arial narrow", Font.CENTER_BASELINE, 60));
        setFontNome(new Font("Arial narrow", Font.CENTER_BASELINE, 40));
        setFontjogadas(new Font("Arial narrow", Font.CENTER_BASELINE, 30));
        setJogadas(0);
        setEstado("S");
        setRdm(new Random());

        try {
            setSprite(ImageIO.read(getClass().getResource("/sprite.png")));
            setInicio(ImageIO.read(getClass().getResource("/inicio.png")));
            setFim(ImageIO.read(getClass().getResource("/fim.png")));
            rdmSprite2();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        carregarSons();

        tempo = new TempoJogo();

        boardName = new HashMap<>();
        boardName.put(0,"Lula");
        boardName.put(1,"Darth Vader helmet");
        boardName.put(2,"Darth Vader");
        boardName.put(3,"MK logo");
        boardName.put(4,"Lion");
        boardName.put(5,"Yoda");
        boardName.put(6,"Sub-Zero");
        boardName.put(7,"Pikachu");
        boardName.put(8,"MK Pokemon");


    }

    public static Recursos getInstance() {
        if (singleton == null) singleton = new Recursos();

        return singleton;
    }

    public BufferedImage getImagem(int numero) {
        int x = numero * 150;

        return getSprite().getSubimage(x, 0, 150, 150);
    }

    public BufferedImage getImagem2(int numero) {
        switch (numero) {
            case 1:
                return sprite2.getSubimage(0, 0, 150, 150);
            case 2:
                return sprite2.getSubimage(150, 0, 150, 150);

            case 3:
                return sprite2.getSubimage(300, 0, 150, 150);

            case 4:
                return sprite2.getSubimage(450, 0, 150, 150);

            case 5:
                return sprite2.getSubimage(0, 150, 150, 150);

            case 6:
                return sprite2.getSubimage(150, 150, 150, 150);

            case 7:
                return sprite2.getSubimage(300, 150, 150, 150);

            case 8:
                return sprite2.getSubimage(450, 150, 150, 150);

            case 9:
                return sprite2.getSubimage(0, 300, 150, 150);

            case 10:
                return sprite2.getSubimage(150, 300, 150, 150);

            case 11:
                return sprite2.getSubimage(300, 300, 150, 150);

            case 12:
                return sprite2.getSubimage(450, 300, 150, 150);

            case 13:
                return sprite2.getSubimage(0, 450, 150, 150);

            case 14:
                return sprite2.getSubimage(150, 450, 150, 150);

            case 15:
                return sprite2.getSubimage(300, 450, 150, 150);

            default:
                return sprite2.getSubimage(450, 450, 150, 150);

        }


    }

    public void carregarSons() {

        try {
            setWin(AudioSystem.getAudioInputStream(getClass().getResource("/win.wav")));
            setSilence(AudioSystem.getAudioInputStream(getClass().getResource("/silence.wav")));
            setTransition(AudioSystem.getAudioInputStream(getClass().getResource("/transition.wav")));

            setClipWin(AudioSystem.getClip());
            setClipSilence(AudioSystem.getClip());
            setClipTransition(AudioSystem.getClip());

            getClipWin().open(getWin());
            getClipSilence().open(getSilence());
            getClipTransition().open(getTransition());

            getClipSilence().start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void tocarTransition() {
        getClipTransition().setFramePosition(0);
        getClipTransition().start();
    }

    public void tocarWin() {
        getClipWin().setFramePosition(0);
        getClipWin().start();
    }

    void incrementarJogadas() {
        setJogadas(getJogadas() + 1);
        tocarTransition();
    }

    public int gerarRandom(int numero) {
        return getRdm().nextInt(numero);
    }

    public Font getFontMenu() {
        return fontMenu;
    }

    public void setFontMenu(Font fontMenu) {
        this.fontMenu = fontMenu;
    }

    public Font getFontNome() {
        return fontNome;
    }

    public void setFontNome(Font fontNome) {
        this.fontNome = fontNome;
    }

    public Font getFontjogadas() {
        return fontjogadas;
    }

    public void setFontjogadas(Font fontjogadas) {
        this.fontjogadas = fontjogadas;
    }

    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public AudioInputStream getSilence() {
        return silence;
    }

    public void setSilence(AudioInputStream silence) {
        this.silence = silence;
    }

    public AudioInputStream getWin() {
        return win;
    }

    public void setWin(AudioInputStream win) {
        this.win = win;
    }

    public AudioInputStream getTransition() {
        return transition;
    }

    public void setTransition(AudioInputStream transition) {
        this.transition = transition;
    }

    public Clip getClipWin() {
        return clipWin;
    }

    public void setClipWin(Clip clipWin) {
        this.clipWin = clipWin;
    }

    public Clip getClipTransition() {
        return clipTransition;
    }

    public void setClipTransition(Clip clipTransition) {
        this.clipTransition = clipTransition;
    }

    public Clip getClipSilence() {
        return clipSilence;
    }

    public void setClipSilence(Clip clipSilence) {
        this.clipSilence = clipSilence;
    }

    public Random getRdm() {
        return rdm;
    }

    public void setRdm(Random rdm) {
        this.rdm = rdm;
    }

    public BufferedImage getInicio() {
        return inicio;
    }

    public void setInicio(BufferedImage inicio) {
        this.inicio = inicio;
    }

    public BufferedImage getFim() {
        return fim;
    }

    public void setFim(BufferedImage fim) {
        this.fim = fim;
    }

    public BufferedImage getSprite2() {
        return sprite2;
    }
    public void rdmSprite2() {
        ArrayList<String> urls = new ArrayList<>(Arrays.asList("/1.png","/2.png","/3.png","/4.png","/5.png","/6.png","/7.png","/8.png","/9.png"));
        boardIndice = rdm.nextInt(urls.size());
        try {
            sprite2 = (ImageIO.read(getClass().getResource(urls.get(boardIndice))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TempoJogo getTempo() {
        return tempo;
    }
    public void setTempo(TempoJogo tempo) {
        this.tempo = tempo;
    }

    public int getBoardIndice() {
        return boardIndice;
    }

    public String getBoardName() {
        return (modo=="1")?"15 Puzzle":boardName.get(boardIndice);
    }
}
