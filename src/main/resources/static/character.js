
// Create Character function
function createCharacter(id, name, race, grandCompany, freeCompany, datacentre) {

    fetch(`http://localhost:8080/character/create`, {
      method: `post`,
      headers: { "Content-type": "application/json" },
      body: JSON.stringify({ id: id, name: name, race: race, grandCompany: grandCompany,
         freeCompany: freeCompany, datacentre: datacentre }),
    })
      .then((response) => response.json())
      .then(data => console.log(`Request succeeded with JSON response ${data}`))
      .then(location.reload())
      .catch((error) => console.error(`Request failed: ${error}`));
  }

  createCharacterButton.onclick = () => createCharacter(
      createId.value,
      createName.value,
      race.value,
      grandCompany.value,
      createFreeCompany.value,
      datacentre.value
  );

//read all characters 
let allCharactersTable = document.createElement("table");

function readAll() {
    let readAllCharacters = fetch(`http://localhost:8080/character/readAll`);
    readAllCharacters.then(function(response) {
        let CA = response.json();
        CA.then(function(data){
          allCharactersTable.innerHTML = ""
          allCharactersTable.style = "width 60%";
            document.body.appendChild(allCharactersTable);

            for (let i = 0; i < data.length; i++) {
                showRecord(data[i].id, data[i].name, data[i].race, data[i].grandCompany, 
                  data[i].freeCompany, data[i].datacentre, data[i].jobs);
              }
        })
    })
    
}

function showRecord(id, name, race, grandCompany, freeCompany, datacentre) {
  let thid = document.createElement("th")
  let thname = document.createElement("th")
  let thrace = document.createElement("th")
  let thgc = document.createElement("th")
  let thfc = document.createElement("th")
  let thdc = document.createElement("th")

  thid.innerHTML = "|id "
  thname.innerHTML = "|Name "
  thrace.innerHTML = "|Race "
  thgc.innerHTML = "|Grand Company "
  thfc.innerHTML = "|Free Comapany "
  thdc.innerHTML = "|Data Centre |"
  allCharactersTable.appendChild(thid)
  allCharactersTable.appendChild(thname)
  allCharactersTable.appendChild(thrace)
  allCharactersTable.appendChild(thgc)
  allCharactersTable.appendChild(thfc)
  allCharactersTable.appendChild(thdc)

  let refRow=document.createElement("tr")

  let refid = document.createElement("td")
  let refname=document.createElement("td")
  let refrace=document.createElement("td")
  let refgc=document.createElement("td")
  let reffc=document.createElement("td")
  let refdc=document.createElement("td")

  refid.innerHTML = id
  refname.innerHTML = name
  refrace.innerHTML = race
  refgc.innerHTML = grandCompany
  reffc.innerHTML = freeCompany
  refdc.innerHTML = datacentre
  refRow.appendChild(refid)
  refRow.appendChild(refname)
  refRow.appendChild(refrace)
  refRow.appendChild(refgc)
  refRow.appendChild(reffc)
  refRow.appendChild(refdc)

  allCharactersTable.appendChild(refRow)
}  

showAllCharactersButton.onclick = () => readAll()
  