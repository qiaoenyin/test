function check(t, oper) {
	var data_tr = $(t).parent().parent();
	if (oper == "MoveUp") {
		if ($(data_tr).prev().html() == null) {
			alert("已经是最顶部了!");
			return;
		}
		{
			$(data_tr).insertBefore($(data_tr).prev());
		}
	} else {
		if ($(data_tr).next().html() == null) {
			alert("已经是最低部了!");
			return;
		}
		{
			$(data_tr).insertAfter($(data_tr).next());
		}
	}
}