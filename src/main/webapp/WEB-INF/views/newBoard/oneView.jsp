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
<link href="${path}/resources/css/oneView.css" rel="stylesheet" />
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${path}/resources/js/oneView.js"></script>
</head>
<body>
  <div id="content-wrap">
    <form method="post">
      <table id="main-table">
        <tr>
          <th colspan="2">게 시 글</th>
        </tr>
        <tr>
          <th class="category">번호</th>
          <td class="content"><input type="text" name="id" id="id"
            value="${boardItem.id }"
            style="border: none; font-size: 15px;" readonly></td>
        </tr>
        <tr>
          <th class="category">제목</th>
          <td class="content">${boardItem.title }</td>
        </tr>
        <tr>
          <th class="category">작성자</th>
          <td class="content">${boardItem.writer }</td>
        </tr>
        <tr>
          <th class="category">일자</th>
          <td class="content">${boardItem.date }</td>
        </tr>

        <tr>
          <th class="category">내용</th>
          <td class="content">${boardItem.content }</td>
        </tr>
      </table>
      <input type="button" value="목록으로" class="btn" id="back" onclick="location.href='${path }/oneBoard/${boardId}'">
      <button class="btn" id="update"
        formaction="${path }/write/update01/${boardId }/${boardItem.id }">수정</button>
    </form>
    <div id="comment-box">
      <form method="post">
        <table id="comment-table">
          <tr>
            <th rowspan="2" class="comment-title">댓글</th>
            <td style="text-align: left; padding: 5px 15px;"><span>작성자</span>
              <input type="text" name="writer" id="writer" placeholder="작성자"></td>
            <td rowspan="2">
              <button class="commentBtn" id="input-comment"
                formaction="${path }/write/write02/${boardId }/${boardItem.id }">작성</button>
            </td>
          </tr>
          <tr>
            <td><textarea name="content" id="comment"
                placeholder="내용을 입력해주세요"></textarea></td>
          </tr>
          <!-- 반복문 돌려야함  -->
          <c:choose>
            <c:when test="${boardItems.size() == 0 }">
            </c:when>
            <c:otherwise>
              <c:forEach var="comment" items="${comments }"
                varStatus="status">
                <tr class='view-comment'>
                  <th>${comment.writer }<br> 
                  <span class='comment-date'> ${comment.date }</span>
                  </th>
                  <td>${comment.content }<br>
                  </td>
                </tr>
              </c:forEach>
            </c:otherwise>
          </c:choose>
        </table>
      </form>
    </div>
  </div>
</body>
</html>