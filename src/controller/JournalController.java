package controller;

import DB.DBUtil;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalController {

    @FXML
    LineChart<String, Integer> lineChart;

    @FXML
    private void initialize() throws Exception{
        getChart();
    }

    @FXML
    public void getChart() throws ClassNotFoundException, SQLException {
        String sql = "select create_date, amount from Balance";
        XYChart.Series<String,Integer> series = new XYChart.Series<>();
        try{
            ResultSet rsSet = DBUtil.Execute(sql);
            while(rsSet.next()){
                series.getData().add(new XYChart.Data<>(rsSet.getString(1),rsSet.getInt(2)));
            }
            lineChart.getData().add(series);
        }catch (SQLException e){
            System.out.println("Error occurred while fetching the records from DB" + e);
            e.printStackTrace();
            throw e;
        }
    }


}
