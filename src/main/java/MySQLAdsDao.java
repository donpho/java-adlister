import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection conn;


    public MySQLAdsDao(Config config){
        try{
            DriverManager.registerDriver(new Driver());
            this.conn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    private List<Ad> createAdsList(ResultSet rs) throws SQLException{
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(
                    new Ad(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getString("title"),
                            rs.getString("description")
                    )
            );
        }
        return ads;
    }

    @Override
    public List<Ad> all() {
        try{
            Statement statement = conn.createStatement();
            String findAllQuery = "SELECT * FROM ads";
            ResultSet rs = statement.executeQuery(findAllQuery);
            return createAdsList(rs);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Problem with building the ads");
        }
    }

    @Override
    public Long insert(Ad ad) {
        try{
            Statement statement = conn.createStatement();
            String insertQuery = String.format("INSERT INTO ads (user_id, title, description) VALUES (%d, '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());
            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Problems with insert");
        }
    }
}
