/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package kanban_board;

import java.util.ArrayList;
import kanban_board.Task;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author munya
 */
public class TaskTest {
    
    Task task = new Task();

    @Test
    public void testCheckTaskDescription() {
        
        //Test data for assertEquals.
        
        /*Actual data and expected data are initialized
        using appropriate variables.
        */
        String actualMessage1 = null;
        String expectedMessage1 = "Task successfully captured";
        String message1 ="Task successfully captured";
        String expectedMessage2 = "Please enter a task description of less than 50 characters";
        String actualMessage2 = "Please enter a task description of less than 50 characters";
        if (task.checkTaskDescription(message1) == true) {
            actualMessage1 = "Task successfully captured";
        }
        
        else {
            actualMessage2 = "Please enter a task description of less than 50 characters";
        }
        
        //Test data for assertTrue and assertFalse.
        assertEquals(expectedMessage1, actualMessage1);
        assertEquals(expectedMessage2, actualMessage2);
        
        boolean result = task.checkTaskDescription("Task successfully captured");
        assertTrue(result);
        
        result = task.checkTaskDescription("Please enter a task description of less than 50 characters");
        assertFalse(result);
    }

@Test
public void testCreateTaskID() {
    Task Task = new Task();

    // Test data for Task 1
    String result1 = Task.createTaskID("Login Feature", 1, "Harrison Robyn");       //Method that create ID is given test data for data Test 1
    assertEquals("LO:1:BYN", result1);                  //Data is compared

    //Test data for additional data.
    int SIZE = 4;
    String[] taskName = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};        //Array of tasks names initialized.
    int[] taskNo = {0, 1, 2, 3};            // Array of tasks numbers initialized.
    String[] developerName = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};        //Array of developers' names for each task.
    /*
    Note that those arrays matches each other with their index position for example; details in index 0 goes together in each array, details in index 1 goes together in each of those arrays and so forth
    */ 

    //A loop is used to generate the ID for each index position details in the arrays.
    for (int index = 0; index < SIZE; index++) {
        String result = Task.createTaskID(taskName[index], taskNo[index], developerName[index]);
        assertEquals(Task.createTaskID(taskName[index], taskNo[index], developerName[index]), result);      //Each loop data is compared.
    }
}

    @Test
    public void testReturnTotalHours() {
        
        //Test data for Task 1 and Task 2
        ArrayList<Integer> totalHours1 = new ArrayList<>();
        ArrayList<Integer> totalHours2 = new ArrayList<>();
        totalHours1.add(8); totalHours1.add(10);            //Durations for Task 1 and Task 2 are stored in an array.
        int result1 = task.returnTotalHours(totalHours1);       //method that return total hours is called from the Task class.
        assertEquals(18, result1);              //Data is compared.
        
        //Test data for addtional data.
        totalHours2.add(10);totalHours2.add(12);totalHours2.add(55);totalHours2.add(11);totalHours2.add(1);        //Durations of the additional data provided are stored in an array.
        int result2 = task.returnTotalHours(totalHours2);       //Method that return the total is called.
        assertEquals(89, result2);          //Data is compared.
    }
    
}
