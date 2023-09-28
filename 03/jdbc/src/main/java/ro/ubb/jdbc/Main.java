package ro.ubb.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/catalog";
    private static final String USER = "postgres";
    private static final String PASSWORD = "AdiAst1703@postgres";

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/catalog";

        List<Student> students = getStudents();
        System.out.println(students);

        insertStudent(new Student(1L, "Michael", 9));
        students = getStudents();
        System.out.println(students);

        System.out.println();

        insertStudent(new Student(2L, "Jackson", 10));
        students = getStudents();
        System.out.println(students);

        var studentToUpdate = students.get(0);  // unsafe
        studentToUpdate.setName("Mihai");
        studentToUpdate.setGrade(10);

        updateStudent(studentToUpdate);
        students = getStudents();
        System.out.println(students);

        System.out.println();

        System.out.println("Students before delete: " + students.size());
        deleteStudent(students.get(0).getId());//the id of the first student :((((

        students = getStudents();
        System.out.println("Students after delete: " + students.size());
    }

    private static void updateStudent(Student studentToUpdate) {
        var sql = "UPDATE student SET name = ?, grade = ? WHERE id = ?";

        try (
                var connection = DriverManager.getConnection(URL, USER, PASSWORD);
                var statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, studentToUpdate.getName());
            statement.setInt(2, studentToUpdate.getGrade());
            statement.setLong(3, studentToUpdate.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteStudent(Long id) {
        var sql = "DELETE FROM student WHERE id=?";

        try (
                var connection = DriverManager.getConnection(URL, USER, PASSWORD);
                var statement = connection.prepareStatement(sql);
        ) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void insertStudent(Student student) {
        var sql = "INSERT INTO student(name, grade) VALUES(?, ?)";

        try (
                var connection = DriverManager.getConnection(URL, USER, PASSWORD);
                var statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getGrade());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (var connection = DriverManager.getConnection(URL, USER, PASSWORD);
             var preparedStatement = connection.prepareStatement(sql);
             var resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int grade = resultSet.getInt("grade");

                var student = new Student(id, name, grade);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


}
