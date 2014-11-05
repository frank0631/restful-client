package com.augmate.dreamfactory;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Session {

    @Expose
    private Integer id;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @Expose
    private String email;
    @SerializedName("is_sys_admin")
    @Expose
    private Boolean isSysAdmin;
    @SerializedName("last_login_date")
    @Expose
    private String lastLoginDate;
    @Expose
    private String role;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("dsp_name")
    @Expose
    private Object dspName;
    @Expose
    private String ticket;
    @SerializedName("ticket_expiry")
    @Expose
    private Integer ticketExpiry;
    @SerializedName("session_id")
    @Expose
    private String sessionId;
    @SerializedName("app_groups")
    @Expose
    private List<Object> appGroups = new ArrayList<Object>();
    @SerializedName("no_group_apps")
    @Expose
    private List<NoGroupApp> noGroupApps = new ArrayList<NoGroupApp>();

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
     * The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName
     * The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return
     * The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     * The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     * The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     * The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The isSysAdmin
     */
    public Boolean getIsSysAdmin() {
        return isSysAdmin;
    }

    /**
     *
     * @param isSysAdmin
     * The is_sys_admin
     */
    public void setIsSysAdmin(Boolean isSysAdmin) {
        this.isSysAdmin = isSysAdmin;
    }

    /**
     *
     * @return
     * The lastLoginDate
     */
    public String getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     *
     * @param lastLoginDate
     * The last_login_date
     */
    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     *
     * @return
     * The role
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     * The role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return
     * The roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     *
     * @param roleId
     * The role_id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     *
     * @return
     * The dspName
     */
    public Object getDspName() {
        return dspName;
    }

    /**
     *
     * @param dspName
     * The dsp_name
     */
    public void setDspName(Object dspName) {
        this.dspName = dspName;
    }

    /**
     *
     * @return
     * The ticket
     */
    public String getTicket() {
        return ticket;
    }

    /**
     *
     * @param ticket
     * The ticket
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     *
     * @return
     * The ticketExpiry
     */
    public Integer getTicketExpiry() {
        return ticketExpiry;
    }

    /**
     *
     * @param ticketExpiry
     * The ticket_expiry
     */
    public void setTicketExpiry(Integer ticketExpiry) {
        this.ticketExpiry = ticketExpiry;
    }

    /**
     *
     * @return
     * The sessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     *
     * @param sessionId
     * The session_id
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     *
     * @return
     * The appGroups
     */
    public List<Object> getAppGroups() {
        return appGroups;
    }

    /**
     *
     * @param appGroups
     * The app_groups
     */
    public void setAppGroups(List<Object> appGroups) {
        this.appGroups = appGroups;
    }

    /**
     *
     * @return
     * The noGroupApps
     */
    public List<NoGroupApp> getNoGroupApps() {
        return noGroupApps;
    }

    /**
     *
     * @param noGroupApps
     * The no_group_apps
     */
    public void setNoGroupApps(List<NoGroupApp> noGroupApps) {
        this.noGroupApps = noGroupApps;
    }

}