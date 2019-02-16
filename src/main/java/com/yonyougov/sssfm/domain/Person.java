package com.yonyougov.sssfm.domain;

import com.crux.core.domain.BaseEntity;
import com.crux.core.service.EnableRestCrud;
import com.crux.metadata.annotation.Display;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyougov.sssfm.service.PersonService;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: zhangshc
 * @Date: 2019/1/15 9:21
 * @Version 1.0
 */
@Display("公民")
@Data
@Entity
@Table(name = "persons")
@EnableRestCrud(PersonService.class)
public class Person extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1653691691895110978L;

    @Display("姓名")
    @Column(name = "name",length = 32)
    private String name;

    @Display("性别")
    @Column(name = "sex",length = 16)
    private String sex;

    @Display("年龄")
    @Column(name = "age")
    private Integer age;

    @Display("身份证")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    private IDCard card;
}
