  var map;
  var marker;
  var businessList;
  var defaultLatLong = {
      lat: 6.465893599999999,
      lng: 3.5614451999999996
  };
  var infoWindow;
  var searchLatitude;
  var searchLongitude;



  function getUserLocation() {
      if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function (position) {
              var pos = {
                  lat: position.coords.latitude,
                  lng: position.coords.longitude
              };

            //    infoWindow.setPosition(pos);
            //    infoWindow.setContent('Your Location');
            //    infoWindow.open(map);
            //   map.setCenter(pos);
            console.log("Current position is ", pos);
              placeDefaultMarker(pos, map);
            }, function () {
              handleLocationError(true, infoWindow, map.getCenter());
          });
      } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
      }
  }

  function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
                          'Error: The Geolocation service failed.' :
                          'Error: Your browser doesnt support geolocation.');
    infoWindow.open(map);
  }



  function initMap() {
      console.log("Map LAUCHED!!!");
      if(searchLatitude && searchLongitude){
       console.log("I have searched now");
       var position = {lat :parseFloat(searchLatitude), lng: parseFloat(searchLongitude)};
       map = new google.maps.Map(document.getElementById('map'), {
                center: position,
                zoom: 15,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            });

             placeDefaultMarker(position, map);
      }else{
      console.log("I havent searched yet");
      map = new google.maps.Map(document.getElementById('map'), {
          center: defaultLatLong,
          zoom: 15,
          mapTypeId: google.maps.MapTypeId.ROADMAP
      });
      getUserLocation();
      }
      infoWindow = new google.maps.InfoWindow;


      //set click listener for the map
      map.addListener('click', function (e) {
          console.log("Map Clicked!!!");
          placeMarker2(e.latLng, map);
      });

      if (businessList) {
          setMarkers(map, businessList);
      }

  }

  //setup the map initially
  google.maps.event.addDomListener(window, 'load', initMap);

 function placeDefaultMarker(location, map) {
      console.log("Map Defaults to ", location.lat, location.lng);
      //place the location object on the form
      document.getElementById('locationLat').value = location.lat;
      document.getElementById('locationLng').value = location.lng;

      if (marker == null) {
          marker = new google.maps.Marker({
              position: location,
              map: map,
              animation: google.maps.Animation.DROP,
              title: 'Search within here',
              label:'S'
          });
      } else {
          marker.setPosition(location);
      }
      map.panTo(location);
  }


  function placeMarker2(location, map) {
      console.log("Map Clicked at ", location.lat(), location.lng());
      //place the location object on the form
      document.getElementById('locationLat').value = location.lat();
      document.getElementById('locationLng').value = location.lng();

      if (marker == null) {
          marker = new google.maps.Marker({
              position: location,
              map: map,
              animation: google.maps.Animation.DROP,
              title: 'Search within here',
              label:'S'
          });
      } else {
          marker.setPosition(location);
      }
      map.panTo(location);
  }

  function placeMarker(location, map) {
      console.log("Display markers for ", location.lat(), location.lng());
      //place the location object on the form

      marker = new google.maps.Marker({
          position: location,
          map: map,
          title: 'Business'
      });

      map.panTo(location);
  }


  function pan(latitude, longitude) {
      var changedLatlong = {
          lat: latitude,
          lng: longitude
      };
      var panPoint = new google.maps.LatLng(latitude, longitude);
      var newmarker = new google.maps.Marker({
          position: {
              lat: Number(latitude),
              lng: Number(longitude)
          },
          title: 'Agent Location'
      });

      map.panTo(panPoint)
      newmarker.setMap(map);
      console.log("successfully panned");
  }

  function setBusinesses(biz) {
      console.log(biz);

      businessList = biz;

      if (!businessList || businessList.length == 0) {
          var x = document.getElementById("emptyBusiness");
          if (x.style.display === "none") {
              x.style.display = "block";
          } else {
              x.style.display = "none";
          }
      }
  }

//set the searched location so that we can pan tlo the location immediately the business search is done
  function setSearchedLocation(latitude, longitude){
            searchLatitude = latitude;
            searchLongitude = longitude;
  }

  function setMarkers(map, locations) {

      var i;
      var mark;
      var infowindow = new google.maps.InfoWindow();
      var contentString;
      console.log("Businesses are ", locations);
      for (i = 0; i < locations.length; i++) {

          console.log("A business is ", locations[i]);
          var businessName = locations[i].businessName;
          console.log("A business name is ", businessName);
          var lat = locations[i].geoloc.lat;
          var long = locations[i].geoloc.lng;
          console.log("Business Long", long);
          var address = locations[i].address;

          var phoneNumber = locations[i].contactNumber;

          var latlngset = new google.maps.LatLng(lat, long);
          console.log("Business Details", phoneNumber);
          //placeMarker(latlngset, map);


          console.log("Business Lat and long", latlngset);





          //            var mark = new google.maps.Marker({
          //            map: map, title: businessName , position: latlngset
          //            });
          //            map.setCenter(mark.getPosition())

          console.log('Marker position ');



          //                       var marker = new google.maps.Marker({
          //                         position: uluru,
          //                         map: map,
          //                         title: 'Uluru (Ayers Rock)'
          //                       });
          mark = new google.maps.Marker({
              map: map,
              title: businessName,
              position: latlngset
          });

          google.maps.event.addListener(mark, 'click', (function (mark, i) {
              return function () {
                  contentString = '<div><h3>' +
                      locations[i].businessName + '</h3>' +
                      '<br/>' + locations[i].address + '<br/>' +
                      '<strong>' + locations[i].contactNumber + '</strong><br/>'
                      //                                 '<a href="#" class="assignProspectSubmission txt-danger btn btn-primary btn-medium"'
                      //                                  + ' data-prospect-name='+"\""+locations[i].businessName+"\""
                      //                                  + ' data-prospect-address='+"\""+locations[i].address+"\""
                      //                                  + ' data-prospect-latitude='+"\""+locations[i].geoloc.lat+"\""
                      //                                  + ' data-prospect-longitude='+"\""+locations[i].geoloc.lng+"\""
                      //                                  + ' data-prospect-phone='+"\""+locations[i].contactNumber+"\""
                      //                                  + ' data-brief-summary='+"\""+locations[i].description+"\""
                      //
                      //                                  + ' data-email-of-key-contact='+"\""+locations[i].emailAddress+"\""
                      //
                      ////                                   +data-longitude=${prospect.longitude}, data-prospect-phone=${prospect.prospectPhone},
                      ////                                  + 'data-type-of-prospect=${prospect.typeOfProspect}, data-prospect-address=${prospect.prospectAddress},
                      ////                                  + 'data-brief-summary=${prospect.briefSummary}, data-nam-of-key-contact=${prospect.namOfKeyContact},
                      ////                                  + 'data-email-of-key-contact=${prospect.emailOfKeyContact}, data-position-of-key-contact=${prospect.positionOfKeyContact},
                      ////                                  + 'data-latitude=${prospect.latitude}, data-submission-id=${prospect.submissionId},
                      ////                                  + 'data-checkable-distance=${prospect.checkableDistance}, data-status-field-id=${prospect.statusFieldId}"'
                      ////
                      //                                  +' data-toggle="modal" data-target="#assignToEmployee">Assign to Employee</a>'
                      +
                      '</div>';

                  console.log('Content is ', contentString);

                  infowindow.setContent(contentString);
                  infowindow.open(map, mark);
              }
          })(mark, i));
          //                       mark.addListener('click', function() {
          //                         infowindow.open(map, mark);
          //                       });

      }
  }

  function assignToProspect(business) {

      console.log("Here is the biz ", business);


  }