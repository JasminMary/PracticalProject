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
                showAll(data[i].id, data[i].jobName, data[i].jobLevel, chara);
              }
        })
    })
    
}
//if time create the table in html instead 
//variable names are just acroynms of element type and parameter 
function showAll(id, jobName, jobLevel, characterId) {
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

let readJobsByIdTable = document.createElement("table");

function readBy(id) {
    let readJobsId = fetch(`http://localhost:8080/job/read/${id}`);
    readJobsId.then(function(response) {
        let job = response.json();
        job.then(function(data){
          allJobsTable.innerHTML = ""
          allJobsTable.style = "width 80%";
            document.body.appendChild(readJobsByIdTable);
                const chara =JSON.stringify(data.character)
                showReadBy(data.id, data.jobName, data.jobLevel, chara);
              
        })
    })
}
//this is repetative - try to refactor if time
function showReadBy(id, jobName, jobLevel, characterId) {
    let thid = document.createElement("th")
    let thjn = document.createElement("th")
    let thjl = document.createElement("th")
    let thci = document.createElement("th")

    thid.innerHTML = "|id "
    thjn.innerHTML = "|Job "
    thjl.innerHTML = "|Level "
    thci.innerHTML = "|Character info "
    readJobsByIdTable.appendChild(thid)
    readJobsByIdTable.appendChild(thjn)
    readJobsByIdTable.appendChild(thjl)
    readJobsByIdTable.appendChild(thci)
    
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

    readJobsByIdTable.appendChild(trRow)

}
readByIdButton.onclick = () => readBy (
    readId.value
  )

//update job
function updateJob(jobid, jobName, jobLevel, character) {
    fetch(`http://localhost:8080/job/update/${jobid}`, {
        method: 'PUT',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(
        { jobid: jobid,
          jobName: jobName,
          jobLevel: jobLevel,
          character: {
              id: character
          }
      }),
  })
    .then(data => console.log(`Request succeeded with JSON response ${data}`))
            //.then(location.reload())
            .catch((error) => console.error(`Request failed: ${error}`))
}

updateJobButton.onclick = () => updateJob (
    updateId.value,
    jobNameUpdate.value,
    updateLevel.value,
    characterIdUpdate.value
)