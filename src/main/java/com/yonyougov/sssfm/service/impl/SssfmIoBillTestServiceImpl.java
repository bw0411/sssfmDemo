package com.yonyougov.sssfm.service.impl;

import com.yonyougov.sssfm.domain.SssfmIoBillItemTest;
import com.yonyougov.sssfm.domain.SssfmIoBillTest;
import com.yonyougov.sssfm.repository.SssfmIoBillTestRepository;
import com.yonyougov.sssfm.service.SssfmIoBillTestService;
import com.yonyougov.sssfm.utils.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


/**
 * @Author: zhangshc
 * @Date: 2019/1/9 11:32
 * @Version 1.0
 */
@Service
public class SssfmIoBillTestServiceImpl implements SssfmIoBillTestService {

    @Autowired
    private SssfmIoBillTestRepository sssfmIoBillRepository;

    @Override
    public SssfmIoBillTest save(SssfmIoBillTest entity) {
        List<SssfmIoBillItemTest> itemTestList = entity.getItemTestList();
        System.out.println("itemTestList---size()===="+itemTestList.size());

        if(entity.getId() != null){
            Optional<SssfmIoBillTest> tempBill = sssfmIoBillRepository.findById(entity.getId());
            if(tempBill!=null){
                //更新
                try {
                    CopyUtils.copyProperties(tempBill.get(),entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sssfmIoBillRepository.save(entity);
    }

    public List<SssfmIoBillTest> queryList(){
        return sssfmIoBillRepository.findAll();
    }
}
