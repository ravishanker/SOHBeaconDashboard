
<%@page import="com.soh.sohbeacon.store.BeaconStore"%>
<h2 id="users">Users</h2>

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=visualization"></script>


<table class="table table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		</tr>
	</tbody>
</table>

<div id="map-canvas"></div>

<script>


//Adding 500 Data Points
var map, pointarray, heatmap;
var taxiData = [

<%for (String user : BeaconStore.getInstance().usersFromBeacon("beacon1"))
 { %>
new google.maps.LatLng(-33.857821, 151.214194),
<%}%>

<%for (String user : BeaconStore.getInstance().usersFromBeacon("beacon2"))
{ %>
new google.maps.LatLng(-33.856252, 151.215192),
<%}%>

<%for (String user : BeaconStore.getInstance().usersFromBeacon("beacon3"))
{ %>
new google.maps.LatLng(-33.857286, 151.215428),
<%}%>
];

function initialize() {
var mapOptions = {
 zoom: 17,
 center: new google.maps.LatLng(-33.856956, 151.215203),
 mapTypeId: google.maps.MapTypeId.SATELLITE
};

map = new google.maps.Map(document.getElementById('map-canvas'),
   mapOptions);

var pointArray = new google.maps.MVCArray(taxiData);

heatmap = new google.maps.visualization.HeatmapLayer({
 data: pointArray
});

heatmap.set('radius', heatmap.get('radius') ? null : 150);
heatmap.setMap(map);
}

function toggleHeatmap() {
heatmap.setMap(heatmap.getMap() ? null : map);
}

function changeGradient() {
var gradient = [
 'rgba(0, 255, 255, 0)',
 'rgba(0, 255, 255, 1)',
 'rgba(0, 191, 255, 1)',
 'rgba(0, 127, 255, 1)',
 'rgba(0, 63, 255, 1)',
 'rgba(0, 0, 255, 1)',
 'rgba(0, 0, 223, 1)',
 'rgba(0, 0, 191, 1)',
 'rgba(0, 0, 159, 1)',
 'rgba(0, 0, 127, 1)',
 'rgba(63, 0, 91, 1)',
 'rgba(127, 0, 63, 1)',
 'rgba(191, 0, 31, 1)',
 'rgba(255, 0, 0, 1)'
]
heatmap.set('gradient', heatmap.get('gradient') ? null : gradient);
}

function changeOpacity() {
heatmap.set('opacity', heatmap.get('opacity') ? null : 0.2);
}

google.maps.event.addDomListener(window, 'load', initialize);

</script>
