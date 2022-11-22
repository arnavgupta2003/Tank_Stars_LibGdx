package com.extinct.tankstars.GameRes;

import java.io.Serializable;

public class Progress implements Serializable {
    Tank playerTank;
    Tank enemyTank;
    Level currentLevel;
    Progress(){
        this.playerTank=new Tank();
        this.enemyTank=new Tank();
        this.currentLevel=new Level();
    }
}
