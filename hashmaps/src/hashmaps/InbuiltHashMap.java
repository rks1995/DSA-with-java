package hashmaps;
import java.util.ArrayList;
import java.util.HashMap;

public class InbuiltHashMap {

	public static ArrayList<Integer> removeDuplicates(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		ArrayList<Integer>ans = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				ans.add(arr[i]);
				map.put(arr[i], true);
			}
		}
		return ans;
	}
	
	public static int maxFrequency(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> keys = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				keys.add(arr[i]);
			}else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		
		int key = 0;
		int freq = 0;
		for(int k: keys) {
			if(map.get(k) > freq) {
				freq = map.get(k);
				key = k;
			}
		}
		
		return key;
		
	}
	public static void intersection(int[] arr1, int[] arr2) {
	    HashMap<Integer, Integer> map = new HashMap<>();
	    for(int i=0; i<arr1.length; i++) {
	    	if(!map.containsKey(arr1[i])) {
	    		map.put(arr1[i], 1);
	    	}else {
	    		map.put(arr1[i], map.get(arr1[i])+1);
	    	}
	    }
	    
	    for(int item: arr2) {
	    	if(map.containsKey(item) && map.get(item) > 0) {
	    		System.out.print(item+ " ");
	    		map.put(item, map.get(item)-1);
	    	}
	    }
	}
	public static void main(String[] args) {
//		HashMap<String, Integer> map = new HashMap<>();
//		map.put("abc", 1);
//		map.put("def", 3);
//
//		System.out.println(map.get("abc"));
//		System.out.println(map.get("def"));
//		
//		Set<String>keys = map.keySet();
//		for(String s: keys) {
//			System.out.println(s + " " + map.put(s, 18));
//		}
//		
//		System.out.println(map.get("abc"));
//		System.out.println(map.get("def"));
		
		int arr[] = {1,2,2,10,2,3,1,6,6,6,5,3};
		ArrayList<Integer> output = removeDuplicates(arr);
		System.out.println(output);
		System.out.println(maxFrequency(arr));
		int arr1[] = {10,10};
		int arr2[] = {10};
		intersection(arr1, arr2);
		

	}

}


//some important methods in hash maps
/*constant operation
 * put(k,v) -> puts a key value pair
 * remove(k)-> removes a key
 * get(k)-> gets the value of corresponding key
 * containsKey(K) -> returns boolean if key is present or not
 * ===================================================================>
 * O(n) time
 * keySet() -> returns keys in the form of set
 * constainsValue()-> returns boolean if value is present or not
 * 
 */
