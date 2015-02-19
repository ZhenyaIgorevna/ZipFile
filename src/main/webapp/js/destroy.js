function deleteAll() {
    if (checkboxCheck()) {
        return deleteOne();
    } else {
        alert(checkboxMessage);
        return false;
    }

}
function deleteOne() {
    if (confirm(confirmMessage)) {
        return true;
    } else {
        return false;
    }
}
function checkboxCheck() {
    var checkboxs = document.getElementsByName('selectedId');
    for (var i = 0; i < checkboxs.length; i++) {
        if (checkboxs[i].checked) {
            return true;
        }
    }
    return false;
}
