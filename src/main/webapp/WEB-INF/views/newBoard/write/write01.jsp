<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link href="${path}/resources/css/board.css" rel="stylesheet" />
<link href="${path}/resources/css/write.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${path}/resources/js/insertBoardItem.js"></script>
<style>

</style>
</head>
<body>
  <%
  String boardId = request.getParameter("boardId");
  String nowPage = request.getParameter("page");
  %>
  <div id="content-wrap">
    <form method="post">
      <table border="1px solid black">
        <tr>
          <th colspan="2">글쓰기</th>
        </tr>
        <tr>
          <th class="category">번호</th>
          <td class="content">신규</td>
        </tr>
        <tr>
          <th class="category">제목</th>
          <td class="content"><input type="text" name="title"
            class="input-box" id="input-title" placeholder="제목을 입력해주세요"
            maxlength="50"></td>
        </tr>
        <tr>
          <th class="category">작성자</th>
          <td class="content"><input type="text" name="writer"
            class="input-box" id="input-writer" placeholder="작성자"
            maxlength="50"></td>
        </tr>
        <tr>
          <th class="category">일자</th>
          <td class="content">${date }</td>
        </tr>

        <tr>
          <th class="category">내용</th>
          <td class="content"><textarea name="content" id="content"
              placeholder="내용을 입력해주세요"></textarea></td>
        </tr>
      </table>
      <input type="button" class="btn" id="back" value="취소"
        onclick="location.href='${path }/oneBoard/${boardId }'">
      <input type="submit" id="submit" class="btn" value="쓰기"
        formaction="${path }/write/write02/${boardId }/0">
    </form>
  </div>
  <script>
    
    </script>
</body>
</html>