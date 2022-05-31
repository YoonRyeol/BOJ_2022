import java.util.*;

class Main {

    static List<String> inputs = new ArrayList<>();
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void dfs(boolean his[], int N, int M, int depth){
        if(M == depth){
            for(String word : list)
                sb.append(word + " ");
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            if(his[i]) continue;
            his[i] = true;
            list.add(inputs.get(i));
            dfs(his, N, M, depth+1);
            his[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N; int M;
        N = scanner.nextInt();
        M = scanner.nextInt();

        boolean his[] = new boolean[N];
        
        for(int i=0; i<N; i++){
            String input = scanner.next();
            inputs.add(input);
        }
        
        Collections.sort(inputs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        });
        dfs(his, N, M, 0);
        System.out.println(sb.toString());

        scanner.close();
    }
    
}
