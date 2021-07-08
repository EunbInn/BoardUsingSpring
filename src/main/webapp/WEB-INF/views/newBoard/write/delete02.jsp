<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<link href="${path}/resources/css/board.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	body {
		display: flex;
		justify-content: center;
		text-align: center;
	}
	
	#content-wrap {
		display: flex;
		flex-direction: column;
		justify-content: center;
		items-align: center;
	}
	
	#main-table {
		width: 850px;
		border-collapse: collapse;
		border-top: 2px solid black;
		border-bottom: 2px solid black;
	}
	
	#confirm {
		padding: 20px;
		border-top: 1px solid black;
	}
</style>
</head>
<body>
<body>
	<div id="content-wrap">
		<form method="post">
			<table id="main-table">
				<tr>
					<th>게 시 글</th>
				</tr>
				<tr>
					<th id="confirm">게시글 삭제가 완료되었습니다</th>
				</tr>
			</table>
			<button class="btn" id="back"><a href="${path }/oneBoard/${boardId }">목록으로</a></button>
		</form>
	</div>
</body>
</html>