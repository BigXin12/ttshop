<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>

<table id="list"></table>
<script>

    function searchForm() {
        $('#list').datagrid('load',{
            title:$('#title').val(),
            status:$('#status').combobox('getValue')
        });
    }
    
    
    function add(){
        ttshop.addTab('新增商品','item-add');
    }
    function edit() {
        console.log("编辑");
    }
    function remove(){
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

    function down() {
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

    function up(){
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



    $("#list").datagrid({
        multiSort:true,
        toolbar:'#toolbar',
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