import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CardFromDBnew {

    public static void main(String[] args) {
        int pin = 3203;
        Connection connection = null;
        try {
            // Step 1: Load the JDBC driver.
            Class.forName("org.postgresql.Driver");

            // Step 2: Establish the connection to the database.
            String url = "jdbc:postgresql://localhost:5432/java_one";
            connection = DriverManager.getConnection(url, "postgres", "Qwerty78");

            // Step 3: Create a statement.
            Statement statement = connection.createStatement();

            // Step 4: Execute a query.
            ResultSet resultSet = statement.executeQuery("SELECT * FROM card WHERE pin=" + pin);

            // Step 5: Process the results.
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)+ " " + resultSet.getString(4)+ " " + resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
