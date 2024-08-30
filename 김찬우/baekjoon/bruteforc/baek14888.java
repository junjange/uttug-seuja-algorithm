
public class Main {

    static int n;
    static int[] operator;
    static int[] arr;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        operator = new int[4];

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[0];
        backTracking(1,sum);

        System.out.println(Collections.max(result));
        System.out.println(Collections.min(result));

    }

    public static void backTracking(int depth ,int sum){

        if(depth == n){
            result.add(sum);
            return;
        }


        for(int i=0; i<4; i++){

            if(operator[i] > 0){


                if(i==0){

                    sum += arr[depth];
                    operator[i] -= 1;
                    backTracking(depth+1,sum);
                    sum -= arr[depth];
                    operator[i] += 1;
                }else if(i==1){

                    sum -= arr[depth];
                    operator[i] -= 1;
                    backTracking(depth+1,sum);
                    sum += arr[depth];
                    operator[i] += 1;
                }else if(i==2){

                    sum *= arr[depth];
                    operator[i] -= 1;
                    backTracking(depth+1,sum);
                    sum /= arr[depth];
                    operator[i] +=1;
                }else{

                    sum /= arr[depth];
                    operator[i] -= 1;
                    backTracking(depth+1,sum);
                    sum *= arr[depth];
                    operator[i] +=1;
                }
            }
        }
    }

}
