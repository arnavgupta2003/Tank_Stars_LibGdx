package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.extinct.tankstars.TankStars;

import org.w3c.dom.Text;

import Scenes.Hud;

public class GameScreen implements Screen {
    private TankStars game;
    private Hud hud;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    Rectangle tank1;
    Texture tank1Img;
    Texture bkgIMG;
    Texture baseTexture;
    TextureRegion terrTe;
    TextureRegion bkgTe;
    public GameScreen(TankStars game){
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort =  new FitViewport(game.V_WIDTH,game.V_HEIGHT,gamecam);
        hud = new Hud(game.batch);

        tank1Img = new Texture(Gdx.files.internal("Tank1.png"));
        baseTexture = new Texture(Gdx.files.internal("Terrain.png"));
        bkgIMG = new Texture(Gdx.files.internal("Broken_Buildings.png"));
        bkgTe = new TextureRegion(bkgIMG,0,0,1920,1080);
        terrTe = new TextureRegion(baseTexture,0,0,1920,1080);

        tank1 = new Rectangle();
        tank1.x = 1920/2 -64/2;
        tank1.y = 120;
        tank1.width=96;
        tank1.height=64;
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

        ScreenUtils.clear(0, 0, 0.2f, 1);
        game.batch.begin();
        game.batch.draw(bkgTe, 0,0, 1920, 1080);
        game.batch.draw(terrTe,0,0,1920,1080);

        game.batch.draw(tank1Img, tank1.x, tank1.y, tank1.width, tank1.height);

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
