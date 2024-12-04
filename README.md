```markdown
# Kanban Board

**Kanban Board** is a Java-based application designed to help teams and individuals manage tasks using the Kanban methodology. The application provides a simple yet effective way to visualize and organize tasks in columns such as **To Do**, **In Progress**, and **Done**, promoting better task management and workflow.

---

## Features
- **Task Management**: Add, update, and delete tasks.
- **Kanban Columns**: Organize tasks into different workflow stages.
- **Drag-and-Drop Interface**: Easily move tasks between columns (planned enhancement).
- **Persistence**: Save task data for future sessions.
- **Java Swing GUI**: User-friendly graphical interface.

---

## Technologies Used
- **Language**: Java
- **Build Tool**: Apache Ant
- **Version Control**: Git
- **Testing Framework**: JUnit (for unit tests)
- **Deployment**: Configured using build.xml for Ant.

---

## Getting Started
### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Ant (for building and running the project)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ST10356476/Kanban_Board.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Kanban_Board
   ```
3. Build the project using Ant:
   ```bash
   ant build
   ```
4. Run the application:
   ```bash
   ant run
   ```

---

## Project Structure
- **src/kanban_board**: Contains the main application source code.
- **test/kanban_board**: Contains unit tests for the application.
- **build.xml**: Apache Ant build configuration file.
- **lib**: Directory for external libraries (if applicable).
- **nbproject**: NetBeans project configuration files.

---

## Usage
1. Launch the application.
2. Add tasks by entering details such as task name, description, and due date.
3. Organize tasks into Kanban columns:
   - **To Do**
   - **In Progress**
   - **Done**
4. Update task statuses by moving them between columns.

---

## Deployment
The application can be packaged into a JAR file using Apache Ant:
```bash
ant jar
```
The generated JAR file will be located in the `dist` directory.

---

## Contributing
We welcome contributions to improve this project! To contribute:
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Description of your changes"
   ```
4. Push to your branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a pull request.

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

## Future Enhancements
- Implement drag-and-drop functionality for task movement.
- Add user authentication for personalized Kanban boards.
- Introduce themes for UI customization.
- Support for exporting board data to external file formats (e.g., CSV, JSON).

---

## Author
- **Phalanndwa Munyai**

---

Manage your tasks and workflows efficiently with the **Kanban Board** application!
