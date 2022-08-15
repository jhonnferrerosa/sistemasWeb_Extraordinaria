## este programa, va a ser para cambiar el color al terminal,

import random; 
from sty import fg;

def about_me (name, profession, pet):
	print ("hola, mi nombre es:  ", name);
	print ("yo me dedico a:  ", profession);
	print ("y yo tengo una mascota:  ", pet);

def generateRGB ():
	red = random.randint (0, 256);
	green = random.randint (0, 256);
	blue = random.randint (0, 256);
	return red, green, blue;



print  ("--- este va a ser el programa, del que vamos a poner el terminal ---");
about_me ("jhon", "developer", "iris");











