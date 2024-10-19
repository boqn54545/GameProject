package Project.java.objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Enemy {
    private float xSpeed;
    private float ySpeed;
    private float x;
    private float y;
    private Sprite image;
    private Rectangle enemyRect;
    private float initialY;
    float elapsedTime;

    public Enemy(float x, float y, float xSpeed, float ySpeed, Sprite image) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.image = image;
        this.ySpeed = ySpeed;
        this.initialY = y;
        this.elapsedTime=0;
        this.enemyRect = new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    public void movement() {
         float amplitude=30;

        elapsedTime += Gdx.graphics.getDeltaTime();
        if (x <= 0-image.getWidth()|| x >= Gdx.graphics.getWidth() - image.getWidth()) {
            xSpeed = -xSpeed;
        }
        x += xSpeed;
        y = initialY - (float) Math.cos(elapsedTime * ySpeed) * amplitude;

        enemyRect.setPosition(x, y);

    }
    public void draw(SpriteBatch batch) {
        batch.begin();
        image.setPosition(x, y);
        image.draw(batch);
        batch.end();
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
}


