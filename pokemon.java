import java.io.*;
import java.util.*;

class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private List<String> abilities;

    public Pokemon(String name, String type1, String type2, List<String> abilities) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.abilities = abilities;
    }

    public String getName() { return name; }
    public String getType1() { return type1; }
    public List<String> getAbilities() { return abilities; }

    @Override
    public String toString() {
        return name + " (" + type1 + (type2.isEmpty() ? "" : "/" + type2) + ") - " + abilities;
    }
}
