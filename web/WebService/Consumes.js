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
        url: "http://localhost:8080/Cours_Java_Web_exploded/webservice/medias/postJson",
        // The key needs to match your method's input parameter (case-sensitive).
        data: JSON.stringify(monBean),
        dataType: 'json',
        contentType: 'application/json',
        success: function(data) {
            console.log(data.id)
        },
        error: function(errMsg) {
            console.log(errMsg);
        }
    });
}