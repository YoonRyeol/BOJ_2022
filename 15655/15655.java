import java.util.*;

class Main {
    static List<String> inputs = new ArrayList<>();
    static List<String> numbers = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void dfs(int N, int startIdx, int M, int depth){
        if(M == depth){
            for(String number : numbers){
                sb.append(number + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i=startIdx; i<N; i++){
            numbers.add(inputs.get(i));
            dfs(N, i+1, M, depth+1);
            numbers.remove(numbers.size()-1);
        }
    }

    public static void main(String[] args){
        int N; int M;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        
        for(int i=0; i<N; i++){
            String input;
            input = scanner.next();
            inputs.add(input);
        }

        Collections.sort(inputs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        });

        dfs(N, 0, M, 0);

        System.out.println(sb.toString());

        scanner.close();

    }

}
