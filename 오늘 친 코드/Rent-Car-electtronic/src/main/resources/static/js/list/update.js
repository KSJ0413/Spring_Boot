

$(function(){
$(document).ready(function () {
  var fontList = ['맑은 고딕','굴림','돋움','바탕','궁서','NotoSansKR','Arial','Courier New','Verdana','Tahoma','Times New Roamn'];
        $('#summernote').summernote({
          height: 150,                 // 에디터 높이
          minHeight: null,             // 최소 높이
          maxHeight: null,             // 최대 높이
          focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
          lang: "ko-KR",					// 한글 설정
                fontNames: fontList,
                          fontNamesIgnoreCheck: fontList,
                          fontSizes: ['8','9','10','11','12','14','18','24','36'],
                          toolbar: [
                              ['font', ['fontname','fontsize','fontsizeunit']],
                              ['fontstyle', ['bold','italic','underline','strikethrough','forecolor','backcolor','superscript','subscript','clear']],
                              ['style', ['style']],
                              ['paragraph', ['paragraph','height','ul','ol']],
                              ['insert', ['table','hr','link','picture','video']],
                              ['codeview'],
                          ],
          callbacks: {	//여기 부분이 이미지를 첨부하는 부분
            onImageUpload: function (files) {
              uploadResource(files[0], this);
              console.log("files ="+files[0]);
            },
            onPaste: function (e) {
              var clipboardData = e.originalEvent.clipboardData;
              if (clipboardData && clipboardData.items && clipboardData.items.length) {
                var item = clipboardData.items[0];
                if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
                  e.preventDefault();
                }
              }
            }
          }
        });
        /**
        * 이미지 파일 업로드
        */
        function uploadResource(file, editor) {
          data = new FormData();
          data.append("file", file);
          console.log(data);
          $.ajax({
            data: data,
            type: "POST",
            url: "/uploadSummernoteImageFile",
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
          }

});