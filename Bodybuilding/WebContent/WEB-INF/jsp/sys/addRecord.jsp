<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<c:set var="domain" value="${pageContext.request.contextPath}"></c:set>
<link rel="apple-touch-icon" sizes="76x76"
	href="${domain}/assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="${domain}/assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title></title>
<script type="text/javascript" src="js/laydate.js"></script>

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
<link href="${domain}/assets/css/themify-icons.css" rel="stylesheet">

<!--  date    -->
<link href="${domain}/assets/css/laydate.css" rel="stylesheet">

</head>
<body>

	<div class="wrapper">


		<div class="main-panel">


			<div class="content">
				<div style="padding-left: 20px; padding-right: 20px">
					<form>
						<div class="row">
							<div class="col-md-5">
								<div class="form-group">
									<label>主场方</label> <input type="text"
										class="form-control border-input" placeholder="主场方客场方不能为同一人"
										value="${recordInfo[0].home_name}" id="home_name">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>客场方</label> <input type="text"
										class="form-control border-input" placeholder="主场方客场方不能为同一人"
										value="${recordInfo[0].visit_name}" id="visit_name">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="exampleInputEmail1">总比分</label> <input type="text"
										class="form-control border-input" placeholder="总比分"
										value="${recordInfo[0].total_score}" id="total_score">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>获胜者</label> <input type="text"
										class="form-control border-input" placeholder="获胜方"
										value="${recordInfo[0].winner}" id="winner">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>比赛时间</label> <input type="text"
									class="form-control border-input" placeholder="比赛日期"
										value="${recordInfo[0].competition_time}" id="competition_time">
								</div>
							</div>

							<div class="text-center">
								<button type="button" class="btn btn-info btn-fill btn-wd"
									onclick="update()">增加记录</button>
							</div>

							<div class="clearfix"></div>
					</form>
				</div>
			</div>
		</div>
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
	function update() {
		var home_name = document.getElementById("home_name").value;
		var visit_name = document.getElementById("visit_name").value;
		var total_score = document.getElementById("total_score").value;
		var winner = document.getElementById("winner").value;
		var competition_time = document.getElementById("competition_time").value;
		if (home_name == "" || visit_name == "" || total_score == ""
				|| winner == "" || competition_time == "") {
			layer.msg('请把信息填写完整!', {
				icon : 2,
				time : 2000
			});
			return false;
		}
		
		var regExp = new RegExp("([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))");
		if(!regExp.test(competition_time)){
			layer.msg('日期格式不正确，正确格式为：2014-01-01', {
			icon : 2,
			time : 2000
			});
			return false;
		} 

		if (home_name == visit_name) {
			layer.msg('主场方客场方不能为同一人!', {
				icon : 2,
				time : 2000
			});
			return false;
		}

		var regScore = new RegExp("^[0-9]+\:[0-9]+$");
		if (!regScore.test(total_score)) {
			layer.msg('请输入正确的比分格式!', {
				icon : 2,
				time : 2000
			});
			return false;
		}

		if (winner != visit_name && winner != home_name) {
			layer.msg('获胜者为主客场方其中一人!', {
				icon : 2,
				time : 2000
			});
			return false;
		}
/*解析总比分字符串*/
		var scores = new Array();
		var total_scores = total_score + ""; //拼接成字符串变量
		scores = total_scores.split(":");
/*		for (i = 0; i < scores.length; i++) 
		{
			document.write(scores[i] + "<br/>"); //分割后的主客场双方比分输出 ,测试使用
		}*/
		if(scores[0] > scores[1])
		{
			winner = home_name;
		}else if(scores[0] < scores[1])
		{
			winner = visit_name;
		}else
		{
			winner = "平手";
		}
		document.write("获胜者：" + winner);
		

		$.post("addCompetitionRecord", {
			'home_name' : home_name,
			'visit_name' : visit_name,
			'total_score' : total_score,
			'winner' : winner,
			'competition_time' : competition_time,
		}, function(result) {
			if (result == "true") {
				layer.msg('添加成功!', {
					icon : 1,
					time : 2000
				});
			}
		})
	}
</script>
</html>
