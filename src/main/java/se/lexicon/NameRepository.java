package se.lexicon;

import java.util.Arrays;

public class NameRepository {

    private static String[] names={};

    public static int getSize(){
        return names.length;
    }

    public static void setNames(String[] names){
      NameRepository.names= Arrays.copyOf(names,names.length);
      System.out.println("setNames = " + Arrays.toString(NameRepository.names));
    }


    public static void clear(){
        names= new String[]{};


    }

    public static String[] findAll(){
        return names;
    }


    public static String find(final String fullName){
            for(String name:names) {
            if (name.equalsIgnoreCase(fullName)) {
                return name;
            }
        }
          return null;
    }

    public static boolean add(final String fullName){

       if(fullName.equalsIgnoreCase(find(fullName))){
            return false;
        }
        names=Arrays.copyOf(names,names.length+1);
        names[names.length -1]=fullName;
        System.out.println("Names = " + Arrays.toString(names));
        return true;
    }



}
