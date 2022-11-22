package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.extinct.tankstars.TankStars;


public class TitleScreen implements Screen {
    TankStars game;
    Texture settingsButton;private Stage stage;


    Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    Texture img;
    Texture newGameButton;
    Texture resumeGameButton;
    ImageButton button3 = new ImageButton(mySkin);

    Texture rewardsButton;
    TextureAtlas textureAtlas;
    Texture title;
    Texture section;
    Texture buttonMenu;
    Texture anim;
    TextureRegion[] anime;
    Animation tanks;
    float time;
    Texture tryi;

    private  TextButton play,exit,load,chage;
    public TitleScreen(TankStars game) {
        stage = new Stage(new ScreenViewport());

        this.game = game;
        rewardsButton = new Texture("coin_stroke.png");
        img = new Texture("loader_2688x1242.png");
        newGameButton =  new Texture("Play-button-icon-in-yellow-color-on-transparent-background-PNG.png");
        title = new Texture("tile000.png");
        section = new Texture("tile002.png");
        buttonMenu =  new Texture("tile001.png");
        anim = new Texture("output-onlinegiftools.png");
        tryi  =  new Texture("b2886663613143.5ab66519f3003.gif");
        anime = new TextureRegion[34];
        int index = 0;
        TextureRegion[][] frams = TextureRegion.split(anim,10,1);
        for (int i = 0; i <34 ; i++) {

                anime[index++] = frams[0][i];
                

        }
        tanks =  new Animation<>(1f/30f);

        this.buttonInitializer();


    }
//    @Override
//    public void create(){
//        Gdx.input.setInputProcessor(stage);
//    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(stage);
        buttonInitializer();

    }

    @Override
    public void render(float delta) {
        time += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.batch.begin();
        update(delta);
        game.batch.draw(new Texture("Canyon_terrein_tile_8.png"),0,0,1280,720);
        //game.batch.draw(img,0,0,1280,720);
        game.batch.draw(title,200,550);
        //game.batch.draw(section,700,0);
        stage.draw();
        stage.act();
        game.batch.draw(tryi,720,320,557,400);
        /*
        game.batch.draw(buttonMenu,200,400);
        game.batch.draw(buttonMenu,200,300);
        game.batch.draw(buttonMenu,200,200);
        */

        game.batch.end();



    }

    @Override
    public void resize(int width, int height) {

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
        game.batch.dispose();

    }
    private void buttonInitializer(){
        play = new TextButton("Play",mySkin,"default");
        play.setPosition(200,400);
        play.setSize(300,100);
        play.addListener(new ClickListener(){
           @Override
           public void clicked(InputEvent event,float x,float y){
               game.setScreen(new GameScreen(game));
           }
        });

        exit  = new TextButton("Exit",mySkin,"default");
        exit.setPosition(200,250);
        exit.setSize(300,100);

        load =  new TextButton("Load",mySkin,"default");
        load.setPosition(200,100);
        load.setSize(300,100);
        chage = new TextButton("Tank",mySkin,"default");
        chage.setPosition(825,200);
        chage.setSize(300,100);
        stage.addActor(play);
        stage.addActor(load);
        stage.addActor(exit);
        stage.addActor(chage);

    }
    private void update(float delta){
        stage.act(delta);

    }
}
