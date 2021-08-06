console.log("in js file");


/*
	If you're confused on WHEN to use AJAX vs a FORM....use this guideline (not a rule, just a guide).
	
	If you're looking to change pages then consider a FORM.
	If you're looking for a JSON then consider an AJAX request.
*/

window.onload = function(){
	//document.getElementById("....stuff....").addEventListener("click", ajaxGetAllVills);

	ajaxgetName();
	ajaxAllReimb();
	//ajaxGetAllVills();
}

function ajaxgetName(){
	console.log("starting the ajax request");
			
	fetch('http://localhost:9001/Project1/json/getName')
		.then(function(daResponse){
					const convertedResponse = daResponse.json();
					return convertedResponse;
				})
		.then(function(daSecondResponse){
					console.log(daSecondResponse);
					addName(daSecondResponse);
				})
}

function addName(nameJson){
	let apName = document.createTextNode(nameJson.userFirstName);
	let space = document.createTextNode(" ");
	let apLName = document.createTextNode(nameJson.userLastName);
	namer = document.getElementById("nameWelcome")
	namer.appendChild(apName);
	namer.appendChild(space);
	namer.appendChild(apLName);
}

function ajaxAllReimb(){
	console.log("starting the ajax request for Reimb");
		
	fetch('http://localhost:9001/Project1/json/allReimb')
		.then(function(daResponse){
					const convertedResponse = daResponse.json();
					return convertedResponse;
				})
		.then(function(daSecondResponse){
					console.log(daSecondResponse);
					ourDOMManipulation(daSecondResponse);
				})
}

function ajaxUsersReimb(){
	console.log("starting the ajax request");
	
	fetch('http://localhost:9001/Project1/json/usersReimb')
		.then(function(daResponse){
					const convertedResponse = daResponse.json();
					return convertedResponse;
				})
		.then(function(daSecondResponse){
					console.log(daSecondResponse);
					ourDOMManipulation(daSecondResponse);
				})
}

// function ajaxGetAllVills(){
// 	console.log("starting the ajax request");
	
	
// 	//console.log(loggedInUserName);
// 	fetch('http://localhost:9001/Project1/json/allVills')
// 		.then(function(daResponse){
// 					const convertedResponse = daResponse.json();
// 					return convertedResponse;
// 				})
// 		.then(function(daSecondResponse){
// 					console.log(daSecondResponse);
// 					ourDOMManipulation(daSecondResponse);
// 				})
// }
function testing(approved)
{
    console.log(approved);
}


function filterTheTable() {
    let mySelect = document.querySelectorAll(".table-row");
    for(let n = 0; n < mySelect.length; n++){
        if(mySelect[n].children[8].outerText == "Approved" || mySelect[n].children[8].outerText == "Denied"){
            console.log(mySelect[n].children[8].outerText);
            mySelect[n].remove();
        };
    }
}


function approval(ourJSON, i, approvalstatus){

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        // console.log("readystate is changing:", xhttp.readyState);

        if(xhttp.readyState===4 && xhttp.status===200){
            let poke = JSON.parse(xhttp.responseText);
            console.log(poke);
        };
    }
    xhttp.open("PUT", `http://localhost:9001/Project1/json/approval`);
    xhttp.setRequestHeader("content-type", "application/json");

    console.log("right before the JSON");
    console.log(ourJSON[i].reimbId);
    let forapproval = {
        "reimbId": ourJSON[i].reimbId,
        "approval": approvalstatus,
    }
    console.log(forapproval.reimbId);
    xhttp.send(JSON.stringify(forapproval)); 
}

function ourDOMManipulation(ourJSON){
	//we are about to do some HEAVY DOM manipulation
	
	/*
		you COULD check to see if they are a employee or manager then dynamically add new buttons
		and/or html elements
	*/
	
	for(let i = 0; i< ourJSON.length; i++){
		////////////CREATE ELEMENTS DYNAMICALLY////////////////
		
		//step1: creating our new element
		let newTR = document.createElement("tr");
        newTR.setAttribute("class", "table-row")
		let newTH = document.createElement("th");
		
		let newTD1 = document.createElement("td");
		let newTD2 = document.createElement("td");
		let newTD3 = document.createElement("td");
		let newTD4 = document.createElement("td");
		let newTD5 = document.createElement("td");
		let newTD6 = document.createElement("td");
		let newTD7 = document.createElement("td");
		let newTD8 = document.createElement("td");
		let newTD9 = document.createElement("td");
		//step 2: populate creations
		newTH.setAttribute("scope", "row");
		let myTextH = document.createTextNode(ourJSON[i].reimbId);
		let myTextD1 = document.createTextNode("$" + ourJSON[i].reimbAmount);
		let myTextD2 = document.createTextNode(ourJSON[i].reimbSubmitted);
        let myTextD3 = document.createTextNode(ourJSON[i].reimbResolved);
        if(ourJSON[i].reimbResolved == null){
            myTextD3 = document.createTextNode("N/A");
        };
		//let myTextD3 = document.createTextNode(ourJSON[i].reimbResolved);
		let myTextD4 = document.createTextNode(ourJSON[i].reimbDescription);
		let myTextD5 = document.createTextNode(ourJSON[i].reimbReceipt);
        if(ourJSON[i].reimbReceipt == null){
            myTextD5 = document.createTextNode("N/A");
        };
		let myTextD6 = document.createTextNode(ourJSON[i].reimbAuthor);
        let myTextD7 = document.createTextNode(ourJSON[i].reimbResolver);
        if(ourJSON[i].reimbResolver == null){
            myTextD7 = document.createTextNode("N/A");
        };
		let myTextD9 = document.createTextNode(ourJSON[i].reimbTypeId);
		
		//all appending
		newTH.appendChild(myTextH);
		newTD1.appendChild(myTextD1);
		newTD2.appendChild(myTextD2);
		newTD3.appendChild(myTextD3);
		newTD4.appendChild(myTextD4);
		newTD5.appendChild(myTextD5);
		newTD6.appendChild(myTextD6);
		newTD7.appendChild(myTextD7);
        if (ourJSON[i].reimbStatusID == "Pending"){
            let myTextD8 = document.createElement('BUTTON');
            let buttonText = document.createTextNode('Approve');
            let denial = document.createElement('BUTTON');
            let dbuttonText = document.createTextNode('Deny');
            myTextD8.className = "btn btn-primary";
            denial.className = "btn btn-primary";
            myTextD8.onclick = (function(ourJSON, i) {return function(){approval(ourJSON, i,"Approved"); this.disabled=true;}})(ourJSON, i); 
            denial.onclick = (function(ourJSON, i) {return function(){approval(ourJSON, i,"Denied"); this.disabled=true;}})(ourJSON, i); 
            myTextD8.appendChild(buttonText);
            newTD8.appendChild(myTextD8);
            denial.appendChild(dbuttonText);
            newTD8.appendChild(denial);
        } else {
            let myTextD8 = document.createTextNode(ourJSON[i].reimbStatusID);
            newTD8.appendChild(myTextD8);
        }
		newTD9.appendChild(myTextD9);


		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
		newTR.appendChild(newTD6);
		newTR.appendChild(newTD7);
		newTR.appendChild(newTD8);
		newTR.appendChild(newTD9);

		
		let newSelection = document.querySelector("#myReimbTable");
		newSelection.appendChild(newTR);
	}
}
