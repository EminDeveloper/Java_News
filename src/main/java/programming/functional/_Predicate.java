package programming.functional;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000055550"));
        System.out.println(isPhoneNumberValid("08000000666"));

        System.out.println("With Predicate ");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000055550"));
        System.out.println(isPhoneNumberValidPredicate.test("08000000666"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("07000000663")
        );

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("08000000666")
        );
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");


}
