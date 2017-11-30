package org.ulco;

import java.util.Vector;

public class Group extends GraphicsObject{
    private Vector<GraphicsObject> m_objectList;
    private int m_ID;

    @Override
    public boolean isGroup() {
        return true;
    }

    @Override
    public boolean isClosed(Point pt, double distance) {
        for (GraphicsObject go : m_objectList){
            if (go.isClosed(pt, distance)){
                return true;
            }
        }
        return false;
    }

    public int compteurGroup(){
        int compteur = 0;
        for(GraphicsObject object : m_objectList){
            if(object.isGroup()){
                compteur = compteur +1;
            }
        }
        return compteur;
    }

    public Group() {
        m_objectList = new Vector<>();
        m_ID = ID.getInstance().suivant();
    }

    public Group(String json) {
        Vector<String> separators = new Vector<String>();
        separators.add("objects");
        separators.add("groups");
        separators.add("}");
        m_objectList = JSON.parseItems(json, separators);
    }

    public void add(Object object) {
        addObject((GraphicsObject)object);
    }

    private void addObject(GraphicsObject object) {
        m_objectList.add(object);
    }

    public Group copy() {
        Group g = new Group();

        for (GraphicsObject o : m_objectList) {
            g.addObject(o.copy());
        }
        return g;
    }

    public int getID() {
        return m_ID;
    }

    public void move(Point delta) {

        for (Object o : m_objectList) {
            GraphicsObject element = (GraphicsObject) (o);

            element.move(delta);
        }
    }

    Point center() {
        return null;
    }

    public int size() {
        int size = 0;

        for (int i = 0; i < m_objectList.size(); ++i) {
            size += m_objectList.get(i).size();
        }
        return size;
    }

    public int type() {
        return 2;
    }

    public String export(String type) {
        boolean json = type.equals("json");
        String object_str = (json) ? "{ type: group, objects : { " : "group[[";
        String group_str = (json) ? " }, groups : { " : "],[";
        String suffix_str = (json) ? " } }" : "]]";
        for (GraphicsObject element : m_objectList) {

            if (element.type() == 1) {
                object_str += ((json) ? element.toJson() : element.toString()) + ", ";
            } else {
                group_str += json ? element.toJson() : element.toString();
            }
        }
        return object_str.substring(0, object_str.length() -2) + group_str + suffix_str;
    }

    public String toJson() {
        return export("json");
    }

    public String toString() {
        return export("string");
    }
}
