$(function(){
    $("#CheckForm").validate({
        debug:true,
        submitHandler:function(form){
            form.submit(); // 表示采用手工提交
        },
        rules:{
        	credate:{
                required:true
            },
            name:{
                required:true
            },
            age:{
                required:true,
                digits:true
            },
            phone:{
                required:true
            },
            note:{
                required:true
            },
            publisher:{
                required:true
            },
            isbn:{
                required:true
            },
            price:{
                required:true
            },
            aid:{
                required:true
            },
            country:{
                required:true
            }    
        }
    })
});