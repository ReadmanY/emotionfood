function join() {
    var user_id = $("#user_id").val();
    var user_name = $("#user_name").val();
    var user_pw = $("#user_pw").val();
    var user_age = $("#user_age option:selected").val();
    var user_gender = $('input[name="user_gender"]:checked').val();

    var data = {
        uemail: user_id,
        uname: user_name,
        upw: user_pw,
        uage: user_age,
        ugend: user_gender,
    };

    var url = "/join";
    $.ajax({
        type: "POST", //Method 유형
        url: url,
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result) {
            if (result.resultCode == 200) {
                Swal.fire({
                    title: "작업성공",
                    icon: "success",
                }).then(function () {
                    window.location.href = "/index";
                });
            } else {
                Swal.fire({
                    title: result.message,
                    icon: "error",
                });
            }
        },
        error: function () {
            Swal.fire({
                title: "작업실패",
                icon: "error",
            });
        },
    });
}
