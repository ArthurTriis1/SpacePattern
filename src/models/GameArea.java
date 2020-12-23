package models;

import models.keyevent.KeyboardAdapter;
import models.fire.SimpleFireTop;
import models.fire.SimpleFireRight;
import models.fire.SimpleFireLeft;
import models.fire.SimpleFireBotton;
import interfaces.FireInterface;
import interfaces.Subject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.counter.CounterSingleton;
import models.enemy.AbstractEnemy;
import models.enemy.EnemyFactory;
import models.keyevent.KeyEventType;
import models.keyevent.KeyEventTypeEnum;

enum GameSteps {
    OnBoarding,
    Game,
    GameOver
}

/**
 * Classe responsável por renderizar e controlar o Game
 * @author Arthur
 */
public class GameArea extends JPanel  implements Subject<KeyEventType>{
    
    private Nav nav;    
    private int dificult = 1000;
    private ArrayList<AbstractEnemy> enemys;
    private GameSteps gameStep;
    CounterSingleton counter;
    private Timer timer;
    private Timer enemyTimer;
    private final FireInterface[] fireTypes = {
        new SimpleFireTop(), new SimpleFireLeft(), 
        new SimpleFireBotton(), new SimpleFireRight()
    };
    private final KeyboardAdapter keyboardObservable = new KeyboardAdapter();
    
    /**
     * Construto do Game
     * Inicia a Nav, Inimigos, KeyboardObservable, Contador e Timers
     */
    public GameArea(){
        setFocusable(true);
        
        nav = new Nav(Arrays.asList(fireTypes));
        enemys = new ArrayList<>();

        this.keyboardObservable.add(nav);
        this.keyboardObservable.add(this);
        
        addKeyListener(this.keyboardObservable);
        
        this.gameStep = GameSteps.OnBoarding;
        
        counter = CounterSingleton.getInstance();
        
        this.setTimers();
    }
    
    /**
     * Inicia os Timers, geral e de geração de Inimigos
     */
    private void setTimers(){
        this.timer = new Timer(1, (arg0) -> {
            if(this.gameStep == GameSteps.Game){
                repaint();
                //colisonsCheck();
            }
        });
        
        this.timer.start();
        
        this.enemyTimer = new Timer(this.dificult, (arg0) -> { 
            if(this.gameStep == GameSteps.Game){
                enemys.add(EnemyFactory.create());
                if(this.dificult > 150){
                   this.dificult -= 10;
                   this.enemyTimer.setDelay(this.dificult);
                }

            }
        }); 
        
        this.enemyTimer.start();
        
        
    }
    
    /**
     * Responsavel por renderizar na tela a situação do Game
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        Graphics2D graphs = (Graphics2D) g;
        graphs.setColor(new Color(25, 25, 112));
        graphs.fillRect(0, 0, 500, 500);
        int fontSize = 20;
        Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
        
        switch(this.gameStep){
            case OnBoarding:
                int dHeight = 30;
                int dWidth = 20;
                graphs.setColor(Color.YELLOW);
                graphs.setFont(f);
                graphs.drawString("Bem Vindo Paulo!", 180 - dWidth, 220 - dHeight);
                graphs.drawString("Utilize W,A,S,D para atirar.", 120 - dWidth, 250 - dHeight);
                graphs.drawString("Utilize as setas para se movimentar.", 80 - dWidth, 280 - dHeight);
                graphs.drawString("Boa Sorte!", 200 - dWidth, 310 - dHeight);

                break;
            case Game:
                nav.render(graphs);
                enemys.forEach(enemy -> enemy.renderAndUpdate(graphs));
                graphs.setColor(Color.YELLOW);
                graphs.setFont(f);
                graphs.drawString(String.valueOf(this.counter.getCounterValue()), 440, 440);
                break;
            case GameOver:
                graphs.setColor(Color.YELLOW);
                graphs.setFont(f);
                graphs.drawString("Game Over :(", 180, 220);
                graphs.drawString("Você Fez " + String.valueOf(this.counter.getCounterValue()) + " pontos", 150, 280);
                break;
        }
        
        g.dispose();
        
    }
    
    /**
     * Checa colisões no sistema da Nave com os Inimigos
     * e de Tiros com Inimigos
     */
    private void colisonsCheck(){
        this.enemys.forEach(enemy -> {
            if(enemy.getBounds().intersects(this.nav.getBounds())){
                this.gameStep = GameSteps.GameOver;
            }
        });
        
        try{
            this.nav.getFires().forEach(fire -> {
            this.enemys.forEach(enemy -> {
                if(enemy.getBounds().intersects(fire.getBounds())){
                    this.nav.getFires().remove(fire);
                    enemys.remove(enemy);
                    this.counter.add1CounterValue();
                }
            });
        });
        }catch(ConcurrentModificationException err){}
        
    }

    /**
     * Implementa Função da Interface Subject, disparada quando corre um evento 
     * em KeyboardObservable
     * Muda a tela exibida atualmente dependendo do step do game
     * @param event 
     */
    @Override
    public void execute(KeyEventType event) {
        int code = event.getEvent().getKeyCode();
        if(code == KeyEvent.VK_SPACE && event.getType() == KeyEventTypeEnum.keyPressed){
            if(this.gameStep == GameSteps.OnBoarding){
                this.gameStep = GameSteps.Game;
            }
//            TODO: Zerar Game quando Space é clicado na tela de Game Over
//            if(this.gameStep == GameSteps.GameOver){;
//                this.nav = new Nav(Arrays.asList(fireTypes));
//                this.keyboardObservable.add(nav);
//                enemys = new ArrayList<>();
//                this.gameStep = GameSteps.OnBoarding;
//            }
        }
    }
    
}
