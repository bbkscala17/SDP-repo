Q3
==
pollSensors is doing too much including initial set up of sensors

Q4
==
Instead of newing up the sensors, the intitial set up of sensors is now handled by the new class SensorManager

Q5
==
Now poll sensors is no longer responsible for sensor set up / adding new sensors etc

Q6
==
This breaches the Interface Segregation Principle which says that "clients should not be forced to depend on interfaces that they do not use"