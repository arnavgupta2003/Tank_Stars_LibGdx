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
    private String p1;
    private String p2;
    private String p3= "        ";
    Label p1name;
    Label p2name;
    Label p3name;
    Label timer;
    public Hud(SpriteBatch sb,String p1,String p2){
        this.p1 = p1;
        this.p2 =p2;
        vp =  new FillViewport(TankStars.V_WIDTH,TankStars.V_HEIGHT,new OrthographicCamera());
        st = new Stage(vp,sb);
        Table tb = new Table();
        tb.top();
        tb.setFillParent(true);
        p1name =  new Label(p1,new Label.LabelStyle((new BitmapFont()),Color.CYAN));
        p2name=new Label(p2,new Label.LabelStyle((new BitmapFont()),Color.MAGENTA));
        p3name=new Label(p3,new Label.LabelStyle((new BitmapFont()),Color.MAGENTA));
        HealthBar p1HealthBar = new HealthBar(12,10,0.7f);
        HealthBar p2HealthBar = new HealthBar(12,10,0.3f);
        HealthBar spaceBar = new HealthBar(2,5,0.5f);

        spaceBar.getStyle().background=null;
        spaceBar.getStyle().knob=null;
        spaceBar.getStyle().knobBefore=null;
        timer = new Label("       ",new Label.LabelStyle((new BitmapFont()),Color.MAGENTA));

        tb.row();
        tb.add(p1HealthBar);
        tb.add(timer).center();
        tb.add(p2HealthBar);
        tb.row();

        tb.add(p1name);
        tb.add(p3name);
        tb.add(p2name);
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
