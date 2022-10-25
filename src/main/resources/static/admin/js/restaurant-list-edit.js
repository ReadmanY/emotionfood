function submit() {
    var rid = $("#rid").val();
    var rname = $("#rname").val();
    var rcate = $("#rcate").val();
    var raddr = $("#raddr").val();
    var raddr_gu = $("#raddr_gu").val();
    var rphone = $("#rphone").val();
    var rlocate_x = $("#rlocate_x").val();
    var rlocate_y = $("#rlocate_y").val();
    var kid = $("#kid").val();

    var data = {
        rid: rid,
        rname: rname,
        rcate: rcate,
        raddr: raddr,
        raddr_gu: raddr_gu,
        rphone: rphone,
        rlocate_x: rlocate_x,
        rlocate_y: rlocate_y,
        kid: kid,
    };

    var url = "/admin/restaurants/update";
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
    window.location.href = "/admin/restaurants";
}
