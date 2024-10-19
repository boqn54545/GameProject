package Project.java.Screens;
import Project.java.objects.Character;
import Project.java.objects.Enemy;
import Project.java.Enums.playerColor;
import Project.java.Enums.wallColor;
import Project.java.objects.Patterns;
import Project.java.objects.Projectile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;


public class Battle {

    private SpriteBatch batch;
    private Texture yellowColor, redColor, greenColor, grayColor;
    private Character character;
    private ShapeRenderer shapeRenderer;
    private float timerCooldown;
    private Sprite yellowWallSprite, greenWallSprite, redWallSprite;
    private Enemy enemy;
    private Patterns pattern;

    public void create() {
        batch = new SpriteBatch();
        redColor = new Texture(Gdx.files.internal("und.png"));
        greenColor = new Texture(Gdx.files.internal("und2.png"));
        yellowColor = new Texture(Gdx.files.internal("und3.png"));
        grayColor = new Texture(Gdx.files.internal("und4.png"));

        Texture redWallTexture = new Texture(Gdx.files.internal("red.png"));
        Texture yellowWallTexture = new Texture(Gdx.files.internal("yellow.png"));
        Texture greenWallTexture = new Texture(Gdx.files.internal("green.png"));


        character = new Character(400, 300, redColor, greenColor, yellowColor, grayColor, false, 0.22);
        shapeRenderer = new ShapeRenderer();
        yellowWallSprite = new Sprite(yellowWallTexture);
        greenWallSprite = new Sprite(greenWallTexture);
        redWallSprite = new Sprite(redWallTexture);
        enemy = new Enemy(0, 500, 5, 5, yellowWallSprite);
        pattern = new Patterns(redWallSprite,greenWallSprite,yellowWallSprite,enemy);

    }


    public void projectiles() {
        for (Projectile projectile : pattern.getProjectilesRight()) {
            projectile.movement(enemy);
            projectile.draw(batch);
            projectile.drawHitbox(shapeRenderer);

        }}

    public void character() {
        character.draw(batch);
        character.movement();
        character.changeHearth();
    }
    public void enemy(){
        enemy.draw(batch);
        enemy.movement();
    }



    public void objects() {
        character.barrier(shapeRenderer);
    }
    public void battle() {
        enemy();
        Damage();
        projectiles();
        character();
        objects();

        pattern.makeProjectiles();

        Gdx.input.setCursorCatched(true);
    }
    public void Damage() {
        timerCooldown += Gdx.graphics.getDeltaTime();
        float cooldownDuration2 = 1f;
        if (character.isGray() == false) {
            for (Projectile projectiles : pattern.getProjectilesRight()) {
                if (projectiles.getProjectileRect().overlaps(character.getCharRect())) {
                    if (character.getCurrentColor().equals(playerColor.Red) && (projectiles.getWallColor() != (wallColor.RedWallColor))) {
                        character.setGray(true);
                        System.out.println(character.isGray());
                        System.out.println("1");
                    }
                    if (character.getCurrentColor().equals(playerColor.Green) && (projectiles.getWallColor() != (wallColor.GreenWallColor))) {
                        character.setGray(true);
                        System.out.println(character.isGray());
                        System.out.println("2");

                    }
                    if (character.getCurrentColor().equals(playerColor.Yellow) && (projectiles.getWallColor() != (wallColor.YellowWallColor))) {
                        character.setGray(true);
                        System.out.println(character.isGray());
                        System.out.println("3");
                    }
                    timerCooldown = 0;
                }
            }
        }else
        if (timerCooldown>cooldownDuration2){
            character.setGray(false);
            if (character.getCurrentColor() == playerColor.Red) {
                character.changeHearthToRed();
                System.out.println(character.isGray());
                System.out.println(character.getCurrentColor());
                timerCooldown = 0;
            }
            if (character.getCurrentColor() == playerColor.Green) {

                character.changeHearthToGreen();
                System.out.println(character.isGray());
                System.out.println(character.getCurrentColor());
                timerCooldown = 0;
            }
            if ( character.getCurrentColor() == playerColor.Yellow) {
                character.changeHearthToYellow();
                System.out.println(character.isGray());
                System.out.println(character.getCurrentColor());
                timerCooldown = 0;
            }

        }
    }


}
