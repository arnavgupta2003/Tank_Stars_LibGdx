package Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.extinct.tankstars.GameRes.Utils;
import com.extinct.tankstars.TankStars;

import org.graalvm.compiler.core.common.util.Util;

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
    Texture PlayerHealthBar;
    Texture EnemyHealthBar;
    Image EneBar;
    Image PlaBar;
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
        //timer = new Label("Time",new Label.LabelStyle(new BitmapFont(),Color.CYAN));
        //tb.add(EnemyHealthBar).ex
//        PlaBar = new Image(PlayerHealthBar);
//        PlaBar.setPosition(10,5,0);
//        PlaBar.setWidth(20);
//        PlaBar.setHeight(10);
//        EneBar = new Image(EnemyHealthBar);
//        EneBar.setWidth(20);
//        EneBar.setHeight(10);
//        PlaBar.setPosition(50,5,0);
//        tb.add(p1name).expandX().padTop(10);
//        tb.add(p2name).expandX().padTop(10);
//        tb.add(PlaBar);
//        tb.add(EneBar);
        HealthBar p1HealthBar = new HealthBar(12,10,0.7f);
        HealthBar p2HealthBar = new HealthBar(12,10,0.3f);
        HealthBar spaceBar = new HealthBar(2,5,0.5f);

        spaceBar.getStyle().background=null;
        spaceBar.getStyle().knob=null;
        spaceBar.getStyle().knobBefore=null;
//        p1HealthBar.setPosition(12,30);
//        p2HealthBar.setPosition(50,30);
        timer = new Label("Time is :",new Label.LabelStyle((new BitmapFont()),Color.MAGENTA));

        tb.row();
        tb.add(p1HealthBar);
//        tb.add(spaceBar);

        tb.add(timer).center();
        tb.add(p2HealthBar);
        st.addActor(tb);
    }


}
class HealthBar extends ProgressBar {


    public HealthBar(int width,int height,float val) {
        super(0f, 1f, 0.01f, false, new ProgressBarStyle());
        getStyle().background= Utils.getColoredDrawable(width,height,Color.RED);
        getStyle().knob = Utils.getColoredDrawable(0,height,Color.GREEN);
        getStyle().knobBefore = Utils.getColoredDrawable(width,height,Color.GREEN);

        setWidth(width);
        setHeight(height);

        setAnimateDuration(0.0f);
        setValue(val);

        setAnimateDuration(0.25f);

    }
}
