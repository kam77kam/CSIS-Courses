/*
  SEMAFORO
*/

// the setup function runs once when you press reset or power the board
void setup() {
  // initialize digital pin as an output.
  pinMode(13, OUTPUT);  
  pinMode(12, OUTPUT);  
  pinMode(11, OUTPUT);  
  pinMode(10, OUTPUT);  
  pinMode(9, OUTPUT);  
  pinMode(8, OUTPUT);  
}

// the loop function runs over and over again forever
void loop() {
  
    digitalWrite(13, HIGH); //Green ligth 1 / Luz    Verde 1
    digitalWrite(12, LOW);  //Yellow ligth 1 / Luz Amarilla 1
    digitalWrite(11, LOW);  //Red ligth 1 / Luz     rojo 1
    digitalWrite(10, LOW);  //Green ligth 2 / Luz    Verde 2
    digitalWrite(9, LOW);   //Yellow ligth 2 / Luz Amarilla 2   
    digitalWrite(8, HIGH);  //Red ligth 2 /Luz     rojo 2 
    delay(1000); 
    delay(1000); 
    delay(1000);    
    delay(1000);                       // wait for a second
    digitalWrite(13, LOW);  //Green ligth 1 / Luz    Verde 1
    digitalWrite(12, HIGH); //Yellow ligth 1 / Luz Amarilla 1
    digitalWrite(11, LOW);  //Red ligth 1 / Luz     rojo 1
    digitalWrite(10, LOW);  //Green ligth 2 / Luz    Verde 2
    digitalWrite(9, LOW);   //Yellow ligth 2 / Luz Amarilla 2   
    digitalWrite(8, HIGH);  //Red ligth 2 / Luz     rojo 2 
    delay(1000);    
    delay(1000);                       // wait for a second
    digitalWrite(13, LOW);   //Green ligth 1 / Luz    Verde 1
    digitalWrite(12, LOW);   // //Yellow ligth 1 / Luz Amarilla 1
    digitalWrite(11, HIGH);  //Red ligth 1 / Luz     rojo 1
    digitalWrite(10, HIGH);  //Green ligth 2 /Luz    Verde 2
    digitalWrite(9, LOW);    //Yellow ligth 2 /Luz Amarilla 2   
    digitalWrite(8, LOW);    //Red ligth 2 /Luz     rojo 2 
    delay(1000); 
    delay(1000); 
    delay(1000);    
    delay(1000);                       // wait for a second
    digitalWrite(13, LOW);   //Green ligth 1 /Luz    Verde 1
    digitalWrite(12, LOW);   //Yellow ligth 1 /Luz Amarilla 1
    digitalWrite(11, HIGH);  //Red ligth 1 /Luz     rojo 1
    digitalWrite(10, LOW);   //Green ligth 2 /Luz    Verde 2
    digitalWrite(9, HIGH);   //Yellow ligth 2 /Luz Amarilla 2   
    digitalWrite(8, LOW);    //Red ligth 2 /Luz     rojo 2 
    delay(1000);    
    delay(1000);                       // wait for a second
  
}
