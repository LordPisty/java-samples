package labeled;

/**
 * Created by screspi on 4/2/15.
 */
public class Main {

    public static void main(String... args) {


        outer: for (int i=0; i<10; i++){
            inner: for(int j=1; j < 5; j++){
                if (i == 5 && j == 3) {
                    continue outer;
                }
                System.out.println(i + " " + j);
            }
        }
    }
}
