public class Validator {

    public String passwordIsValid(String password) {
        /*This is where my try and catch starts*/
        try {
            // This is where your length is being tested
            if (password.length() > 0 && password.length() >= 8) {
                char cha;
                int digit = 1, upper = 1, lower = 1, special = 1;
                // This for loop helps to find each and every character in a password
                for (int i = 0; i < password.length(); i++) {
                    cha = password.charAt(i);
                    if (Character.isDigit(cha)) {
                        digit++; // we increment if we find a digit
                    } else if (Character.isUpperCase(cha)) {
                        upper++; // we increment if we find an Upper case
                    } else if (Character.isLowerCase(cha)) {
                        lower++; // we increment if we find a lower case
                    } else if (!Character.isLowerCase(cha) && !Character.isUpperCase(cha) && !Character.isDigit(cha)) {
                        special++; // we increment if we find a special character
                    }
                }

                // we are checking if all conditions were met
                if (digit > 1 && upper > 1 && lower > 1 && special > 1) {
                    return "The password is correct";
                } else if (digit == 1) {// if we did not find a digit than it will remain 1
                    throw new Exception("The password must have at least one digit");
                } else if (upper == 1) {// if we did not find an upper case than it will remain 1
                    throw new Exception("The password must have at least one uppercase");
                } else if (lower == 1) {// if we did not find a lower case than it will remain 1
                    throw new Exception("The password must have at least one lowercase");
                } else if (special == 1) {// if we did not find a special character than it will remain 1
                    throw new Exception("The password must have at least one special character");
                }


            } else {// if the password is empty or did not reach minimum
                throw new Exception("Password is less than min");
            }

        } catch (Exception e) { // we print the exception that we encountered
            System.out.println(e);
        }
        return "There is something wrong";
    }
}
