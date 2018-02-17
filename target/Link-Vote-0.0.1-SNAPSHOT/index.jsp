<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	pageContext.setAttribute("PATH", request.getContextPath());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入jQuery -->
<script type="text/javascript" src="${PATH }/linkVoteApp/jQuery/jquery-3.1.1.js"></script>
<!-- 引入bootstrap框架 -->
<link href="${PATH }/linkVoteApp/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${PATH }/linkVoteApp/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	  var serverPath="${PATH}";
	  $(function(){
		   $.ajax({
				url : serverPath+"/users",
				type : "GET",
				success : function(result) {
					var users = result.extend.userList;
					$("#emps_tbl tbody").empty();
					$.each(users,function(index,user){
						var user_tr =$("<tr></tr>");
						var checkBox = $("<td></td>").append(
								$("<input type='checkbox'>"));
						var id_td = $("<td></td>")
						var name_td = $("<td></td>");
						var sex_td = $("<td></td>");
						name_td.append(user.name);
					sex_td.append(user.sex);
						id_td.append(user.userId);
						user_tr.append(checkBox).append(id_td).append(name_td).append(sex_td).appendTo("#emps_tbl tbody");
					});
				}
		   })
	   });
	  function jump(){
		  $.ajax({
				url : serverPath+"/users",
				type : "GET",
				success : function(result) {
					var users = result.extend.userList;
					alert(users);
				}
		   })
	  }
	  
	  var file = $("#imageSelect").val();
	  
	  $("#imageSubmit").click(function(){
		  $.ajax({
			  url:serverPath+"/upload",
			  type:"GET",
			  data:{
				"file":file  
			  },
			  success:function(data){
				  alert(data);
			  }
		  });
	  });
	  
	</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Link-Vote</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-9">
				<button class="btn btn-primary" id="emp_add_btn" onclick="jump();">新增</button>
				<button class="btn btn-danger" id="del_checked_emp">删除</button>
			</div>
		</div>
		<div class="row">
			<table class="table table-hover" id="emps_tbl">
				<thead>
					<tr>
						<td><input type="checkbox" id="check_all" /></td>
						<th>#</th>
						<th>name</th>
						<th>sex</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		</div>
		
		<img alt="图片显示" src="" id="image">
		<form action="" enctype="multipart/form-data">
		  <input type="file" name="file" id="imageSelect"/>
		  <input type="submit" value="提交" id="imageSubmit"/>
		 </form>
	</div>
    

</body>
</html>