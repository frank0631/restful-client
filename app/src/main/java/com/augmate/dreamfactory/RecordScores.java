package com.augmate.dreamfactory;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class RecordScores {

    @Expose
    private List<Record> record = new ArrayList<Record>();

    /**
     *
     * @return
     * The record
     */
    public List<Record> getRecord() {
        return record;
    }

    /**
     *
     * @param record
     * The record
     */
    public void setRecord(List<Record> record) {
        this.record = record;
    }

}