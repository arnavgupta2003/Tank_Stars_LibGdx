package com.extinct.tankstars.GameRes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Level {
    Texture levelStage;
    Texture levelBackground;
    public Level(){
        this.levelStage = new Texture(Gdx.files.internal("levelStageRes/Terrain.png"));
        this.levelBackground = new Texture(Gdx.files.internal("levelBKGRes/Broken_Buildings.png"));
    }

    public Texture getLevelStage() {
        return levelStage;
    }

    public void setLevelStage(Texture levelStage) {
        this.levelStage = levelStage;
    }

    public Texture getLevelBackground() {
        return levelBackground;
    }

    public void setLevelBackground(Texture levelBackground) {
        this.levelBackground = levelBackground;
    }
}
