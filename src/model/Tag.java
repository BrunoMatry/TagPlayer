package model;

import java.awt.Color;

public class Tag {
    private final String name;
    private final Color textColor;
    private final Color backgroundColor;

    public Tag(String name, Color textColor, Color backgroundColor) {
        this.name = name;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public String getName() {
        return name;
    }
}
