import java.sql.*;

public class DatabaseConnector {
    private Connection connection;

    public  DatabaseConnector() {
        try {
            String url = "jdbc:mysql://localhost:3306/dataprojekt?useSSL=false";
            String username = "DataProjekt";
            String password = "123456789";
            // Rejestrowanie sterownika JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Nawiązywanie połączenia z bazą danych
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Połączono z bazą danych!");
        } catch (ClassNotFoundException e) {
            System.out.println("Nie można odnaleźć sterownika JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Błąd podczas połączenia z bazą danych: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Zamknięto połączenie z bazą danych.");
            } catch (SQLException e) {
                System.out.println("Błąd podczas zamykania połączenia: " + e.getMessage());
            }
        }
    }

    public void dodajSwieto(Data data, String nazwaSwieta) {
        String sql = "INSERT INTO swieta (data, nazwa) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, data.toString("yyyy-MM-dd"));
            statement.setString(2, nazwaSwieta);
            statement.executeUpdate();
            System.out.println("Dodano święto do bazy danych.");
        } catch (SQLException e) {
            System.out.println("Błąd podczas dodawania święta do bazy danych: " + e.getMessage());
        }
    }
    public void aktualizujSwieto(int id, Data newData, String newNazwaSwieta) {
        String sql = "UPDATE swieta SET data = ?, nazwa = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newData.toString("yyyy-MM-dd"));
            statement.setString(2, newNazwaSwieta);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Zaktualizowano święto w bazie danych.");
        } catch (SQLException e) {
            System.out.println("Błąd podczas aktualizacji święta w bazie danych: " + e.getMessage());
        }
    }

    public void usunSwieto(int id) {
        String sql = "DELETE FROM swieta WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Usunięto święto z bazy danych.");
        } catch (SQLException e) {
            System.out.println("Błąd podczas usuwania święta z bazy danych: " + e.getMessage());
        }
    }

    public void wyswietlSwieta() {
        String sql = "SELECT * FROM swieta";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String data = resultSet.getString("data");
                String nazwa = resultSet.getString("nazwa");

                System.out.println("ID: " + id + ", Data: " + data + ", Nazwa: " + nazwa);
            }
        } catch (SQLException e) {
            System.out.println("Błąd podczas pobierania świąt z bazy danych: " + e.getMessage());
        }
    }
}
