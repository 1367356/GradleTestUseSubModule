$(function () {
    $('#btSearch').click(function () {  
        var checkDate = $('#checkDate').val();  
        var orderNo = $('#orderNo').val();  
//        var sortFiled = $('#sortFiled').val();
//        var hotelSeq = $('#hotelSeq').val();
        var tbody=window.document.getElementById("tbody-result");  
  
        $.ajax({  
            type: "post",  
            dataType: "json",  
            url: "orderTest",
            data: {  
//                hotelSeq: hotelSeq,
                orderNo: orderNo,  
//                sortFiled: sortFiled,
                checkDate: checkDate  
            },  
            success: function (msg) {  
                if (msg.ret) {  
                    var str = "";  
                    var data = msg.data;  
  
                    for (i in data) {  
                        str += "<tr>" +  
                        "<td>" + data[i].hotel_seq + "</td>" +  
                        "<td>" + data[i].hotel_name + "</td>" +  
//                        "<td>" + data[i].order_no + "</td>" +
//                        "<td>" + data[i].user_phone + "</td>" +
//                        "<td>" + data[i].create_time + "</td>" +
//                        "<td>" + data[i].user_id + "</td>" +
//                        "<td>" + data[i].cellid + "</td>" +
//                        "<td>" + data[i].gps_city + "</td>" +
//                        "<td>" + data[i].cell_city + "</td>" +
//                        "<td>" + data[i].distance + "</td>" +
                        "</tr>";  
                    }  
                    tbody.innerHTML = str;  
                }  
            },  
            error: function () {  
                alert("查询失败")  
            }  
        });  
    });  
});