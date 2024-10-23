package se.lexicon;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println("Size of Array::"+ NameRepository.getSize());

        //Add names and display all the names available in Array.
        NameRepository.add("Sayana Surendran");
        NameRepository.add("Erik Svensson");
        System.out.println("Displays all elements in Names Array:"+ Arrays.toString(NameRepository.findAll()));
        System.out.println(NameRepository.add("Sayana Surendran"));

        //Replaces the existing names in NamesArray with below names
        NameRepository.setNames(new String[]{"Philip Thomas", "Ulf Svensson", "Simon Svensson", "Kent Svensson"});
        System.out.println("Displays all elements in Names Array:"+ Arrays.toString(NameRepository.findAll()));

        //prints if Name is available in Array, if not returns null
        System.out.println("Name found ::"+NameRepository.find("Sayana Surendran"));
        System.out.println("Name found ::"+NameRepository.find("Sayana"));
        System.out.println("Name found ::"+NameRepository.find("Philip Thomas"));

        //returns the size of Array
        System.out.println("Size of Array::"+ NameRepository.getSize());

        //returns empty array
        NameRepository.clear();
        System.out.println("Size of Array::"+ NameRepository.getSize());

    }
}