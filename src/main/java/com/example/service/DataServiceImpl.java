package com.example.service;

import com.example.entity.Data;
import com.example.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created by pavelbortnikov on 06.04.16.
 */

@Service("dataService")
public class DataServiceImpl implements DataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    @Qualifier("dataRespitory")
    private DataRepository dataRepository;

    @Override
    public boolean isLoginCorrect(String login, String password){
        return !dataRepository.getUser(login, password).isEmpty();
    }

    @Override
    public Map<String, String> getPrices(){
        return dataRepository.getPrices();
    }

    @Override
    public boolean setPrices(Map<String, String> prices){
        dataRepository.savePrices(prices);
        return true;
    }
}
