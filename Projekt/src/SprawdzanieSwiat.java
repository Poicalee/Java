import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SprawdzanieSwiat implements SprawdznieSw {
    private final Connection connection;

    public SprawdzanieSwiat(Connection connection) {
        this.connection = connection;
    }


    public boolean czySwieto(Data data) {
        String sql = "SELECT COUNT(*) FROM swieta WHERE EXTRACT(MONTH FROM data) = ? AND EXTRACT(DAY FROM data) = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, data.getMiesiac());
            statement.setInt(2, data.getDzien());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Błąd podczas sprawdzania świąt: " + e.getMessage());
        }

        return false;
    }
}
