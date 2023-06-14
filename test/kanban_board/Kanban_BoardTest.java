/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package kanban_board;

import kanban_board.Kanban_Board;
import kanban_board.Login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;

/**
 *
 * @author munyai
 */
public class Kanban_BoardTest {
    
    Login Login = new Login();
    Kanban_Board test1 = new Kanban_Board();
    
    public Kanban_BoardTest() {
    }

    @Test
    public void testIsValidPassword() {
        String password = "Ch&&sec@ke99!";
        boolean expectedData = true;
        boolean actualData = Login.isValidPassword(password);
        assertEquals(expectedData,actualData);
    }

}
