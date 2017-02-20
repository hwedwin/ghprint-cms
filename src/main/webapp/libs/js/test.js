$(document).ready(function(){
    count = $("#play_list li").size();
    $("#play_list li:not(:first-child)").hide();
    $("#play_info").html($("#play_list li:first-child").find("img").attr("alt"));
    $("#play_text li:first-child").addClass("play_text");
    $("#play_info").click(function() {
        window.open($("#play_list li:first-child").attr("href"), "_blank")
    });
    $("#play_text li").click(function() {
        var a = $(this).text() - 1;
        n = a;
        if (a >= count) {
            return
        }
        $("#play_info").html($("#play_list li").eq(a).find("img").attr("alt"));
        $("#play_info").unbind().click(function() {
            window.open($("#play_list li").eq(a).attr("href"), "_blank")
        });
        $("#play_list li").filter(":visible").fadeOut(500).parent().children().eq(a).fadeIn(1000);
        $(this).addClass("play_text").siblings().removeClass("play_text")
    });

    t = setInterval("showAuto()", 6000);
    $("#play").hover(function() {
            clearInterval(t)
        },
        function() {
            t = setInterval("showAuto()", 6000)
        });

    function dynamicLoadingCss(path){
        if(!path || path.length === 0){

        }
        var head = document.getElementsByTagName('head')[0];
        var link = document.createElement('link');
        link.href = path;
        link.rel = 'stylesheet';
        link.type = 'text/css';
        head.appendChild(link);
    }

    var browser = function() {
        var u = navigator.userAgent;
        return {//“∆∂Ø÷’∂À‰Ø¿¿∆˜∞Ê±æ–≈œ¢
            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios÷’∂À
            android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1 //android÷’∂ÀªÚ’ﬂuc‰Ø¿¿∆˜
        };
    }();

    if (browser.ios || browser.android) {
        dynamicLoadingCss("css/style.css");
        $(".top-tit").css("top", "13rem");
        $(".top-tit span").css({
            fontSize: "3rem",
            lineHeight: "4rem"
        });
        $(".top-tit i").css({
            fontSize: "2.5rem",
            lineHeight: "3rem"
        });

        var zoom = $("body").width() / 1280;
        $(".shear-box").css("zoom", zoom);
        $(".shear-box h3").css("font-size", "4rem");
        $(".shear-box span").css("font-size", "3rem");
        $(".shear").css("min-height", zoom * 930);
        $("#play").css("height", zoom * 550);

        $(".case-box").css({
            width: "90%",
            height: "auto",
            paddingBottom:"10rem",
            margin: "2.2rem"
        });
        $(".download").css({
            "font-size": "4rem",
            "line-height": "6rem",
            "background-size": "4rem",
            "background-position": "1rem center",
            "padding": "0 2rem 0 6rem"
        });
        $(".case-img-").css({
            "width": "30%",
            "margin-left": "-15%",
            "border-radius": "130px"
        });
        $(".case-box h3").css({
            fontSize: "3rem",
            lineHeight: "5rem"
        });
        $(".case-box span").css({
            fontSize: "3rem",
            lineHeight: "4rem"
        });
        $(".case-box i").css({
            fontSize: "3rem",
            lineHeight: "4rem"
        });
        $(".footer").css("font-size", "3rem");

        $(".top").css("background-image","url(./img/banner1.jpg)");

        $(".mask").hide();
        $(".mask-box").hide();
        //Ω˚÷π±≥æ∞“∆∂Ø
        //var css='<style id="css">html,body {position:absolute;width:100%;height:100%;top:0;left:0;overflow:hidden}</style>';
        //$('head').append(css);
    }else{
        dynamicLoadingCss("css/style1.css");
        $(".mask").hide();
        $(".mask-box").hide();
    }
});

window.onload = function () {

    $(".mask-close").click(function(){
        $(".mask").hide();
        $(".mask-box").hide();


    })

}

var n=0;
function showAuto() {
    n = n >= (count - 1) ? 0: n + 1;
    $("#play_text li").eq(n).trigger("click")
    //log.debug('xxxxx');
};


function down(){
    $(".mask-box").show();
    $(".mask").show();



}


