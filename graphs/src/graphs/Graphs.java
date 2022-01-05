package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs {
	
	public static void dfs(int[][] matrix, int source, int size, boolean[] visited) {
		
		visited[source] = true;
		System.out.print(source+ " ");
		
		for(int i=0; i<size; i++) {
			if(matrix[source][i] == 1 && !visited[i]) {
				dfs(matrix, i, size, visited);
			}
		}
		//disconnect graph;
		System.out.println();
		for(int i=0; i<size; i++) {
			if(!visited[i]) {
				dfs(matrix, i, size, visited);
			}
		}
	}
	
	public static void bfs(int[][] matrix) {
		Queue<Integer>q = new LinkedList<>();
		boolean visited[] = new boolean[matrix.length];
		
		for(int city=0; city<matrix.length; city++) {
			if(!visited[city]) {
				q.add(city);
				visited[city] = true;
			}
			while(!q.isEmpty()) {
				int currVertex = q.poll();
				System.out.print(currVertex + " ");
				for(int i=0; i<matrix.length; i++) {
					if(matrix[currVertex][i] == 1 && !visited[i]) {
						q.add(i);
						visited[i] = true;
					}
				}
			}
		}
	}
	
	public static boolean hasPathBFS(int[][] matrix, int a, int b) {
    	Queue<Integer> pendingCities = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];
        pendingCities.add(a);
        visited[a] = true;
        
        while(!pendingCities.isEmpty()) {
            int city = pendingCities.poll();
            for(int neighbourCity = 0; neighbourCity<matrix.length; neighbourCity++) {
                if(matrix[city][neighbourCity] == 1 && !visited[neighbourCity]) {
                    pendingCities.add(neighbourCity);
                    visited[neighbourCity] = true;
                }
            }
        }
        
        return visited[a]&&visited[b];
    }
	
	public static boolean hasPathDFS(int[][] matrix, int s, int d, boolean[] visited) {
		visited[s] = true;
		for(int city=0; city<matrix.length; city++) {
			if(matrix[s][city] == 1 && !visited[city]) {
				hasPathDFS(matrix, city, d, visited);
			}
		}
		return visited[s] && visited[d];
	}
	
	public static void getPathDFS(int[][] m, int s, int d, String path, boolean[] v) {
		if(s == d) {
			v[d] = true;
            path = d+" "+path;
            System.out.print(path);
            return;
        }
		
        v[s] = true;
        for(int i=0; i<m.length; i++) {
            if(m[s][i] == 1 && !v[i]) {
                getPathDFS(m, i, d, s+" "+path, v);
            }
        }
        
    }
	
	public static ArrayList<Integer> getPathBFS(int[][] m, int s, int d) {
		Queue<Integer> pendingVertices = new LinkedList<>();
		ArrayList<Integer>path = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		boolean visited[] = new boolean[m.length];
		map.put(s, -1);
		pendingVertices.add(s);
		visited[s] = true;
		while(!pendingVertices.isEmpty()) {
			int cv = pendingVertices.poll();
			for(int i=0; i<m.length; i++) {
				if(m[cv][i] == 1 && !visited[i]) {
					pendingVertices.add(i);
					visited[i] = true;
					map.put(i, cv);
					if(i == d) {
						path.add(d);
						int parent = map.get(d);
						while(parent != -1) {
							path.add(parent);
							parent = map.get(parent);
						}
						break;
					}
				}
			}
		}
		return path;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s[] = br.readLine().split("\\s");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        
		int adjMatrix[][] = new int[n][n];
		
		for(int i=0; i<e; i++) {
			String s1[] = br.readLine().split("\\s");
			int v1 = Integer.parseInt(s1[0]);
			int v2 = Integer.parseInt(s1[1]);
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;	
		}
		String s2[] = br.readLine().split("\\s");
		int a = Integer.parseInt(s2[0]);
		int b = Integer.parseInt(s2[1]);
		
//		boolean []visited = new boolean[n];
//		dfs(adjMatrix, 0, n, visited);
//		System.out.println();
//		bfs(adjMatrix);
//		System.out.println(hasPathBFS(adjMatrix, a, b));
//		System.out.println(hasPathDFS(adjMatrix, a, b, visited));
		//getPathDFS(adjMatrix, a, b, "", visited);
		ArrayList<Integer> ans = getPathBFS(adjMatrix, a, b);
		System.out.println(ans);
		if(ans != null) {
			for(int i: ans) {
				System.out.print(i + " ");
			}
		}
	}
}
