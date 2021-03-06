package org.ulco;

public class Square extends Rectangle {

    // Constructeurs
    public Square(Point center, double length) {
        this.m_origin = center;
        this.m_width  = length;
    }

    public Square(String json) {
        m_origin = JSON.parsePoint(json, "length");
        m_width = JSON.parseDouble(json, "length", "}");
        m_height = JSON.parseDouble(json, "length", "}");
    }

    public GraphicsObject copy() {
        return new Square(m_origin.copy(), m_width);
    }

    // Get
    @Override
    public String get_name() {
        return "square";
    }


    public String toString() {
        return "square[" + m_origin.toString() + "," + m_width + "]";
    }
}
