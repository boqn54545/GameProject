package Project.java.objects;

import Project.java.Enums.playerColor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Character {
    private float x;
    private float y;
    private Texture image;
    private Texture redTexture;
    private Texture greenTexture;
    private Texture yellowTexture;
    private Texture grayTexture;
    private Rectangle charRect;
    private double sensitivity;
    private float prevMouseX;
    private float prevMouseY;
    private playerColor currentColor;
    private float timerCooldown;
    private float barrierX = 280;
    private float barrierY = 180;
    private float barrierWidth = 240;
    private float barrierHeight = 235;
    private Rectangle playerRect;
    private boolean isGray;

    public Character(float x, float y, Texture redTexture, Texture greenTexture,Texture yellowTexture,Texture grayTexture,boolean isGray, double sensitivity){
        this.x = x;
        this.y = y;
        this.yellowTexture = yellowTexture;
        this.redTexture = redTexture;
        this.greenTexture = greenTexture;
        this.grayTexture = grayTexture;
        this.image = redTexture;
        this.isGray=isGray;
        this.currentColor = playerColor.Red;
        this.sensitivity = sensitivity;
        this.charRect = new Rectangle(x, y, redTexture.getWidth(), redTexture.getHeight());
        this.prevMouseX = Gdx.input.getX();
        this.prevMouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
        this.playerRect = new Rectangle(x, y, image.getWidth(), image.getHeight());this.playerRect = new Rectangle(x, y, image.getWidth(), image.getHeight());
    }


    public void changeHearthToRed(){
        currentColor = playerColor.Red;
        image = redTexture;
        setGray(false);
        timerCooldown = 0;
    }
    public void changeHearthToGreen(){
        currentColor = playerColor.Green;
        image = greenTexture;
        setGray(false);
        timerCooldown = 0;
    }
    public void changeHearthToYellow(){
        currentColor = playerColor.Yellow;
        image = yellowTexture;
        setGray(false);
        timerCooldown = 0;
    }
    public void changeHearthToGray(){
        image = grayTexture;
        //currentColor = playerColor.Gray;
    }
    public void changeHearth() {
        timerCooldown += Gdx.graphics.getDeltaTime();
        float cooldownDuration = 0.0001f;
        if (isGray==true);
        else if (Gdx.input.isKeyPressed(Input.Keys.Z) && timerCooldown >= cooldownDuration) {
           changeHearthToRed();
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.X) && timerCooldown >= cooldownDuration) {
            changeHearthToGreen();
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.C) && timerCooldown >= cooldownDuration) {
         changeHearthToYellow();
        }
      if (isGray==true){
          changeHearthToGray();
        }
      }


    public void movement() {
        float currentMouseX = Gdx.input.getX();
        float currentMouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
        float deltaX = currentMouseX - prevMouseX;
        float deltaY = currentMouseY - prevMouseY;
        x += deltaX * sensitivity;
        y += deltaY * sensitivity;
        charRect.setPosition(x, y);
        prevMouseX = currentMouseX;
        prevMouseY = currentMouseY;
    }

    public void barrier(ShapeRenderer shapeRenderer) {
        x = Math.max(0, Math.min(x, Gdx.graphics.getWidth() - image.getWidth()));
        y = Math.max(0, Math.min(y, Gdx.graphics.getHeight() - image.getHeight()));
     //  x = Math.max(barrierX, Math.min(x, barrierX + barrierWidth - image.getWidth()));
     //  y = Math.max(barrierY, Math.min(y, barrierY + barrierHeight - image.getHeight()));
     //  shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
     //  shapeRenderer.setColor(0, 1, 0, 1);
     //  shapeRenderer.rect(barrierX, barrierY, barrierWidth, barrierHeight);
     //  shapeRenderer.end();
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(image, x, y);
        batch.end();
    }


    public Rectangle getPlayerRect() {
        return playerRect;
    }

    public void setPlayerRect(Rectangle playerRect) {
        this.playerRect = playerRect;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getPrevMouseY() {
        return prevMouseY;
    }

    public void setPrevMouseY(float prevMouseY) {
        this.prevMouseY = prevMouseY;
    }

    public float getPrevMouseX() {
        return prevMouseX;
    }

    public void setPrevMouseX(float prevMouseX) {
        this.prevMouseX = prevMouseX;
    }

    public double getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(double sensitivity) {
        this.sensitivity = sensitivity;
    }

    public void setSensitivity(float sensitivity) {
        this.sensitivity = sensitivity;
    }

    public boolean isGray() {
        return isGray;
    }

    public void setGray(boolean gray) {
        this.isGray = gray;
    }

    public void setX(int x) {
            this.x = x;
        }


        public void setY(int y) {
            this.y = y;
        }


        public Texture getImage() {
            return image;
        }

        public void setImage(Texture image) {
            this.image = image;
        }

    public Rectangle getCharRect() {
        return charRect;
    }

    public playerColor getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(playerColor currentColor) {
        this.currentColor = currentColor;
    }

    public void setCharRect(Rectangle charRect) {
        this.charRect = charRect;
    }
}

//  public void movement() {
//        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
//            y += ySpeed;
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
//            y -= ySpeed;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//            x -= xSpeed;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//            x += xSpeed;
//        }
//        //   if (Gdx.input.isKeyPressed(Input.Keys.W)&&(Gdx.input.isKeyPressed(Input.Keys.D))){ ////// Пречи на диагонално вървене
//        //       y += ySpeed-10;
//        //   }
//        charRect.setPosition(x, y);
//    }
