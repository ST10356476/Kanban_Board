/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanban_board;



import java.util.regex.*;
public class Login {

    private String username;
    private String passwords;
    private String firstname;
    private String lastname;




        // Function to validate the password (prashant_srivastava, 2023).
    public boolean isValidPassword(String password) {

            // Regex to check valid password.
            String regex = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[!@#$%^&*+=])"
                    + "(?=\\S+$).{8,}$";

            // Compile the ReGex (prashant_srivastava, 2023).
            Pattern p = Pattern.compile(regex);

            // If the password is empty return false (prashant_srivastava, 2023).
            if (password == null) {
                return false;
            }

            // Pattern class contains matcher() method to find matching between given password and regular expression (prashant_srivastava, 2023).
            Matcher m = p.matcher(password);

            // Return if the password matched the ReGex (prashant_srivastava, 2023).
            System.out.println(m.matches());
    }

    //Vallidates if the username entered satisfies the conditions.
    public static boolean checkUserName(String username)
    {
        boolean isUsernameValid;

        if (username.length()<=5 && username.contains("_"))
        {
            isUsernameValid = true;
        }

        else
        {
            isUsernameValid = false;
        }

        return isUsernameValid;
    }

    //Checks if the complexity rules of the password are met.
    public  boolean checkPasswordComplexity(String password)
    {

        boolean isPasswordComplex;
        
        if (password.length()>=8 && isValidPassword(password)) {
            isPasswordComplex = true;
        }
        else {
            isPasswordComplex = false;
        }

        return isPasswordComplex;
    }



    // Returns the necessary messages when registering. 
    public String registerUser(String userName, String password) {
        
        String registerSuccessful = null;
        
        //Message for a successful registration.
        if (checkUserName(userName) && checkPasswordComplexity(password)) {
            registerSuccessful = "User successfully registered";
                        
        }
        
        //Message for incorrect format of a username.
        else if (!checkUserName(userName)) {
            registerSuccessful = "User name is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
            
        }
        
        //Message for incorrrect format of password.
        else if  (!checkPasswordComplexity(password)) {
            registerSuccessful = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";

        }
        return registerSuccessful;
    }

    //Returns the login status after checking the username and the password. If it is true then it is a successful login and if it is false it is unsuccessful login.
    public boolean loginUser(String userName, String password) {
        boolean LoginSuccess = false;
 
        if (checkUserName(userName) && checkPasswordComplexity(password)) {
            
            LoginSuccess = true;
        }

        else {

            LoginSuccess = false;
        }

        return LoginSuccess;

    }

    //Returns necessary login message. Either the welcome message will be displayed for a successful login or the error message will be displayed for unsuccessful login.
    public String returnLoginStatus(boolean logInSuccessful,String firstname, String lastname ) {
        String loginMessage= null;

       if (logInSuccessful) {
            loginMessage = "Welcome " + firstname + " " + lastname + " it is great to see you.";
           
        }

        else {
            loginMessage = "Username or password incorrect, please try again";

        }

        return loginMessage;
    }


}

//Reference list:
/*
1. prashant_srivasta.2023, How to validate a Password using Regular Expressions in Java. [Online]. Available at: https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/  
[Accessed 23 April 2023].
*/
