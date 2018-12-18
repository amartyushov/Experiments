const requestOld = require('request');
const request = require('superagent');


let getNameOld = () => {
    return request({
    url: `http://localhost:3333/name`,
    json: true
  }, (error, response, body) => {
    console.log(body);
  });
}

const getName = () => {
  return request
    .get('http://localhost:3333/name')
    .then( res => {
      return res.body;
    })

}

module.exports = {
  getNameOld,
  getName
}
