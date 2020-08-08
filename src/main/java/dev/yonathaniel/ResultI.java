package dev.yonathaniel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ResultI {
    int getTotal();

    double getAverage();

    int getSize();

    String getResult();

    String getRemarks();


    ArrayList<ResultModel> viewAll() throws SQLException, ClassNotFoundException;

    Result getResults(String admNo) throws SQLException, ClassNotFoundException;

    boolean addResult(ResultModel resultModel) throws SQLException, ClassNotFoundException;

    boolean deleteResult(int id) throws SQLException;

    boolean updateResult(int id, Result result) throws SQLException;

    void clearAll();
}
