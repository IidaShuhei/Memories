/**
 * 
 */
$(function() {
  var API_KEY = '3e5fa589e6b5a8e6f1c25c83569182d7'
  var city = 'Tokyo';
  var url = 'http://api.openweathermap.org/data/2.5/forecast?q=' + city + ',jp&units=metric&APPID=' + API_KEY;
  $.ajax({
    url: url,
    dataType: "json",
    type: 'GET',
  })
  .done(function(data) {
  })
  .fail(function(data) {
  });
});