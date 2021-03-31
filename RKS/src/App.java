import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws IOException, SQLException {
        String jsonString = DataHandler.readFile("src\\data.json");
        CMP point = new CMP(jsonString);
        for (int i = 0; i < point.interferenceData.length; i++) {
            PostgreSQL.insertCMPdata(point.name, point.location, point.interferenceData[i].antennaID,
                    point.interferenceData[i].units, point.interferenceData[i].value);
        }
    }
}
