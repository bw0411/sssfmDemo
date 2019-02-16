package com.yonyougov.sssfm.domain;

import com.crux.core.domain.BaseEntity;
import com.crux.core.service.EnableRestCrud;
import com.crux.metadata.annotation.Display;
import com.yonyougov.sssfm.service.GroupService;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhangshc
 * @Date: 2019/1/14 12:14
 * @Version 1.0
 */
@Display("用户组表")
@Data
@Entity
@Table(name = "test_group")
@EnableRestCrud(value = GroupService.class)
public class TestGroup extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -4013741066075845042L;

    @Display("组名称")
    @Column(name = "group_name",length = 64)
    private String groupName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "test_user_groups",
            joinColumns = {@JoinColumn(name = "group_id",referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name = "user_id",referencedColumnName = "id")})
    private List<TestUser> users;
}
