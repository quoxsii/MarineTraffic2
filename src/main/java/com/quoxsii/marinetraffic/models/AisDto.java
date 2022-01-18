package com.quoxsii.marinetraffic.models;

public class AisDto {
    private Long channelId;
    private String channel;
    private String mmsi;
    private String imo;
    private String eta;
    private String country;
    private Integer length;
    private Integer width;
    private Float draught;
    private String callSign;
    private Integer typeCode;
    private String type;
    private String typeDetail;
    private String name;
    private Float lat;
    private Float lon;
    private Float cog;
    private Float sog;
    private Integer trueHeading;
    private Float rot;
    private Integer navStateCode;
    private String navState;
    private String destination;
    private String msgTime;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getImo() {
        return imo;
    }

    public void setImo(String imo) {
        this.imo = imo;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Float getDraught() {
        return draught;
    }

    public void setDraught(Float draught) {
        this.draught = draught;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDetail() {
        return typeDetail;
    }

    public void setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getCog() {
        return cog;
    }

    public void setCog(Float cog) {
        this.cog = cog;
    }

    public Float getSog() {
        return sog;
    }

    public void setSog(Float sog) {
        this.sog = sog;
    }

    public Integer getTrueHeading() {
        return trueHeading;
    }

    public void setTrueHeading(Integer trueHeading) {
        this.trueHeading = trueHeading;
    }

    public Float getRot() {
        return rot;
    }

    public void setRot(Float rot) {
        this.rot = rot;
    }

    public Integer getNavStateCode() {
        return navStateCode;
    }

    public void setNavStateCode(Integer navStateCode) {
        this.navStateCode = navStateCode;
    }

    public String getNavState() {
        return navState;
    }

    public void setNavState(String navState) {
        this.navState = navState;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }
}
