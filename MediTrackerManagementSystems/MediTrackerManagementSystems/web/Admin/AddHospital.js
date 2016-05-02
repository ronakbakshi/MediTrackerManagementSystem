

$(document).ready(function () {
    // Add the page method call as an onclick handler for the register button.
    $("#addhospitalBTN").click(function () {
        alert("HI");
        var name = $("#name").val();
        var hours = $("#hours").val();
        var address = $("#address").val();
        var contact = $("#contact").val();
        var city = $("#city").val();
        var state = $("#state").val();
        
        alert(name+hours+address+contact+city+state);
        var msgError = "";
        if (name == "") {
            msgError += "Enter Name <br/> ";
            $("#name").css("border-color", "red");
        }
        else
        {
            $("#name").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (hours == "") {
            msgError += "Enter Hours <br/> ";
            $("#hours").css("border-color", "red");
        }
        else
        {
            $("#hours").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (address == "") {
            msgError += "Enter address <br/> ";
            $("#address").css("border-color", "red");
        }
        else
        {
            $("#address").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (contact == "") {
            msgError += "Enter contact information <br/> ";
            $("#contact").css("border-color", "red");
        }
        else
        {
            $("#contact").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (city == "") {
            msgError += "Enter City <br/> ";
            $("#city").css("border-color", "red");
        }
        else
        {
            $("#city").css("border-color", "rgba(221, 221, 221, 1)");
        }
        if (state == "") {
            msgError += "Enter State <br/> ";
            $("#state").css("border-color", "red");
        }
        else
        {
            $("#state").css("border-color", "rgba(221, 221, 221, 1)");
        }
        
        if (msgError != "") {
            $("#messageTextDoc").html(msgError);
            $("#messageTextDoc").css("display", "block");
        } else {
            $("#messageTextDoc").css("display", "none");
            alert("before ajax call");
//                    $.get("RegisterServlet"?firstName=" + fname.toString() + "&lastName=" + lname.toString() + "&gender=" + gender.toString() + "&DOB=" + dob.toString() + "&specialization=" + specialization.toString() + "&location=" + location.toString() + "&availableTimings=" + timings.toString() + "&hospitalName=" + hName.toString() + "&email=" + email.toString() + "&password=" + password.toString(), success);
            $.ajax({
                url: 'http://localhost:8080/MediTrackerManagementSystems/AddHospitalServlet',
                data: {
                    name: name.toString(), contact:contact.toString(), hours: hours.toString(), address: address.toString(), city: city.toString(), state: state.toString()
                },
                success: function (responseText) {

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
        alert(fname + lname + gender + dob + password + email + confirmPassword)
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
            $("#messageText").css("display", "block");
        } else {
            $("#messageText").css("display", "none");
//            $.get('RegisterServlet', {
//                firstName: fname
//            }, function (responseText) {
//                alert("Registered successfully!")
//            });
            $.ajax({
                url: 'http://localhost:8080/MediTrackerManagementSystems/RegisterServlet',
                data: {
                    isUser: "1", firstName: fname.toString(), lastName: lname.toString(), gender: gender.toString(), DOB: dob.toString(), email: email.toString(), password: password.toString()
                },
                success: function (responseText) {
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