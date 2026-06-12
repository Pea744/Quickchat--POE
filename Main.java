File 2: Main.java

package main;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        accountRegistration();
    }

    public static void accountRegistration() {

        try (Scanner sc = new Scanner(System.in)) {

            Login login = new Login();

            System.out.println("****** Registration ******");

            String firstname;
            String lastname;
            String username;
            String password;
            String cellPhone;

            System.out.println("Enter firstname:");
            firstname = sc.nextLine();

            if (firstname.matches("^[A-Za-z]+$")) {
                System.out.println("Valid firstname: " + firstname);
            } else {
                System.out.println("Invalid first name");
            }

            System.out.println("Enter lastname:");
            lastname = sc.nextLine();

            if (lastname.matches("^[A-Za-z]+$")) {
                System.out.println("Valid lastname: " + lastname);
            } else {
                System.out.println("Invalid last name (letters only)");
            }

            System.out.println("Create Username:");
            username = sc.nextLine();

            if (username.contains("_") && username.length() <= 5) {
                System.out.println("Username successfully captured");
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is not more than five characters in length.");
            }

            System.out.println("Create Password:");
            password = sc.nextLine();

            if (password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$")) {
                System.out.println("Password successfully captured!");
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.");
            }

            System.out.println("Enter Cell Phone number:");
            cellPhone = sc.nextLine();

            if (cellPhone.matches("^\\+27\\d{9,}$")) {
                System.out.println("Cell Phone number successfully added");
            } else {
                System.out.println("Cell Phone number incorrectly formatted or does not contain international code");
            }

            String registerUser = login.registerUser(firstname, lastname, username, password, cellPhone);
            System.out.println(registerUser);

            if (registerUser.equals("User registered successfully!")) {

                System.out.println("****** Login ******");

                System.out.println("Enter username:");
                String inputUsername = sc.nextLine();

                System.out.println("Enter password:");
                String inputPassword = sc.nextLine();

                String loginResult = login.loginUser(inputUsername, inputPassword);
                System.out.println(loginResult);
            }
        }
    }
}