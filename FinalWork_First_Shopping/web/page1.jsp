<jsp:useBean id="goods" class="com.fc.exercise.Goods" scope="page">
</jsp:useBean>
<jsp:setProperty property="gname" name="goods" value="小米10"/>
<jsp:getProperty  name="goods" property="gname"/>
