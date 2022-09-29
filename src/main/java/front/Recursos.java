package front;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Recursos {

    private static Recursos singleton;
    private Font fontMenu;
    private Font fontNome;
    private Font fontjogadas;
    private int jogadas;
    private String nome;
    private Map<Integer, int[]> mapaCordenadas;
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




    Recursos() {
        setFontMenu(new Font("Arial narrow", Font.CENTER_BASELINE, 60));
        setFontNome(new Font("Arial narrow", Font.CENTER_BASELINE, 40));
        setFontjogadas(new Font("Arial narrow", Font.CENTER_BASELINE, 30));
        setJogadas(0);
        setMapaCordenadas(new HashMap<>());
        setEstado("S");
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                getMapaCordenadas().put(k, new int[]{i, j});
                k++;
            }
        }
        try {
            setSprite(ImageIO.read(getClass().getResource("/sprite.png")));
            setInicio(ImageIO.read(getClass().getResource("/inicio.png")));
            setFim(ImageIO.read(getClass().getResource("/fim.png")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        carregarSons();
        setRdm(new Random());
    }

    public static Recursos getInstance() {
        if (singleton == null) singleton = new Recursos();

        return singleton;
    }

    public BufferedImage getImagem(int numero) {
        int x = numero * 150;

        return getSprite().getSubimage(x, 0, 150, 150);
    }

    public void carregarSons(){

        try{
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

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void tocarTransition(){
        getClipTransition().setFramePosition(0);
        getClipTransition().start();
    }
    public void tocarWin(){
        getClipWin().setFramePosition(0);
        getClipWin().start();
    }
    void incrementarJogadas(){
        setJogadas(getJogadas() + 1);
        tocarTransition();
    }
    public int gerarRandom(int numero){
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

    public Map<Integer, int[]> getMapaCordenadas() {
        return mapaCordenadas;
    }

    public void setMapaCordenadas(Map<Integer, int[]> mapaCordenadas) {
        this.mapaCordenadas = mapaCordenadas;
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
}
