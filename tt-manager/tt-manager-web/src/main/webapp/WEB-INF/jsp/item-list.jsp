<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="list"></table>
<script>

    var toolbar =[
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
        toolbar:toolbar,
        fit:true,
        pagination:true,
        url:"items",
        columns:[[
            {field:"check",checkbox:true},
            {field:"id",title:"商品编号",width:100},
            {field:"title",title:"商品名称",width:300},
            {field:"sellPoint",title:"卖点",width:300},
            {field:"catName",title:"类别",width:100},
            {field:"statusName",title:"状态",width:100}
        ]]

    });

</script>