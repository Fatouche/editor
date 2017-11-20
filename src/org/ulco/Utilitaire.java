package org.ulco;

import java.lang.reflect.Constructor;

public class Utilitaire {

    static public GraphicsObjects select(Document document, Point point, double distance){
        GraphicsObjects list = new GraphicsObjects();
        for(Layer layer : document.getM_layers()){
            for(GraphicsObject object : layer.getM_list()) {
                if(object.isClosed(point, distance)){
                    list.add(object);
                }
            }
        }
        return list;
    }
}
