import java.util.*;

class Main{

    static List<Integer> list = new ArrayList<>();
    static StringBuilder stringBuilder = new StringBuilder();

    static void dfs(int N, int startIdx, int M, int depth){
        if(M == depth){
            for(int num : list)
                stringBuilder.append(Integer.toString(num) + " ");
            stringBuilder.append("\n");
            return;
        }

        for(int i=startIdx; i<=N; i++){
            list.add(i);
            dfs(N, i, M, depth+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        dfs(N, 1, M, 0);
        System.out.println(stringBuilder.toString());
        scanner.close();
    }
}