package org.ulco.test;

import junit.framework.TestCase;
import org.junit.Test;
import org.ulco.*;

public class ColorTest extends TestCase{

    public void testColor() throws Exception {
        Point p = new Point(2,10);
        Square s = new Square(p,3);

        s.setColor(GraphicsObject.Colors.BLUE);
        assertEquals(s.getColor(), GraphicsObject.Colors.BLUE);

        s.setborderColor(GraphicsObject.Colors.BLACK);
        assertEquals(s.getborderColor(), GraphicsObject.Colors.BLACK);
    }
}
