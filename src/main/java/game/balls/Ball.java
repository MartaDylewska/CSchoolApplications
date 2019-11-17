package excercises.game.balls;

import sun.security.pkcs11.wrapper.Constants;

import java.awt.*;
import java.util.ArrayList;

public class Ball {
    private static final int DIAMETER = 30;
    int locationX;
    int locationY;
    int xa = 1;
    int ya = 1;
    private Game game;
    private Color color;

    public Ball(Game game, int locationX, int locationY, Color color) {
        this.game= game;
        this.locationX = locationX;
        this.locationY = locationY;
        this.color = color;
    }

    void move() {
        if (locationX + xa < 0)
            xa = 1;
        if (locationX + xa > game.getWidth() - DIAMETER)
            xa = -1;
        if (locationY + ya < 0)
            ya = 1;
        if (locationY + ya > game.getHeight() - DIAMETER)
            ya=-1;

        locationX = locationX + xa;
        locationY = locationY + ya;
    }

    public boolean collisionObstacle() {
        return game.obstacle.getBounds().intersects(getBounds());
    }

    public void collisionBall(ArrayList<Ball> ballList){
        for (Ball b: ballList){
            //ewentualnie if this.colliding(b)
            if(this.colliding(b) && b!=this){
                resolveCollision(b);
            }
        }
    }

    public void paintComponent(Graphics2D g) {
        g.setColor(this.color);
        g.fillOval(locationX, locationY, DIAMETER, DIAMETER);
    }
    //position.getY, position.getx zamiast Location Y i X
    public Rectangle getBounds() {
        return new Rectangle(locationX, locationY, DIAMETER, DIAMETER);
    }

    public boolean colliding(Ball ball)
    {
        float xd = this.locationX - ball.locationX;
        float yd = this.locationY - ball.locationY;

        float sumRadius = DIAMETER;
        float sqrRadius = DIAMETER * DIAMETER;

        float distSqr = (xd * xd) + (yd * yd);

        if (distSqr <= sqrRadius)
        {
            return true;
        }

        return false;
    }

    public void resolveCollision(Ball ball)
    {
        Vector2D positionThisBall = new Vector2D(this.locationX, this.locationY);
        Vector2D positionOtherBall = new Vector2D(ball.locationX, ball.locationY);
        // get the mtd
        Vector2D delta = (positionThisBall.subtract(positionOtherBall));
        float r = DIAMETER;
        float dist2 = delta.dot(delta);

        if (dist2 > r*r) return; // they aren't colliding


        float d = delta.getLength();

        Vector2D mtd;
        if (d != 0.0f)
        {
            mtd = delta.multiply(((DIAMETER/2 + DIAMETER/2)-d)/d); // minimum translation distance to push balls apart after intersecting

        }
        else // Special case. Balls are exactly on top of eachother.  Don't want to divide by zero.
        {
            d = DIAMETER - 1.0f;
            delta = new Vector2D(DIAMETER, 0.0f);

            mtd = delta.multiply(((DIAMETER-d)/d));
        }

        // resolve intersection
        float im1 = 1f; // inverse mass quantities
        float im2 = 1f;

        // push-pull them apart
        positionThisBall = positionThisBall.add(mtd.multiply(im1 / (im1 + im2)));
        positionOtherBall = positionOtherBall.subtract(mtd.multiply(im2 / (im1 + im2)));

        Vector2D velocityThisBall = new Vector2D(this.xa, this.ya);
        Vector2D velocityOtherBall = new Vector2D(ball.xa, ball.ya);
        // impact speed
        Vector2D v = (velocityThisBall.subtract(velocityOtherBall));
        float vn = v.dot(mtd.normalize());

        // sphere intersecting but moving away from each other already
        if (vn > 0.0f) return;

        // collision impulse
        float i = (-(1.0f + 0.9f) * vn) / (im1 + im2);
        Vector2D impulse = mtd.multiply(i);

        // change in momentum
        velocityThisBall = velocityThisBall.add(impulse.multiply(im1));
        velocityOtherBall = velocityOtherBall.subtract(impulse.multiply(im2));

        this.locationX = (int)positionThisBall.getX();
        this.locationY = (int)positionThisBall.getY();
        this.xa = -this.xa;
        this.ya = -this.ya;

        ball.locationX = (int)positionOtherBall.getX();
        ball.locationY = (int)positionOtherBall.getY();
        ball.xa = -ball.xa;
        ball.ya = -ball.ya;

    }



}