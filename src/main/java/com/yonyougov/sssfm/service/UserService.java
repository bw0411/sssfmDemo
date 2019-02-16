package com.yonyougov.sssfm.service;

import com.crux.core.service.CrudService;
import com.yonyougov.sssfm.domain.TestUser;

/**
 * @Author: zhangshc
 * @Date: 2019/1/14 13:55
 * @Version 1.0
 */
public interface UserService extends CrudService<TestUser> {

    TestUser getById(Long id);

    TestUser saveUserAndGroup(TestUser user);
}
