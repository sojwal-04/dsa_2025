package sheet.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Temp {
    public static void main(String[] args) {
//        Queue<Integer> q = new LinkedList<>();
//
//        q.add(4);
//        q.add(5);
//        q.add(6);
//
//        System.out.println(q.poll() + " " + q.size());

        ArrayList<String> lst = new ArrayList<>();

        lst.add("geeks");
        lst.add("for");
        lst.add("geeks");


//        System.out.println(Collections.frequency(lst,"geeks"));

        Collections.sort(lst);
        System.out.println(lst);

//        int arr[][] = new int[2][2]{{1,2}, {2,4}};

        String s1 = "Geeks";
        String s2 = "eeGesk";


        int res = 0;

        for(int i =0; i < s1.length(); i++){
            res ^= s1.charAt(i);
        }

        for(int i = 0; i < s2.length(); i++){
            res ^= s2.charAt(i);
        }


        System.out.println((char) res);
    }
}
