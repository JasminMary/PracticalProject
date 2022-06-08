
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
        let Chara = response.json();
        Chara.then(function(data){
          allCharactersTable.innerHTML = ""
          allCharactersTable.style = "width 80%";
            document.body.appendChild(allCharactersTable);

            for (let i = 0; i < data.length; i++) {
                showRecord(data[i].id, data[i].name, data[i].race, data[i].grandCompany, 
                  data[i].freeCompany, data[i].datacentre, data[i].jobs);
              }
        })
    })
    
}
//if time create the table in html instead 
//variable names are just acroynms of element type and parameter 
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
}  

showAllCharactersButton.onclick = () => readAll()
  