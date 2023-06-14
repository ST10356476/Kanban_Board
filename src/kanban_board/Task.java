/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanban_board;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author munya
 */
public class Task {
    
    //Method that checks if the task decription entered by the user is not longer than 50 characters.
    public boolean checkTaskDescription(String descriptionLength) {
        boolean isDescriptionCorrect = false;
        
        
        if (descriptionLength.length() < 50) {
            isDescriptionCorrect = true;
        }
        
        else {
            isDescriptionCorrect = false;
        }
        
        return isDescriptionCorrect;
    }
    
    //Method that create unique task ID for each developer assigned to the task.
    public String createTaskID(String nameOfTask, int taskNo, String developerName) {
        
        String twoTaskLetters = nameOfTask.substring(0, Math.min(nameOfTask.length(), 2));          //Retrieve the initial two characters of a String (Andrew, 2017).
        String threeLastDeveloperLetters = developerName.substring(Math.max(developerName.length()-3, 0));      //Retrieve the last three characters of a String (Andrew, 2017).
        String generatedId = twoTaskLetters.toUpperCase() + ":" + taskNo + ":" +threeLastDeveloperLetters.toUpperCase();        //Generate the task ID.
                
       return generatedId;
      
    } 
    
    //Method that prints all the tasks details.
    public String printTaskDetails(String statusTask, String detailsDeveloper, int numberTask, String nameTask, String descriptionTask, String idTask, int durationTask) {
        String displayTaskDetails;
        
        displayTaskDetails = "Task Status: " + statusTask+"\nDelevoper Details: " + detailsDeveloper+"\nTask Number: " + numberTask+"\nTask Name: " + nameTask+"\nTask Description: " + descriptionTask+"\nTask ID: " + idTask+"\nTask Duration: " + durationTask;

        return displayTaskDetails;
        
    }
    
    //Method that tracks and calculates the total hours/durations of all the tasks added.
    public int returnTotalHours(ArrayList<Integer> tasksDurations) {         //(Anderson, 2015).
        int totalTasksHours = 0;
        
        for (int hours : tasksDurations) {                  //(Anderson, 2015).
            totalTasksHours += hours;                       //For each duration, it adds it to the totalTasksHours variable.
        }
        return totalTasksHours;
    }
    
    public String printTasksDetails(String taskStatus, String developerDetails, int taskNumber, String taskName, int taskDuration) {
        StringBuilder taskDetails = new StringBuilder();
        taskDetails.append("Task ").append(taskNumber).append(":\n");
        taskDetails.append("Task Name: ").append(taskName).append("\n");
        taskDetails.append("Task Status: ").append(taskStatus).append("\n");
        taskDetails.append("Developer Details: ").append(developerDetails).append("\n");
        taskDetails.append("Task Duration: ").append(taskDuration).append(" hours\n");
    return taskDetails.toString();
}

       
}



//References

/*
1. Andrew, J. 2017. Extract first two characters of a String in Java. [online] Available at: https://stackoverflow.com/questions/42217815/extract-first-two-characters-of-a-string-in-java [Accessed 21 May 2023].
2. Anderson, V. 2015. Adding integers to an int array. [online] Available at: https://stackoverflow.com/questions/29172164/adding-integers-to-an-int-array [Accessed 23 May 2023].
*/
