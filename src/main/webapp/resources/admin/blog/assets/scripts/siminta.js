
/*====================================
 Free To Use For Personal And Commercial Usage
Author: http://binarytheme.com
 Share Us if You Like our work 
 Enjoy Our Codes For Free always.
======================================*/

$(function () {
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    ///calling side menu

    $('#side-menu').metisMenu();

    ///pace function for showing progress
/**/

    function load(time) {
        var x = new XMLHttpRequest()
        x.open('GET', "" + time, true);
   
    };

     setTimeout(function () {
        Pace.ignore(function () {
        });
    }, 4000);

    Pace.on('hide', function () {
    });
    paceOptions = {
        elements: true
    };
   

});

//Loads the correct sidebar on window load, collapses the sidebar on window resize.
$(function() {
    $(window).bind("load resize", function() {
       
    })
});
