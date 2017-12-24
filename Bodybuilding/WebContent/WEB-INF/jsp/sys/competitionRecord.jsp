<%@ page language="java" import="java.util.*"  import="com.cn.pojo.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	if (session.getAttribute("account") == null) {
%>
<script type="text/javascript" language="javascript">        
            alert("您还没有登录，请登录...");   
           top.location.href="../login.jsp";  
           </script>
<%
	}
%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8" />
<c:set var="domain" value="${pageContext.request.contextPath}"></c:set>
<link rel="apple-touch-icon" sizes="76x76"
	href="${domain}/${domain}/assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="${domain}/${domain}/assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>比赛记录</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="${domain}/assets/css/bootstrap.min.css" rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="${domain}/assets/css/animate.min.css" rel="stylesheet" />

<!--  Paper Dashboard core CSS    -->
<link href="${domain}/assets/css/paper-dashboard.css" rel="stylesheet" />

<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="${domain}/assets/css/demo.css" rel="stylesheet" />

<!--  Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Muli:400,300'
	rel='stylesheet' type='text/css'>
<link href="${domain}/assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">

			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="#" class="simple-text"> 台球俱乐部管理系统 </a>
				</div>

				<ul class="nav">
					<li><a href="ForwardAdmin"> <i class="ti-panel"></i>
							<p>信息总览</p>
					</a></li>
					<li class="active"><a href="userTable"> <i class="ti-user"></i>
							<p>会员列表</p>
					</a></li>
					<li><a href="teachTable"> <i class="ti-user"></i>
							<p>教练列表</p>
					</a></li>
					<li><a href="apparatusTable"> <i class="ti-text"></i>
							<p>器材管理</p>
					</a></li>
					<li><a href="recordsTable"> <i class="ti-text"></i>
							<p>比赛记录</p>
					</a></li>
					<li class="active-pro"><a href="exit"> <i
							class="ti-export"></i>
							<p>退出</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
							<span class="icon-bar bar3"></span>
						</button>
						<a class="navbar-brand" href="#">比赛记录</a>
					</div>
					<div class="collapse navbar-collapse"></div>
				</div>
			</nav>

			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<p class="category">请选择你要进行的操作</p>
									<h4 class="title">
										<button class="btn btn-info btn-fill " onclick="add()">增加</button>
									</h4>
								</div>
								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th>序号</th>
											<th>主场方</th>
											<th>客场方</th>
											<th>总比分</th>
											<th>获胜者</th>
											<th>比赛日期</th>
											<th>操作</th>
										</thead>
										<tbody>
											<c:forEach var="list" items="${listPageRecords}">
												<tr>
													<td>${list.id}</td>
													<td>${list.home_name}</td>
													<td>${list.visit_name}</td>
													<td>${list.total_score}</td>
													<td>${list.winner}</td>
													<td>${list.competition_time}</td>
													<td>
														<input class="btn btn-danger btn-fill " type="text" value="不可编辑" disabled="true"></input>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
<table align="center" valign="center" width="461" height="24" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="199">当前为第${page.currentPage}页,共${page.totalPage}页</td>
    <td width="256">
    <c:choose>
        <c:when test="${page.hasPrePage}">
           <a href="recordsTable?currentPage=1">首页</a> | 
    <a href="recordsTable?currentPage=${page.currentPage -1 }">上一页</a>
        </c:when>
        <c:otherwise>
            首页 | 上一页
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${page.hasNextPage}">
           <a href="recordsTable?currentPage=${page.currentPage + 1 }">下一页</a> | 
    <a href="recordsTable?currentPage=${page.totalPage }">尾页</a>
        </c:when>
        <c:otherwise>
            下一页 | 尾页
        </c:otherwise>
    </c:choose>

</td>
  </tr>
</table>


			<footer class="footer">
				<div class="container-fluid">
					<div class="copyright">
						Copyright &copy; 2017.Company name All rights reserved.<a
							target="_blank" href="javascript:">abcd</a>
					</div>
				</div>
			</footer>
		</div>
	</div>

</body>
<!--   Core JS Files   -->
<script src="${domain}/assets/js/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="${domain}/assets/js/bootstrap.min.js"
	type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="${domain}/assets/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="${domain}/assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="${domain}/assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<!---<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>--->

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="${domain}/assets/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="${domain}/assets/js/demo.js"></script>
<script src="${domain}/js/layer.js"></script>
<script type="text/javascript">
function add(){
	parent.layer.open({
    type: 2,
    shadeClose: true,
    shade: 0.8,
    area: ['450px', '75%'],
    content: 'addRecord',
    end: function () {
       location.reload();
    }
});
}

function del(id){
	layer.confirm('确认要删除这位学员吗？',function(index){
			$.ajax({
				type: 'get',
				url: 'delUser',
				data: {id : id},
				success: function(data){
					layer.msg('删除成功!',{icon: 1,time:2000});
					setTimeout(function(){
						window.location.href='userTable';
					},2000)
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
}

function update(id,account,name,pwd,sex,age,tel,address){
	parent.layer.open({
	    type: 2,
	    shadeClose: true,
	    shade: 0.8,
	    area: ['450px', '75%'],
	    content: 'upUser?id='+id+'&account='+account+'&name='+name+'&pwd='+pwd+'&sex='+sex+'&age='+age+'&tel='+tel+'&address='+address,
	    end: function () {
	       window.location.href='userTable';
	    }
	});
}
</script>


</html>