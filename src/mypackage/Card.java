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

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //    @Override
//    public String toString() {
//        if (Objects.equals(value, "As"))
//            return "La carte tirée est l'" + value + " de " + color;
//        else if (Objects.equals(value,"Reine"))
//            return "La carte tirée est la " + value + " de " + color;
//        else
//        return "La carte tirée est le " + value + " de " + color;
//    }

    @Override
    public String toString() {
        return "\n-----\n" + "  " + value + "\n" + "  " + color + "\n-----";

    }

}