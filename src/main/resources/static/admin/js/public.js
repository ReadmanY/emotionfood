// jqGrid로 선택한 데이터 호출
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        Swal.fire("데이터를 선택해주세요", {
            icon: "warning",
        });
        return;
    }
    var selectedIDs = grid.getGridParam("selarrrow");
    if (selectedIDs.length > 1) {
        Swal.fire("하나 이상의 데이터를 선택할 수 없습니다", {
            icon: "warning",
        });
        return;
    }
    return selectedIDs[0];
}

// jqGrid로 선택한 여러개의 데이터 호출
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        Swal.fire("데이터를 선택해주세요", {
            icon: "warning",
        });
        return;
    }
    return grid.getGridParam("selarrrow");
}
