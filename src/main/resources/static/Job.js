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

