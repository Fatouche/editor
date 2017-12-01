package org.ulco;

public class Triangle extends GraphicsObject{
    // Variables
    private final Point center;
    private final double height;
    private final double length;

    // Constructeurs
    public Triangle(Point center, double length, double height) {
        this.center = center;
        this.height = height;
        this.length = length;
    }

    public Triangle(Point center, double length, double height, String colorIn, String colorBorder) {
        this.center = center;
        this.height = height;
        this.length = length;

        switch (colorIn){
            case "BLACK":
                this.setColor(GraphicsObject.Colors.BLACK);
                break;
            case "RED":
                this.setColor(GraphicsObject.Colors.RED);
                break;
            case "BLUE":
                this.setColor(GraphicsObject.Colors.BLUE);
                break;
            case "WHITE":
                this.setColor(GraphicsObject.Colors.WHITE);
                break;
            case "GREEN":
                this.setColor(GraphicsObject.Colors.GREEN);
                break;
        }

        switch (colorBorder){
            case "BLACK":
                this.setborderColor(GraphicsObject.Colors.BLACK);
                break;
            case "RED":
                this.setborderColor(GraphicsObject.Colors.RED);
                break;
            case "BLUE":
                this.setborderColor(GraphicsObject.Colors.BLUE);
                break;
            case "WHITE":
                this.setborderColor(GraphicsObject.Colors.WHITE);
                break;
            case "GREEN":
                this.setborderColor(GraphicsObject.Colors.GREEN);
                break;
        }
    }

    public GraphicsObject copy() {
        String colorIn = "";
        String colorBorder = "";

        switch (this.getColor()){
            case BLACK:
                colorIn = "BLACK";
                break;
            case RED:
                colorIn = "RED";
                break;
            case BLUE:
                colorIn = "BLUE";
                break;
            case WHITE:
                colorIn = "WHITE";
                break;
            case GREEN:
                colorIn = "GREEN";
                break;
        }

        switch (this.getborderColor()){
            case BLACK:
                colorBorder = "BLACK";
                break;
            case RED:
                colorBorder = "RED";
                break;
            case BLUE:
                colorBorder = "BLUE";
                break;
            case WHITE:
                colorBorder = "WHITE";
                break;
            case GREEN:
                colorBorder = "GREEN";
                break;
        }
        return new Triangle(center.copy(), length, height, colorIn, colorBorder);
    }

    public Point getCenter() {
        return center;
    }

    Point center() {
        return center;
    }

    void move(Point delta) {
        center.move(delta);
    }

    public String toString() {
        return "triangle [" + center.toString() + "," + height + "," + length + "]";
    }

    public double get_height() {
        return height;
    }

    public double get_length() {
        return length;
    }

    public String get_name() {
        return "triangle";
    }
}