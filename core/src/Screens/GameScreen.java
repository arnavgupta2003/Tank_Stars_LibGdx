package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.extinct.tankstars.GameRes.Level;
import com.extinct.tankstars.GameRes.Progress;
import com.extinct.tankstars.GameRes.Tank;
import com.extinct.tankstars.TankStars;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

import Scenes.Hud;

public class GameScreen implements Screen {

    private TankStars game;
    private Hud hud;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    Texture tank1Img;
    Texture bkgIMG;
    Texture baseTexture;
    TextureRegion terrTe;
    TextureRegion bkgTe;
    BodyDef tankPhy;
    World world;
    Level currentLevel;
    Texture tankTempTexture;
    Texture tankTempTexture2;
    Rectangle tankTemp;
    Rectangle tankTemp2;
    Sprite tank2Sprite;

    public GameScreen(TankStars game) throws IOException {
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort =  new FitViewport(game.V_WIDTH,game.V_HEIGHT,gamecam);
        hud = new Hud(game.batch);
        Level.addInitLevel();
        Progress p1 = new Progress();
        p1.Serialize();
        currentLevel = Level.gameLevels.get(0);


        tankTempTexture = Tank.tankList.get(0).getTankTexture(0);//Temp tank
        tankTemp = new Rectangle();
        tankTemp.x = 50; // center the tank1 horizontally
        tankTemp.y = 0;
        tankTemp.width = 75;
        tankTemp.height = 50;

        tankTempTexture2 = Tank.tankList.get(1).getTankTexture(1);//Temp tank 2
        tankTemp2 = new Rectangle();
        tankTemp2.x = 250; // center the tank2 horizontally
        tankTemp2.y = 0;
        tankTemp2.width = 75;
        tankTemp2.height = 50;
        tank2Sprite = new Sprite(tankTempTexture2);
        tank2Sprite.flip(true,false);

        //Imple Tank using phy
        this.world = new World(new Vector2(0,-10),true);
        tankPhy = new BodyDef();
        tankPhy.type = BodyDef.BodyType.DynamicBody;
        tankPhy.position.set(200,230);
        Body body = world.createBody(tankPhy);

        //TEmp circle
        CircleShape circle = new CircleShape();
        circle.setRadius(6f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape=circle;
        fixtureDef.density=0.5f;
        fixtureDef.friction=0.4f;
        fixtureDef.restitution=0.6f;

        Fixture fixture = body.createFixture(fixtureDef);

        baseTexture = currentLevel.getLevelStage();
        bkgIMG = currentLevel.getLevelBackground();
        bkgTe = new TextureRegion(bkgIMG,0,0,1920,1080);
        terrTe = new TextureRegion(baseTexture,0,0,1920,1080);


    }
    @Override
    public void show(){

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.st.getCamera().combined);


        world.step(1/60f,6,2);
        ScreenUtils.clear(0, 0, 0.2f, 1);
        game.batch.begin();

        game.batch.draw(bkgTe, 0,0, 720, 250);
        game.batch.draw(terrTe,0,0,720,200);
        game.batch.draw(tankTempTexture,tankTemp.x,tankTemp.y,tankTemp.width,tankTemp.height);
        game.batch.draw(tank2Sprite,tankTemp2.x,tankTemp2.y,tankTemp2.width,tankTemp2.height);
        game.batch.end();
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
