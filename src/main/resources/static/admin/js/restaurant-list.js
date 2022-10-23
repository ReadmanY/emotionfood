$(function () {
    $("#jqGrid").jqGrid({
        url: "/admin/restaurants/list",
        datatype: "json",
        colModel: [
            { label: "id", name: "eid", index: "eid", width: 60, key: true },
            { label: "time", name: "etime", index: "etime", width: 120 },
            { label: "emotion", name: "eemote", index: "eemote", width: 120 },
            { label: "locate_x", name: "elocate_x", index: "elocate_x", width: 120 },
            { label: "locate_y", name: "elocate_y", index: "elocate_y", width: 120 },
            { label: "email", name: "uemail", index: "uemail", width: 120 },
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
