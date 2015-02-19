function validateForm(title, date, brief, content, language) {
    var isValidate = true;
    if (title.length == 0) {
        $("#error_title").html(emptyTitle);
        isValidate = false;
    } else {
        if (title.length > 100) {
            $("#error_title").html(longTitle);
            isValidate = false;
        } else {
            $("#error_title").empty();
        }
    }
    if (date.length == 0) {
        $("#error_date").html(emptyDate);
        isValidate = false;
    } else if (!validateDate(date, language)) {
        isValidate = false;
    } else {
        $("#error_date").empty();
    }
    if (brief.length == 0) {
        $("#error_brief").html(emptyBrief);
        isValidate = false;
    } else {
        var lengthBrief = brief.length + brief.split('\n').length - 1;
        if (lengthBrief > 500) {
            $("#error_brief").html(longBrief);
            isValidate = false;
        } else {
            $("#error_brief").empty();
        }
    }
    if (content.length == 0) {
        $("#error_content").html(emptyContent);
        isValidate = false;
    } else {
        var lengthContent = content.length + content.split('\n').length - 1;
        if (lengthContent > 2000) {
            $("#error_content").html(longContent);
            isValidate = false;
        } else {
            $("#error_content").empty();
        }
    }
    return isValidate;
}

function validateDate(date, language) {
    var pattern = /^(\d{2})\/(\d{2})\/\d{4}$/;
    if (date.match(pattern) == null) {
        $("#error_date").html(messagePatternDate);
        return false;
    } else {
        var part = date.split('/');
        if (language == "ru_RU") {
            var day = parseInt(part[0]);
            var month = parseInt(part[1]);
        } else {
            var day = parseInt(part[1]);
            var month = parseInt(part[0]);
        }
        var year = parseInt(part[2]);
        if (day > 31 || day == 0) {
            $("#error_date").html(messageValidateDay);
            return false;
        }
        if (month > 12 || month == 0) {
            $("#error_date").html(messageValidateMonth);
            return false;
        }
        if (year > 2100 || year < 1900) {
            $("#error_date").html(messageValidateYear);
            return false;
        }

        if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            $("#error_date").html(messageValidateDay);
            return false;
        } else if (month == 2) {
            if (year % 4 == 0) {
                if (day > 29) {
                    $("#error_date").html(messageValidateDay);
                    return false;
                }
            } else {
                if (day > 28) {
                    $("#error_date").html(messageValidateDay);
                    return false;
                }
            }
        }
        return true;
    }
}

