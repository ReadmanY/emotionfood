$(function () {
    $("#jqGrid").jqGrid({
        url: "/admin/users/list",
        datatype: "json",
        colModel: [
            { label: "e-mail", name: "uemail", index: "uemail", width: 120, key: true },
            { label: "name", name: "uname", index: "uname", width: 120 },
            { label: "pw", name: "upw", index: "upw", width: 120 },
            { label: "gender", name: "ugend", index: "ugend", width: 60 },
            { label: "age", name: "uage", index: "uage", width: 60 },
            { label: "join date", name: "ujoindate", index: "ujoindate", width: 180 },
        ],
        height: 760,
        rowNum: 20,
        rowList: [20, 50, 80],
        styleUI: "Bootstrap",
        loadtext: "DB 불러오는 중",
        rownumbers: false,
        rownumWidth: 20,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount",
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order",
        },
        gridComplete: function () {
            //하단 가로 스크롤바
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x": "hidden" });
        },
    });

    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });
});

// jqGrid reload(페이지를 받고 그리드 다시 호출)
function reload() {
    initFlatPickr();
    var page = $("#jqGrid").jqGrid("getGridParam", "page");
    $("#jqGrid")
        .jqGrid("setGridParam", {
            page: page,
        })
        .trigger("reloadGrid");
}

function editUser() {
    var id = getSelectedRow();
    if (id == null) {
        return;
    }
    window.location.href = "/admin/users/edit/" + id;
}

function deleteUser() {
    var id = getSelectedRows();
    if (id == null) {
        return;
    }
    Swal.fire({
        title: "사용자 삭제",
        text: "사용자를 정말 삭제하시겠습니까?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((flag) => {
        if (flag) {
            $.ajax({
                type: "POST",
                url: "/admin/users/delete",
                contentType: "application/json",
                data: JSON.stringify(id),
                success: function (r) {
                    if (r.resultCode == 200) {
                        Swal.fire("삭제성공", {
                            icon: "success",
                        });
                        $("#jqGrid").trigger("reloadGrid");
                    } else {
                        Swal.fire(r.message, {
                            icon: "error",
                        });
                    }
                },
            });
        }
    });
}