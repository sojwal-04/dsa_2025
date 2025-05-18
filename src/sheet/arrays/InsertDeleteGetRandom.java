package sheet.arrays;

import java.util.*;

public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();


        System.out.println(randomizedSet.insert(1));   // true
        System.out.println(randomizedSet.remove(2));   // false
        System.out.println(randomizedSet.insert(2));   // true
        System.out.println(randomizedSet.getRandom()); // 1 or 2
        System.out.println(randomizedSet.remove(1));   // true
        System.out.println(randomizedSet.insert(2));   // false
        System.out.println(randomizedSet.getRandom()); // 2
    }
}


class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private static Random random = new Random();


    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {

        if(map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {

        if(!map.containsKey(val)) {
            return false;
        }

        int valIndex = map.get(val);
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        Collections.swap(list, valIndex, lastIndex);

        map.remove(val);

        list.remove(lastIndex);
        map.put(lastVal, valIndex);

        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */