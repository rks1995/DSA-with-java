package hashmaps;

public class MapUse {

	public static void main(String[] args) {
		Hashmaps<String, Integer> hm = new Hashmaps<>();
		
		hm.insert("abc", 1);
		hm.insert("def", 2);
		hm.insert("ghi", 3);
		
		System.out.println(hm.get("abc"));
		System.out.println(hm.get("def"));
		System.out.println(hm.get("ghi"));
		System.out.println("size" + hm.size());
		System.out.println(hm.search("abc"));
		
		hm.remove("abc");
		hm.remove("def");
		
		System.out.println("size" + hm.size());
		System.out.println(hm.search("abc"));
		System.out.println(hm.get("abc"));
		
	}

}
