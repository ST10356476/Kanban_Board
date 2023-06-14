/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanban_board;

/**
 *
 * @author Munyai Phalanndwa
 */

import java.util.ArrayList;

public class ReportHandling {
    
    private ArrayList<String> developers;
    private ArrayList<String> taskNames;
    private ArrayList<Integer> taskDurations;
    private ArrayList<String> taskStatuses;
    
    Task Task = new Task();
    
    public ReportHandling() {
        developers = new ArrayList<>();
        taskNames = new ArrayList<>();
        taskDurations = new ArrayList<>();
        taskStatuses = new ArrayList<>();
    }
    
    public void addTaskDetails(String developer, String taskName, int duration, String status) {
        developers.add(developer);
        taskNames.add(taskName);
        taskDurations.add(duration);
        taskStatuses.add(status);
    }
    
    public String displayDoneTasks() {
        StringBuilder doneReport = new StringBuilder();         //(www.javatpoint.com, n.d.)
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase("Done")) {
                doneReport.append("Developer: ").append(developers.get(i))
                          .append("\nTask Name: ").append(taskNames.get(i))
                          .append("\nTask Duration: ").append(taskDurations.get(i))
                          .append("\n\n");
            }
        }
        return doneReport.toString();
    }
    
public String getDeveloperWithLongestTask() {
    int longestDuration = 0;
    int longestDurationIndex = -1;
    for (int i = 0; i < taskDurations.size(); i++) {
        if (taskDurations.get(i) > longestDuration) {
            longestDuration = taskDurations.get(i);
            longestDurationIndex = i;
        }
    }
    
    if (longestDurationIndex != -1) {
        String developerName = developers.get(longestDurationIndex);
        return "Developer: " + developerName + "\nDuration: " + longestDuration + " hours";
    }
    
    return "No tasks found";
}

    
    public String taskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                return "Task Name: " + taskNames.get(i) +
                       "\nDeveloper: " + developers.get(i) +
                       "\nTask Status: " + taskStatuses.get(i);
            }
        }
        
        return "Task not found.";
    }
    
    public String taskByDeveloper(String developer) {
        StringBuilder developerReport = new StringBuilder();        //(www.javatpoint.com, n.d.)
        boolean tasksFound = false;
        
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).contains(developer)) {
                developerReport.append("Task Name: ").append(taskNames.get(i))
                               .append("\nTask Status: ").append(taskStatuses.get(i))
                               .append("\n\n");
                tasksFound = true;
            }
        }
        
        if (tasksFound) {
            return developerReport.toString();
        }
        
        return "No tasks found assigned to " + developer + ".";
    }
    
    public boolean deleteTaskByName(String taskName) {
    int index = taskNames.indexOf(taskName);
    if (index != -1) {
        taskNames.remove(index);
        taskDurations.remove(index);
        developers.remove(index);
        taskStatuses.remove(index);
        return true; // Task found and deleted successfully
    }
    return false; // Task not found
    }
    
    public String displayAllTasks() {
        StringBuilder report = new StringBuilder();
        if (taskNames.size() == 0) {
            report.append("No tasks found.");
    } else {
        for (int i = 0; i < taskNames.size(); i++) {
            String taskDetails = Task.printTasksDetails(taskStatuses.get(i), developers.get(i), i + 1, taskNames.get(i), taskDurations.get(i));
            report.append(taskDetails).append("\n");
        }
    }
    return report.toString();
}



}



//Code Attribution.
/*
1. www.javatpoint.com. (n.d.). Java StringBuilder append() Method with Examples - Javatpoint. [online] Available at: https://www.javatpoint.com/java-stringbuilder-append-method [Accessed 13 Jun. 2023].
*/