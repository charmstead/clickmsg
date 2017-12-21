function httpClient(requestype,data,url){
			
			
			var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
                 console.log("token="+token);
                 console.log("token="+header);

            // $(document).ajaxSend(function(e, xhr, options) {
            //   	xhr.setRequestHeader(header, token);
            // });

            
            // DO Ajax request
           return $.ajax({
                        type : requestype,
                        contentType : "application/json",
                        url : url,
                        data : JSON.stringify(data),
                        dataType : 'json',
                       timeout:5000,
                        success : function(result) {
                           
                            console.log(result);
                                
                        },
                        error : function(e) {
                            console.log("ERROR: ", e);
                        }

            });
            
            
         //this is an overlay with a spinner
         
}// end of function ajaxPost   
