const request = require('request');

let getWeather = (lat, lon, callback) => {
  request({
    url: `https://api.darksky.net/forecast/d658217543a4545109fd8fd05d1edde8/${lat},${lon}`,
    json: true
  }, (error, response, body) => {
    if (!error && response.statusCode === 200) {
      callback(undefined, {
        temperature: body.currently.temperature,
        actualTemperature: body.currently.apparentTemperature
      });
    } else {
      callback('Unable to fetch weather');
    }
  });
};

module.exports = {
  getWeather
}
