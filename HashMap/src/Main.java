import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        HashTableLP ht = new HashTableLP();
        ht.put(25, "ABCD");
        ht.put(35,"XYZ");
        ht.put(10,"AMEN");
        System.out.println(ht.get(25));
        ht.remove(35);
        System.out.println(ht.get(35));
        System.out.println(ht.get(10));
//        System.out.println(Arrays.toString(twoSum(new int[]{0, 2, 4, 9, 11, 15}, 9)));
//        int nOfPairs = pairsWithDifferenceK(new int[]{8, 12, 16, 4, 0, 20}, 4);
//        System.out.println(nOfPairs);
//        int mostFrequent = mostRepeatedCharacter(new int[]{1, 2, 2, 3, 3, 3, 4});
//        System.out.println(mostFrequent);
//        char firstNonRepeatedCharacter = firstNonRepeatedCharacter("A gregen Apple".toLowerCase());
//        System.out.println(firstNonRepeatedCharacter);
    }
    public static Character firstNonRepeatedCharacter(String s){
        Map<Character, Integer> map = new HashMap<>();
        var chars = s.toCharArray();
        for (char c : chars){
            if (!map.containsKey(c) ){
                map.put(c,1);
            }else map.put(c,map.get(c)+1);
        }
        for (char key: chars){
            if (map.get(key) == 1)
                return key;
        }
        return Character.MIN_VALUE;
    }

    public static int mostRepeatedCharacter(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int mostFrequent = 0;
        int frequency = 0;
        for (int i: arr) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.put(i, ++count);
                if (count > frequency) {
                    frequency = count;
                    mostFrequent = i;
                }
            } else {
                map.put(i, 1);
                if (1 > frequency) {
                    frequency = 1;
                    mostFrequent = i;
                }
            }
        }
        return mostFrequent;
    }

    public static int pairsWithDifferenceK(int[] arr, int k){
        Map<Integer, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i : arr)
            map.put(i,true);
        for (int i : arr){
            if (map.containsKey(i-k) && map.get(i-k))
                count++;
            if (map.containsKey(i+k) && map.get(i+k))
                count++;
            map.put(i,false);
        }
        return count;
    }

    public static int[] twoSum(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] indices = new int[2];
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], i);
        }
        for (int e: arr){
            if (map.containsKey(target-e)){
                indices[0] = map.get(e);
                indices[1] = map.get(target-e);
                return indices;
            }
        }
        return null;
    }
}
