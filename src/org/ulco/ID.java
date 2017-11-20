package org.ulco;

public class ID {
    public int ID = 0;

    private static ID INSTANCE = new ID();

    private ID(){}

    public static ID getInstance(){
        return INSTANCE;
    }

    public int suivant(){
        return ID=ID+1;
    }

    public int courant(){
        return ID;
    }
}