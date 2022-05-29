import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    static List<Integer> list = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void dfs(int N, int startIdx, int M, int depth) throws IOException{
        if(depth == M){
            for(int i=0; i<list.size(); i++)
                bw.write(Integer.toString(list.get(i)) + " ");
            bw.newLine();
            return;
        }

        for(int i=startIdx; i<=N; i++){
            list.add(i);
            dfs(N, startIdx, M, depth+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int N; int M;
        N = scanner.nextInt();
        M = scanner.nextInt();
        dfs(N, 1, M, 0);
        bw.flush();
        scanner.close();
    }
}
