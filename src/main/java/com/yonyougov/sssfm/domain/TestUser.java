package com.yonyougov.sssfm.domain;

import com.crux.core.domain.BaseEntity;
import com.crux.core.service.EnableRestCrud;
import com.crux.metadata.annotation.Display;
import com.yonyougov.sssfm.service.UserService;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhangshc
 * @Date: 2019/1/14 12:12
 * @Version 1.0
 */
@Display("用户")
@Data
@Entity
@Table(name = "test_user")
@EnableRestCrud(value = UserService.class)
public class TestUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3413423571965443509L;

    @Column(name = "用户名",unique = true)
    private String name;

    @Column(name = "手机号",length = 18)
    private String mobile;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy ="users")
    private List<TestGroup> groups;
}
