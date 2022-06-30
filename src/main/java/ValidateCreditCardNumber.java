public class ValidateCreditCardNumber {

        public static boolean validate(String n){
            int sumNumber = 0;
            int sumArray = 0;
            int remainder = 0;
            long number = Long.parseLong(n);

            int[] newGuess = new int[n.length()];
            for (int i = 0; i < n.length(); i++) {
                newGuess[i] = n.charAt(i) - '0';
            }

            if (newGuess.length % 2 != 0) {
                for (int i = 1; i < newGuess.length; i+=2) {
                    newGuess[i] = newGuess[i] * 2;
                    if(newGuess[i] >= 10) {

                    }
                }
            }

            if(newGuess.length % 2 == 0) {
                for (int i = 0; i < newGuess.length; i+=2) {
                    newGuess[i] = newGuess[i] * 2;
                }
            }

            for (int i = 0; i < newGuess.length; i++) {
                if (newGuess[i] >= 10) {
                    while (newGuess[i] != 0) {
                        sumNumber += (newGuess[i] % 10);
                        newGuess[i]/=10;
                    }
                    newGuess[i] = sumNumber;
                }
            }

            for (int i = 0; i < newGuess.length; i++) {
                sumArray = sumArray + newGuess[i];
            }

            remainder = sumArray % 10;

            if (remainder == 0) {
                return true;
            } else
                return false;
        }
    }
