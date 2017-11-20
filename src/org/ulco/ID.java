package org.ulco;

public class ID {
    //static public int ID = 0;

    private static ID INSTANCE = new ID();

    public static ID getInstance(){
        return INSTANCE;
    }

    private int id = 0;

    private ID(){}

    public int suivant(){
        return id=id+1;
    }

    public int courant(){
        return id;
    }
}