package DB;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;


public class DBUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        String url = "jdbc:oracle:thin:@localhost:32769:orclcdb";
        String user = "c##readyroll";
        String pas = "qwerty";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, user, pas);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void Disconnect() throws SQLException{
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }

        }catch (Exception e){
            throw e;
        }
    }


    public static void ExecuteQuery(String sqlStml) throws SQLException, ClassNotFoundException{
        Statement stml = null;
        try{
            getConnection();
            stml = connection.createStatement();
            stml.executeUpdate(sqlStml);
        } catch (SQLException e){
            System.out.println("Problem occurred at Execute Query");
        }
        finally {
            if(stml!=null){
                stml.close();
            }
        }
    }

    public static ResultSet Execute(String sqlQuery) throws ClassNotFoundException, SQLException{
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSetImpl crs = null;
        try {
            getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            crs = new CachedRowSetImpl();
            crs.populate(rs);
        }catch (SQLException e){
            System.out.println("Error occurred in Execute operation" + e);
            throw e;
        }
        finally {
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            Disconnect();
        }
        return crs;
    }
}
