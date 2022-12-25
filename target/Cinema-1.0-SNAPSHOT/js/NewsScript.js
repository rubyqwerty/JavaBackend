let News=[];

function getBase(typeOfBase){
    $.ajax({
        url: 'http://localhost:8080/Cinema_war/GetBaseServlet',
        method : "GET",
        dataType: 'json',
        data: {
            "type" : typeOfBase
        },
        success: function (data) {
            News = data['Base'];
            GenerateNewsHtml();
        }
    });
}

function GenerateNewsHtml(){

    var htmlNews = ``;
    for (var i = 0; i < News.length; i++){
        htmlNews +=
            `<div id = "news" class = "news">
                <p class ="heading">` +News[i]['nameOfNew'] + `</p>
        <p class ="maintext">
            ` + News[i]['text'] + `</p></div>`
    }
    console.log(htmlNews);
    $("#All").append(htmlNews);
}