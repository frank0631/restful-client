package com.augmate.retrofit;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class NoGroupApp {

    @Expose
    private Integer id;
    @SerializedName("api_name")
    @Expose
    private String apiName;
    @Expose
    private String name;
    @Expose
    private String description;
    @SerializedName("is_url_external")
    @Expose
    private Boolean isUrlExternal;
    @SerializedName("launch_url")
    @Expose
    private String launchUrl;
    @SerializedName("requires_fullscreen")
    @Expose
    private Boolean requiresFullscreen;
    @SerializedName("allow_fullscreen_toggle")
    @Expose
    private Boolean allowFullscreenToggle;
    @SerializedName("toggle_location")
    @Expose
    private String toggleLocation;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;

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
     * The apiName
     */
    public String getApiName() {
        return apiName;
    }

    /**
     *
     * @param apiName
     * The api_name
     */
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The isUrlExternal
     */
    public Boolean getIsUrlExternal() {
        return isUrlExternal;
    }

    /**
     *
     * @param isUrlExternal
     * The is_url_external
     */
    public void setIsUrlExternal(Boolean isUrlExternal) {
        this.isUrlExternal = isUrlExternal;
    }

    /**
     *
     * @return
     * The launchUrl
     */
    public String getLaunchUrl() {
        return launchUrl;
    }

    /**
     *
     * @param launchUrl
     * The launch_url
     */
    public void setLaunchUrl(String launchUrl) {
        this.launchUrl = launchUrl;
    }

    /**
     *
     * @return
     * The requiresFullscreen
     */
    public Boolean getRequiresFullscreen() {
        return requiresFullscreen;
    }

    /**
     *
     * @param requiresFullscreen
     * The requires_fullscreen
     */
    public void setRequiresFullscreen(Boolean requiresFullscreen) {
        this.requiresFullscreen = requiresFullscreen;
    }

    /**
     *
     * @return
     * The allowFullscreenToggle
     */
    public Boolean getAllowFullscreenToggle() {
        return allowFullscreenToggle;
    }

    /**
     *
     * @param allowFullscreenToggle
     * The allow_fullscreen_toggle
     */
    public void setAllowFullscreenToggle(Boolean allowFullscreenToggle) {
        this.allowFullscreenToggle = allowFullscreenToggle;
    }

    /**
     *
     * @return
     * The toggleLocation
     */
    public String getToggleLocation() {
        return toggleLocation;
    }

    /**
     *
     * @param toggleLocation
     * The toggle_location
     */
    public void setToggleLocation(String toggleLocation) {
        this.toggleLocation = toggleLocation;
    }

    /**
     *
     * @return
     * The isDefault
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     *
     * @param isDefault
     * The is_default
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

}