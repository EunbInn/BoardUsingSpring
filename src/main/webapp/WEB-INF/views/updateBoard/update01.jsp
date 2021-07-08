<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드판 수정</title>
<link href="${path}/resources/css/board.css" rel="stylesheet" />
<link href="${path}/resources/css/makeboard.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${path}/resources/js/newBoard.js"></script>
</head>
<body>
	<form method="post">
		<table border="1px solid black">
			<tr>
				<th colspan="2">게시판 수정</th>
			</tr>
			<tr>
				<th class="category">번호</th>
				<td class="content"><input type="text" id="input-boardId" name="id" readonly value="${board.id }"></td>
			</tr>
			<tr>
				<th class="category">게시판 이름</th>
				<td class="content">
					<input type="text" name="title" class="input-box" id="input-title" 
					placeholder="게시판 이름을 입력해주세요" maxlength="50" value="${board.title }">
				</td>
			</tr>
		</table>
		<button class="btn" id="submit" formaction="${path }/update02/${board.id }">수정</button>
		<button class="btn" formaction="${path }/delete01/${board.id }">삭제</button>
		<input type="button" class="btn" id="back" value="취소" onclick="location.href='${path }/'">
	</form>
</body>
</html>