 /*
  Truth Table
  Switch 1: start/stop
  Switch 1, 2: increment until 9, buzzer sounds
  Switch 1, 4: decrement until 0, buzzer sounds
  */

//Output Pins for Display
int pinArray[7] = {8, 9, 10, 11, 12, 13, 6}; //{pinA, pinB, pinC, pinD, pinE, pinF, pinG};

//Input Pins from Dip Switch
int pin0 = 0;
int pin1 = 1;
int pin2 = 2;
int pin3 = 3;

//Output pin for Buzzer
int buzzPin = 7;

//Digital Display values
byte values[10][7] = {
  {1, 1, 1, 1, 1, 1, 0}, //number 0
  {0, 1, 1, 0, 0, 0, 0}, //number 1
  {1, 1, 0, 1, 1, 0, 1}, //number 2
  {1, 1, 1, 1, 0, 0, 1}, //number 3
  {0, 1, 1, 0, 0, 1, 1}, //number 4
  {1, 0, 1, 1, 0, 1, 1}, //number 5
  {1, 0, 1, 1, 1, 1, 1}, //number 6
  {1, 1, 1, 0, 0, 0, 0}, //number 7
  {1, 1, 1, 1, 1, 1, 1}, //number 8
  {1, 1, 1, 0, 0, 1, 1}  //number 9
  };

//Value to know where the counter is in the countdown(up)
int curVal = 0;

//Boolean to know if the buzzer is triggered or not
bool buzzed = false;



void setup() {
  Serial.begin(9600);
  //Set up for 7 seg display
  for(int x = 0; x < 7; x++)
  {
    pinMode(pinArray[x], OUTPUT);
  }

  //Set up for Dip Switch
  pinMode(pin0, INPUT);     
  pinMode(pin1, INPUT);     
  pinMode(pin2, INPUT);     
  pinMode(pin3, INPUT); 

  //Set up for buzzer pin
  pinMode(buzzPin, OUTPUT);
  //Sets Display to current value (Will start at 0)
  writeNum(curVal);
}



void loop() {
  //Remains in loop if Start/Stop is triggered
  while(digitalRead(pin3) == 1){}
  //Waits 1 second
  delay(1000);

  //Increases value to next level as long as it is less than 9, incrementer is triggered, and decrementer is not triggered
  if(curVal < 9 && digitalRead(pin2) == 0 && digitalRead(pin0) != 0)
  {
    curVal++;
    writeNum(curVal);

    //Triggers buzzer if value is 9 after incrementing
    if(curVal == 9)
    {
      writeNum(curVal);
      alarmBuzzer();
    }
  }
  //Decreases value to next level as long as it is greater than 0, decrimenter is triggered, and incrementer is not triggered
  else if(curVal > 0 && digitalRead(pin0) == 0 && digitalRead(pin2) != 0)
  {
    curVal--;
    writeNum(curVal);
    
    //Triggers buzzer if value is 0 after decrementing
    if(curVal == 0)
    {
      writeNum(curVal);
      alarmBuzzer();
    }
  }
  //If buzzer is triggered, waits for 3rd switch to be hit to turn off before continuing
  while(buzzed && digitalRead(pin1) == 1){}
  
  //After 3rd switch is hit, turns buzzer off
  if(buzzed)
  {
    disarmBuzzer();
  }
}



void alarmBuzzer()
{
  if(digitalRead(pin1) == 1)
  {
    buzzed = true;
    digitalWrite(buzzPin, HIGH);
  }
}



void disarmBuzzer()
{
  buzzed = false;
  digitalWrite(buzzPin, LOW);
}


//Writes number to display
void writeNum(int n) {
  for(int x = 0; x < 7; x++)
  {
    digitalWrite(pinArray[x], values[n][x]);
  }
}
