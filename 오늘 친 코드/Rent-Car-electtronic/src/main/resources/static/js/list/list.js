$(function(){

  $.ajax({
            data: data,
            type: "POST",
            url: "https://naveropenapi.apigw.ntruss.com/recog/v1/stt",
            contentType: false,
            processData: false,
            success: function (data) {
              console.log(data);
              //항상 업로드된 파일의 url이 있어야 한다.
              $('#summernote').summernote('insertImage', data.url);
            },
            error: function () {
              alert("에러입니다");
            }
          });

});