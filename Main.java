public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la implementación de Map:");
        System.out.println("1) HashMap  2) TreeMap  3) LinkedHashMap");
        String option = scanner.nextLine();
        String mapType = option.equals("1") ? "HashMap" : option.equals("2") ? "TreeMap" : "LinkedHashMap";

        Map<String, Pokemon> pokemonMap = MapFactory.getMap(mapType);
        PokemonDatabase database = new PokemonDatabase(pokemonMap);
        PokemonCollection userCollection = new PokemonCollection();

        try {
            database.loadFromFile("pokemon.csv");
        } catch (IOException e) {
            System.err.println("Error al cargar datos.");
            return;
        }

        while (true) {
            System.out.println("\n1) Agregar Pokémon a colección");
            System.out.println("2) Mostrar datos de un Pokémon");
            System.out.println("3) Mostrar colección del usuario ordenada por tipo");
            System.out.println("4) Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5) Buscar Pokémon por habilidad");
            System.out.println("6) Salir");
            System.out.print("Seleccione opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String pokemonName = scanner.nextLine();
                    Pokemon p = database.getPokemon(pokemonName);
                    if (p != null) {
                        if (userCollection.addPokemon(p)) {
                            System.out.println(pokemonName + " agregado.");
                        } else {
                            System.out.println(pokemonName + " ya está en la colección.");
                        }
                    } else {
                        System.out.println("Pokémon no encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String searchName = scanner.nextLine();
                    Pokemon searchedPokemon = database.getPokemon(searchName);
                    if (searchedPokemon != null) {
                        System.out.println(searchedPokemon);
                    } else {
                        System.out.println("Pokémon no encontrado.");
                    }
                    break;
                case 3:
                    userCollection.getUserPokemonsSortedByType().forEach(System.out::println);
                    break;
                case 4:
                    database.getAllPokemons().stream()
                        .sorted(Comparator.comparing(Pokemon::getType1))
                        .forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad: ");
                    String ability = scanner.nextLine();
                    database.getAllPokemons().stream()
                        .filter(pkm -> pkm.getAbilities().contains(ability))
                        .forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
