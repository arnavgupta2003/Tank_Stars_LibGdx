package com.extinct.tankstars.GameRes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class Tank implements Serializable {
    public static int currentTank = 0;
    public static ArrayList<Tank> tankList = new ArrayList<>();
    public static int tankID=1;
    public float tankHealth;
    int currentTankID = tankID;
    String TankName;
    float gameWidth;
    float gameHeight;
    float normalWidth;
    float normalHeight;
    String TankTexturePath;
    String TankTextureRegionPath;
    Tank(){
        tankID++;

    }
    void setTankTexture(String filepath){
        this.TankTexturePath = (filepath);
    }
    public Texture getTankTexture(int idx){
        return new Texture(Gdx.files.internal(tankList.get(idx).TankTexturePath));
    }
    public static void addTanks(){
        Tank temp = new Tank();
        temp.setTankTexture("Tanks_res/Tank_Res1.png");
        tankList.add(temp);
        Tank temp2 = new Tank();
        temp2.setTankTexture("Tanks_res/Tank_Res2.png");
        tankList.add(temp2);
        Tank temp3 = new Tank();
        temp3.setTankTexture("Tanks_res/Tank_Res3.png");
        tankList.add(temp3);
    }
}
