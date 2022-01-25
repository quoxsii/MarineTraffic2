package com.quoxsii.marinetraffic.dtos;

/**
 * Класс объект таблицы данных API клиента поста.
 */
public class PostApiClientDto {
    /**
     * Поле морской идентификатор мобильной службы.
     */
    private String mmsi;
    /**
     * Поле страна.
     */
    private String country;
    /**
     * Поле длина.
     */
    private Integer length;
    /**
     * Поле ширина.
     */
    private Integer width;
    /**
     * Поле осадка.
     */
    private Float draught;
    /**
     * Поле позывной.
     */
    private String callSign;
    /**
     * Поле код типа.
     */
    private Integer typeCode;
    /**
     * Поле тип.
     */
    private String type;
    /**
     * Поле подробности типа.
     */
    private String typeDetail;
    /**
     * Поле название.
     */
    private String name;
    /**
     * Поле широта.
     */
    private Float lat;
    /**
     * Поле долгота.
     */
    private Float lon;
    /**
     * Поле курс относительно грунта.
     */
    private Float cog;
    /**
     * Поле скорость относительно грунта.
     */
    private Float sog;
    /**
     * Поле курс.
     */
    private Integer trueHeading;
    /**
     * Поле ожидаемое время прибытия.
     */
    private String eta;
    /**
     * Поле индикатор скорости поворота.
     */
    private Float rot;
    /**
     * Поле код состояния навигации.
     */
    private Integer navStateCode;
    /**
     * Поле состояние навигации.
     */
    private String navState;
    /**
     * Поле пункт назначения.
     */
    private String destination;
    /**
     * Поле время сообщения.
     */
    private String msgTime;

    /**
     * Функция получения значения поля {@link PostApiClientDto#mmsi}.
     * @return возвращает морской идентификатор мобильной службы судна.
     */
    public String getMmsi() {
        return mmsi;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#mmsi}.
     * @param mmsi морской идентификатор мобильной службы судна.
     */
    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#country}.
     * @return возвращает страну судна.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#country}.
     * @param country страна судна.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#length}.
     * @return возвращает длину судна.
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#length}.
     * @param length длина судна.
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#width}.
     * @return возвращает ширину судна.
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#width}.
     * @param width ширина судна.
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#draught}.
     * @return возвращает осадку судна.
     */
    public Float getDraught() {
        return draught;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#draught}.
     * @param draught осадка судна.
     */
    public void setDraught(Float draught) {
        this.draught = draught;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#callSign}.
     * @return возвращает позывной судна.
     */
    public String getCallSign() {
        return callSign;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#callSign}.
     * @param callSign позывной судна.
     */
    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#typeCode}.
     * @return возвращает код типа судна.
     */
    public Integer getTypeCode() {
        return typeCode;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#typeCode}.
     * @param typeCode код типа судна.
     */
    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#type}.
     * @return возвращает тип судна.
     */
    public String getType() {
        return type;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#type}.
     * @param type тип судна.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#typeDetail}.
     * @return возвращает подробности по типу судна.
     */
    public String getTypeDetail() {
        return typeDetail;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#typeDetail}.
     * @param typeDetail подробности типа судна.
     */
    public void setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#name}.
     * @return возвращает название судна.
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура определения сущности поста {@link PostApiClientDto#name}.
     * @param name название судна.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#lat}.
     * @return возвращает широту судна.
     */
    public Float getLat() {
        return lat;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#lat}.
     * @param lat широта судна.
     */
    public void setLat(Float lat) {
        this.lat = lat;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#lon}.
     * @return возвращает долготу судна.
     */
    public Float getLon() {
        return lon;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#lon}.
     * @param lon долгота судна.
     */
    public void setLon(Float lon) {
        this.lon = lon;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#cog}.
     * @return возвращает курс судна относительно грунта.
     */
    public Float getCog() {
        return cog;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#cog}.
     * @param cog курс судна относительно грунта.
     */
    public void setCog(Float cog) {
        this.cog = cog;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#sog}.
     * @return возвращает скорость судна относительно грунта.
     */
    public Float getSog() {
        return sog;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#sog}.
     * @param sog скорость судна относительно грунта.
     */
    public void setSog(Float sog) {
        this.sog = sog;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#trueHeading}.
     * @return возвращает курс судна.
     */
    public Integer getTrueHeading() {
        return trueHeading;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#trueHeading}.
     * @param trueHeading курс судна.
     */
    public void setTrueHeading(Integer trueHeading) {
        this.trueHeading = trueHeading;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#eta}.
     * @return возвращает ожидаемое время прибытия судна.
     */
    public String getEta() {
        return eta;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#eta}.
     * @param eta ожидаемое время прибытия судна.
     */
    public void setEta(String eta) {
        this.eta = eta;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#rot}.
     * @return возвращает индикатор скорости поворота судна.
     */
    public Float getRot() {
        return rot;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#rot}.
     * @param rot индикатор скорости поворота судна.
     */
    public void setRot(Float rot) {
        this.rot = rot;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#navStateCode}.
     * @return возвращает код состояния навигации судна.
     */
    public Integer getNavStateCode() {
        return navStateCode;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#navStateCode}.
     * @param navStateCode код состояния навигации судна.
     */
    public void setNavStateCode(Integer navStateCode) {
        this.navStateCode = navStateCode;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#navState}.
     * @return возвращает состояние навигации судна.
     */
    public String getNavState() {
        return navState;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#navState}.
     * @param navState состояние навигации судна.
     */
    public void setNavState(String navState) {
        this.navState = navState;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#destination}.
     * @return возвращает пункт назначения судна.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#destination}.
     * @param destination пункт назначения судна.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Функция получения значения поля {@link PostApiClientDto#msgTime}.
     * @return возвращает время сообщения от судна.
     */
    public String getMsgTime() {
        return msgTime;
    }

    /**
     * Процедура определения широты судна {@link PostApiClientDto#msgTime}.
     * @param msgTime время сообщения от судна.
     */
    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }
}
