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
"title",
"image_url",
"subtitle",
"buttons"
})
public class Element implements Serializable
{

@JsonProperty("title")
private String title;
@JsonProperty("image_url")
private String imageUrl;
@JsonProperty("subtitle")
private String subtitle;
@JsonProperty("buttons")
private List<Button> buttons = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -2623802020361484717L;

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("image_url")
public String getImageUrl() {
return imageUrl;
}

@JsonProperty("image_url")
public void setImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
}

@JsonProperty("subtitle")
public String getSubtitle() {
return subtitle;
}

@JsonProperty("subtitle")
public void setSubtitle(String subtitle) {
this.subtitle = subtitle;
}

@JsonProperty("buttons")
public List<Button> getButtons() {
return buttons;
}

@JsonProperty("buttons")
public void setButtons(List<Button> buttons) {
this.buttons = buttons;
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