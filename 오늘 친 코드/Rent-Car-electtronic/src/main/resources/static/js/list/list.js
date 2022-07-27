$(function(){



















 if(!("webkitSpeechRecognition") in window){
        alert("Connect in Chrome Browser");
    }else{
        const speech = new webkitSpeechRecognition;

        document.getElementById("rcdStart").addEventListener("click",()=>{
            speech.start();
            console.log('start!');
            setTimeout(function() {
             speech.stop();
             console.log('stop!');
            }, 3000);
        });



        speech.addEventListener("result", (event)=>{
            console.log(event);
            const { transcript } = event["results"][0][0];
            console.log(transcript);
            resultListView(transcript);
        });

        function resultListView(transcript){
            document.getElementById("word").value = transcript;
        }
    }


});
