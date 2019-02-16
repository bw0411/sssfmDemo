package com.yonyougov.sssfm.repository;

import com.crux.core.repository.GenericRepository;
import com.yonyougov.sssfm.domain.TestGroup;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhangshc
 * @Date: 2019/1/14 12:39
 * @Version 1.0
 */
@Repository
public interface GroupRepository extends GenericRepository<TestGroup> {
}
