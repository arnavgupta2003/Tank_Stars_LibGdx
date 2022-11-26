package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.extinct.tankstars.GameRes.Tank;
import com.extinct.tankstars.TankStars;

import java.io.IOException;

public class PauseScreen implements Screen {//Call Obj Serialize
    Stage st;
    TankStars game;
    TextButton pause;
    Table tb;
   // Viewport vp;
    TextButton resume,exit,settings,save;
    Skin mySkin= new Skin(Gdx.files.internal("skin/glassy-ui.json"));;
    public PauseScreen(TankStars game){
        this.game = game;
        tb = new Table();
        tb.setHeight(100);
        tb.setWidth(100);
        //vp =  new FillViewport(TankStars.V_WIDTH+100,TankStars.V_HEIGHT+100,new OrthographicCamera());
        st = new Stage();
        //createLabels("--------Pause--------");
        buttonInitializer();


    }
    public void createLabels(String name){
        //pause = new Label(name,new Label.LabelStyle((new BitmapFont()), Color.WHITE));
       // pause.setFontScale(2f);
        tb.top();
        tb.setFillParent(true);
        tb.add(pause).expandX().padTop(20);
        st.addActor(tb);


    }
    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(new Texture("Canyon_terrein_tile_8.png"),0,0,1280,720);
        st.draw();
        st.act();
        game.batch.end();
        st.draw();

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
        //game.batch.dispose();
    }
    private void buttonInitializer(){
        pause = new TextButton("------Pause------",mySkin,"small");
        pause.getLabel().setFontScale(2);
        pause.setPosition(380,610);
        pause.setSize(500,100);

        resume = new TextButton("Resume",mySkin,"default");
        resume.setPosition(480,500);
        resume.setSize(300,100);
        resume.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

            }
        });

        exit  = new TextButton("Exit",mySkin,"default");
        exit.setPosition(480,350);
        exit.setSize(300,100);
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                //Set to exit screen
                System.exit(0);
            }
        });

        save =  new TextButton("Save",mySkin,"default");
        save.setPosition(480,200);
        save.setSize(300,100);

        settings = new TextButton("Settings",mySkin,"default");
        //settings.getLabel().setFontScale(0.60f);
        settings.setPosition(480,50);
        settings.setSize(300,100);
        settings.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){

            }
        });
        st.addActor(pause);
        st.addActor(resume);
        st.addActor(save);
        st.addActor(exit);
        st.addActor(settings);

    }
}