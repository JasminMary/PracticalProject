// Create Job function
function createJob(jobid, jobName, jobLevel, character) {

    fetch(`http://localhost:8080/job/create`, {
      method: `post`,
      headers: { "Content-type": "application/json" },
      body: JSON.stringify(
          { jobid: jobid,
            jobName: jobName,
            jobLevel: jobLevel,
            character: {
                id: character
            }
        }),
    })
      .then((response) => response.json())
      .then(data => console.log(`Request succeeded with JSON response ${data}`))
      .then(location.reload())
      .catch((error) => console.error(`Request failed: ${error}`));
  }

  createJobButton.onclick = () => createJob(
      createId.value,
      jobName.value,
      createLevel.value,
      characterId.value
  )

//read all characters 
let allJobsTable = document.createElement("table");

function readAll() {
    let readAllJobs = fetch(`http://localhost:8080/job/readAll`);
    readAllJobs.then(function(response) {
        let job = response.json();
        job.then(function(data){
          allJobsTable.innerHTML = ""
          allJobsTable.style = "width 80%";
            document.body.appendChild(allJobsTable);

            for (let i = 0; i < data.length; i++) {
                const chara =JSON.stringify(data[i].character)
                showRecord(data[i].id, data[i].jobName, data[i].jobLevel, chara);
              }
        })
    })
    
}
//if time create the table in html instead 
//variable names are just acroynms of element type and parameter 
function showRecord(id, jobName, jobLevel, characterId) {
    let thid = document.createElement("th")
    let thjn = document.createElement("th")
    let thjl = document.createElement("th")
    let thci = document.createElement("th")

    thid.innerHTML = "|id "
    thjn.innerHTML = "|Job "
    thjl.innerHTML = "|Level "
    thci.innerHTML = "|Character info "
    allJobsTable.appendChild(thid)
    allJobsTable.appendChild(thjn)
    allJobsTable.appendChild(thjl)
    allJobsTable.appendChild(thci)

    let trRow=document.createElement("tr")

    let tdid = document.createElement("td")
    let tdjn=document.createElement("td")
    let tdjl=document.createElement("td")
    let tdci=document.createElement("td")


    tdid.innerHTML = id
    tdjn.innerHTML = jobName
    tdjl.innerHTML = jobLevel
    tdci.innerText = characterId
    trRow.appendChild(tdid)
    trRow.appendChild(tdjn)
    trRow.appendChild(tdjl)
    trRow.appendChild(tdci)

    allJobsTable.appendChild(trRow)

}

showAllJobButton.onclick = () => readAll()