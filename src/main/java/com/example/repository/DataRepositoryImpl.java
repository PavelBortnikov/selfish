package com.example.repository;

import com.example.entity.Data;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Types;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pavelbortnikov on 06.04.16.
 */

@org.springframework.stereotype.Repository("dataRespitory")
public class DataRepositoryImpl implements DataRepository<Data> {

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Override
    public Set<String> getUser(String login, String password) {
        Set<String> result = new HashSet<>();
        Object[] params = new Object[] { login, password };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT * FROM accounts WHERE login_account = ? AND password_account = ?;", params, types);
        while (rowSet.next()) {
            result.add(rowSet.getString("login_account"));
        }
        return result;
    }

    @Override
    public Map<String, String> getPrices() {
        Map<String,String> result = new HashMap();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT * FROM prices;");
        while (rowSet.next()) {
            result.put(rowSet.getString("label_of_fuel"), rowSet.getString("price_of_fuel"));
        }
        return result;
    }

    @Override
    public void savePrices(Map<String, String> prices){
        prices.keySet().stream().forEach(k -> savePrice(k, prices.get(k)));
    }

    private void savePrice(String label, String value) {
        Object[] params = new Object[] { value, label };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR};
        jdbcOperations.update("UPDATE public.prices SET price_of_fuel = ? WHERE label_of_fuel = ?;", params, types);
    }

}
