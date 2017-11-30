package org.ulco;

import java.util.Vector;

public class Layer implements Builder {
    // Variables
    private Vector<GraphicsObject> children;
    private int m_ID;

    // Constructeurs
    public Layer() {
        children = new Vector<GraphicsObject>();
        m_ID = ID.getInstance().suivant();
    }

    public Layer(String json) {
        Vector<String> separators = new Vector<String>();
        separators.add("objects");
        separators.add("groups");
        separators.add("}");
        children = JSON.parseItems(json, separators);
    }

    // Get
    public GraphicsObject get(int index) {
        return children.elementAt(index);
    }

    public int getObjectNumber() {
        return children.size();
    }

    public int getID() {
        return m_ID;
    }

    public Vector<GraphicsObject> get_children() {
        return children;
    }

    public String get_name(){
        return "layer";
    }

    public Vector<GraphicsObject> getChildren() {
        return children;
    }

    @Override
    public String[] get_types_children() {
        return new String[]{"objects", "groups"};
    }

    public String get_builder_type(){
        return "layers";
    }


    public void add(GraphicsObject o) {
        children.add(o);
    }

    public int type(){
        return 2;
    }
}
