package org.ulco;

import java.util.Iterator;
import java.util.Vector;

public class Document implements Builder {
    // Variable
    private Vector<Layer> children;

    // Constructeurs
    public Document() {
        children = new Vector<Layer>();
    }

    public Document(String json) {
        Vector<String> separators = new Vector<String>();
        separators.add("layers");
        separators.add("}");
        children = JSON.parseItems(json, separators);
    }

    public Document(Point origin, int line, int column, double length) {
        children = new Vector<Layer>();

        Layer layer = createLayer();

        for (int indexX = 0; indexX < column; ++indexX) {
            for (int indexY = 0; indexY < line; ++indexY) {
                layer.add(new Square(new Point(origin.getX() + indexX * length, origin.getY() + indexY * length), length));
            }
        }
    }

    public Document(Point center, int number, double radius, double delta) {
        children = new Vector<Layer>();

        Layer layer = createLayer();

        for (int index = 0; index < number; ++index) {
            layer.add(new Circle(center, radius + index * delta));
        }
    }

    // Get
    public int getLayerNumber() {
        return children.size();
    }

    public int getObjectNumber() {
        int size = 0;

        for (int i = 0; i < children.size(); ++i) {
            size += children.elementAt(i).getObjectNumber();
        }
        return size;
    }

    public String get_name(){
        return "document";
    }

    public String[] get_types_children(){
        return new String[]{"layers"};
    }

    public String get_builder_type(){
        return "documents";
    }

    public Vector<Layer> get_children() {
        return children;
    }


    public Layer createLayer() {
        Layer layer = new Layer();

        children.add(layer);
        return layer;
    }

    public int type() {
        return 2;
    }
}
