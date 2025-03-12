class PokemonDatabase {
    private Map<String, Pokemon> pokemonMap;

    public PokemonDatabase(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void loadFromFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String name = data[1].trim();
            String type1 = data[2].trim();
            String type2 = data[3].trim();
            List<String> abilities = Arrays.asList(data[4].trim().split(";"));
            pokemonMap.put(name, new Pokemon(name, type1, type2, abilities));
        }
        br.close();
    }

    public Pokemon getPokemon(String name) {
        return pokemonMap.get(name);
    }

    public Collection<Pokemon> getAllPokemons() {
        return pokemonMap.values();
    }
}
