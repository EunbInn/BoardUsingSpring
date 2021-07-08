 $(function() {
        $('#submit').click(function() {
          var title = $('#input-title').val();

          if ($.trim(title) == "") {
            alert('게시판 이름을 입력해주세요');
            return false;
          } else {
            return true;
          }
        })
      })