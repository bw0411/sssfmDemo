package com.yonyougov.sssfm.domain;

import com.crux.core.domain.BaseEntity;
import com.crux.core.service.EnableRestCrud;
import com.crux.metadata.annotation.Display;
import com.yonyougov.sssfm.service.IDCardService;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: zhangshc
 * @Date: 2019/1/15 9:21
 * @Version 1.0
 */
@Display("身份证")
@Data
@Entity
@Table(name = "card")
@EnableRestCrud(IDCardService.class)
public class IDCard extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 7505507530083936010L;

    @Display("身份证号码")
    @Column(name = "id_number",length = 23)
    private String idNumber;

    @Display("所属公民")
    @OneToOne(cascade = CascadeType.ALL,mappedBy="card",optional = false)
    private Person person;
}
