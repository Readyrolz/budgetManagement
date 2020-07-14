package DAO;

import DB.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Operation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OperationDAO {

    public static void insertOperation(String article_id, String credit,
                                       String debit, String data) throws SQLException, ClassNotFoundException{
        String sql = "insert into OPERATIONS(ARTICLE_ID, CREDIT, DEBIT, CREATE_DATE) values('"+ article_id +"','" +debit+ "', '"
                +credit+ "',TO_TIMESTAMP('" + data +"', 'yyyy-mm-dd'))";
        try{
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Exception occur while inserting date" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void insertOperation(String article_id, String credit,
                                       String debit) throws SQLException, ClassNotFoundException{
        String sql = "insert into OPERATIONS(ARTICLE_ID, CREDIT, DEBIT) values('"+ article_id +"','" +debit+ "', '"
                +credit+ "')";
        try{
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Exception occur while inserting date" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Operation> getAllRecordsOp() throws ClassNotFoundException, SQLException{
        String sql = "select * from OPERATIONS";
        try{
            ResultSet rsSet = DBUtil.Execute(sql);
            return getOperationObjects(rsSet);
        }catch (SQLException e){
            System.out.println("Error occurred while fetching the records from DB" + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Operation> getOperationObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException {
        try{
            ObservableList<Operation> artList = FXCollections.observableArrayList();
            while(rsSet.next()) {
                Operation operation = new Operation();
                operation.setId(rsSet.getInt("Id"));
                operation.setArticleId(rsSet.getInt("Article_Id"));
                operation.setBalanceId(rsSet.getInt("Balance_Id"));
                operation.setCredit(rsSet.getInt("Credit"));
                operation.setDebit(rsSet.getInt("Debit"));
                operation.setDate(rsSet.getString("Create_date"));
                artList.add(operation);
            }
            return artList;
        }catch (SQLException e){
            System.out.println("Error occurred while fetching the records from DB" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteOperationById(String id) throws  SQLException, ClassNotFoundException{
        String sql = "delete from OPERATIONS where id = " + id;
        try{
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occurred while deleting records" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void updateOperation(String id, String value, String type)
            throws SQLException, ClassNotFoundException{
        String sql = "update OPERATIONS set "+ type +" = '" + value + "' where id = " + id;
        try {
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occurred update the record " + e);
            e.printStackTrace();
            throw e;
        }

    }

    public static void updateOperationDate(String id, String value)
            throws SQLException, ClassNotFoundException{
        String sql = "update OPERATIONS set CREATE_DATE = TO_TIMESTAMP('" + value + "', 'yyyy-mm-dd') where id = " + id;
        try {
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occurred update the record " + e);
            e.printStackTrace();
            throw e;
        }

    }

}
