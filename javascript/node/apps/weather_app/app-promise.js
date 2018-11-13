const yargs = require('yargs');
const axios = require('axios');

let argv = yargs
  .options({
    a: {
      demand: true,
      alias: 'address',
      describe: 'Address to fetch weather for',
      string: true
    }
  })
  .help()
  .alias('help', 'h')
  .argv;

let encodedAddress = encodeURIComponent(argv.address);
let url = `http://localhost:3000/coordinates?address=${encodedAddress}`;

axios.get(url).then((response) => {
  if (response.data.status === 'ZERO_RESULTS') {
    throw new Error('Unable to find that address');
  }

  let lat = response.data[0].lat;
  let lon = response.data[0].lon;
  let weatherUrl = `https://api.darksky.net/forecast/d658217543a4545109fd8fd05d1edde8/${lat},${lon}`;

  return axios.get(weatherUrl);
}).then((response) => {
  let temperature = response.data.currently.temperature;
  let apparentTemperature = response.data.currently.apparentTemperature;
  console.log(`It is currently ${temperature}. If feels like ${apparentTemperature}.`);
}).catch((e) => {
  if (e.code === 'ENOTFOUND') {
    console.log('Unable to connect');
  } else {
    console.log(e.message);
  }
});
