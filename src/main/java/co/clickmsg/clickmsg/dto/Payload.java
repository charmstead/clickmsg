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
"template_type",
"elements"
})
public class Payload implements Serializable
{

@JsonProperty("template_type")
private String templateType;
@JsonProperty("elements")
private List<Element> elements = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -892315622233550070L;

@JsonProperty("template_type")
public String getTemplateType() {
return templateType;
}

@JsonProperty("template_type")
public void setTemplateType(String templateType) {
this.templateType = templateType;
}

@JsonProperty("elements")
public List<Element> getElements() {
return elements;
}

@JsonProperty("elements")
public void setElements(List<Element> elements) {
this.elements = elements;
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