var boardService = (function () {

    function save(board, callback, error) {

        $.ajax({
            url        : "/board/regist/",
            type       : "POST",
            data       : JSON.stringify(board),
            contentType: "application/json;charset=utf-8",
            success    : function (result) {
                alert(result);
                location.href = "/board/list";
            },
            error      : function (error) {
                console.log(error);
                alert("저장 실패!");
                location.href = "/board/list";
            }
        });
    }

    function remove(bno, callback, error) {
        $.ajax({
            url        : "/board/delete/" + bno,
            type       : "delete",
            contentType: "application/json;charset=utf-8",
            success    : function (data) {
                alert(data);
                location.href = "/board/list";
            },
            error      : function (error) {
                //alert("삭제 실패!");
                alert(JSON.stringify(error));
                //location.href = "/board";
            }
        })
    }

    function update(board, callback, error) {
        $.ajax({
            url        : "/board/update/" + board.bno,
            type       : "PUT",
            data       : JSON.stringify(board),
            contentType: "application/json; charset=utf-8"
        }).done(function () {
            alert('수정 되었습니다.');
            location.href = "/board/list";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

    return {
        save  : save,
        remove: remove,
        update: update

    };

})