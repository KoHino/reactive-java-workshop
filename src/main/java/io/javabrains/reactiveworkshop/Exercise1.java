package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("print all numbers");
        StreamSources.intNumbersStream().forEach(num -> System.out.println(num));

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("print numbers less than 5");
        StreamSources.intNumbersStream().filter(num -> num < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("print the second and third numbers greater than 5");
        StreamSources.intNumbersStream().filter(num -> num > 5)
            .skip(1)
            .limit(2)
            .forEach(num -> System.out.println(num));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("print the first numbers greater than 5");
        Integer value = StreamSources.intNumbersStream().filter(num -> num > 5)
            .findFirst()
            .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        System.out.println("print first name of all users");
        StreamSources.userStream() //.forEach(user -> System.out.println(user.getFirstName()));
            .map(user -> user.getFirstName())
            .forEach(userName -> System.out.println(userName));
        
        // Print first names in userStream for users that have IDs from number stream
        System.out.println("print first name of users that have IDs from number stream");
        StreamSources.userStream()
            .filter(user -> 
                    StreamSources.intNumbersStream().anyMatch(i -> i == user.getId()))
            .map(user -> user.getFirstName())
            .forEach(userName -> System.out.println(userName));

        StreamSources.intNumbersStream()
            .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
            .map(user -> user.getFirstName())
            .forEach(userName -> System.out.println(userName));

    }

}
