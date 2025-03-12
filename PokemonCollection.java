class PokemonCollection {
    private Set<Pokemon> userPokemons = new HashSet<>();

    public boolean addPokemon(Pokemon pokemon) {
        return userPokemons.add(pokemon);
    }

    public void showUserCollection() {
        userPokemons.forEach(System.out::println);
    }

    public List<Pokemon> getUserPokemonsSortedByType() {
        List<Pokemon> sortedList = new ArrayList<>(userPokemons);
        sortedList.sort(Comparator.comparing(Pokemon::getType1));
        return sortedList;
    }
}
