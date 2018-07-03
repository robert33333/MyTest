function myFuncGet() {
    $.ajax({
        url:"http://localhost:8081/MyTest/dbController",
        type: "GET",
        data: {
            pk: $("#inputGET").val(),
            type: "get"
        },
        dataType: "text",
        success: function (result) {
            console.log(result);

            toast(result);
        }
    });
}

function myFuncUpdate() {
    $.ajax({
        url:"http://localhost:8081/MyTest/dbController",
        type: "GET",
        data: {
            pk: $("#inputUPDATE").val(),
            value: $("#inputUpdateValue").val(),
            type: "update"
        },
        dataType: "text",
        success: function (result) {
            console.log(result);

            toast(result);
        }
    });
}

function myFuncInsert() {
    $.ajax({
        url:"http://localhost:8081/MyTest/dbController",
        type: "GET",
        data: {
            pk: $("#inputINSERT").val(),
            value: $("#inputInsertValue").val(),
            type: "insert"
        },
        dataType: "text",
        success: function (result) {
            console.log(result);

            toast(result);
        }
    });
}

function myFuncDelete() {
    $.ajax({
        url:"http://localhost:8081/MyTest/dbController",
        type: "GET",
        data: {
            pk: $("#inputDELETE").val(),
            type: "delete"
        },
        dataType: "text",
        success: function (result) {
            console.log(result);

            toast(result);
        }
    });
}

function toast(result) {
    var x = document.getElementById("snackbar");
    x.className = "show";
    x.innerText = result;
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}
