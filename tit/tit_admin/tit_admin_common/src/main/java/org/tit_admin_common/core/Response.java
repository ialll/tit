package org.tit_admin_common.core;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author 刘晓勇
 *
 */
@XStreamAlias("response")
@XmlRootElement(name = "response")
public class Response implements Serializable {
    private class Result {}
    private @XStreamAlias(value = "result", impl = Result.class) Object result;
    private Meta meta = new Meta();


    public void setError(int code, String msg) {
        meta.setCode(code);
        result = msg;
    }


    public void setError(int code, Object msg) {
        meta.setCode(code);
        result = msg;
    }


    @XmlElement(type = Object.class)
    public Object getResult() {
        return result;
    }


    public void setResult(Object result) {
        this.result = result;
    }


    @XmlElement
    public Meta getMeta() {
        return meta;
    }


    public void setMeta(Meta meta) {
        this.meta = meta;
    }


    @Override public String toString() {
        return "Response{" +
                "result=" + result +
                ", meta=" + meta +
                '}';
    }
}
