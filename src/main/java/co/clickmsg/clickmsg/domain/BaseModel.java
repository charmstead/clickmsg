package co.clickmsg.clickmsg.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



/**
 * Created by tycoon on 3/21/16.
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
  //    @Version
  //    private Long version;

    public Long getId() {
        return id;
    }



  public BaseModel setId(Long id) {
    this.id = id;
    return this;
  }
}
