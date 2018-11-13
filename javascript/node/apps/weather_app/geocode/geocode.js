const request = require('request');

let geocodeAddress = (address, callback) => {
  let encodedAddress = encodeURIComponent(address);
  console.log(encodedAddress);

  // please run ../simple_rest_api for faking api (node app.js)
  request({
    url: `http://localhost:3000/coordinates?address=${encodedAddress}`,
    json: true
  }, (error, response, body) => {
    if (error) {
      callback('Unable to connect');
    } else if (body[0].status === 'BAD') {
      callback('Request is not correct');
    } else {
      callback(undefined, {
        lat: body[0].lat,
        lon: body[0].lon
      });
    }
  });
};

module.exports = {
  geocodeAddress
}
