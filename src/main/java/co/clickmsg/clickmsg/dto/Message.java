/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.dto;

/**
 *
 * @author tomide
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"attachment",
"quick_replies"
})
public class Message implements Serializable
{

@JsonProperty("attachment")
private Attachment attachment;
@JsonProperty("quick_replies")
private List<QuickReply> quickReplies = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -5337515599737788516L;

@JsonProperty("attachment")
public Attachment getAttachment() {
return attachment;
}

@JsonProperty("attachment")
public void setAttachment(Attachment attachment) {
this.attachment = attachment;
}

@JsonProperty("quick_replies")
public List<QuickReply> getQuickReplies() {
return quickReplies;
}

@JsonProperty("quick_replies")
public void setQuickReplies(List<QuickReply> quickReplies) {
this.quickReplies = quickReplies;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}