package study.datajpa.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class JpaBaseEntity {

    @Column(updatable = false) // 생성일을 실수로 변경하는것을 방지
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist // persist 하기 전에 호출됨
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;
    }

    @PreUpdate // update 할때 호출됨
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }

}
