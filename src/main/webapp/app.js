function getZip() {
    fetch("http://localhost:8084/mavenproject1/api/options/zip/allzip")
            .then(res => handleHttpError(res))
            .then(data => {
                document.getElementById("tbody").innerHTML = makeZipTable(data)
                document.getElementById("thead").innerHTML = makeZipHeader();
            })
            .catch(err => {
                if (err.httpError) {
                    err.fullError.then(eJson => {
                        console.log("Error: " + eJson.error);
                        document.getElementById("tbody").innerHTML = eJson.error;
                    });
                } else {
                    console.log("Netværksfejl");
                }
            }

            );
}

function makeZipHeader() {
    return stringReturn = "<tr><th>City</th><th>ZipCode</th><tr>";
}


function makeZipTable(data) {
    let stringReturn = "";
    for (let i = 0; i < data.length; i++) {
        stringReturn += "<tr><td>" + data[i].city + "</td><td>" + data[i].zip + "</td></tr>";
    }
    return stringReturn;
}

function findPersonsWithHobby() {
    var hobby = document.getElementById("value").value;
    fetch("http://localhost:8084/mavenproject1/api/options/person/hobby/" + hobby)
            .then(res => handleHttpError(res))
            .then(data => {
                document.getElementById("tbody").innerHTML = makeHobbyTable(data);
                document.getElementById("thead").innerHTML = makeHobbyHeader();
            })
            .catch(err => {
                if (err.httpError) {
                    err.fullError.then(eJson => {
                        console.log("Error: " + eJson.error);
                        document.getElementById("tbody").innerHTML = eJson.error;
                    });
                } else {
                    console.log("Netværksfejl");
                }
            }

            );
}

function makeHobbyHeader() {
    return stringReturn = "<tr><th>Id</th><th>Firstname</th><th>Lastname</th><th>Email</th></tr>";
}

function makeHobbyTable(data) {
    let stringReturn = "";
    for (let i = 0; i < data.length; i++) {
        stringReturn += "<tr><td>" + data[i].DTOid + "</td><td>" + data[i].DTOfirstName + "</td><td>" + data[i].DTOlastName + "</td><td>" + data[i].DTOemail + "</td></tr>";
    }
    return stringReturn;
}

function findAllPeople(){
    fetch("http://localhost:8084/mavenproject1/api/options/person/all")
    .then(res => handleHttpError(res))
            .then(data => {
                document.getElementById("tbody").innerHTML = makeAllPersonTable(data);
                document.getElementById("thead").innerHTML = makeAllPersonHeader();
            })
            .catch(err => {
                if (err.httpError) {
                    err.fullError.then(eJson => {
                        console.log("Error: " + eJson.error);
                        document.getElementById("tbody").innerHTML = eJson.error;
                    });
                } else {
                    console.log("Netværksfejl");
                }
            }

            );
}

function makeAllPersonHeaer(){
    return stringReturn = "<tr><th>Id</th><th>Firstname</th><th>Lastname</th><th>Email</th></tr>";
}

function makeAllPersonTable(data){
    let stringReturn = "";
    for (let i = 0; i < data.length; i++) {
        stringReturn += "<tr><td>" + data[i].DTOid + "</td><td>" + data[i].DTOfirstName + "</td><td>" + data[i].DTOlastName + "</td><td>" + data[i].DTOemail + "</td></tr>";
    }
    return stringReturn;
}




function findPerson() {
    var id = document.getElementById("findvalue").value;
    fetch("http://localhost:8084/mavenproject1/api/options/person/" + id)
            .then(res => handleHttpError(res))
            .then(data => {
                document.getElementById("tbody").innerHTML = makePersonTable(data);
                document.getElementById("thead").innerHTML = makePersonHeader();
            })
            .catch(err => {
                if (err.httpError) {
                    err.fullError.then(eJson => {
                        console.log("Error: " + eJson.error);
                        document.getElementById("tbody").innerHTML = eJson.error;
                    });
                } else {
                    console.log("Netværksfejl");
                }
            }

            );
}

function makePersonHeader(){
    return stringReturn = "<th>Id</th><th>Firstname</th><th>Lastname</th><th>Email</th></tr>"
}

function makePersonTable(data){
    return stringReturn = "<tr><td>" + data[0].DTOid + "</td><td>" + data[0].DTOfirstName + "</td><td>" + data[0].DTOlastName + "</td><td>" + data[0].DTOemail + "</td></tr>";
}

function createPerson(){
    var firstname = document.getElementById("firstname").value;
    var lastname = document.getElementById("lastname").value;
    var email = document.getElementById("email").value;
    
    var newPerson = {
        firstName : firstname,
        lastName : lastname,
        email : email
    };
    
    var data = JSON.stringify(newPerson);
    console.log(data);
   fetch("http://localhost:8084/mavenproject1/api/options/person/"+firstname+"/"+lastname+"/"+email, {
       method : "POST",
       headers : {
           "Accept" : "application/json",
           "Content-type" : "application/json"
       },
       body : data
   })
            .then(res => httpHandlerError(res))
            .then(data => {
                console.log(data);
                document.getElementById("tbody").innerHTML = createdPerson(data);
                document.getElementById("thead").innerHTML = createdPersonHeader();
            })
            .catch(err => {
                if (err.httpError) {
                    err.fullError.then(eJson => {
                        console.log("Error: " + eJson.error);
                        document.getElementById("tbody").innerHTML = eJson.error;
                    });
                } else {
                    console.log("Netværksfejl");
                }
            }

            );
}   

function createdPersonHeader(){
    return stringReturn = "<tr><th>Id</th><th>Firstname</th><th>Lastname</th><th>Email</th></tr>";
}

function createdPerson(data){
    console.log(data);
    return stringReturn = "<tr><td>"+data.id+"</td><td>"+data.firstName+"</td><td>"+data.lastName+"</td><td>"+data.email+"</td></tr>";
}


function deletePerson(){
    var id = document.getElementById("id").value;
    fetch("http://localhost:8084/mavenproject1/api/options/person/delete/"+ id, {
       method : "DELETE"
   })
            .then(res => httpHandlerError(res))
            .then(data => {
                console.log(data + "Deleted Successfully");
            })
            .catch(err => {
                if (err.httpError) {
                    err.fullError.then(eJson => {
                        console.log("Error: " + eJson.error);
                        document.getElementById("tbody").innerHTML = eJson.error;
                    });
                } else {
                    console.log("Netværksfejl");
                }
            }

            );
}


function handleHttpError(res) {
    if (res.ok) {
        return res.json();
    } else {
        return Promise.reject({httpError: res.status, fullError: res.json()});
    }
}

document.getElementById("delete").addEventListener("click", deletePerson, false);
document.getElementById("create").addEventListener("click", createPerson, false);
document.getElementById("btnzip").addEventListener("click", getZip, false);