package ui;

import data.PersonRepository;
import data.Repositories;
import domain.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private final PersonRepository repo = Repositories.getPersonRepo();
    private final Map<Integer, Runnable> commands = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private static final int OPTION_EXIT = 9;

    private void run() {
        initRepository();
        initCommands();

        boolean cont = true;

        while (cont) {
            cont = showMenu();
        }
    }

    private void initCommands() {
        commands.put(1, this::listAllPersonsSortedByAge);
        commands.put(2, this::listAllPersonsSortedByName);
        commands.put(3, this::calculateAverageAge);
        commands.put(4, this::filterByAge);
        commands.put(5, this::groupByAge);
        commands.put(6, this::displayAgeStatistics);
        commands.put(OPTION_EXIT, this::exit);
    }

    private boolean showMenu() {
        System.out.println("1. listAllPersonsSortedByAge");
        System.out.println("2. listAllPersonsSortedByName");
        System.out.println("3. calculateAverageAge");
        System.out.println("4. filterByAge >18");
        System.out.println("5. groupByAge");
        System.out.println("6. displayAgeStatistics");
        System.out.println("9. exit");
        System.out.println();

        Optional<Integer> input = readIntChoice();
        if (input.isPresent()) {
            if (commands.containsKey(input.get())) {
                commands.get(input.get()).run();

                return input.get() != OPTION_EXIT;
            } else {
                System.out.println("ERROR - invalid input");
                return true;
            }
        } else {
            System.out.println("ERROR - invalid input, only numbers allowed");
            return true;
        }
    }

    private Optional<Integer> readIntChoice() {
        String input = scanner.nextLine();

        try {
            int i = Integer.parseInt(input);
            return Optional.of(i);
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }

    private void exit() {
        System.out.println("Goodbye!");
    }

    private void displayAgeStatistics() {
        DoubleSummaryStatistics stats =
            repo.getPersons()
                    .stream()
                    .collect(Collectors.summarizingDouble(Person::getAge));

        System.out.println(stats);
    }

    private void groupByAge() {
        Map<Integer, List<Person>> persons =
                repo.getPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));

        persons.forEach((a, p) -> System.out.printf("%d -> %s%n", a, p));
    }

    private void filterByAge() {
        repo.getPersons()
            .stream()
            .filter(e -> e.getAge() > 18)
            .forEach(System.out::println);
    }

    private void calculateAverageAge() {
        double avg = repo.getPersons().stream()
            .mapToInt(Person::getAge)
            .average()
            .orElse(0);

        System.out.println(avg);
    }

    private void listAllPersonsSortedByName() {
        repo.getPersons().stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }

    private void listAllPersonsSortedByAge() {
        repo.getPersons().stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
    }

    private void initRepository() {
        repo.addPerson(new Person("Jughead", 18));
        repo.addPerson(new Person("Betty", 18));
        repo.addPerson(new Person("Veronica", 21));
        repo.addPerson(new Person("Archie", 20));
    }

}
