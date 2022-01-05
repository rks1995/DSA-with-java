package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Krushkal {

	static Scanner s = new Scanner(System.in);
	static int n, e;
	static int count = 0;
	static ArrayList<Edge> MST;
	static int parent[];
	static int size[];
	private static int findParent(int v) {
		if(v == parent[v]) {
			return v;
		}
		return findParent(parent[v]);
	}
	
	public static void krushkalAlgo(ArrayList<Edge> edgeList) {
		MST = new ArrayList<>();
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		for (Edge e : edgeList) {
			int v1 = e.v1;
			int v2 = e.v2;
			v1 = findParent(v1);
			v2 = findParent(v2);
			if(count == n-1) break;
			if (v1 != v2) {
				count++;
				MST.add(e);
				if(size[v1] > size[v2]) {
					int temp = v1;
					v1 = v2;
					v2 = temp;
				}
				parent[v1] = v2;
				size[v2] += size[v1];
			}
		}

}

	public static void main(String[] args) {
		n = s.nextInt();
		e = s.nextInt();
		ArrayList<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			if(v1 > v2) {
				int a = v1;
				v1 = v2;
				v2 = a;
			}
			int w = s.nextInt();
			Edge e = new Edge(v1, v2, w);
			edgeList.add(e);
		}

		Collections.sort(edgeList, new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				if (e1.w == e2.w)
					return 0;
				if (e1.w > e2.w)
					return 1;
				else
					return -1;
			}
		});
		krushkalAlgo(edgeList);
		for (Edge e : MST) {
			System.out.println(e.v1 + " " + e.v2 + " " + e.w);
		}
	}
}
