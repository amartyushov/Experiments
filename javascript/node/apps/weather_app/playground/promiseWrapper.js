const request = require('request');

let geocodeAddress = (address) => {

  return new Promise((resolve, reject) => {
    let encodedAddress = encodeURIComponent(address);

    request({
      url: `http://localhost:3000/coordinates?address=${encodedAddress}`,
      json: true
    }, (error, response, body) => {
      if (error) {
        reject('Unable to connect');
      } else if (body[0].status === 'BAD') {
        reject('Request is not correct');
      } else {
        resolve({
          lat: body[0].lat,
          lon: body[0].lon
        });
      }
    });
  })
};

geocodeAddress('11111').then((location) => {
  console.log(JSON.stringify(location, undefined, 2));
}, (errorMessage) => {
  console.log(errorMessage);
});
