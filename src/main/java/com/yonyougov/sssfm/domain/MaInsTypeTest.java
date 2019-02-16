package com.yonyougov.sssfm.domain;

import com.crux.core.domain.BaseEntity;
import com.crux.core.service.EnableRestCrud;
import com.crux.metadata.annotation.Display;
import com.yonyougov.sssfm.service.MaInsTypeService;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhangshc
 * @Date: 2019/1/16 15:54
 * @Version 1.0
 */
@Display("资金性质")
@Data
@Table(name = "ma_ins_type_test")
@Entity
@EnableRestCrud(MaInsTypeService.class)
public class MaInsTypeTest extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1130232726403388306L;

    @Display("资金性质编码")
    @Column(name = "ins_type_code",length = 16)
    private String insTypeCode;

    @Display("资金性质名称")
    @Column(name = "ins_type_name",length = 64)
    private String insTypeName;

    @Display("资金性质类型")//资金、基金FUND
    @Column(name = "ins_type_kind",length = 16)
    private String insTypeKind;

    @Display("备注")
    @Column(name = "remark")
    private String remark;

    @Display("子类资金")
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<MaInsTypeTest> childs;

    @Display("父类资金")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pid")
    private MaInsTypeTest parent;

    @Display("资金收支项目类型")
    @OneToMany(mappedBy = "maInsType",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private List<MaInsIoItemTest> maInsIoItem;


}
