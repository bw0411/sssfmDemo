package com.yonyougov.sssfm.service.impl;

import com.yonyougov.sssfm.domain.TestGroup;
import com.yonyougov.sssfm.domain.TestUser;
import com.yonyougov.sssfm.repository.GroupRepository;
import com.yonyougov.sssfm.repository.UserRepository;
import com.yonyougov.sssfm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangshc
 * @Date: 2019/1/14 14:15
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    public TestUser getById(Long id){
        return userRepository.getOne(id);
    }

    @Override
    @Transactional
    public TestUser saveUserAndGroup(TestUser user) {
        //被维护方保存时需双方建立关联
        List<TestGroup> groups = user.getGroups();
        if(groups!=null && groups.size()>0){
            for (TestGroup group : groups) {
                //建立关联关系
                TestGroup tempGroup = groupRepository.getOne(group.getId());
                if(tempGroup.getUsers()!=null && tempGroup.getUsers().size()>0){
                    tempGroup.getUsers().add(user);
                }else{
                    List<TestUser> list = new ArrayList<TestUser>();
                    list.add(user);
                    tempGroup.setUsers(list);
                }
            }
        }
        return userRepository.save(user);
    }
}
