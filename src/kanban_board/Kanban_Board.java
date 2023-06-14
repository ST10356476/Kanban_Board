
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kanban_board;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Kanban_Board {
    
    public static void main(String[] args) {

        // Initializes the variables to be used.
        String firstName, lastName, regUsername, regPassword;
        String logUsername = null, logPassword = null;

        Task task = new Task();
        Login login = new Login();
        ReportHandling report = new ReportHandling();

        // Prompt the user to enter their first name and last name.
        firstName = JOptionPane.showInputDialog(null, "Registration\n\nEnter Your First name", "First name",
                JOptionPane.PLAIN_MESSAGE);
        lastName = JOptionPane.showInputDialog(null, "Enter your Last name:", "Last name", JOptionPane.PLAIN_MESSAGE);

        /* Prompt the user to enter their username and will continue to loop/repeat if
        the user is entering their username in the incorrect format.
        */
        while (true) {
            regUsername = JOptionPane.showInputDialog(null, "Enter User name:", "User name", JOptionPane.PLAIN_MESSAGE);

            if (regUsername.contains("_") && regUsername.length() <= 5) {
                JOptionPane.showMessageDialog(null, "User name successfully captured.", "Captured",
                        JOptionPane.PLAIN_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null,
                        "User name is not correctly formatted, please ensure that your user name contains an underscore and is no more than 5 characters in length.",
                        "Incorrect input", JOptionPane.PLAIN_MESSAGE);
            }
        }

        /* Prompt the user to enter their password and will continue to loop/repeat if
        the user enters the password in the incorrect format.
        */
        while (true) {
            String confirmPassword;
            regPassword = JOptionPane.showInputDialog(null, "Enter Password:", "Password", JOptionPane.PLAIN_MESSAGE);
            confirmPassword = JOptionPane.showInputDialog(null, "Confirm Password:", "Confirm",
                    JOptionPane.PLAIN_MESSAGE);

            /* Validate if the user entered the password in the correct format and also
            prompt the user to verify their password for security purposes.
            */
            if (login.isValidPassword(regPassword) && regPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Password successfully captured.", "Captured",
                        JOptionPane.PLAIN_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character",
                        "Incorrect input", JOptionPane.PLAIN_MESSAGE);
            }

        }

        /*
        Returns the registration confirmation if the conditions were met and it also
        returns necessary messages if the registration details were incorrect
        */
        JOptionPane.showMessageDialog(null, login.registerUser(regUsername, regPassword), "Registration Message",
                JOptionPane.PLAIN_MESSAGE);

        /*
        Verifies that the login details entered match the login details stored when
        the user registered and returns necessary messages if the login was
        successful or not.
        */
        while (login.loginUser(regUsername, regPassword)) {
            boolean successLogin = false;

            // User is prompted to use their registered details to login.
            logUsername = JOptionPane.showInputDialog(null, "Login\n\nEnter your User name:", "Login",
                    JOptionPane.PLAIN_MESSAGE);
            logPassword = JOptionPane.showInputDialog(null, "Enter your Password:", "Login",
                    JOptionPane.PLAIN_MESSAGE);

            if (logUsername.equals(regUsername) && logPassword.equals(regPassword)) {
                successLogin = true;
                JOptionPane.showMessageDialog(null,
                        login.returnLoginStatus(successLogin, firstName, lastName), "Welcome Message",
                        JOptionPane.PLAIN_MESSAGE);
                break;
            } else {
                successLogin = false;
                JOptionPane.showMessageDialog(null,
                        login.returnLoginStatus(successLogin, firstName, lastName), "Incorrect Login Input",
                        JOptionPane.PLAIN_MESSAGE);

            }
        }

        // The following code will be executing the adding tasks feature.
        if (login.loginUser(logUsername, logPassword)) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban", "Welcome Message",JOptionPane.PLAIN_MESSAGE);
            
            int optionCondition = 0;
            int options;

            // Asks the user to choose the event they want to perform
            options = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Please select the feature you want to use from the ones below:\nOption 1) Add tasks\nOption 2) Show report\nOption 3) Quit",
                    "Feature Option", JOptionPane.QUESTION_MESSAGE));
            while (optionCondition != 1) {
                
                /*
                Declare all the variables and their data types that will be used to track
                the tasks events.
                */
                String taskName = null;
                String developerDetails = null;
                int taskDuration = 0;
                String taskStatus = null;
                int numberOfTask = 0;
                String taskDescription = null;
                String taskId = null;
                String showTaskDetails;
                int taskNumber = 0;
                ArrayList<Integer> taskHours = new ArrayList<Integer>();
                if (options == 1) {

                // Asks the user to enter the number of tasks they want to enter.
                numberOfTask = Integer.parseInt(JOptionPane.showInputDialog(null,"How many tasks would you like to add?", "Number of tasks", JOptionPane.QUESTION_MESSAGE)); // 


                    /*
                    Will prompt the user to enter all the tasks' details for all the number of
                    tasks stated by the user.
                    */
                    for (int i = 0; i < numberOfTask; i++) {
                        while (i <= numberOfTask) {
                            taskName = JOptionPane.showInputDialog(null, "Enter Task Name:", ("Task " + i),
                                    JOptionPane.PLAIN_MESSAGE); // Prompts the user to enter the name of the task.

                            taskNumber = i; // Tracks the number of tasks and auto-assigns task number each time a task is added

                            while (true) {
                                taskDescription = JOptionPane.showInputDialog(null,"Please enter a short description of the task:", "Task Description",JOptionPane.PLAIN_MESSAGE); // Prompts the user to enter a short description of their added task.
                                if (task.checkTaskDescription(taskDescription)) {
                                    JOptionPane.showMessageDialog(null, "Task successfully captured","Description Confirmation", JOptionPane.PLAIN_MESSAGE); // Confirms if the description is not more than 50 characters.
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Task description should not exceed 50 characters","Incorrect Description Input", JOptionPane.ERROR_MESSAGE); // Displays if the user entered the description that is more than 50 characters.
                                }
                            }

                            developerDetails = JOptionPane.showInputDialog(null,
                                    "Please enter the developer's last and first name assigned to the task:","Developer Details", JOptionPane.PLAIN_MESSAGE); // Prompts the user to enter the first name and last name of the developer assigned to the task.

                            taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the duration of the task:", "Task Duration",JOptionPane.PLAIN_MESSAGE)); // Prompts the user to enter the duration of the task.

                            taskHours.add(taskDuration); // Stores the duration of each task in an array

                            String automatedId = task.createTaskID(taskName, taskNumber, developerDetails); // Generate the unique ID to the assigned developer.
                            taskId = automatedId;

                            int menuChoices = 0;
                            String generatedStatus = null;
                            taskStatus = null;
                            while (menuChoices != 1 && menuChoices != 2 && menuChoices != 3) {
                                int status = Integer.parseInt(JOptionPane.showInputDialog(null,"What is the task status?\nOption 1) To do\nOption 2) Done\nOption 3) Doing","Task Status", JOptionPane.QUESTION_MESSAGE)); // Asks the user to enter the status of the task.

                                if (status == 1) {
                                    generatedStatus = "To do";
                                    break;
                                }

                                if (status == 2) {
                                    generatedStatus = "Done";
                                    break;
                                }

                                if (status == 3) {
                                    generatedStatus = "Doing";
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid Input", "Error",JOptionPane.ERROR_MESSAGE); // Displays an error message if the user entered an incorrect input.
                                }

                            }

                            taskStatus = generatedStatus;

                            break;
                        }
                        showTaskDetails = task.printTaskDetails(taskStatus, developerDetails, taskNumber, taskName,taskDescription, taskId, taskDuration); // Stores all the details of the task entered.
                        JOptionPane.showMessageDialog(null, showTaskDetails, "Task Details",JOptionPane.PLAIN_MESSAGE); // Displays the task's details to the user.
                        report.addTaskDetails(developerDetails, taskName, taskDuration, taskStatus);
                    }

                    int totalHours = task.returnTotalHours(taskHours); // Tracks the total hours/durations of all the
                                                                       // tasks added.
                    JOptionPane.showMessageDialog(null, "Total hours for all the tasks added: " + totalHours,"Total Hours", JOptionPane.PLAIN_MESSAGE); // Displays the total hours/durations of all the tasks added to the user
                    options = Integer.parseInt(JOptionPane.showInputDialog(null,"Please select the feature you want to use from the ones below:\nOption 1) Add tasks\nOption 2) Show report\nOption 3) Quit","Feature Option", JOptionPane.QUESTION_MESSAGE)); // Returns to the main menu after all the tasks are added.

                }

                if (options == 2) {
                    int menuOption;
                    menuOption = Integer.parseInt(JOptionPane.showInputDialog(null,"How do you want to show the report?\nOption 1) Tasks with 'Done' Status .\nOption 2) Task with longest duration.\nOption 3) Search with a task name.\nOption 4) Search with Developer.\nOption 5) Delete task with task name.\nOption 6) Display report for all tasks.\nOption 7) Main Menu.", "Report Handling Option", JOptionPane.QUESTION_MESSAGE));
                                                                                                                                                                                                                                                                                                                            
                    if (menuOption == 1) {
                        String doneTasks = report.displayDoneTasks();
                        JOptionPane.showMessageDialog(null, doneTasks, "Report for all Done tasks",JOptionPane.PLAIN_MESSAGE);
                    } else if (menuOption == 2) {
                        String longestTask = report.getDeveloperWithLongestTask();
                        JOptionPane.showMessageDialog(null, longestTask,"Longest Task Duration Report", JOptionPane.PLAIN_MESSAGE);
                    } else if (menuOption == 3) {
                        String byTaskName = JOptionPane.showInputDialog(null, "Enter the task name you want to search:","Task Name", JOptionPane.PLAIN_MESSAGE);
                        String searchResult = report.taskByName(byTaskName);
                        JOptionPane.showMessageDialog(null, searchResult, "Search Result",JOptionPane.PLAIN_MESSAGE);
                    } else if (menuOption == 4) {
                        String searchByDeveloper = JOptionPane.showInputDialog(null,"Enter the developer name you want to search:", "Developer Name",JOptionPane.PLAIN_MESSAGE);
                        String searchResult = report.taskByDeveloper(searchByDeveloper);
                        JOptionPane.showMessageDialog(null, searchResult, "Search Result",JOptionPane.PLAIN_MESSAGE);
                    } else if (menuOption == 5) {
                        String deleteByTaskName = JOptionPane.showInputDialog(null,"Enter the task name you want to delete:", "Task Name", JOptionPane.PLAIN_MESSAGE);
                        boolean deleteResult = report.deleteTaskByName(deleteByTaskName);
                        if (deleteResult) {
                            JOptionPane.showMessageDialog(null, "Task " + deleteByTaskName + " deleted successfully","Delete Task Result", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Task " + deleteByTaskName + " not found","Delete Task Result", JOptionPane.PLAIN_MESSAGE);
                        }
                    } else if (menuOption == 6) {
                        String reportResult = report.displayAllTasks();
                        JOptionPane.showMessageDialog(null, reportResult, "Report for All Tasks", JOptionPane.PLAIN_MESSAGE);
                    } else if (menuOption == 7) {
                        options = Integer.parseInt(JOptionPane.showInputDialog(null,"Please select the feature you want to use from the ones below:\nOption 1) Add tasks\nOption 2) Show report\nOption 3) Quit","Feature Option", JOptionPane.QUESTION_MESSAGE));
                    }
                }

                if (options == 3) {
                    optionCondition = 1;
                    JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban", "Exit",JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);     //To initiate the shutdown sequence of the currently running Java virtual machine, which leads to its termination (Oracle.com, 2020).
                }
            }
        }
    }
}


//Reference list:
/*
1. prashant_srivasta.2023, How to validate a Password using Regular Expressions in Java. [Online]. Available at: https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/ [Accessed 23 April 2023].
2. Anderson, V. 2015. Adding integers to an int array. [online] Available at: https://stackoverflow.com/questions/29172164/adding-integers-to-an-int-array [Accessed 23 May 2023].
3. Oracle.com. 2020. Runtime (Java Platform SE 7 ). [online] Available at: https://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html [Accessed 14 Jun. 2023].
*/
