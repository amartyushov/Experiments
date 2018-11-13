var express = require("express");
var app = express();
app.listen(3000, () => {
 console.log("Server running on port 3000");
});

app.get("/coordinates", (req, res, next) => {

 res.json([
{
"place_id": "228251020",
"licence": "Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright",
"osm_type": "way",
"osm_id": "271683344",
"boundingbox": [
"39.94444",
"39.94454",
"-75.163327",
"-75.163227"
],
"lat": "39.94449",
"lon": "-75.163277",
"display_name": "1301, Lombard Street, Society Hill, Philadelphia, Philadelphia County, Pennsylvania, 19147, USA",
"class": "place",
"type": "house",
"importance": 0.411,
"address": {
"house_number": "1301",
"road": "Lombard Street",
"neighbourhood": "Society Hill",
"city": "Philadelphia",
"county": "Philadelphia County",
"state": "Pennsylvania",
"postcode": "19147",
"country": "USA",
"country_code": "us"
}
}
]);
});
