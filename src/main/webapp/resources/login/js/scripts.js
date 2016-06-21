
jQuery(document).ready(function() {

    $('#form').submit(function(){
        var id = $(this).find('#userId').val();
        var password = $(this).find('#userPassword').val();
        var captcha = $(this).find('.captcha').val();
        if(id == '') {
            flash('#form',8,10,100);
            return false;
        }
        if(password == '') {
            flash('#form',8,10,100);
            return false;
        }
        if(captcha == '') {
            flash('#form',8,10,100);
            return false;
        }
    });


    $('#form1').submit(function(){
        var id = $(this).find('#id1').val();
        var password = $(this).find('#password1').val();
        var name = $(this).find('#name1').val();
        if(id == '') {
            flash('#form1',8,10,100);
            return false;
        }
        if(password == '') {
            flash('#form1',8,10,100);
            return false;
        }
        if(name == '') {
            flash('#form1',8,10,100);
            return false;
        }
    });

    $('#forget').submit(function(){
        var id = $(this).find('#userId').val();
        var name = $(this).find('#userName').val();
        var password = $(this).find('#userPassword').val();
        if(id == '') {
            flash('#forget',8,10,100);
            return false;
        }
        if(name == '') {
            flash('#forget',8,10,100);
            return false;
        }
        if(password == '') {
            flash('#forget',8,10,100);
            return false;
        }
        insert();
    });

});
