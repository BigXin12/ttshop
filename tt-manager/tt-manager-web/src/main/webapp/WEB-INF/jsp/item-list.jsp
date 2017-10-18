<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="list"></table>
<script>

    $("#list").datagrid({
        fit:true,
        pagination:true,
        url:"items",
        columns:[[
            {field:"id",title:"商品编号",width:100},
            {field:"title",title:"商品名称",width:300},
            {field:"sellPoint",title:"卖点",width:300}
        ]]

    });

</script>