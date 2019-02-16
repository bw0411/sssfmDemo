package com.yonyougov.sssfm.service.impl;

import com.yonyougov.sssfm.domain.TestGroup;
import com.yonyougov.sssfm.domain.TestUser;
import com.yonyougov.sssfm.repository.GroupRepository;
import com.yonyougov.sssfm.repository.UserRepository;
import com.yonyougov.sssfm.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: zhangshc
 * @Date: 2019/1/14 14:09
 * @Version 1.0
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

   /* @Override
    @Transactional
    public TestGroup saveGroupAndUser(TestGroup group) {
        List<TestUser> users = group.getUser();
        List usersTemp = new ArrayList<TestUser>();
        if(users != null && users.size()>0)
            for (TestUser user : users) {
                usersTemp.add(userRepository.getOne(user.getId()));
            }
        group.setUser(usersTemp);
        return groupRepository.saveAndFlush(group);
    }*/
}
