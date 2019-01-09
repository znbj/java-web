<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">

	$(function () {
		$("#tid").keyup(function () {
		    //alert(1)

		    var content=$(this).val();

		    $("#did").empty();
            $("#did").hide();

			if (content!="") {
				$.get("http://localhost/KeyWordAjax","kw="+content,function (data) {

				    $(data).each(function (index,ele) {
				        var  kname=this.name;

						var div = "<div onmouseover='ms(this)' onmouseout='mo(this)'>"+kname+"</div>";

						$("#did").append(div);


                    })
                    $("#did").show();
                },"json")
            }else {

            }
        })

    })

    function ms(obj){
		$(obj).css("color","red")
	}
	function mo(obj) {
		$(obj).css("color","black")
    }



</script>
<title>Insert title here</title>
</head>
<body>
	<center>
		<div>
			<h1>黑马搜索</h1>
			<div>
				<input name="kw" id="tid" ><input type="button"  value="黑马一下">
			</div>
			<div id="did" style="border: 3px solid #4e39ff;width: 171px;position:relative;left:-34px;display:none"></div>
		</div> 
	</center>
</body>
</html>