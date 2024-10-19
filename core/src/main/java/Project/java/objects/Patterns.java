package Project.java.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;
import java.util.Random;

public class Patterns {
    private ArrayList<Projectile> projectilesRight;
    private float timerCooldown;
    float elapsedTime;
    private Sprite redWallSprite, greenWallSprite, yellowWallSprite;
    private Enemy enemy;
    Random rand = new Random();
    public Patterns(Sprite redWallSprite, Sprite greenWallSprite, Sprite yellowWallSprite,Enemy enemy) {
        this.projectilesRight = new ArrayList<>();
        this.redWallSprite = redWallSprite;
        this.greenWallSprite = greenWallSprite;
        this.yellowWallSprite = yellowWallSprite;
        this.timerCooldown = 0;
        this.elapsedTime = 0;
        this.enemy=enemy;


    }

    public void makeProjectiles() {
        timerCooldown += Gdx.graphics.getDeltaTime();


        float cooldownDuration = rand.nextInt(3) + 2;

        if (timerCooldown >= cooldownDuration) {
            spawnProjectileFromRight();
            spawnProjectileFromLeft();
            spawnProjectileFromTop();
            timerCooldown = 0;
        }

        projectilesRight.removeIf(projectile -> projectile.getLifespan() >= 4.0f);
    }

    private void spawnProjectileFromLeft() {
        float randomY = rand.nextInt(Gdx.graphics.getHeight() - 500-(int) redWallSprite.getWidth());
        float xSpeed = rand.nextInt(6) + 5;
        projectilesRight.add(new Projectile(-100, randomY, xSpeed, 2, redWallSprite, greenWallSprite, yellowWallSprite, false, false, false));
    }

    private void spawnProjectileFromRight() {
        float randomY = rand.nextInt(Gdx.graphics.getHeight() - 500);
        float xSpeed = rand.nextInt(6) + 5;

        projectilesRight.add(new Projectile(1200, randomY, xSpeed, 2, redWallSprite, greenWallSprite, yellowWallSprite, false, false, true));
    }

    private void spawnProjectileFromTop() {
        float randomX = rand.nextInt(Gdx.graphics.getWidth() - (int) redWallSprite.getWidth());
        float ySpeed = rand.nextInt(6) + 5;
        projectilesRight.add(new Projectile(enemy.getX(), enemy.getY(), 3, ySpeed, redWallSprite, greenWallSprite, yellowWallSprite, true, false, false));
    }

    private void spawnProjectileFromBottom() {
        float randomX = rand.nextInt(Gdx.graphics.getWidth() - (int) redWallSprite.getWidth());
        float ySpeed = rand.nextInt(6) + 5;
        projectilesRight.add(new Projectile(randomX, -150, 0, ySpeed, redWallSprite, greenWallSprite, yellowWallSprite, true, true, false));
    }

    public ArrayList<Projectile> getProjectilesRight() {
        return projectilesRight;
    }

    public void setProjectilesRight(ArrayList<Projectile> projectilesRight) {
        this.projectilesRight = projectilesRight;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectilesRight;
    }

    public float getTimerCooldown() {
        return timerCooldown;
    }

    public void setTimerCooldown(float timerCooldown) {
        this.timerCooldown = timerCooldown;
    }

    public Sprite getRedWallSprite() {
        return redWallSprite;
    }

    public void setRedWallSprite(Sprite redWallSprite) {
        this.redWallSprite = redWallSprite;
    }

    public Sprite getGreenWallSprite() {
        return greenWallSprite;
    }

    public void setGreenWallSprite(Sprite greenWallSprite) {
        this.greenWallSprite = greenWallSprite;
    }

    public Sprite getYellowWallSprite() {
        return yellowWallSprite;
    }

    public void setYellowWallSprite(Sprite yellowWallSprite) {
        this.yellowWallSprite = yellowWallSprite;
    }
    public void setWallSprites(Sprite redWallSprite, Sprite greenWallSprite, Sprite yellowWallSprite) {
        this.redWallSprite = redWallSprite;
        this.greenWallSprite = greenWallSprite;
        this.yellowWallSprite = yellowWallSprite;
    }


}
