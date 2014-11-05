package com.augmate.dreamfactory;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Record {

    @Expose
    private Integer id;
    @Expose
    private Integer user;
    @Expose
    private Integer score;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
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
        record.append(" id: ");
        record.append(getId());
        record.append(" user: ");
        record.append(getUser());
        record.append(" score: ");
        record.append(getScore());
        return record.toString();
    }

}