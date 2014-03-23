package com.studio.bookings.entity;

import lombok.Getter;
import lombok.Setter;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;


@Entity
public class EventCategory {
	
	@Index
	@Getter @Setter
	@Id Long id;
	
	@Parent
    @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    private Key<Account> accountKey;
	
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    public Key<Account> getAccountKey() { 
    	return this.accountKey; 
    }
    
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    public void setAccountKey(Key<Account> value) { 
    	this.accountKey = value; 
    }
	
    @Index
	@Getter @Setter
	String name;
	
	public EventCategory(){}
	
	public EventCategory(String name, Account account) {
		this.accountKey = account.getKey();
		this.name = name;
	}
	
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
	public Key<EventCategory> getKey() {
    	if(id == null){
    		return null;
    	}
        return Key.create(this.getClass(), id);
    }
	
	public String toString() {
		return this.name;
	}
	
}
