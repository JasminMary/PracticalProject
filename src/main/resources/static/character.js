
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

  