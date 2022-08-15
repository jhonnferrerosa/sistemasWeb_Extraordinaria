#1) la declaración de TODAS las variables y las varables enumeradas, las voy a hacer en la
#cabezera del script. Esto lo he sacado de Ada. 
#2) cuando se busque un resultado importante de la ejecucion de un programa, se imprimira por pantalla de la 
#siguiente forma:  "+++se ha acertdado el numero+++" "+++la variable totalIntentos vale: 8+++"
#3) las variables se escriben al principio en minuscula. ejemplo:  totalIntentos = 0;
#4) el nombre de las clases siempre con Mayuscula al principio. ejemplo: Test2. 
#5) si tengo alguna duda sobre el Script, lo pondre como comentario en la primera linea de este. 

import random;

miNumero = 0;
numeroAleatorio = 0;
rangoDeAleatorios = 0;
numeroIntentos = 0;
verdad = True;
acertadoNumero = False;
totalIntentos = 0;

def saluda ():
	print ("hola desde saludo. ");

print ("---comienza el programa del acierto de los numeros---");
rangoDeAleatorios = int(input(" escriba el rango de posibles numeros Aleatorios:   "));
totalIntentos = int(input("escriba el numero de intentos que quiere:   "));
numeroAleatorio = random.random();
numeroAleatorio = int ( numeroAleatorio * rangoDeAleatorios );

#print ("este es el numero Aleatorio:  ", numeroAleatorio);


while verdad == True:
	miNumero = int(input("escriba su numero:  "));

	if (miNumero == numeroAleatorio):
		acertadoNumero = True;
		verdad = False;
		print (" Has Acertado el Numero! ");
	else:
		if miNumero > numeroAleatorio:
			print ("th has pasado, numero intentos: ", numeroIntentos);
		else:
			print ("te has quedado corto, numero intentos:  ", numeroIntentos); 

	if (numeroIntentos >= totalIntentos):
		print ("se te han acabado los intentos, has perdido.");
		verdad = False;



	numeroIntentos = numeroIntentos + 1;




print ("---fin del programa ---");



