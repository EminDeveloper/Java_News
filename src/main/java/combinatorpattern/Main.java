package combinatorpattern;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "Svetlana",
                "sveta@yahoo.com",
                "+079834577889",
                LocalDate.of(2000, 1, 1)
        );

        System.out.println(new CustomerValidatorService().isValid(customer));

        // todo if valid store customer db


    }
}
