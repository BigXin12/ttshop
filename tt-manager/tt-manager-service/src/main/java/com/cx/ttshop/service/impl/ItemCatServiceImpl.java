package com.cx.ttshop.service.impl;

import com.cx.common.dto.TreeNode;
import com.cx.ttshop.dao.TbItemCatMapper;
import com.cx.ttshop.pojo.po.TbItemCat;
import com.cx.ttshop.pojo.po.TbItemCatExample;
import com.cx.ttshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        List<TreeNode> resultList = new ArrayList<>();

        //遍历所有集合
        for(int i=0;i<list.size();i++){
            TreeNode node = new TreeNode();
            node.setId(list.get(i).getId());
            node.setState(list.get(i).getIsParent()?"closed":"open");
            node.setText(list.get(i).getName());
            resultList.add(node);
        }
        return resultList;
    }
}
