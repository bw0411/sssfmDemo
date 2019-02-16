package com.yonyougov.sssfm.domain;

import com.crux.core.domain.BaseEntity;
import com.crux.core.service.EnableRestCrud;
import com.crux.metadata.annotation.Display;
import com.yonyougov.sssfm.service.SssfmIoBillTestService;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhangshc
 * @Date: 2019/1/9 10:21
 * @Version 1.0
 */
@Data//lombok 自动生成get set方法
@Table(name="sssfm_io_bill_test")//对应数据库的表
@Display("测试单据")//平台提供的元数据注释
@Entity
@EnableRestCrud(SssfmIoBillTestService.class)
public class SssfmIoBillTest extends BaseEntity implements Serializable {


    @Display("单据编号")
    @Column(name = "bill_no",length = 16,unique = true)
    private String billNo;

    @Display("单据类型")
    @Column(name = "bill_type",length = 16)
    private String billType;

    @Display("来源系统")
    private String srcSys;

    @Display("是否打印")
    private String isPrint;

    @Display("备注")
    private String remark;


    /*指定多方中关联的外键字段名，
     * 如果多方中未指定对应的外键列(@JoinColumn)，此处应为多方属性名_id，否则会多方会新建一个外键名
     * */
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    @Where(clause="ins_id = 1")
    @OrderBy("id asc")
    private List<SssfmIoBillItemTest> itemTestList;

    private String billNo_billType;

    @Transient
    public String getBillNo_billType() {
        return this.billNo+"_"+this.getBillType();
    }
}
