$(document).ready(()=>{
    $("#btn").click(appuiBouton)
});

class bean{
    constructor() {
        this.attr1 = "Julien"
        this.attr2 = "Gazeau"
    }
}

function appuiBouton() {
    let monBean = new bean();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/Cours_Java_Web_exploded/api/test",
        // The key needs to match your method's input parameter (case-sensitive).
        data: JSON.stringify(monBean),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){alert("ok");},
        error: function(errMsg) {
            alert("fail");
        }
    });
}