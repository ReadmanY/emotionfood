$(function () {
    $("#jqGrid").jqGrid({
        url: "/admin/restaurants/list",
        datatype: "json",
        colModel: [
            { label: "kid", name: "kid", index: "kid", width: 60 },
            { label: "rid", name: "rid", index: "rid", width: 60, key: true },
            { label: "rname", name: "rname", index: "rname", width: 120 },
            { label: "rcate", name: "rcate", index: "rcate", width: 120 },
            { label: "raddr", name: "raddr", index: "raddr", width: 120 },
            { label: "raddr_gu", name: "raddrGu", index: "raddrGu", width: 120 },
            { label: "rphone", name: "rphone", index: "rphone", width: 120 },
            { label: "rlocate_x", name: "rlocateX", index: "rlocateX", width: 120 },
            { label: "rlocate_y", name: "rlocateY", index: "rlocateY", width: 120 },
            { label: "krate", name: "krate", index: "krate", width: 120 },
            { label: "kcount_rate", name: "kcountRate", index: "kcountRate", width: 120 },
            { label: "kcount_blog", name: "kcountBlog", index: "kcountBlog", width: 120 },
            { label: "kkeyword", name: "kkeyword", index: "kkeyword", width: 120 },
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

function detailRestaurant() {
    var id = getSelectedRow();
    if (id == null) {
        return;
    }
    window.location.href = "/admin/restaurants/info/" + id;
}

function editRestaurant() {
    var id = getSelectedRow();
    if (id == null) {
        return;
    }
    window.location.href = "/admin/restaurants/edit/" + id;
}

function deleteRestaurant() {
    var id = getSelectedRows();
    if (id == null) {
        return;
    }
    Swal.fire({
        title: "식당 삭제",
        text: "식당을 정말 삭제하시겠습니까?",
        icon: "warning",
        showDenyButton: true,
        confirmButtonText: "Yes",
        denyButtonText: "No",
        dangerMode: true,
    }).then((flag) => {
        if (flag.isConfirmed) {
            $.ajax({
                type: "POST",
                url: "/admin/restaurants/delete",
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
