package com.yonyougov.sssfm.domain;

import com.crux.core.domain.BaseEntity;
import com.crux.core.service.EnableRestCrud;
import com.crux.metadata.annotation.Display;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyougov.sssfm.service.SssfmIoBillItemTestService;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: zhangshc
 * @Date: 2019/1/9 10:39
 * @Version 1.0
 */

@Data
@Table(name = "sssfm_io_bill_test_c1")
@Display("社保收支单据项目明细测试")
@Entity
@EnableRestCrud(SssfmIoBillItemTestService.class)
public class SssfmIoBillItemTest extends BaseEntity implements Serializable {

    @Display("基金险种")
    @Column(name="ins_id",nullable = false)
    private Long insType;

    @Display("用途")
    @Column(name="out_use_reason",length = 255)
    private String outUseReason;

    @Display("付款单位")
    @Column(name="pay_co_id")
    private Long payCo;

    @Display("付款银行")
    @Column(name="pay_bank_id")
    private Long payBank;

    @Display("收款单位")
    @Column(name = "io_co_id")
    private Long ioCo;

    @Display("收款银行")
    @Column(name = "io_bank_id")
    private Long ioBank;

    @Display("金额")
    private BigDecimal amount;

    @Display("备注")
    private String remark;

    @Display("单据类型")
    @Column(name = "bill_type")
    private String billType;

    @Display("单据")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bill_id")//指定数据库表中外键列的字段名称，不指定默认为属性名_id
    @JsonIgnore
    private SssfmIoBillTest sssfmIoBillTest;
}
