package id.net.iconpln.dreamap.api.util;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
public class CommonModule {

    private static Logger getLogger(Object obj) {
        return Logger.getLogger(obj.getClass());
    }

    public static CommonModule getInstance() {
        return new CommonModule();
    }

    public static List<Map<String, Object>> convertResultToList(ResultSet resultSet) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int totalColumn = metaData.getColumnCount();
            while(resultSet.next()) {
                HashMap<String, Object> maps = new HashMap<String, Object>();
                for(int i = 0; i < totalColumn; i++) {
                    try {
                        if(resultSet.getObject(i).getClass().getName().equals("java.sql.Date"))
                            maps.put(metaData.getColumnName(i).toLowerCase(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(resultSet.getDate(i)));
                        else
                            maps.put(metaData.getColumnName(i).toLowerCase(), resultSet.getObject(i));
                    } catch(Exception e) {
                        maps.put(metaData.getColumnName(i).toLowerCase(), "");
                    }
                }
                list.add(maps);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Map<String,String>> convertResultToListStr(ResultSet resultSet){
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int totalColumn = metaData.getColumnCount();
            String value = "";

            while (resultSet.next()) {
                HashMap<String,String> map = new HashMap<String,String>();
                for (int i = 1; i <= totalColumn; i++) {
                    try{
                        if (resultSet.getObject(i).toString().equals("") || resultSet.getObject(i).toString().equals("null")){
                            value = " ";
                        }else{
                            value = resultSet.getObject(i).toString();
                        }
                    }catch(Exception e){
                        value = " ";
                    }
                    map.put(metaData.getColumnName(i).toLowerCase(), value);
                }
                list.add(map);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
