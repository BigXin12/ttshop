<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="list"></table>
<script>

    var toolbar =[
        {
            id:"search",
            text:"搜索",
            iconCls:"icon-search",
            handler:function () {
                console.log("搜索");
            }
        },
        {
            iconCls: 'icon-add',
            text: "新增",
            handler: function () {
                console.log("新增");
            }
        },
        {
            iconCls: 'icon-remove',
            text: "删除",
            handler: function () {
                console.log("删除");
                var selectRows = $('#list').datagrid('getSelections');
                if(selectRows.length==0){
                    $.messager.alert('提示','未选中记录','warning');
                    return;
                }
                $.messager.confirm('确认','确定删除吗',function(r){
                    if(r){
                        var ids = [];
                        for(var i= 0;i<selectRows.length;i++){
                            ids.push(selectRows[i].id);
                        }

                        //异步提交给后台
                        $.post(
                            //url：提交给后台哪个动作去处理，必须，其他属性不必须
                            'item/batch',
                            //data:提交到后台的数据
                            {'ids[]':ids},
                            //function：处理成功后的回调函数，相当于ajax中的success
                            function(data) {

                                $('#list').datagrid('reload');
                            },
                            //dataType:返回的数据类型
                            'json'
                        );
                    }
                });

            }
        },
        {
            iconCls: 'icon-edit',
            text: "编辑",
            handler: function () {
                console.log("编辑");

            }
        },
        {
            iconCls: 'icon-up',
            text: "上架",
            handler: function () {
                console.log("上传");
                var selectRows = $('#list').datagrid('getSelections');
                if(selectRows.length==0){
                    $.messager.alert('提示','未选中记录','warning');
                    return;
                }
                $.messager.confirm('确认','确认上架吗',function(r){
                    if(r){
                        var ids = [];
                        for(var i=0;i<selectRows.length;i++){
                            ids.push(selectRows[i].id);
                        }
                        //异步提交后台
                        $.post(
                            'item/up',
                            {'ids[]':ids},
                            function(data){
                                $('#list').datagrid('reload');
                            },
                            'json'
                        )
                    }
                });
            }
        },
        {
            iconCls:"icon-down",
            text:"下架",
            handler:function(){
                console.log("下架");
                var selectRows = $('#list').datagrid('getSelections');
                if(selectRows.length==0){
                    $.messager.alert('提示','未选中记录','warning');
                    return;
                }
                $.messager.confirm('确认','确认下架吗',function(r){
                    if(r){
                        var ids = [];
                        for(var i=0;i<selectRows.length;i++){
                            ids.push(selectRows[i].id);
                        }
                        //异步提交后台
                        $.post(
                            'item/down',
                            {'ids[]':ids},
                            function(data){

                                $('#list').datagrid('reload');
                            },
                            'json'
                        )
                    }
                });
            }
    }];

    $("#list").datagrid({
        multiSort:true,
        toolbar:toolbar,
        fit:true,
        pagination:true,
        url:"items",
        columns:[[
            {field:"check",checkbox:true},
            {field:"id",title:"商品编号",width:100,sortable:true},
            {field:"title",title:"商品名称",width:200,sortable:true},
            {field:"sellPoint",title:"卖点",width:200},
            {field:"catName",title:"类别",width:50},
            {field:"statusName",title:"状态",width:50},
            {field:"created",title:"创建时间",width:150,formatter:function(value,row,index){
                return moment(value).format('lll')
            }},
            {field:"updated",title:"更新时间",width:150,formatter:function(value,row,index){
                return moment(value).format('lll')
            }},
            {field:"priceView",title:"价格",width:50}
        ]]

    });

</script>