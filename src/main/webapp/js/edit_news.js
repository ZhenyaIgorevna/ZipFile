$(document).ready(function () {
    var language = $("#lang").val();
    if (language == "en_EN") {
        convertDate();
    }

    $("#saveBtn").click(function () {
        var title = $("#newsTitle").val();
        var brief = $("#newsBrief").val();
        var content = $("#newsContent").val();
        var date = $("#newsDate").val();
        var validate = validateForm(title, date, brief, content, language);
        if(validate == true){
            convertDate();
        }
        return validate;
    });
});

function convertDate(){
    var date = $("#newsDate").val();
    var part = date.split('/');
    var resultDate = part[1]+"/"+part[0]+"/"+part[2];
    $("#newsDate").val(resultDate);
}