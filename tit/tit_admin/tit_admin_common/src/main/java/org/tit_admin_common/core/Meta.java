package org.tit_admin_common.core;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 刘晓勇
 *
 */
@XmlRootElement(name = "meta")
public class Meta {
    private int code;
    private String responseTime;
    private long responseTimeL;
    private @XStreamOmitField long timeOfRequest;


    public Meta() {
        this.timeOfRequest = System.currentTimeMillis();
    }


    @XmlElement
    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }


    @JsonIgnore
    public long getTimeOfRequest() {
        return timeOfRequest;
    }


    public void setTimeOfRequest(long timeOfRequest) {
        this.timeOfRequest = System.currentTimeMillis();
    }


    @XmlElement
    public String getResponseTime() {
        responseTimeL = System.currentTimeMillis() - timeOfRequest;
        return responseTimeL + " ms";
    }


    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }


    @Override 
    public String toString() {
        return "Meta{" +
                "code=" + code +
                ", responseTime=" + responseTime +
                '}';
    }
}
