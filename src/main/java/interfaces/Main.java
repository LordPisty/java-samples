package interfaces;

/**
 * Created by crespis on 4/1/2015.
 */
public class Main {

    private static void testFun(FunI funI, int j) {
        System.out.println(funI.functionalMethod(j));
    }

    public static void main(String... args) {
        Inter i = new Clas();
        System.out.println(i.doDefault(3));
        Inter.utilityMethod();
        new Inter() {
            @Override
            public void doSomething(int i, int j){
                System.out.println("hello");
            }
        }.doSomething(3,4);

        new Inter() {
            @Override
            public void doSomething(int i, int j){
                System.out.println("hello");
            }

            @Override
            public int doDefault(int i){
                System.out.println("hello " + i);
                return i;
            }
        }.doDefault(4);

        testFun(j -> j*2,6);
        System.out.println(FunI.staticMethod(5));
        System.out.println(new FunI() {
            @Override
            public int functionalMethod(int j) {
                return j;
            }
        }.functionalMethod(2));
    }
}
