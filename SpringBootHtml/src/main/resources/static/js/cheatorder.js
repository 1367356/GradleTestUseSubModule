$(function() {
    $('#btSearch').click(function () {
        var orderNo = $('#orderNo').val();  
        var sortFiled = $('#sortFiled').val();
        var tbody=window.document.getElementById("tbody-result");
        $.ajax({  
            type: "post",  
            dataType: "json",  
            url: "/orderTest",
            data: {
                orderNo: orderNo,
                sortFiled: sortFiled
            },  
            success: function (msg) {    //请求成功之后的操作
//                if (msg.ret) {
                    var str = "";  
//                    var data = msg.data;
                    var data1=msg[0];
//                    for (i in data) {
                        str += "<tr>" +
                        "<td>" + data1.hotelSeq + "</td>" +
                        "<td>" + data1.hotelName + "</td>" +
                        "</tr>";  
//                    }
                    tbody.innerHTML = str;  
//                }
            },  
            error: function () {  
                alert("查询失败")  
            }  
        });  
    });  
});