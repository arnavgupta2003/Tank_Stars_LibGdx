package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.extinct.tankstars.TankStars;
import com.extinct.tankstars.TankStars;

public class PauseScreen implements Screen {//Call Obj Serialize
    Stage st;
    TankStars game;
    Texture img;
    Label pause;
    Table tb;
    Viewport vp;
    TextButton resume,exit,settings,save;
    Skin mySkin= new Skin(Gdx.files.internal("skin/glassy-ui.json"));;
    public PauseScreen(TankStars game){
        this.game = game;
        img  = new Texture("tile002.png");
        tb = new Table();
        tb.setHeight(100);
        tb.setWidth(100);
        vp =  new FillViewport(TankStars.V_WIDTH+100,TankStars.V_HEIGHT+100,new OrthographicCamera());
        st = new Stage(vp);
        createLabels("--------Pause--------");
        buttonInitializer();


    }
    public void createLabels(String name){
        pause = new Label(name,new Label.LabelStyle((new BitmapFont()), Color.WHITE));
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
        game.batch.draw(img,300,0);

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
        resume = new TextButton("Resume",mySkin,"default");
        resume.setPosition(200,200);
        resume.setSize(120,50);
        exit  = new TextButton("Exit",mySkin,"default");
        exit.setPosition(200,140);
        exit.setSize(120,50);
        save =  new TextButton("Save",mySkin,"default");
        save.setPosition(200,80);
        save.setSize(120,50);
        settings = new TextButton("settings",mySkin,"default");
        settings.setPosition(200,20);
        settings.setSize(120,50);
        st.addActor(resume);
        st.addActor(exit);
        st.addActor(save);
        st.addActor(settings);

    }
}
