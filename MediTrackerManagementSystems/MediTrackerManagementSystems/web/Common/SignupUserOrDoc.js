

$(document).ready(function () {
    // Add the page method call as an onclick handler for the register button.
    $("#registerBTNDoctor").click(function () {
        var fname = $("#fNameDoc").val();
        var lname = $("#lNameDoc").val();
        var gender = $('input:radio[name=genderDoc]:checked').val();
        var dob = $("#dobDoc").val();
        var specialization = $("#specialization").val();
        var location = $("#location").val();
        var timings = $('input:radio[name=timings]:checked').val();
        var hName = $("#hName").val();
        var email = $("#emailDoc").val();
        var password = $("#pwdDoc").val();
        var cpwd = $("#cpwdDoc").val();
        //alert(timings)
        var msgError = "";
        if (fname == "") {
            msgError += "Enter First Name <br/> ";
            $("#fNameDoc").css("border-color", "red");
        }
        else
        {
            $("#fNameDoc").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (lname == "") {
            msgError += "Enter Last Name <br/> ";
            $("#lNameDoc").css("border-color", "red");
        }
        else
        {
            $("#lNameDoc").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (dob == "") {
            msgError += "Enter Date of Birth <br/> ";
            $("#dobDoc").css("border-color", "red");
        }
        else
        {
            $("#dobDoc").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (specialization == "") {
            msgError += "Enter Specialization <br/> ";
            $("#specialization").css("border-color", "red");
        }
        else
        {
            $("#specialization").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (location == "") {
            msgError += "Enter Location <br/> ";
            $("#location").css("border-color", "red");
        }
        else
        {
            $("#location").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (hName == "") {
            msgError += "Enter Hospital Name <br/> ";
            $("#hName").css("border-color", "red");
        }
        else
        {
            $("#hName").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (email == "") {
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
        if (cpwd == "") {
            msgError += "Enter Confirm password <br/> ";
            $("#cpwdDoc").css("border-color", "red");
        }
        else
        {
            $("#cpwdDoc").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (password != "") {
            if (cpwd != "") {
                if (password != cpwd) {
                    msgError += "Password and confirm password should be same <br/>";
                    $("#cpwdDoc").css("border-color", "red");
                }
                else {
                    $("#cpwdDoc").css("border-color", "rgba(221, 221, 221, 1)");
                }
            }
        }

        if (msgError != "") {
            $("#messageTextDoc").html(msgError);
            //$("#messageTextDoc").css("display", "block");
        } else {
            $("#messageTextDoc").css("display", "none");
            //alert("before ajax call");
//                    $.get("RegisterServlet"?firstName=" + fname.toString() + "&lastName=" + lname.toString() + "&gender=" + gender.toString() + "&DOB=" + dob.toString() + "&specialization=" + specialization.toString() + "&location=" + location.toString() + "&availableTimings=" + timings.toString() + "&hospitalName=" + hName.toString() + "&email=" + email.toString() + "&password=" + password.toString(), success);
            $.ajax({
                url : 'http://localhost:8080/MediTrackerManagementSystems/RegisterServlet',
                data: {
                    isUser: "0",firstName: fname.toString(), lastName: lname.toString(), gender: gender.toString(), DOB: dob.toString(), specialization: specialization.toString(), location: location.toString(), timingShifts: timings.toString() , hospitalName: hName.toString(), email: email.toString(), password: password.toString()
                },
                success : function(responseText){
                    
                    $("#alertUserSignUp").css("display", "block");
                    $("#alertUserSignUp").css("display", "block");
                    $("#alertUserSignUp").html(responseText)
                }
            });

        }

    });
    $("#registerBTNUser").click(function () {
        var fname = $("#fName").val();
        var lname = $("#lName").val();
        var gender = $('input:radio[name=gender]:checked').val();
        var dob = $("#dob").val();
        var email = $("#email").val();
        var password = $("#pwd").val();
        var confirmPassword = $("#cpwd").val();
        //alert(fname + lname + gender + dob + password + email + confirmPassword)
        var msgError = "";
        if (fname == "") {
            msgError += "Enter First Name <br/> ";
            $("#fName").css("border-color", "red");
        }
        else
        {
            $("#fName").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (lname == "") {
            msgError += "Enter Last Name <br/> ";
            $("#lName").css("border-color", "red");
        }
        else
        {
            $("#lName").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (dob == "") {
            msgError += "Enter Date of Birth <br/> ";
            $("#dob").css("border-color", "red");
        }
        else
        {
            $("#dob").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (email == "") {
            msgError += "Enter Email ID <br/> ";
            $("#email").css("border-color", "red");
        }
        else
        {
            $("#email").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (password == "") {
            msgError += "Enter Password<br/> ";
            $("#pwd").css("border-color", "red");
        }
        else
        {
            $("#pwd").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (confirmPassword == "") {
            msgError += "Enter Confirm Password <br/> ";
            $("#cpwd").css("border-color", "red");
        }
        else
        {
            $("#cpwd").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (password != "") {
            if (confirmPassword != "") {

                if (password != confirmPassword) {
                    msgError += "Password and confirm password should be same <br/>";
                    $("#cpwd").css("border-color", "red");
                }
                else {
                    $("#cpwd").css("border-color", "rgba(221, 221, 221, 1)");
                }
            }
        }

        if (msgError != "") {
            $("#messageText").html(msgError);
            //$("#messageText").css("display", "block");
        } else {
            $("#messageText").css("display", "none");
//            $.get('RegisterServlet', {
//                firstName: fname
//            }, function (responseText) {
//                alert("Registered successfully!")
//            });
            $.ajax({
                url : 'http://localhost:8080/MediTrackerManagementSystems/RegisterServlet',
                data: {
                    isUser: "1",firstName: fname.toString(), lastName: lname.toString(), gender: gender.toString(), DOB: dob.toString(), email: email.toString(), password: password.toString()
                },
                success : function(responseText){
                    $("#alertUserSignUp").css("display", "block");
                    $("#alertUserSignUp").html(responseText)
                }
            });

//            $.ajax({
//                url: "",
//                dataType: "text",
//                type: "POST",
//                data: {firstName: fname.toString(), lastName: lname.toString(), gender: gender.toString(), DOB: dob.toString(), password: password.toString()},
//                error: function (err) {
//                    alert("Error:" + err.toString());
//                },
//                success: function (data) {
//                    // Replace the div's content with the page method's return.
//                    alert("success:" + data.val + data);
//                    $("#messageText").css("display", "block");
//                    $("#messageText").html("Successfully sign up!");
//                }
//            });
        }
    });
});