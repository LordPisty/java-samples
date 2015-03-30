package annotation;

/**
 * Created by screspi on 3/29/15.
 */
public class Utils {

    public static void main(String[] args) throws Exception{
        final TestAnnotationParser parser = new TestAnnotationParser();
        parser.parse(Annotated.class);
    }
}
