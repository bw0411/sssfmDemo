package com.yonyougov.sssfm.domain;

import com.crux.core.domain.BaseEntity;
import com.crux.metadata.annotation.Display;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhangshc
 * @Date: 2019/1/16 16:45
 * @Version 1.0
 */
@Display("收支项目")
@Data
@Table(name = "ma_ins_io_item_test")
@Entity
public class MaInsIoItemTest extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 237222719924684177L;

    @Display("收支项目代码")
    private String ioItemCode;

    @Display("收支项目名称")
    private String ioItemName;

    @Display("收支类型")
    private String inOut;

    @Display("项目类别")
    private String itemType;

    @Display("备注")
    private String remark;

    @Display("是否使用")
    private String isValid;

    @Display("是否有效")
    private String isUsed;

    @Display("行政区划")
    private Long distId;

    @Display("参保地")
    private Long insuredplaceId;

    @Display("就医地")
    private Long medicalplaceId;

    @Display("父级项目")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private MaInsIoItemTest parent;

    @Display("子级项目")
    @OneToMany(mappedBy = "parent",cascade = CascadeType.PERSIST)
    private List<MaInsIoItemTest> children;

    @Display("基金险种")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ins_type_id")
    private MaInsTypeTest maInsType;

}
