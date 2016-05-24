package com.example.entity;

import java.util.UUID;

/**
 * Created by pavelbortnikov on 06.04.16.
 */
public class Data implements DomainObject {

    private UUID id;

    public Data(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}