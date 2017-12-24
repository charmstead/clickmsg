/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;

/**
 *
 * @author tomide
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonMessageDto implements Serializable{
    
    private long id;
    
    private String name;
    
    private Object message;

    public JsonMessageDto(Long id, String name, Object message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public JsonMessageDto() {
    }

    
    
    public String getName() {
        return name;
    }

    public JsonMessageDto setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
    
    
    
    
    
}
