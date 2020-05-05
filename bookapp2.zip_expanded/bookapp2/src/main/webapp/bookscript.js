
function sendDataWithJavascript(form){
    var book=new Object();
    book.name=form.name.value;
    book.pages=form.pages.value;
   
   
    var json=JSON.stringify(book);
       
   
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
       document.getElementById("response").innerHTML = this.responseText;
      }
    };
    xhttp.open("POST", "/rest/bookservice/addbook", true);
//    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.setRequestHeader("Content-type", "application/json");
   
    xhttp.send(json);
}


function getData(){
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        //Ensin result-kenttään JSON sellaisenaan
        var tulos=this.responseText;
        document.getElementById("result").innerHTML = tulos;
        //Sitten puretaan se Javascript oliotaulukoksi
         booklist = JSON.parse(tulos);
        var txt="";
        //Käydään taulukko läpi yksi kerrallaan ja liitetään
        //muuttujaan txt kunkin yksittäisen olion arvot
        for (index in booklist){
              txt += booklist[index].name + "<br>";
             txt += booklist[index].pages + "<br>";
           
        }
       
        //The same with normal for-statement
/*        for (i=0;i<laptoplist.length;i++){
              txt += laptoplist[i].brand + "<br>";
             txt += laptoplist[i].price + "<br>";
            txt += laptoplist[i].weight + "<br>";
        }
*/       
        //Lisätään saatu merkkijono kenttään result2
         document.getElementById("result2").innerHTML = txt;
       }
    };
    xmlhttp.open("GET", "/rest/bookservice/getall", true);
    xmlhttp.send();   
}

