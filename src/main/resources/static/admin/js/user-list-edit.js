function submit() {
    var user_id = $("#user_id").val();
    var user_name = $("#user_name").val();
    var user_pw = $("#user_pw").val();
    var user_age = $("#user_age").val();
    var user_gender = $('input[name="user_gender"]:checked').val();
    var user_joindate = $("user_joindate").val();

    var data = {
        uemail: user_id,
        uname: user_name,
        upw: user_pw,
        uage: user_age,
        ugend: user_gender,
        ujoindate: user_joindate,
    };

    var url = "/admin/users/update";
    $.ajax({
        type: "POST", //Method 유형
        url: url,
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result) {
            if (result.resultCode == 200) {
                Swal.fire("작업성공", {
                    icon: "success",
                });
                reload();
            } else {
                Swal.fire(result.message, {
                    icon: "error",
                });
            }
        },
        error: function () {
            Swal.fire("작업실패", {
                icon: "error",
            });
        },
    });
}

function cancel() {
    window.location.href = "/admin/users";
}
