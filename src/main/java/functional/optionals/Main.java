package functional.optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Optional.ofNullable("juris@gmail.com")
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email")
                );

//        Optional.ofNullable("juris@gmail.com")
//                .ifPresent(email -> System.out.println("Sending email to " + email));

//        Optional.ofNullable(null)
//                .ifPresent(System.out::println);


//        Optional.ofNullable("Hello")
//                .ifPresent(value -> {
//                    System.out.println(value);
//                });

//        Supplier<IllegalStateException> illegalStateExceptionSupplier = () -> new IllegalStateException();
////        Object value = Optional.ofNullable(null)
//////                .orElseGet(() -> "default value");
////        .orElseThrow(illegalStateExceptionSupplier);
////        System.out.println(value);
    }
}
