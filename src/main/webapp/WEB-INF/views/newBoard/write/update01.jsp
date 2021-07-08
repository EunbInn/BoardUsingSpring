<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/board.css" rel="stylesheet" />
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${path}/resources/js/insertBoardItem.js"></script>
  <style>
    table {
      width: 850px;
      border-collapse: collapse;
      border: 2px solid black;
    }
    
    .category {
      width: 150px;
    }
    
    .content {
      text-align: left;
      padding: 8px;
    }
    
    tr {
      border-bottom: 2px solid black;
    }
    
    .input-box {
      width: 700px;
    }
    
    #content {
      width: 700px;
      height: 500px;
      resize: none;
    }
    
    #date {
      border: none;
      font-size: 15px;
    }
    
    #date:focus {
      outline: none;
    }
  </style>
</head>
<body>
  <div id="content-wrap">
    <form method="post">
      <table border="1px solid black">
        <tr>
          <th colspan="2">글쓰기</th>
        </tr>
        <tr>
          <th class="category">번호</th>
          <td class="content">${boardItem.id }</td>
        </tr>
        <tr>
          <th class="category">제목</th>
          <td class="content"><input type="text" name="title"
            class="input-box" id="input-title" placeholder="제목을 입력해주세요"
            value="${boardItem.title }" maxlength="50"></td>
        </tr>
        <tr>
          <th class="category">작성자</th>
          <td class="content"><input type="text" name="writer"
            class="input-box" id="input-writer" placeholder="작성자"
            value="${boardItem.writer }" maxlength="50"></td>
        </tr>
        <tr>
          <th class="category">일자</th>
          <td class="content"><input type="text" name="date"
            id="date" value="${boardItem.date }" readonly></td>
        </tr>

        <tr>
          <th class="category">내용</th>
          <td class="content"><textarea name="content" id="content"
              placeholder="내용을 입력해주세요">${boardItem.content }</textarea>
          </td>
        </tr>
      </table>
      <input type="button" class="btn" id="back" value="취소"
        onclick="location.href='${path}/oneView/${boardId }/${boardItem.id }'">
      <input type="submit" id="submit" class="btn" value="쓰기"
        formaction="${path}/write/update02/${boardId }/${boardItem.id }">
      <input type="submit" id="delete" class="btn" value="삭제"
        formaction="${path}/write/delete01/${boardId }/${boardItem.id }">
    </form>
  </div>
</body>
</html>