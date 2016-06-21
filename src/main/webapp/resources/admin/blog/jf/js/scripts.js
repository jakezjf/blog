
jQuery(document).ready(function() {

    $('#bookUpdate').submit(function(){
        var name = $(this).find('#bookName').val();
        var author = $(this).find('#bookAuthor').val();
        var time = $(this).find('#addTimeString').val();
        if(name == '') {
            flash('#bookUpdate',8,10,100);
            return false;
        }
        if(author == '') {
            flash('#bookUpdate',8,10,100);
            return false;
        }
        if(time == '') {
            flash('#bookUpdate',8,10,100);
            return false;
        }
    });



});

