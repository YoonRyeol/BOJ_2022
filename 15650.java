import java.util.*;


class Prob_15650{

    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N; int M;
        N = scanner.nextInt();
        M = scanner.nextInt();
        dfs(N, 1, M, 0);
        scanner.close();
    }

    static void dfs(int N, int startIdx, int M, int depth){
        if(M == depth){
            for(int i=0; i<list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            return;
        }
        for(int i=startIdx; i<=N; i++){
            list.add(i);
            dfs(N, i+1, M, depth+1);
            list.remove(list.size()-1);
        }
    }
}