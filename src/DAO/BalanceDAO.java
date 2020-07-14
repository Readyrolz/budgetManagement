package DAO;

import DB.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Balance;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceDAO {

    public static ObservableList<Balance> getAllRecordsBal() throws ClassNotFoundException, SQLException {
        String sql = "select * from Balance";
        try{
            ResultSet rsSet = DBUtil.Execute(sql);
            return getBalanceObjects(rsSet);
        }catch (SQLException e){
            System.out.println("Error occurred while fetching the records from DB" + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Balance> getBalanceObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException {
        try{
            ObservableList<Balance> balList = FXCollections.observableArrayList();
            while(rsSet.next()) {
                Balance balance = new Balance();
                balance.setId(rsSet.getInt("Id"));
                balance.setDate(rsSet.getString("Create_date"));
                balance.setCredit(rsSet.getInt("Credit"));
                balance.setDebit(rsSet.getInt("Debit"));
                balance.setAmount(rsSet.getInt("Amount"));
                balList.add(balance);
            }
            return balList;
        }catch (SQLException e){
            System.out.println("Error occurred while fetching the records from DB" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteBalanceById(String id) throws  SQLException, ClassNotFoundException{
        String sql = "delete from \"C##TEST\".Balance where id = '" + id+"'";
        try{
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occurred while deleting records" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void insertBalance(String debit, String credit)throws SQLException, ClassNotFoundException{
        String sql = "insert into Balance(CREATE_DATE, DEBIT, CREDIT, AMOUNT) " +
                "values(CURRENT_TIMESTAMP,'"+debit+"','"+credit+"', '"+ (Integer.parseInt(debit) - Integer.parseInt(credit)) +"')";
        try{
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Exception occur while inserting date" + e);
            e.printStackTrace();
            throw e;
        }
    }

}
