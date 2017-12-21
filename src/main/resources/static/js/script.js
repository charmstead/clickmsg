$("input[name=cta], input[name=name], input[name=message_title], input[name=msg_body], input[name=image_url], input[name=link_btn_url], input[name=link_btn_text], input[name=reply2], input[name=reply1] ").on('change keyup paste', function (event) {
    console.log($(this).val());

    var value = $(this).val();
    var name = $(this).attr("name");
    
    switch(name){

        case "name":
            JsonMessage.name=value;
            break;
        case "cta":
            $("#cta").text(value);
            JsonMessage.message.attachment.payload.elements[0]["title"]=value;
            break;
        case "message_title":
             JsonMessage.message.attachment.payload.elements[0]["buttons"][1].title=value;
            $("#message_title").text(value);
            break;
        case "msg_body":
              JsonMessage.message.attachment.payload.elements[0]["subtitle"]=value;
            $("#msg_body").text(value);
            break;
        case "image_url":
            $("#image_url").attr("src",value);
            JsonMessage.message.attachment.payload.elements[0]["image_url"]=value;
            break;
        case "link_btn_url":
            JsonMessage.message.attachment.payload.elements[0]["buttons"]["url"]=value;
            $("#link_btn").attr("href",value);
            break;
        case "link_btn_text":
            JsonMessage.message.attachment.payload.elements[0]["buttons"][0].title=value;
            $("#link_btn").text(value);
            break;
        case "reply1":
            $("#reply1").text(value);
            JsonMessage.message.quick_replies.push(value);
            break;
        case "reply2":
            $("#reply2").text(value);
            JsonMessage.message.quick_replies.push(value);
            break;

    }
    JsonMessage.id=$('input[name=id]').val();
    console.log(JSON.stringify(JsonMessage));
});



$("#messageForm").submit(function(event){

    var has_empty = false;

    $(this).find( 'input[type = text]' ).each(function () {
        
        if ( ! $(this).val() ) { has_empty = true; return false; }
    });
        
    if ( has_empty ) { 
        event.preventDefault();
        console.log("voila......d....");
        return false;
    }
    else{
        event.preventDefault();
        $('#msg_submit').prop("disabled","disable");

        var target = $('#msg_submit');
        var spinner = new Spinner().spin();
        target.append(spinner.el);

        console.log("voila..........");

        var url = window.location.origin+"/create_message";
        
        httpClient('POST',JsonMessage,url).done(function(){
               
               $('#warning').text('Successfully saved message');
               
               $('#warning').css({"color":"#00C853","visibility":"visible"});
               
        
            }).fail(function(){
                 
                
               $('#warning').text('The was an error saving your message');
               
               $('#warning').css({"color":"#00C853","visibility":"visible"});  
        
            }).always(function(){
                spinner.stop();     
                $("#msg_submit").removeAttr("disabled");
                
                setTimeout(function (){
    
                    $('#warning').css({"color":"#00C853","visibility":"hidden"});
                
                },5000);
                
            });


    }
    

});

function getJson(){
    return JsonMessage;
    //document.execCommand("Copy");
   // alert("Copied the text: " + copyText.value);

}

$("#copy_json").click(function(){

    

});
