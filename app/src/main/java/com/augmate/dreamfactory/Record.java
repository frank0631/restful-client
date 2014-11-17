package com.augmate.dreamfactory;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Record {

    @Expose
    private String _id;
    @Expose
    private Integer user;
    @Expose
    private Integer score;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return _id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String _id) {
        this._id = _id;
    }

    /**
     *
     * @return
     * The user
     */
    public Integer getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(Integer user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The score
     */
    public Integer getScore() {
        return score;
    }

    /**
     *
     * @param score
     * The score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString(){
        StringBuffer record=new StringBuffer();
        record.append(" _id: ");
        record.append(getId());
        record.append(" user: ");
        record.append(getUser());
        record.append(" score: ");
        record.append(getScore());
        return record.toString();
    }

}