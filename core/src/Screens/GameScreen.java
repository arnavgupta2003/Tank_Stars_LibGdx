package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.extinct.tankstars.TankStars;

import Scenes.Hud;

public class GameScreen implements Screen {
    private TankStars game;
    private Hud hud;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    public GameScreen(TankStars game){
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort =  new FitViewport(game.V_WIDTH,game.V_HEIGHT,gamecam);
        hud = new Hud(game.batch);
    }
    @Override
    public void show(){

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.st.getCamera().combined);
        hud.st.draw();

    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
