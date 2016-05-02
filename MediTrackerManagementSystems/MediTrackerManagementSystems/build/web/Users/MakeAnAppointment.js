/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

// Add the page method call as an onclick handler for the register button.
    $("#appointmentBTN").click(function () {
        var name = $("#name").val();
        var number = $("#contactNumber").val();
        var email = $("#email").val();
        var address = $("#address").val();
        var docName = $("#docName").val();
        var appDate = $("#datepicker").val();
        var appTime = $("#timepicker").val();
        var hName = $("#hospitalName").val();
        alert(name + number + email + address + docName + appDate + appTime+ hName);
        var msgError = "";
        if (name == "") {
            msgError += "Enter Name <br/> ";
            $("#name").css("border-color", "red");
        }
        else
        {
            $("#name").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (number == "") {
            msgError += "Enter contact nnumber ID <br/> ";
            $("#contactNumber").css("border-color", "red");
        }
        else
        {
            $("#contactNumber").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (email == "") {
            msgError += "Enter Email ID <br/> ";
            $("#email").css("border-color", "red");
        }
        else
        {
            $("#email").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (address == "") {
            msgError += "Enter Address <br/> ";
            $("#address").css("border-color", "red");
        }
        else
        {
            $("#address").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (hName == "") {
            msgError += "Enter Hospital's Name <br/> ";
            $("#hospitalName").css("border-color", "red");
        }
        else
        {
            $("#hospitalName").css("border-color", "rgba(221, 221, 221, 1)");
        }

        if (docName == "") {
            msgError += "Enter Doctor's Name <br/> ";
            $("#docName").css("border-color", "red");
        }
        else
        {
            $("#docName").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (appDate == "") {
            msgError += "Enter Appointment Date <br/> ";
            $("#datepicker").css("border-color", "red");
        }
        else
        {
            $("#datepicker").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (appTime == "") {
            msgError += "Enter Appointment Time <br/> ";
            $("#timepicker").css("border-color", "red");
        }
        else
        {
            $("#timepicker").css("border-color", "rgba(221, 221, 221, 1)");
        }

        if (msgError != "") {
            //alert("Nothing")
            //$("#messageTextDoc").html(msgError);
            $("#messageTextDoc").css("display", "block");
        } else {
            //alert("Going to servlet");
            $("#messageTextDoc").css("display", "none");

            $.ajax({
                url: 'http://localhost:8080/MediTrackerManagementSystems/MakeAnAppointmentServlet',
                dataType: "text",
                type: "POST",
                data: {
                    email: email.toString(), name: name.toString(), number: number.toString(), address: address.toString(), hName: hName.toString(), docName: docName.toString(), appDate: appDate.toString(), appTime: appTime.toString()
                },
                error: function (err) {
                    alert("Error:" + err.toString());
                },
                success: function (data) {
                    alert(data.toString());
                    var result = $.trim(data);
                    var response = data.toString();

                    $("#alertUserSignUp").css("display", "block");

                    $("#alertUserSignUp").html(response);

                }
            });
        }


    });
//    function displayOrder() {
//        if (request.readyState === 4 && request.status === 200) {
//            alert(request.responseText);
//            var result = $.trim(request.responseText);
//            if (result ===   "Admin") {
//                window.location.href = "../Admin/AdminHome";
//            }
//            if (result === "Doctor") {
//                window.location.href = "../Doctor/ConfirmAppointment.html";
//            }
//            if (result === "User")
//            {
//                alert("inside");
//                window.location.href = "../User/UserHomeAppointmentStatus.html";
//            }
//            else {
//                $("#alertUserSignUp").css("display", "block");
//                $("#alertUserSignUp").css("display", "block");
//                $("#alertUserSignUp").html(request.responseText);
//            }
//        }
//    }
});





