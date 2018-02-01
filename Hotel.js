var elementoDiv=document.getElementById("contenido");
elementoDiv.textContent="Nombre del hotel " + hotel().nombre;



function hotel(){
var hotel = new Object();
hotel.nombre="Hotel del amor Castorena";
hotel.habitaciones=20;
hotel.alberca=false;
hotel.tenis=false;
return hotel;
}
