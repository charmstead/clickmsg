package co.clickmsg.clickmsg.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseAuditableModel extends BaseModel {
  private static final long serialVersionUID = 1L;

      @Column(name = "created_at")
      @CreatedDate
      private LocalDateTime creationDate;
  
      @Column(name = "updated_at")
      @LastModifiedDate
      private LocalDateTime lastModifiedDate;
  
      public LocalDateTime getCreationDate() {
          return creationDate;
      }
  
      public BaseAuditableModel setCreationDate(LocalDateTime creationDate) {
          this.creationDate = creationDate;
          return this;
      }
  
      public LocalDateTime getLastModifiedDate() {
          return lastModifiedDate;
      }
  
      public BaseAuditableModel setLastModifiedDate(LocalDateTime lastModifiedDate) {
          this.lastModifiedDate = lastModifiedDate;
          return this;
      }
}
