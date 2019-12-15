const collapseSidebar = function () {
  let sidebar = document.getElementById('sidebar');
  if (!sidebar.classList.contains('collapsed')) {
    sidebar.classList.add('collapsed');
  }
};
const switchSidebar = function () {
  let sidebar = document.getElementById('sidebar');
  if (sidebar.classList.contains('collapsed')) {
    sidebar.classList.remove('collapsed');
  } else {
    sidebar.classList.add('collapsed');
  }
};
const loadMap = function () {
  let locationMap = document.getElementById('location-map');
  if (!locationMap) {
    return;
  }
  let coords = [52.3666451, 4.892396599999984];
  locationMap.setAttribute('location-map', coords);
  let myMap = L.map('location-map', {
    scrollWheelZoom: false,
  });
  myMap.setView(coords, 17);
  L.tileLayer(
      'https://api.mapbox.com/styles/v1/gonzih/cixw9sqla002c2sn0a5uqu72s/tiles/256/{z}/{x}/{y}?access_token={accessToken}',
      {
        attribution: '&copy; <a href=\'http://openstreetmap.org\' target=\'_blank\'>OpenStreetMap</a>, <a href=\'http://creativecommons.org/licenses/by-sa/2.0/\' target=\'_blank\'>CC-BY-SA</a>, © <a href=\'http://mapbox.com\' target=\'_blank\'>Mapbox</a>',
        maxZoom: 18,
        accessToken: 'pk.eyJ1IjoiZ29uemloIiwiYSI6ImNpeHc1eDA0NjAwMmczMmw4MnR5b2p4eWsifQ.nrJj6lim59mVefvEwsiCgA'
      }).addTo(myMap);
  L.marker(coords)
      .addTo(myMap)
      .bindPopup('<a href=\'http://tq.co\' target=\'_blank\'>TQ - Singel 542</a>');
};
loadMap();