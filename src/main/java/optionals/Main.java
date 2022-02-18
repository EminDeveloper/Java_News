package optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
//                .orElseGet(() -> "default value");
        .orElseThrow(() -> new IllegalStateException());
        System.out.println(value);
    }
}
