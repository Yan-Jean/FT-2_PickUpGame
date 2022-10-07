package mypackage;

import java.util.Objects;

public class Card {

    public String color;
    public String value;

    public Card(String value, String color) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "\n-----\n" + "  " + value + "\n" + "  " + color + "\n-----";

    }

}