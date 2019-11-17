package excercises.game.balls;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel {

    Ball ball1 = new Ball(this, 60,60,Color.BLUE);
    Ball ball2 = new Ball(this, 200,180, Color.RED);
    Ball ball3 = new Ball(this,300,130,Color.GREEN);

    ArrayList<Ball> balls = new ArrayList<>();

    Obstacle obstacle = new Obstacle(this, Color.YELLOW);

    public Game() {
        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
    }

    private void move() {
        for(Ball b: balls){
            b.move();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        obstacle.paint(g2d);

        for (Ball b: balls) {
            b.paintComponent(g2d);
        }

    }

    public void gameOver() {
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Catch me if you can");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {

            game.move();
            game.repaint();

            if(game.ball1.collisionObstacle()){
                game.balls.remove(game.ball1);
            }
            if(game.ball2.collisionObstacle()){
                game.balls.remove(game.ball2);
            }
            if(game.ball3.collisionObstacle()){
                game.balls.remove(game.ball3);
            }
            if(game.balls.size() == 0){
                game.gameOver();
            }

            if(game.balls.contains(game.ball1)) {
                game.ball1.collisionBall(game.balls);
            }
            if(game.balls.contains(game.ball2)) {
                game.ball2.collisionBall(game.balls);
            }
            if(game.balls.contains(game.ball3)) {
                game.ball3.collisionBall(game.balls);
            }

            Thread.sleep(10);

        }



    }
}