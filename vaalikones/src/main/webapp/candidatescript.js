/*
 author :
 */

function sendData(){
	//Create a new Javascript object
	var ehdokkaat = new Object();
	ehdokkaat.etunimi=document.getElementById("Etunimi").value;
	ehdokkaat.sukunimi=document.getElementById("Sukunimi").value;

	var json=JSON.stringify(ehdokkaat);
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		
			var returned=JSON.parse(this.responseText);

			console.log(returned);
			if (returned.ehdokasId > 0){
				location.reload();
				return;
			}
			/*document.getElementById("inparts").innerHTML="ID="+returned.id+" Etunimi="+returned.etunimi+" Weight="+returned.weight;*/
		}
		
	};

	xhttp.open("POST","./rest/candidateService/login",true);
	xhttp.setRequestHeader("Content-Type","application/json");
	//xhttp.setRequestHeader("Accept","application/json");
	xhttp.send(json);


}
function sendAns(form){
	var formData = "";
	console.log(formData);
	var list = Array.slice.call(form.getElementsByClassName("ans"));
	console.log(list);
}
