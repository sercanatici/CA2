function getZip() {
    fetch("http://localhost:8084/mavenproject1/api/person/allzip")
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
    return stringReturn = "<th>City</th><th>ZipCode</th>";
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
    console.log(hobby);
    fetch("http://localhost:8084/mavenproject1/api/person/hobby/" + hobby)
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
    return stringReturn = "<th>Id</th><th>Firstname</th><th>Lastname</th><th>Email</th></tr>";
}

function makeHobbyTable(data) {
    let stringReturn = "";
    for (let i = 0; i < data.length; i++) {
        stringReturn += "<tr><td>" + data[i].DTOid + "</td><td>" + data[i].DTOfirstName + "</td><td>" + data[i].DTOlastName + "</td><td>" + data[i].DTOemail + "</td></tr>";
    }
    return stringReturn;
}













function handleHttpError(res) {
    if (res.ok) {
        return res.json();
    } else {
        return Promise.reject({httpError: res.status, fullError: res.json()});
    }
}

document.getElementById("btnzip").addEventListener("click", getZip, false);