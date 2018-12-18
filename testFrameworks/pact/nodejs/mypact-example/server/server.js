const express = require('express')
const app = express()

app.get('/name', (request, response) => {
  response.json({
    "title": "myTitle",
    "count": 4
  })
})

app.listen(3333, () => {
 console.log("Server running on port 3333");
});
