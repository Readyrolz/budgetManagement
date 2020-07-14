package DAO;

import DB.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDAO {

    public static void insertArticle(String name)throws SQLException, ClassNotFoundException{
        String sql = "insert into ARTICLES(Name) values ('" +name+ "')";
        try{
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Exception occur while inserting date" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Article> getAllRecordsAr() throws ClassNotFoundException, SQLException{
        String sql = "select * from ARTICLES";
        try{
            ResultSet rsSet = DBUtil.Execute(sql);
            return getArticleObjects(rsSet);
        }catch (SQLException e){
            System.out.println("Error occurred while fetching the records from DB" + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Article> getArticleObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException {
        try{
            ObservableList<Article> artList = FXCollections.observableArrayList();
            while(rsSet.next()) {
                Article article = new Article();
                article.setId(rsSet.getString("Id"));
                article.setName(rsSet.getString("Name"));
                artList.add(article);
            }
            return artList;
        }catch (SQLException e){
            System.out.println("Error occurred while fetching the records from DB" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void updateArticle(String id, String name) throws SQLException, ClassNotFoundException{
        String sql = "update ARTICLES set name = '" + name + "' where id = " + id;
        try {
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occurred update the record " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteArtivleById(String id) throws  SQLException, ClassNotFoundException{
        String sql = "delete from ARTICLES where id = " + id;
        try{
            DBUtil.ExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occurred while deleting records" + e);
            e.printStackTrace();
            throw e;
        }
    }
}
