package Project.java.objects;


import Project.java.Enums.playerColor;
import Project.java.Enums.wallColor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


import java.awt.*;
import java.util.Random;

public class Projectile {
   private float xSpeed;
   private float ySpeed;
    private Sprite redWall;
    private Sprite greenWall;
    private Sprite yellowWall;
    private float x;
    private float y;
    private Sprite image;
    private Rectangle projectileRect;
    private wallColor wallColor;
    private float timerCooldown;
    private boolean isVertical;
    private boolean verticalUp;
    private boolean horizontalLeft;
    private float lifespan = 0;
    private float elapsedTime = 0;


    public Projectile(float x, float y, float xSpeed, float ySpeed, Sprite redWall, Sprite greenWall, Sprite yellowWall,boolean isVertical,boolean verticalUp,boolean horizontalLeft) {
        this.image=yellowWall;
        this.xSpeed = xSpeed;
        this.ySpeed=ySpeed;
        this.redWall=redWall;
        this.yellowWall=yellowWall;
        this.greenWall=greenWall;
        this.isVertical = isVertical;
        this.verticalUp=verticalUp;
        this.horizontalLeft=horizontalLeft;

        this.x=x;
        this.y=y;
        this.projectileRect = new Rectangle(x, y, image.getWidth(), image.getHeight());
        getRandomWall();

    }

    public void getRandomWall(){
   Random rand=new Random();
   int num = rand.nextInt(3)+1;
   if (num==1){
       image=redWall;
       wallColor = Project.java.Enums.wallColor.RedWallColor;
   }
   if (num==2){
       image=greenWall;
       wallColor = Project.java.Enums.wallColor.GreenWallColor;
   }
   if (num==3){
            image=yellowWall;
            wallColor = Project.java.Enums.wallColor.YellowWallColor;
        }
    }
    public void draw(SpriteBatch batch) {
        batch.begin();

        image.setPosition(x, y);
        image.draw(batch);
        batch.end();
    }

    public void drawHitbox(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(projectileRect.x, projectileRect.y, projectileRect.width, projectileRect.height);
        shapeRenderer.end();
    }
    public void movement(Enemy enemy) {

        Random rand=new Random();
        timerCooldown += Gdx.graphics.getDeltaTime();
        image.setOriginCenter();

        lifespan += Gdx.graphics.getDeltaTime();
        if (isVertical) {

            image.setRotation(90);

            if (verticalUp) {
                y = y + ySpeed;
            }else {
                float amplitude=4;
                elapsedTime += Gdx.graphics.getDeltaTime();
                //case with scenarios for patterns
               x = enemy.getX() - (float) Math.sinh(elapsedTime * 2) * amplitude;
               //y = enemy.getY() - (float) Math.sinh(elapsedTime * 4) * amplitude;
                //x = enemy.getX();
                y = enemy.getY() - (float) Math.sinh(elapsedTime * 5)* amplitude;
            }
            this.projectileRect.setSize(image.getHeight(), image.getWidth());
            this.projectileRect.setPosition(x - 100, y + 100);
        } else {
            image.setRotation(0);
            if (horizontalLeft){
                x=x-xSpeed;
            }else {
                x = x + xSpeed;
            }
            this.projectileRect.setSize(image.getWidth(), image.getHeight());
            this.projectileRect.setPosition(x, y);

        }}
//Sprite projectileSprite = (rand.nextBoolean()) ? topWallSprite1 : topWallSprite2; idea


    public Rectangle getProjectileRect() {
        return projectileRect;
    }

    public void setProjectileRect(Rectangle projectileRect) {
        this.projectileRect = projectileRect;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Sprite getRedWall() {
        return redWall;
    }
    public float getLifespan() {
        return lifespan;
    }
    public void setRedWall(Sprite redWall) {
        this.redWall = redWall;
    }

    public Sprite getYellowWall() {
        return yellowWall;
    }

    public void setYellowWall(Sprite yellowWall) {
        this.yellowWall = yellowWall;
    }

    public Sprite getGreenWall() {
        return greenWall;
    }

    public void setGreenWall(Sprite greenWall) {
        this.greenWall = greenWall;
    }

    public Project.java.Enums.wallColor getWallColor() {
        return wallColor;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setWallColor(Project.java.Enums.wallColor wallColor) {
        this.wallColor = wallColor;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }
}
