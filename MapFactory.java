class MapFactory {
    public static Map<String, Pokemon> getMap(String type) {
        switch (type) {
            case "HashMap": return new HashMap<>();
            case "TreeMap": return new TreeMap<>();
            case "LinkedHashMap": return new LinkedHashMap<>();
            default: throw new IllegalArgumentException("Tipo de Mapa no válido.");
        }
    }
}
