import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
public class MyCFG {
    public static void main(String args[]){
        String file_name;
        Scanner in;
        HashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
        String value;
        String k;
        try {
            //read the file, ignore the dashes and lines
            file_name = "Test_1.txt";
            in = new Scanner(new FileReader(file_name)).useDelimiter("\\W|\\s");
            //Read as long as there is a new line
            while(in.hasNextLine()){
                if(in.hasNext()){
                    //set the first letter of a line as the key in the hashmap
                    k=in.next();
                    map.put(k,new ArrayList<String>());
                    System.out.println("Added key " + k );

                    if(in.hasNext()){
                        while(in.hasNext()){
                            // add additional string of letters to the arraylist in the hashmap, with corresponding key
                            value=in.next();
                            System.out.println("Linked value \"" + value + "\" to key " + k);
                            map.get(k).add(value);
                            if(in.hasNext("")){
                                break;
                            }
                        }
                    }
                    if(in.hasNext("")){
                        in.next();
                    }
                }
            }
            //Map Print Out
            System.out.println("                    ");
            System.out.println("Hash Map: ");
            System.out.println(map);
            remove0(map);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    //get file name from the user
    public static String readUser(){
        System.out.println("Enter the file name:");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        in.close();
        return name;
    }
    public static void remove0(HashMap<String,ArrayList<String>> map){
        for(String name : map.keySet()){
            if(map.get(name).contains("0")){
                System.out.println("Empty Here " + name);
            }
        }

    }
}
