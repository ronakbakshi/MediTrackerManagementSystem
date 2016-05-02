/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

// Add the page method call as an onclick handler for the register button.
//    $("#loginBTN").click(function () {

    $(function () {
        var getUrlParameter = function getUrlParameter(sParam) {
            var sPageURL = decodeURIComponent(window.location.search.substring(1)),
                    sURLVariables = sPageURL.split('&'),
                    sParameterName,
                    i;
            for (i = 0; i < sURLVariables.length; i++) {
                sParameterName = sURLVariables[i].split('=');
                if (sParameterName[0] === sParam) {
                    return sParameterName[1] === undefined ? true : sParameterName[1];
                }
            }
        };

        var email = getUrlParameter('email');

        //alert(email);
        var msgError = "";

        //alert("Going to servlet");
        $("#messageTextDoc").css("display", "none");
//            var url = "http://localhost:8080/MediTrackerManagementSystems/LoginServlet?email=" + email.toString() + "&password=" + password.toString();
//            request.open("GET", url, true);
//            request.onreadystatechange = displayOrder;
//            request.send(null);

        $.ajax({
            url: 'http://localhost:8080/MediTrackerManagementSystems/AppointmentHistoryServlet',
            dataType: "json",
            type: "POST",
            data: {
                email: email.toString()
            },
            error: function (err) {
                alert("Error:" + err.toString());
            },
            success: function (data) {
                //alert("Success:" + data.toString());
                //   var result = $.trim(data);

                $("divAppointments").empty();
             
                $.each(data,
                        function () {
                            $('#divAppointments').append("<div class=\"col-sm-3\" style=\"background-color:lavender\">" + this.doctorName + "</div>"
                                    + "<div class=\"col-sm-3\" style=\"background-color:lavender\">" + this.hospitalName + "</div>"
                                   + "<div class=\"col-sm-2\" style=\"background-color:lavender\">" + this.appDate + "</div>"      
                                   + "<div class=\"col-sm-2\" style=\"background-color:lavender\">" + this.appTime + "</div>"
                                   + "<div class=\"col-sm-2\" style=\"background-color:lavender\">" + this.status + "</div>"
                                    );
                        });

//               $.each(data,function(index,appoint){
//                    $("divAppointments").append(
//                               "<div class=\"col-sm-3\" style=\"background-color:lavender\">" + appoint + "</div>"
////                <div class="col-sm-3" style="background-color:lavender;">St. Francis Hospital and Health Services</div>
////                <div class="col-sm-2" style="background-color:lavender;">04/30/2016</div>
////                <div class="col-sm-2" style="background-color:lavender;">12:30</div>
////                <div class="col-sm-2" style="background-color:lavender;">Waiting for approval</div>
//
//                            );
                //});
            }
        });


    });
});

