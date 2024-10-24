package se.lexicon;

import java.util.Arrays;

public class NameRepository {

    private static String[] names = {};

    /**
     * Returns the number of elements present in  names array
     */
    public static int getSize() {
        return names.length;
    }

    /**
     * sets the names to names array.It replaces all the existing elements
     *
     * @param names the names array to be set
     */

    public static void setNames(String[] names) {
        NameRepository.names = Arrays.copyOf(names, names.length);
        //System.out.println("setNames = " + Arrays.toString(NameRepository.names));
    }


    /**
     * Clears the names array
     */
    public static void clear() {
        names = new String[]{};
    }

    /**
     * Retrieves all the elements from an array.
     *
     * @return names array
     */
    public static String[] findAll() {
        return names;
    }

    /**
     * Search for the given name
     *
     * @param fullName The name to be searched
     * @return name or null if it finds in array or not respectively
     */

    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName)) {
                return name;
            }
        }
        return null;
    }


    /**
     * Adds the name to the names array
     *
     * @param fullName name to be added
     * @return true if name is added or false if name already exists
     */
    public static boolean add(final String fullName) {

        if (fullName.equalsIgnoreCase(find(fullName))) {
            return false;
        }
        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = fullName;
        System.out.println("Names = " + Arrays.toString(names));
        return true;
    }



    /**
     * to search by firstName
     *
     * @param firstName searches the names array with firstName
     * @return an array which consists of matching firstnames
     */
    public static String[] findByFirstName(final String firstName) {
        String fullNames[] = {};
        for (String name : names) {
            if (name.split(" ")[0].equalsIgnoreCase(firstName)) {
                fullNames = Arrays.copyOf(fullNames, fullNames.length + 1);
                fullNames[fullNames.length - 1] = name;
            }
        }
        return fullNames;
    }



    /**
     * to search by lastName
     * @param lastName searches the names array wih lastName
     * @return an array which consists of matching firstnames
     */

    public static String[] findByLastName(final String lastName) {
        String fullNames[] = {};
        for (String name : names) {
            if (name.split(" ")[1].equalsIgnoreCase(lastName)) {
                fullNames = Arrays.copyOf(fullNames, fullNames.length + 1);
                fullNames[fullNames.length - 1] = name;
            }

        }
        return fullNames;
    }


    /**
     * Updates the neames array with the given name
     * @param original name which exist in names array
     * @param updatedName name to be updated for original name
     * @return true if updated or false if name not found and not updated
     */


    public static boolean update(final String original, final String updatedName) {
        String name = find(original);

        if (name != null && !name.equalsIgnoreCase(updatedName)) {
            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(name)) {
                    names[i] = updatedName;

                }
            }
            System.out.println( Arrays.toString(names));
            return true;
        } else {
            System.out.println( Arrays.toString(names));
            return false;
        }

    }


    /**
     *
     * @param fullName name to be removed from names array
     * @return trus if removed or false if name not found
     */

    public static boolean remove(final String fullName) {
        String name = find(fullName);
        if (name != null) {
            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(fullName)) {
                    String temp = names[0];
                    names[0] = names[i];
                    names[i] = temp;
                    names = Arrays.copyOfRange(names, 1, names.length);
                    System.out.println( Arrays.toString(names));
                    return true;
                }
            }
        }
        System.out.println("Array after removing name"+ Arrays.toString(names));
        return false;
    }


}
