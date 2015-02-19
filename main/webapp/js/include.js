function validate() {
    var from = document.getElementById("from").value;
    var size = document.getElementById("size").value;
    if ( size == "") {
        alert("You not enter from which you want begin or size.");
        return false;
    }
    if (!isNaN(from)) {
        if (parseInt(from) < 0 || parseInt(from) >= 10000) {
            alert("You enter incorrect value from which you want begin. You can begin from 0-10 000");
            return false;
        }
    } else {
        alert("You enter not a number in field 'from'");
        return false;
    }
    if (!isNaN(size)) {
        if (parseInt(size) < 0 || parseInt(size) >= 500) {
            alert("You enter incorrect or very big size. You can get 1-500 employees.");
            return false;
        }
    } else {
        alert("You enter not a number in field 'size'");
        return false;
    }


    if (parseInt(size) + parseInt(from) > 10000) {
        alert("You enter incorrect size or begin. No such many employees.");
        return false;
    }
    return true;
}

$(document).ready(function () {

    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.scrollup').fadeIn();
        } else {
            $('.scrollup').fadeOut();
        }
    });

    $('.scrollup').click(function () {
        $("html, body").animate({ scrollTop: 0 }, 600);
        return false;
    });

});