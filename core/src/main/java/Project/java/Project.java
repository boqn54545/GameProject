package Project.java;

import Project.java.Screens.Battle;
import Project.java.objects.Projectile;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;



public class Project extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture yellowColor;
    private Texture redColor;
    private Texture greenColor;
    private Texture grayColor;
    private ShapeRenderer shapeRenderer;
    private ArrayList<Projectile> projectilesRight;
    private float timerCooldown;
    private Texture redWallTexture;
    private Texture greenWallTexture;
    private Texture yellowWallTexture;
    private Battle battle;


    public void create() {
        battle = new Battle();
        battle.create();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ScreenUtils.clear(0.15f, 0.235f, 0.2f, 1f);
        battle.battle();
        exitGame();
    }
    public void exitGame(){
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        redColor.dispose();
        greenColor.dispose();
        yellowColor.dispose();
        yellowWallTexture.dispose();
        greenWallTexture.dispose();
        redWallTexture.dispose();
        shapeRenderer.dispose();

    }

}



