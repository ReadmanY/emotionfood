function login() {
    var loginName = $("#user_id").val();
    var password = $("#user_pw").val();

    //인증
    var params = $("#loginForm").serialize();
    var url = "/login";
    $.ajax({
        type: "POST", //메소드 유형
        url: url,
        data: params,
        success: function (result) {
            if (result.resultCode == 200) {
                window.location.href = "/user/index";
            } else {
                Swal.fire(result.message, {
                    icon: "error",
                });
            }
        },
        error: function () {
            Swal.fire("작업 실패", {
                icon: "error",
            });
        },
    });
}
