package interfaces;

import java.awt.Graphics2D;
import models.fire.Fire;

/**
 *
 * @author arthu
 */


/**
 * Interface responsável por implementar o padrão STRATEGY no sistema
 * dando uma base para os tipos de tiros a serem executados
 * IMPLEMENTA O PADRÃO STRATEGY
 */
public interface FireInterface {
    public void renderAndUpdate(Fire fire, Graphics2D graphcs2D);
    public int getKeyValue();
}
