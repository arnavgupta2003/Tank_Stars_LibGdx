package Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.extinct.tankstars.TankStars;

public class Hud {
    public Stage st;
    private Viewport vp;
    private int worldTimer;
    private int Health;
    private int timecount;
    private String p1="hello";
    private String p2= "world";
    Label p1name;
    Label p2name;
    Label timer;
    Label tankType;
    public Hud(SpriteBatch sb){
        worldTimer = 60;
        timecount = 0;
        vp =  new FillViewport(TankStars.V_WIDTH,TankStars.V_HEIGHT,new OrthographicCamera());
        st = new Stage(vp,sb);
        Table tb = new Table();
        tb.top();
        tb.setFillParent(true);
        p1name =  new Label(p1,new Label.LabelStyle((new BitmapFont()),Color.CYAN));
        p2name=new Label(p2,new Label.LabelStyle((new BitmapFont()),Color.MAGENTA));
        timer = new Label("Time",new Label.LabelStyle(new BitmapFont(),Color.CYAN));
        tb.add(p1name).expandX().padTop(10);
        tb.add(p2name).expandX().padTop(10);
        tb.row();

        tb.add(timer).center();
        st.addActor(tb);
    }


}