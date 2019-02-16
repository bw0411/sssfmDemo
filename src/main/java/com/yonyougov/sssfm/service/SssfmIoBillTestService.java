package com.yonyougov.sssfm.service;

import com.crux.core.service.CrudService;
import com.yonyougov.sssfm.domain.SssfmIoBillTest;

import java.util.List;

/**
 * @Author: zhangshc
 * @Date: 2019/1/9 11:24
 * @Version 1.0
 */

public interface SssfmIoBillTestService extends CrudService<SssfmIoBillTest>{

    public List<SssfmIoBillTest> queryList();
}
