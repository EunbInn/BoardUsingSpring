function filter(str) {
	var filter = /^[가-힣ㄱ-ㅎa-zA-Z0-9]{2,}$/;
	if (filter.test(str)) {
		return true;
	} else {
		return false;
	}
}

$(function() {
	$('#input-comment').click(function() {
		var writer = $('#writer').val();
		var comment = $('#comment').val();

		if ($.trim(writer) == "") {
			alert('작성자를 입력해주세요');
			return false;
		}

		if (!filter(writer)) {
			alert('작성자 명은 공백 없이 한글, 숫자, 영문 2자리 이상 작성해주세요');
			return false;
		}

		if ($.trim(comment) == "") {
			alert('내용을 입력해주세요');
			return false;
		}

		if ($.trim(comment) != "" && $.trim(writer) != "" && filter(writer)) {
			return true;
		}
	});
});