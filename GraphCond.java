import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
public class GraphCond {
    public static int n;
    public static int m;
    public static boolean[] used;
    public static Stack<Integer> order;
    public static int[][] matrix;
    public static int[][] rmatrix;
    public static int count;
    public static Stack<Integer> component;
    public static HashMap<Integer,ArrayList<Integer>> Hash;
    public static HashMap<Integer,ArrayList<Integer>> RHash;
    public static int[] Prinadlezhdost;
    public static void dfs(int v, boolean for_reversed){
        used[v] = true;
        if(for_reversed){
            component.add(v);
            ArrayList<Integer> array = RHash.get(v);
            for(int item: array){
                if(!used[item]){
                    dfs(item,for_reversed);
                }
            }
        }
        else{
            ArrayList<Integer> array = Hash.get(v);
            for(int item: array){
                if(!used[item]){
                    dfs(item,for_reversed);
                }
            }
            order.add(v);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        matrix = new int[n][n];
        rmatrix = new int[n][n];
        for(int i = 0; i < m; i++){
            String[] str1 = in.nextLine().split(" ");
            int a = Integer.parseInt(str1[0]);
            int b = Integer.parseInt(str1[1]);
            matrix[a-1][b-1] = 1;
            rmatrix[b-1][a-1] = 1;
        }
        Prinadlezhdost = new int[n];
        used = new boolean[n];
        component = new Stack<>();
        order = new Stack<>();
        Hash = new HashMap<>();
        RHash = new HashMap<>();
        for(int i = 0; i < n ; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> rarr = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(matrix[i][j]==1)
                    arr.add(j);
                if(rmatrix[i][j]==1)
                    rarr.add(j);
            }
            Hash.put(i,arr);
            RHash.put(i,rarr);
        }
        for(int i = 0; i < n; i++){
            used[i] = false;
        }
        for(int i = 0; i < n; i++){
            if(!used[i])
                dfs(i,false);
        }
        for(int i = 0; i < n; i++)
            used[i] = false;
        count = 1;
        for(int i = 0; i < n; ++i){
            int v = order.get(n-1-i);
            if(!used[v]){
                dfs(v,true);
                for(var item: component){
                    Prinadlezhdost[item]=count;
                }
                count++;
                component.clear();
            }
        }
        Hash = null;
        RHash = null;
        matrix = null;
        rmatrix = null;
        used = null;
        order = null;
        System.gc();
        System.out.println(count-1 +"\n");
        for(int i = 0 ; i < n ; i++){
            System.out.print(Prinadlezhdost[i]+" ");
        }
    }
}

