package Project.java.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Object {
    private float x;
    private float y;
    private Texture image;
    private Rectangle objectRect;

    public Object(float x, float y,Texture image,Rectangle objectRect) {
        this.x = x;
        this.y = y;
        this.image=image;
        this.objectRect = new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    public Rectangle getObjectRect() {
        return objectRect;
    }

    public void setObjectRect(Rectangle objectRect) {
        this.objectRect = objectRect;
    }

    public Texture getImage() {
        return image;
    }

    public void setImage(Texture image) {
        this.image = image;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setX(int x) {
        this.x = x;
    }
}
