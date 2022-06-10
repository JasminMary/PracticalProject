
// Create Character function
function createCharacter(id, name, race, grandCompany, freeCompany, datacentre) {

    fetch(`http://localhost:8080/character/create`, {
      method: `post`,
      headers: { "Content-type": "application/json" },
      body: JSON.stringify({ id: id, 
                            name: name, 
                            race: race, 
                            grandCompany: grandCompany,
                            freeCompany: freeCompany, 
                            datacentre: datacentre }),
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
        let Chara = response.json();
        Chara.then(function(data){
          allCharactersTable.innerHTML = ""
          allCharactersTable.style = "width 80%";
            document.body.appendChild(allCharactersTable);

            for (let i = 0; i < data.length; i++) {
                showAll(data[i].id, data[i].name, data[i].race, data[i].grandCompany, 
                  data[i].freeCompany, data[i].datacentre);
              }
        })
    })
    
}
//if time create the table in html instead 
//variable names are just acroynms of element type and parameter 
function showAll(id, name, race, grandCompany, freeCompany, datacentre) {
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

  let trRow=document.createElement("tr")

  let tdid = document.createElement("td")
  let tdname=document.createElement("td")
  let tdrace=document.createElement("td")
  let tdgc=document.createElement("td")
  let tdfc=document.createElement("td")
  let tddc=document.createElement("td")

  tdid.innerHTML = id
  tdname.innerHTML = name
  tdrace.innerHTML = race
  tdgc.innerHTML = grandCompany
  tdfc.innerHTML = freeCompany
  tddc.innerHTML = datacentre
  trRow.appendChild(tdid)
  trRow.appendChild(tdname)
  trRow.appendChild(tdrace)
  trRow.appendChild(tdgc)
  trRow.appendChild(tdfc)
  trRow.appendChild(tddc)

  allCharactersTable.appendChild(trRow)
  showAllContainer.appendChild(allCharactersTable)
}  

showAllCharactersButton.onclick = () => readAll()

//read by id
let readCharaByIdTable = document.createElement("table");

function readBy(id) {
  let readCharacters = fetch(`http://localhost:8080/character/read/${id}`);
  readCharacters.then(function(response) {
      let Chara = response.json();
      Chara.then(function(data){
        readCharaByIdTable.innerHTML = ""
        readCharaByIdTable.style = "width 80%";
          document.body.appendChild(readCharaByIdTable);
          showReadBy(data.id, data.name, data.race, data.grandCompany, 
            data.freeCompany, data.datacentre);

          })
        })
}
//this is repetative - try to refactor if time
function showReadBy(id, name, race, grandCompany, freeCompany, datacentre) {
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
  readCharaByIdTable.appendChild(thid)
  readCharaByIdTable.appendChild(thname)
  readCharaByIdTable.appendChild(thrace)
  readCharaByIdTable.appendChild(thgc)
  readCharaByIdTable.appendChild(thfc)
  readCharaByIdTable.appendChild(thdc)

  let trRow=document.createElement("tr")

  let tdid = document.createElement("td")
  let tdname=document.createElement("td")
  let tdrace=document.createElement("td")
  let tdgc=document.createElement("td")
  let tdfc=document.createElement("td")
  let tddc=document.createElement("td")

  tdid.innerHTML = id
  tdname.innerHTML = name
  tdrace.innerHTML = race
  tdgc.innerHTML = grandCompany
  tdfc.innerHTML = freeCompany
  tddc.innerHTML = datacentre
  trRow.appendChild(tdid)
  trRow.appendChild(tdname)
  trRow.appendChild(tdrace)
  trRow.appendChild(tdgc)
  trRow.appendChild(tdfc)
  trRow.appendChild(tddc)

  readCharaByIdTable.appendChild(trRow)
  readByIdContainer.appendChild(readCharaByIdTable)

}
readByIdButton.onclick = () => readBy (
  readId.value
)

//update character
function updateCharacter(id, name, race, grandCompany, freeCompany, datacentre) {
  fetch(`http://localhost:8080/character/update/${id}`, {
      method: 'PUT',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
              id: id, 
              name: name, 
              race: race, 
              grandCompany: grandCompany,
              freeCompany: freeCompany, 
              datacentre: datacentre
            })
          }) 
            .then(data => console.log(`Request succeeded with JSON response ${data}`))
            .then(location.reload())
            .catch((error) => console.error(`Request failed: ${error}`))
        }

updateCharacterButton.onclick = () => updateCharacter(
    updateId.value,
    updateName.value,
    updateRace.value,
    grandCompanyUpdate.value,
    updateFreeCompany.value,
    updateDatacentre.value
)
//delete character
function deletebyID(id) {
  fetch(`http://localhost:8080/character/delete/${id}`, {
      method: 'delete'   
  })
  .then((data) => {
      console.log(`Request succeeded with JSON response ${data}`);
  })
  .catch((error) => {
      
  });
}

deleteCharaButton.onclick = () => deletebyID (
  deleteChara.value
)