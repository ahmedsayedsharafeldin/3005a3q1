
import java.sql.*;

public class main {
    private static final String url = "yoururl";
    private static final String user = "postgres";
    private static final String password ="yourpassword";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);


            getAllStudents(connection);

            addStudent(connection, "ahmed", "Johnson", "ahmed.johson@yahoo.com", "2024-03-18");


            updateStudentEmail(connection, 2, "rock@yahoo.com");

            deleteStudent(connection,1);
            getAllStudents(connection);



            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    private static void getAllStudents(Connection connection){
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM students");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("student_id") + ", " + resultSet.getString("first_name") + ", " + resultSet.getString("last_name") + ", " + resultSet.getString("email") + ", " + resultSet.getDate("enrollment_date"));
            }
            statement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addStudent(Connection connection, String firstName, String lastName, String email, String enrollmentDate){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, Date.valueOf(enrollmentDate));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void updateStudentEmail(Connection connection, int studentId, String newEmail){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students SET email = ? WHERE student_id = ?");
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, studentId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteStudent(Connection connection, int studentId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE student_id = ?");
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

