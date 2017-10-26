package com.cx.common.dto;

/**
 * User: DHC
 * Date: 2017/10/24
 * Time: 9:58
 * Version:V1.0
 * 树节点结构实体类
 */
public class TreeNode {
    private Long id;
    private String text;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
