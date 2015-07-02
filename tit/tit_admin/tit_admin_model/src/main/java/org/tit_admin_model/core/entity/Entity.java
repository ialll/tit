package org.tit_admin_model.core.entity;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * JpaEntity to declare fields to be in each entity table
 *
 * @author: 刘晓勇
 */
public @Data class Entity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5984680201973125214L;
	protected @XStreamOmitField int id;
    protected @XStreamOmitField Date createDt;
    protected @XStreamOmitField Date updateDt;


    public Entity() {
        createDt = new Date();
        updateDt = new Date();
    }


    /**
     * To make XStream deserialization assign values to
     * base class fields of createdAt and updatedAt
     *
     * @return
     */
    public Object readResolve() {
        if (this.createDt == null) {
            this.createDt = new Date();
            this.updateDt = createDt;
        }

        return this;
    }

}
