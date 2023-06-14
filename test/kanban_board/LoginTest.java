/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package kanban_board;

import kanban_board.Login;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author munya
 */
public class LoginTest {
    
    
       Login    Login = new Login();
    
    public LoginTest() {
    }

    @Test
    public void testCheckUserName() {
        String username;
        boolean expectedCondition;
        boolean actualResponse; 
        boolean testCondition = false;
        
        if (testCondition == true) {
            username = "kyl_1";
            expectedCondition = true;
            actualResponse = Login.checkUserName(username);
            assertEquals(expectedCondition,actualResponse);
        }
        
        else if (testCondition) {
            username = "kyle!!!!!!!";
            expectedCondition = false;
            actualResponse = Login.checkUserName(username);
            assertEquals(expectedCondition,actualResponse);
        }

        
   }

    @Test
    public void testCheckPasswordComplexity() {
        String password;
        boolean expectedCondition;
        boolean actualResponse;
        boolean testCondition = false;
        
        if (testCondition == true) {
            password = "Ch&&sec@ke99!";
            expectedCondition = true;
            actualResponse = Login.checkPasswordComplexity(password);
            assertEquals(expectedCondition, actualResponse);
        }
        
        else if (testCondition) {
            password = "password";
            expectedCondition = false;
            actualResponse = Login.checkPasswordComplexity(password);
            assertEquals(expectedCondition, actualResponse);
        }
    }

    @Test
    public void testIsPasswordComplex() {
        String password1 = "Ch&&sec@ke99!" ;
        assertTrue(Login.checkPasswordComplexity(password1));
        
        String password2 = "password";
        assertFalse(Login.checkPasswordComplexity(password2));
        
    }
    
    @Test
    public void testIsUsernameCorrectFormat() {
        String username1 = "kyl_1";
        assertTrue(Login.checkUserName(username1));
        
        String username2 = "kyle!!!!!!!";
        assertFalse(Login.checkUserName(username2));
    }
    
    @Test
    public void testLoginSuccess() {
        String username1 = "kyl_1";
        String password1 = "Ch&&sec@ke99!";
        assertTrue(Login.loginUser(username1, password1));
        
        String username2 = "kyle!!!!!!!";
        String password2 = "password";
        assertFalse(Login.loginUser(username2, password2));
        
    }
    
}
