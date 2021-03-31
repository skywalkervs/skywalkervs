import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgreSQL {

    public static void insertCMPdata(String pointName, String pointLocation, int antennaID, String units, int value) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testbase",
                "postgres", "12345");) {
            String sql = "INSERT INTO \"InterferenceData\" (\"PointName\",\"PointLocation\",\"AntennaID\",\"Units\",\"Value\") VALUES (?, ?, ?, ?, ?);";
            try (PreparedStatement statement = connection.prepareStatement(sql);) {
                statement.setString(1, pointName);
                statement.setString(2, pointLocation);
                statement.setInt(3, antennaID);
                statement.setString(4, units);
                statement.setInt(5, value);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}