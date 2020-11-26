package spacepattern;

import javax.swing.JFrame;
import models.GameArea;

/**
 * @author Arthur Andrade
 * No presente projeto foi implementado o Design Pattern Strategy
 * Para isso foi criada a interface "FireInterface", ela define o método 
 * renderAndUpdate(Fire fire, Graphics2D graphcs2D), responsável pela 
 * renderização e atualização da posição do projetil "Fire".
 * 
 * A FireInterface é implementada pela classe SimpleFire que define o movimento 
 * do Projetil Fire fixo no eixo X e para cima no eixo Y, e pela classe
 * FollowFire, responsável por atualizar o projetil no eixo x, de acordo com a
 * movimentação da Nav e o eixo Y para cima.
 * 
 * Por fim a classe principal do projetil é Fire, ela define toda a estrutura de 
 * um projetil e é COMPOSTA por uma classe que implemente a FireInterface, assim
 * dependendo do estado da nave ela opta por criar um novo projetil composto por
 * SimpleFire ou FollowFIre de maneira dinâmica.
 * 
 * Com a implmentação do Strategy, caso se deseje criar uma nova implementação 
 * para Fire é preciso apenas criar  uma classe que implementa FireInterface e 
 * adiciona-lá a implementação de Nav, sem mudar nada na classe Fire
 */
public class SpacePattern extends JFrame{
    
    public SpacePattern(){
        add(new GameArea());
        setTitle("SpacePatters !!!");
        setSize(500, 500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new SpacePattern();
    }
}
