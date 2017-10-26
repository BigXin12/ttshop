package com.cx.ttshop.service;

import com.cx.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {

    List<TreeNode> listItemCats(Long parentId);
}
