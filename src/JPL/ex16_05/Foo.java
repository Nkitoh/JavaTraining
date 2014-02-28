package ex16_05;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface BugsFixed {
    String[] value();
}


@BugsFixed({"45678", "43246"})
public class Foo {

}
