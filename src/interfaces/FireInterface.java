package interfaces;

import java.awt.Graphics2D;
import models.Fire;

/**
 *
 * @author arthu
 */



//Interface responsável por implementar o padrão STRATEGY no sistema
public interface FireInterface {
    public void renderAndUpdate(Fire fire, Graphics2D graphcs2D);
}
