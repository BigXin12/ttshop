package com.cx.ttshop.dao;

import com.cx.ttshop.pojo.po.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class TbUserMapperTest {

    @Autowired
    private TbUserMapper userdao;

    @Test
    public void selectByPrimaryKey() throws Exception {
        TbUser tbUser = userdao.selectByPrimaryKey(5L);
        System.out.println(tbUser);
    }

}