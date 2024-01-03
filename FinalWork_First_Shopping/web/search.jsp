<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>搜索商品</title>
</head>
<body>
<script src="js/getAjaxObject.js"></script>
请输入商品名称查询:<input type="text" id="goodsname" name="goodsname"/>
<input type="button" value="查询" onclick="search()">
<hr>
<div id="searchresult">
</div>
<script>
    function search(){
        var xmlHttp=getAjaxObject();
        var goodsname=document.getElementById("goodsname").value;
        var url="SearchServlet";
        var result="没有类似商品";
        xmlHttp.open("POST",url,true);
        xmlHttp.onreadystatechange=function(){
            if (xmlHttp.readyState==4 && xmlHttp.status==200){
                var responsetext=xmlHttp.responseText;
                var goodsList=JSON.parse(responsetext);
                if(goodsList.length!=0){
                    result="<table><tr><th>商品号</th><th>商品名称</th><th>单价</th></tr>"
                    for(var i=0;i<goodsList.length;i++){
                        result+="<tr><td>"+goodsList[i].gid+"</td><td>"+goodsList[i].gname+"</td><td>"+Number(goodsList[i].gprice).toFixed(2)+"</td><tr>";
                    }
                    result+="</table>";
                }
                document.getElementById("searchresult").innerHTML=result;
            }
        }
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send("goodsname="+goodsname);
    }
</script>
</body>
</html>