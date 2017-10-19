package com.cx.ttshop.dao;

import com.cx.common.dto.Page;
import com.cx.ttshop.pojo.vo.TbItemCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class TbItemMapperCustomTest {

    @Autowired
    private TbItemMapperCustom tbItemMapperCustom;

    @Test
    public void listItemByPage() throws Exception {
        Page page = new Page();
        page.setPage(1);
        page.setRows(10);
        List<TbItemCustom> list = tbItemMapperCustom.listItemByPage(page);

        System.out.println(list.size());
    }

}