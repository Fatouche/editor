package org.ulco.test;

import junit.framework.TestCase;
import org.ulco.*;

public class TriangleTest extends TestCase {

    public void testTriangle() throws Exception{
        Point p = new Point(7,14);
        double height = 12;
        double width = 5;
        Triangle m_triangle = new Triangle(p,height,width);

        assertTrue(m_triangle instanceof Triangle);
        assertTrue(m_triangle instanceof  GraphicsObject);
    }
}