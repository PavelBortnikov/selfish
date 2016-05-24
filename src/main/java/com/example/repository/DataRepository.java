package com.example.repository;

import com.example.entity.DomainObject;

import java.util.Map;
import java.util.Set;

/**
 * Created by pavelbortnikov on 06.04.16.
 */
public interface DataRepository<V extends DomainObject> {

    Set<String> getUser(String login, String password);

    Map<String, String> getPrices();

    void savePrices(Map<String, String> prices);
}
