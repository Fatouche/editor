package org.ulco;

abstract public class GraphicsObject implements Parsable {
    // Variables
    private int m_ID;
    protected Colors m_Color;
    protected Colors m_borderColor;
    public enum Colors{BLUE,RED,BLACK,WHITE,GREEN};

    // Constructeurs
    public GraphicsObject() {
        m_ID = ID.getInstance().suivant();
    }

    abstract public GraphicsObject copy();

    // Get
    public int getID() {
        return m_ID;
    }

    public String get_builder_type(){
        return "objects";
    }

    public Colors getColor() {
        return m_Color;
    }

    public Colors getborderColor(){
        return m_borderColor;
    }


    // Set
    public void setborderColor(Colors m_borderColor){
        this.m_borderColor = m_borderColor;
    }

    public void setColor(Colors m_Color){
        this.m_Color = m_Color;
    }


    public boolean isGroup(){
        return false;
    }

    public int size(){ return 1; }

    public int type() {
        return 1;
    }

    abstract Point center();

    public boolean isClosed(Point pt, double distance){
        return center().distance(pt) <= distance;
    }

    abstract void move(Point delta);

    abstract public String toString();
}
