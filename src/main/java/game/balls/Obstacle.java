package excercises.game.balls;

import java.awt.*;
import java.util.Random;

public class Obstacle {

    private static final int WIDTH = 20;
    int locationyY;
    int locationx;
    Color color;
    private Game game;
    Random random = new Random();

    public Obstacle(Game game, Color color) {
        this.game = game;
        locationx = random.nextInt(300-WIDTH);
        locationyY = random.nextInt(400-WIDTH);
        this.color = color;
    }


    public void paint(Graphics2D g) {
        g.setColor(this.color);
        g.fillRect(locationx, locationyY, WIDTH, WIDTH);

    }


    public Rectangle getBounds() {
        return new Rectangle(locationx, locationyY, WIDTH, WIDTH);
    }


}
