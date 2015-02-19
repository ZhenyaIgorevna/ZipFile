$(document).ready(function () {
    alert("Doc ready");
    $(".Expand").click(function () {
        if($(this).parent().hasClass('ExpandOpen')){
            $(this).parent().removeClass("ExpandOpen");
             $(this).parent().addClass("ExpandClosed");
        }else{
            $(this).parent().removeClass("ExpandClosed");
            $(this).parent().addClass("ExpandOpen");
        }
    });
    $("textarea").autosize();

});