package org.ulco;
import java.util.Vector;

public interface Builder extends Parsable{

    Vector<?> get_children();
    String[] get_types_children();
}
