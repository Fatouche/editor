package org.ulco;

public interface Parsable {

    // Get
    String get_name();
    String get_builder_type();

    int type();

    String[] child_types = null;
}
