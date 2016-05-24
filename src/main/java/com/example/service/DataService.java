package com.example.service;

import java.util.Map;
import java.util.Set;

/**
 * Created by pavelbortnikov on 06.04.16.
 */
public interface DataService {

    public boolean isLoginCorrect(String login, String password);

    public Map<String, String> getPrices();

    boolean setPrices(Map<String, String> prices);
}

