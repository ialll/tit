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
    protected @XStreamOmitField Date createdAt;
    protected @XStreamOmitField Date updatedAt;


    public Entity() {
        createdAt = new Date();
        updatedAt = new Date();
    }


    /**
     * To make XStream deserialization assign values to
     * base class fields of createdAt and updatedAt
     *
     * @return
     */
    public Object readResolve() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
            this.updatedAt = createdAt;
        }

        return this;
    }

}
