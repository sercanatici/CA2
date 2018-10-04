function getZip(){
    fetch("http://localhost:8084/mavenproject1/api/person/allzip")
            .then(res => handleHttpError(res))
            .then(data => document.getElementById("tbody").innerHTML = makeZipTable(data))
            .catch(err => {
                if (err.httpError) {
                    err.fullError.then(eJson =>{ console.log("Error: " + eJson.error);
                    document.getElementById("tbody").innerHTML = eJson.error;
                });
                } else {
                    console.log("Netværksfejl");
                }
            }

            );
}

function makeZipTable(data){
    let stringReturn = "";
    for(let i = 0; i < data.length; i++){
                stringReturn += "<tr><td>"+data[i].city+"</td><td>"+data[i].zip+"</td></tr>";
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