
 $(document).ready(function () {
  var fontList = ['맑은 고딕','굴림','돋움','바탕','궁서','NotoSansKR','Arial','Courier New','Verdana','Tahoma','Times New Roamn'];
        $('#summernote').summernote({
          height: 1000,                 // 에디터 높이
          width: 1200,                  // 에디터 넓이
          minHeight: null,             // 최소 높이
          maxHeight: null,             // 최대 높이
          focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
          lang: "ko-KR",					// 한글 설정
          placeholder:'이쁘게 맛집을 소개해주세요',
                fontNames: fontList,
                          fontNamesIgnoreCheck: fontList,
                          fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
                          toolbar: [
                              ['font', ['fontname','fontsize','fontsizeunit']],
                              ['fontstyle', ['bold','italic','underline','strikethrough','forecolor','backcolor','superscript','subscript','clear']],
                              ['style', ['style']],
                              ['paragraph', ['paragraph','height','ul','ol']],
                              ['insert', ['table','hr','link','picture','video']],
                              ['codeview'],
                          ],
          callbacks: {	//여기 부분이 이미지를 첨부하는 부분
            onImageUpload: function (file) {
              uploadResource(file[0], this);
              console.log("file ="+file[0]);
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
            url: "/list/resource",
            contentType: false,
            processData: false,
            success: function (data) {
              //항상 업로드된 파일의 url이 있어야 한다.
              console.log("data = "+data)
              console.log("datakey = "+data.key)
              $('#summernote').summernote('insertImage', data.path);
              console.log("data.path = "+data.path)

            },
            error: function () {
              alert("2222222에러입니다");
            }
          })


          }


             });









      function checkIn(f) {
        if (f.title.value == "") {
          alert("제목를 입력하세요");
          f.title.focus();
          return false;
        }
        if (CKEDITOR.instances['content'].getData() == '') {
          window.alert('내용을 입력해 주세요.');
          CKEDITOR.instances['content'].focus();
          return false;
        }

      }


//   function uploadResource(file, editor) {
//          data = new FormData();
//          data.append("file", file);
//          console.log(data);
//          $.ajax({
//            data: data,
//            type: "POST",
//            url: "/s3/resource",
//            contentType: false,
//            processData: false,
//            success: function (data) {
//              //항상 업로드된 파일의 url이 있어야 한다.
//              $('#summernote').summernote('insertImage', data.path);
//              console.log("data.path = "+data.path)
//var idx = data.path;
//console.log("idx = "+idx)
//  $.ajax({
//            data: idx,
//            type: "get",
//            url: "/s3/resource/${idx}",
//            contentType: false,
//            processData: false,
//            success: function (data) {
//              //항상 업로드된 파일의 url이 있어야 한다.
//             alert("성공");
//
//            },
//            error: function () {
//              alert("1111에러입니다");
//            }
//          })
//
//
//
//
//
//
//
//            },
//            error: function () {
//              alert("2222222에러입니다");
//            }
//          })
//
//
//          }