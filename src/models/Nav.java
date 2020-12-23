package models;

import models.keyevent.KeyEventType;
import models.fire.Fire;
import interfaces.FireInterface;
import interfaces.Subject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe Responsavel por controlar a Nave
 */
public class Nav implements Subject<KeyEventType>{
    private int x , y, dx, dy;
    private int fireTypeValue = 0;
    private int height = 30 , width = 30;
    private List<Fire> fires;
    private boolean followFire = false;
    private List<FireInterface> fireTypes;
    
    /**
     * Inicia a posição incial da Nave e um Array de Tiros
     * @param fireTypes 
     */
    public Nav(List<FireInterface> fireTypes){
     this.x = 210;
     this.y = 210;
     fires = new ArrayList<Fire>();
     this.fireTypes = fireTypes;
    }
    
    /**
     * Responsavel por atualizar a localização da Nave no Game
     */
    public void update(){
        if(x + dx > 10 && x + dx < 440) x = x + dx; 
        if(y + dy > 10 && y + dy < 420) y = y + dy; 
    }
    
    /**
     * Função responsavel por Execução do tiro 
     * Intranciando uma Classe Fire composta pela Classe que implementa a 
     * FireInterface
     * @param fireType 
     */
    public void simpleFire(FireInterface fireType){
        this.fires.add(new Fire(this, fireType)); 
    }
    
    /**
     * Mudar tipoi de Fire que vai ser disparado
     */
    private void changeFireMode(){
        this.fireTypeValue++;
        if(this.fireTypeValue >= this.fireTypes.size()){
            this.fireTypeValue = 0;
        }
    }
    
    
    /**
     * Método chamado quando o evento de tecla pressionada é disparado
     * ele move a nave de localização e dispara o tipo especifico de tiro
     * @param event 
     */
    private void keyPressedEvent(KeyEvent event){
        int code = event.getKeyCode();

        if(code == KeyEvent.VK_LEFT){
           dx = -3;
           return;
        }
        if(code == KeyEvent.VK_RIGHT){
           dx = 3;
           return;
        } 
        if(code == KeyEvent.VK_UP){
           dy = -3;
           return;
        }
        if(code == KeyEvent.VK_DOWN){
           dy = 3;
           return;
        } 
        
        Optional<FireInterface> fireTypeOptional = this.fireTypes.stream().filter(type -> type.getKeyValue() == code).findFirst();
        
        if(fireTypeOptional.isPresent()){
            this.simpleFire(fireTypeOptional.get());
        }
    }
    
    /**
     * Método chamado quando o evento de tecla pressionada é largada
     * zerando a movimentação da nave
     * @param event 
     */
    private void keyReleaseEvent(KeyEvent event){
                    
        int code = event.getKeyCode();
        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT){           
            dx = 0;
        }
        if(code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN){           
            dy = 0;
        } 
    }
    
    /**
     * Retorna o retangulo que a nave ocupa no game para checagem de colisões
     * @return 
     */
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);   
    }
    
    /**
     * Renderiza a nave e as balas disparadas atualizando a posição
     * @param graphs 
     */
    public void render(Graphics2D graphs){
        this.update();
        
        this.fires.stream().forEach(fire ->{
            if(fire.isVisible()){
                fire.renderAndUpdate(graphs);
            }
        });
        
        this.renderLine(2, 0, 1, graphs);
        this.renderLine(1, 1, 3, graphs);
        this.renderLine(0, 2, 5, graphs);
        this.renderLine(1, 3, 3, graphs);
        this.renderLine(2, 4, 1, graphs);
    }
    
    /**
     * Função auxiliar para renderizar linha por linha da nave
     * @param x
     * @param y
     * @param width
     * @param graphs 
     */
    private void renderLine(int x, int y, int width, Graphics2D graphs){
        int yUnit = this.getHeight()/5; //6
        int xUnit = this.getWidth()/5; //5
        graphs.setColor(Color.yellow);
        graphs.fillRect(this.getX() + x * xUnit ,this.getY() +  yUnit * y , width * xUnit, yUnit);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Fire> getFires() {
        return fires;
    }

    /**
     * Implementa Função da Interface Subject, disparada quando corre um evento 
     * em KeyboardObservable
     * Dispara os eventos relacionados a nave
     * @param event 
     */
    @Override
    public void execute(KeyEventType event) {
        switch(event.getType()){
            case keyPressed:
                this.keyPressedEvent(event.getEvent());
                break;
            case keyReleased:
                this.keyReleaseEvent(event.getEvent());
                break;  
        }
    }
       
}
