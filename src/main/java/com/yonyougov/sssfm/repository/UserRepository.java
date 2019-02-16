package com.yonyougov.sssfm.repository;

import com.crux.core.repository.GenericRepository;
import com.yonyougov.sssfm.domain.TestUser;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhangshc
 * @Date: 2019/1/14 12:38
 * @Version 1.0
 */
@Repository
public interface UserRepository extends GenericRepository<TestUser> {
}
