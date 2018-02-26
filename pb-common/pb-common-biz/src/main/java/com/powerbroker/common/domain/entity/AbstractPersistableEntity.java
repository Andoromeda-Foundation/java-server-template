package com.powerbroker.common.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author william
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractPersistableEntity<ID extends Serializable> implements Persistable<ID> {

    private static final long serialVersionUID = -1L;

    public abstract void setId(ID id);

    // 显示/隐藏
    public static final Integer SHOW = 1;
    public static final Integer HIDE = 0;

    // 是/否
    public static final Integer YES = 1;
    public static final Integer NO = 0;

    // 删除标记（0：正常；1：删除；2：审核；）
    public static final String FIELD_DEL_FLAG = "deleted";
    public static final Integer DEL_FLAG_NORMAL = 0;
    public static final Integer DEL_FLAG_DELETE = 1;
    // public static final Integer DEL_FLAG_AUDIT = 2;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @NotFound(action = NotFoundAction.IGNORE)
    // @JoinColumn(name = "create_by", updatable = false)
    @Column(updatable = false)
    private Long createBy;

    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @NotFound(action = NotFoundAction.IGNORE)
    // @JoinColumn(name = "update_by")
    private Long updateBy;

    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;

    private boolean active = true;

    private boolean deleted = false;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @NotFound(action = NotFoundAction.IGNORE)
    // @JoinColumn(name = "delete_by", insertable = false)
    @Column(insertable = false)
    private Long deleteBy;

    @Column(insertable = false)
    private LocalDateTime deleteAt;

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }
}
