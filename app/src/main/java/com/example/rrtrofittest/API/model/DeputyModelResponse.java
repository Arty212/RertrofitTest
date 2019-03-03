
package com.example.rrtrofittest.API.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeputyModelResponse {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("position")
    @Expose
    public String position;
    @SerializedName("isCurrent")
    @Expose
    public boolean isCurrent;

    @Override
    public String toString() {
        return name;
    }
}