#include "StepperAxis.cpp"

// Motor and pin configuration
#define MOTOR_STEPS 200                         // Steps per revolution
#define MICROSTEPS 16                           // Microstepping mode
#define ENABLE_PIN 8                            // Enable pin for stepper driver
#define HOME_X_PIN 9                            // Home switch pin
#define DIR_X_PIN 5                             // Direction control pin
#define STEP_X_PIN 2                            // Step control pin

// Pins for position control signals
const int positionPins[] = {10, 11, 12, 13};
const int positions[] = {0, 6000, 12000, 18000};

// Stepper motor initialization
StepperAxis axis(MOTOR_STEPS, DIR_X_PIN, STEP_X_PIN, HOME_X_PIN);

void setup() {
  Serial.begin(115200);
  pinMode(ENABLE_PIN, OUTPUT);
  
  // Set up control pins as input
  for (int i = 0; i < 4; i++) {
    pinMode(positionPins[i], INPUT);
  }

  axis.init(300, MICROSTEPS);
  axis.setHomeOffset(250);
  axis.home();
  axis.printPosition();
  axis.setPositionIndex(0, 0);
  axis.setSpeed(8000);
  axis.setMotionProfile(1, 2500, 2500);
}

void loop() {
  //THIS IS WHERE WE NEED TO CHANGE THE LOOP TO LISTEN TO ADDRESS 
  //2 (CHRIS) AND MOVE BASED ON THE POSITION HE SENDS VIA CAN BUS
  for (int i = 0; i < 4; ++i) {
    if (digitalRead(positionPins[i]) == HIGH) {
      axis.moveIDX(i + 1);   // Move to predefined position based on input
      axis.printPosition();  // Print the position for verification
      delay(1000);           // Short delay to prevent rapid switching
    }
  }
}
