///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
$(document).ready(function () {

// Add the page method call as an onclick handler for the register button.
    $("#loginBTN").click(function () {
        var email = $("#emailDoc").val();
        var password = $("#pwdDoc").val();
        alert(email + password);
        var msgError = "";
        if (email == "") {
            alert("Email is " + email + ".");
            msgError += "Enter Email ID <br/> ";
            $("#emailDoc").css("border-color", "red");
        }
        else
        {
            $("#emailDoc").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (password == "") {
            msgError += "Enter Password <br/> ";
            $("#pwdDoc").css("border-color", "red");
        }
        else
        {
            $("#pwdDoc").css("border-color", "rgba(221, 221, 221, 1)");
        }

        if (msgError != "") {
            $("#messageTextDoc").html(msgError);
            $("#messageTextDoc").css("display", "block");

        } else {
            alert("Going to servlet");
            $("#messageTextDoc").css("display", "none");

//            var url = "http://localhost:8080/MediTrackerManagementSystems/LoginServlet?email=" + email.toString() + "&password=" + password.toString();
//            request.open("GET", url, true);
//            request.onreadystatechange = displayOrder;
//            request.send(null);

            $.ajax({
                url: 'http://localhost:8080/MediTrackerManagementSystems/LoginServlet',
                //async: false,
                contentType:"text/html",
                dataType: "text",
                type: "POST",
                data: {
                    email: email.toString(), password: password.toString()
                },
                error: function (err) {
                    alert("Back from servlet with servlet");
                    alert("Error:" + err.toString());
                },
                success: function (data) {
                    alert(data.toString());
                    var result = $.trim(data);
                    var response = data.toString();
                    if (result === "Admin") {
                        window.location.href = "http://localhost:8080/MediTrackerManagementSystems/faces/Admin/AdminHome.html?email=" + email;
                    }
                    else if (result === "Doctor") {
                        window.location.href = "http://localhost:8080/MediTrackerManagementSystems/faces/Doctor/ConfirmAppointment.html?email=" + email;
                    }
                    else if (result === "User")
                    {
                        window.location.href = "http://localhost:8080/MediTrackerManagementSystems/faces/Users/UserHomeAppointmentStatus.html?email=" + email;
                    }
                    else {
                        alert(data);
                        var snd = new Audio("beep02.wav"); // buffers automatically when created
                        snd.play();
                        $("#alertUserSignUp").css("display", "block");

                        $("#alertUserSignUp").html(response);
                    }
                }
            });
//             $.ajax({
//                url : 'http://localhost:8080/MediTrackerManagementSystems/RegisterServlet',
//                data: {
//                    isUser: "0",firstName: fname.toString(), lastName: lname.toString(), gender: gender.toString(), DOB: dob.toString(), specialization: specialization.toString(), location: location.toString(), timingShifts: timings.toString() , hospitalName: hName.toString(), email: email.toString(), password: password.toString()
//                },
//                success : function(responseText){
//                    
//                    $("#alertUserSignUp").css("display", "block");
//                    $("#alertUserSignUp").css("display", "block");
//                    $("#alertUserSignUp").html(responseText)
//                }
//            });
        }
    });
});



/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//$(document).ready(function () {
//
//// Add the page method call as an onclick handler for the register button.
//    $("#loginBTN").click(function () {
//        var email = $("#email").val();
//        var password = $("#pwd").val();
//        //alert(email + password);
//        var msgError = "";
//        if (email == "") {
//            msgError += "Enter Email ID <br/> ";
//            $("#emailDoc").css("border-color", "red");
//        }
//        else
//        {
//            $("#emailDoc").css("border-color", "rgba(221, 221, 221, 1)");
//        }
//        if (password == "") {
//            msgError += "Enter Password <br/> ";
//            $("#pwdDoc").css("border-color", "red");
//        }
//        else
//        {
//            $("#pwdDoc").css("border-color", "rgba(221, 221, 221, 1)");
//        }
//
//        if (msgError != "") {
//            $("#messageTextDoc").html(msgError);
//            $("#messageTextDoc").css("display", "block");
//        } else {
//            //alert("Going to servlet");
//            $("#messageTextDoc").css("display", "none");
//
////            var url = "http://localhost:8080/MediTrackerManagementSystems/LoginServlet?email=" + email.toString() + "&password=" + password.toString();
////            request.open("GET", url, true);
////            request.onreadystatechange = displayOrder;
////            request.send(null);
//
//            $.ajax({
//                url: 'http://localhost:8080/MediTrackerManagementSystems/LoginServlet',
//                dataType: "text",
//                type: "POST",
//                data: {
//                    email: email.toString(), password: password.toString()
//                },
//                error: function (err) {
//                    alert("Error:" + err.toString());
//                },
//                success: function (data) {
//                   // alert(data.toString());
//                    var result = $.trim(data);
//                    var response = data.toString();
//                    if (result === "Admin") {
//                        window.location.href = "http://localhost:8080/MediTrackerManagementSystems/faces/Admin/AdminHome.html?email="+email;
//                    }
//                    else if (result === "Doctor") {
//                        window.location.href = "http://localhost:8080/MediTrackerManagementSystems/faces/Doctor/ConfirmAppointment.html?email="+email;
//                    }
//                    else if (result === "User")
//                    {
//                        window.location.href = "http://localhost:8080/MediTrackerManagementSystems/faces/Users/UserHomeAppointmentStatus.html?email="+email;
//                    }
//                    else {
//                        $("#alertUserSignUp").css("display", "block");
//                        
//                        $("#alertUserSignUp").html(response);
//                    }
//                }
//            });
//        }
//
//
//    });
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
//});



