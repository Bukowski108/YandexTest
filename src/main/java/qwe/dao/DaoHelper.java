package qwe.dao;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoHelper {

    private Connection connection;

    public DaoHelper(Connection connection) {
        this.connection = connection;
    }

    private String readSqlFile(String sqlFile) throws IOException{
        File file = new File("src/main/resources/sql/"+ sqlFile);
        return FileUtils.readFileToString(file,StandardCharsets.UTF_8);
    }

    private void setPreparedStatementObjects(PreparedStatement statement, Object ... args) throws IOException, SQLException {
        for (int i =0; i<args.length; i++){
            statement.setObject(i+1,args[i]);
        }
    }


    public ResultSet select (String sqlFile, Object ... args) throws IOException, SQLException{

        String sql = readSqlFile(sqlFile);
        PreparedStatement statement = connection.prepareStatement(sql);
        setPreparedStatementObjects(statement,args);
        return statement.executeQuery();
    }


    public List<Map<String,Object >> selectSmart(String sqlFile, Object ... args) throws IOException, SQLException {
        List<Map<String,Object >> result = new ArrayList<>();

        ResultSet rs = select(sqlFile,args);
        ResultSetMetaData meta = rs.getMetaData();
        while (rs.next()){
            Map<String, Object> map = new HashMap<>();
            for (int i =1; i<=meta.getColumnCount();i++){
                map.put(meta.getColumnName(i),rs.getObject(i));
            }
            result.add(map);
        }
        return result;
    }

    public int update(String sqlFile, Object ... args) throws SQLException,IOException{
        String sql = readSqlFile(sqlFile);
        PreparedStatement statement = connection.prepareStatement(sql);
        setPreparedStatementObjects(statement,args);
        return statement.executeUpdate();
    }

}
