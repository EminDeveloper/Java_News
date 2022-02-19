package functional.combinatorpattern;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "Svetlana",
                "sveta@yahoo.com",
                "+079834577889",
                LocalDate.of(2005, 1, 1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // to do if valid store customer db
        //  Using combinator pattern

        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator.isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(customer);

        System.out.println(result);

        if(result != CustomerRegistrationValidator.ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
