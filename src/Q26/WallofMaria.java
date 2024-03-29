package Q26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author iwana
 */
public class WallofMaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> bigList = new LinkedList<>();

        System.out.print("Enter number of layers: ");
        Scanner input = new Scanner(System.in);
        int layers = input.nextInt();
        input.nextLine();// To prevent skipping first entry

        for (int i = 0; i < layers; i++) {
            list.add(new LinkedList<>());
            System.out.printf("Enter brick edges of layer %d: ", i + 1);
            String str = input.nextLine(); // reads the line of integers
            ArrayList<String> strlist = new ArrayList<>(Arrays.asList(str.split(" "))); // converts the string to an array of string
            for (int j = 0; j < strlist.size(); j++) {
                list.get(i).add(Integer.valueOf(strlist.get(j))); // adds the elements of the array as integers into the linked list
            }
            bigList.addAll(list.get(i));// Add all the lists together
            Collections.sort(bigList);// sort in ascending order
        }
        frequency(bigList);
    }

    static void frequency(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer s : list) {
            Integer count = frequencyMap.get(s);
            if (count == null) {
                count = 0;
            }
            frequencyMap.put(s, count + 1);
        }
        int maxValueInMap = (Collections.max(frequencyMap.values()));
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.println("\nWeakest part of the wall is at position " + entry.getKey());
            }
        }
    }
}
