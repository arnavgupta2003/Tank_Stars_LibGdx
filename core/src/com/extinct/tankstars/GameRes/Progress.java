package com.extinct.tankstars.GameRes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Progress implements Serializable {
    public static int playerID=0;
    Tank playerTank;
    Tank enemyTank;
    Level currentLevel;
    public Progress(){
        this.playerTank=new Tank();
        this.enemyTank=new Tank();
        this.currentLevel=new Level();
        playerID++;
    }
    public void Serialize() throws IOException {
        ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(("assets/storage/"+playerID+".txt")));
        file.writeObject(this);
    }
    public Progress DeSerialize() throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream(("assets/storage/"+playerID+".txt")));
        return (Progress) file.readObject();
    }
}
