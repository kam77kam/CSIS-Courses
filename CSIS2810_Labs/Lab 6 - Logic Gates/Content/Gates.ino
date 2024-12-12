/*
	LAB: NOT
	Author: Samuel Gardner
*/

void setup()
{
	pinMode(PIN0, INPUT);
	pinMode(PIN1, INPUT);
	pinMode(PIN4, OUTPUT);
	pinMode(PIN5, OUTPUT);
}

void loop()
{
	if (!digitalRead(PIN0))
	{
		digitalWrite(PIN4, HIGH);
	}
	else
	{
		digitalWrite(PIN4, LOW);
	}
	if (digitalRead(PIN1))
	{
		digitalWrite(PIN5, HIGH);
	}
	else
	{
		digitalWrite(PIN5, LOW);
	}
}

/*
	LAB: AND/OR
	Author: Samuel Gardner
*/

//void setup()
//{
//	pinMode(PIN0, INPUT);
//	pinMode(PIN1, INPUT);
//	pinMode(PIN2, INPUT);
//	pinMode(PIN3, INPUT);
//	pinMode(PIN4, OUTPUT);
//	pinMode(PIN5, OUTPUT);
//}
//
//void loop()
//{
//	if (!digitalRead(PIN0) || !digitalRead(PIN1))
//	{
//		digitalWrite(PIN4, HIGH);
//	}
//	else
//	{
//		digitalWrite(PIN4, LOW);
//	}
//	if (!digitalRead(PIN2) && !digitalRead(PIN3))
//	{
//		digitalWrite(PIN5, HIGH);
//	}
//	else
//	{
//		digitalWrite(PIN5, LOW);
//	}
//}