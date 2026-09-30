package Unit2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Glen_James_ArrayLists {
    public static void main(String[] args) {
        // Question One
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arrayList.add(i, "*");
        }

        arrayList.set(3 , "#");

        System.out.println(arrayList.get(3));
        System.out.println(arrayList.get(arrayList.size() - 1));

        // Question Two
        ArrayList<String> arrayList2 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arrayList2.add(i, "0");
        }

        arrayList2.set(0, "7");
        arrayList2.set(3, "dog");

        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.println(arrayList2.get(i));
        }

        // Question Three
        ArrayList<String> arrayList3 = new ArrayList<>();
        String word = "MINECRAFT";

        for (int i = 0; i < word.length(); i++) {
            String letter = String.valueOf(word.charAt(i));
            arrayList3.add(i, letter);
        }


        // Print mine and craft.
        for (int i = 0; i < 4; i++) {
            System.out.print(arrayList3.get(i));
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(arrayList3.get(i + 4));
        }

        System.out.println(); //

        // Question Four
        ArrayList<Integer> zero_list = new ArrayList<>();
        ArrayList<Integer> one_list = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            zero_list.add(i, 0);
        }

        for (int i = 0; i < 6; i++) {
            one_list.add(i, 1);
        }

        // A.
        for (int i = 0; i < zero_list.size(); i++) {
            try {
                System.out.println(i + " -> " + zero_list.get(i) + one_list.get(i));
            } catch (IndexOutOfBoundsException e ) {
                break;
            }
        }

        // B.
        for (int i = 0; i < zero_list.size(); i++) {
            System.out.println(3 * zero_list.get(i));
        }

        // C.
        ArrayList<Integer> one_zero_list = new ArrayList<>();

        for (int i = 0; i < one_list.size(); i++) {
            one_zero_list.add(one_list.get(i));
        }

        for (int i = 0; i < zero_list.size(); i++) {
            one_zero_list.add(zero_list.get(i));
        }

        System.out.println(one_zero_list);

        // D.

        ArrayList<Integer> zero_one_list = new ArrayList<>();

        for (int i = 0; i < zero_list.size(); i++) {
            zero_one_list.add(zero_list.get(i));
        }

        for (int i = 0; i < one_list.size(); i++) {
            zero_one_list.add(one_list.get(i));
        }

        System.out.println(zero_one_list);


        // E.
        ArrayList<Integer> zero_list_twos = new ArrayList<>(zero_list);

        zero_list_twos.add(2);
        zero_list_twos.add(2);
        zero_list_twos.add(2);

        System.out.println(zero_list_twos);
    }
}
